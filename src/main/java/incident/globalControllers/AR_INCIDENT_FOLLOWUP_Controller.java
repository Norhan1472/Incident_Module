package incident.globalControllers;

import incident.payload.response.APIResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("AR_INCIDENT_FOLLOWUP")
public interface AR_INCIDENT_FOLLOWUP_Controller {
    @GetMapping("getArIncidentFollowUpById")
    @PreAuthorize("hasAuthority('ArchivedIncident.view')")
    public ResponseEntity<APIResponse> getArIncidentFollowUpByIncidentId(@RequestParam long incidentId);
}
