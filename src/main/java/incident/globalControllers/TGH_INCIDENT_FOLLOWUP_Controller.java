package incident.globalControllers;

import incident.payload.request.TGH_INCIDENT_FOLLOWUP_Req;
import incident.payload.response.APIResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RequestMapping("TGH_INCIDENT_FOLLOWUP")
public interface TGH_INCIDENT_FOLLOWUP_Controller {
    @GetMapping("getIncidentFollowUpById")
    @PreAuthorize("hasAuthority('TghIncident.view')")
    public ResponseEntity<APIResponse> getIncidentFollowUpByIncidentId(@RequestParam long incidentId);

    @PostMapping("insertIncidentFollowUp")
    @PreAuthorize("hasAnyAuthority('TghIncident.view','TghIncident.create','TghIncident.update')")
    public ResponseEntity<APIResponse> insertIncidentFollowUp(@RequestBody TGH_INCIDENT_FOLLOWUP_Req followup_req);
}
