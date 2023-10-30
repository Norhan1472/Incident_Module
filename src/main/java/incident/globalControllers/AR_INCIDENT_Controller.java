package incident.globalControllers;

import incident.models.AR_INCIDENT;
import incident.payload.request.AR_INCIDENT_search_Req;
import incident.payload.request.SearchRequestTelegraph;
import incident.payload.response.APIResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RequestMapping("AR_INCIDENT")
public interface AR_INCIDENT_Controller {
    @PostMapping("searchArIncident")
    @PreAuthorize("hasAuthority('ArchivedIncident.view')")
    public ResponseEntity<APIResponse> searchArIncident(@RequestBody AR_INCIDENT_search_Req searchRequest,@RequestParam Integer pageNo,@RequestParam Integer pageSize);
    @GetMapping("getDataByCode")
    @PreAuthorize("hasAuthority('ArchivedIncident.view')")
    public ResponseEntity<APIResponse> getDataByCode(@RequestParam long code);
}
