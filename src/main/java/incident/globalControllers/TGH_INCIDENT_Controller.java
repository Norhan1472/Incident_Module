package incident.globalControllers;

import incident.models.TGH_INCIDENT;
import incident.payload.request.Incident_Search_Request;
import incident.payload.request.TGH_INCIDENT_Insert_Req;
import incident.payload.response.APIResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RequestMapping("TGH_INCIDENT")
public interface TGH_INCIDENT_Controller {
    @GetMapping("/getNextValINC_SEQ")
    @PreAuthorize("hasAuthority('TghIncident.create')")
    public ResponseEntity<APIResponse> getNextValINC_SEQ();
    @PostMapping("/createTghIncident")
    @PreAuthorize("hasAuthority('TghIncident.create')")
    public ResponseEntity<APIResponse> createTghIncident(@RequestBody TGH_INCIDENT_Insert_Req incident_insert_req) ;
    @PostMapping("/searchTghIncident")
    @PreAuthorize("hasAuthority('TghIncident.view')")
    public ResponseEntity<APIResponse> searchTghIncident(@RequestBody Incident_Search_Request incidentSearchRequest);
    @PostMapping("/updateTghIncident")
    @PreAuthorize("hasAuthority('TghIncident.update')")
    public ResponseEntity<APIResponse> updateTghIncident(@RequestBody TGH_INCIDENT_Insert_Req incident_insert_req);
    @GetMapping("/getTghIncidentById")
    @PreAuthorize("hasAnyAuthority('TghIncident.update','TghIncident.view')")
    public ResponseEntity<APIResponse> getTghIncidentById(@RequestParam long incidentId);
    @PostMapping("archiveIncident")
    @PreAuthorize("hasAnyAuthority('TghIncident.update','ArchivedIncident.view')")
    public ResponseEntity<APIResponse> archiveIncident(@RequestParam long incidentId);
    }
