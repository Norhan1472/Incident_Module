package incident.globalControllers;

import incident.payload.response.APIResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("TGH_GENERATOR")
public interface TGH_GENERATOR_Controller {
    @GetMapping("getGeneratorById")
    @PreAuthorize("hasAnyAuthority('TelegraphGenerator.view','ArchivedIncidentTelegraphGenerator.view')")
    public ResponseEntity<APIResponse>getGeneratorById(@RequestParam long genId);
}
