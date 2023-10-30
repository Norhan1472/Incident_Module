package incident.globalControllers;

import incident.payload.response.APIResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("TGH_INCIDENT_STATUS")
public interface TGH_INCIDENT_STATUS_Controller {
    @GetMapping("/findAllStatusNames")
    @PreAuthorize("hasAnyAuthority('TghIncident.view','TghIncident.update','TghIncident.create')")
    public ResponseEntity<APIResponse>findAllStatusNames();
}
