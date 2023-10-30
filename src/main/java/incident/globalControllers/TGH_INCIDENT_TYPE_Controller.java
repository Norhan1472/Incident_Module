package incident.globalControllers;

import incident.payload.response.APIResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("TGH_INCIDENT_TYPE")
public interface TGH_INCIDENT_TYPE_Controller {
    @GetMapping("/getAllTypes")
    @PreAuthorize("hasAnyAuthority('TghIncident.update','TghIncident.create','ArchivedIncident.view')")
    public ResponseEntity<APIResponse> getAllTypes();
}
