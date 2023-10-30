package incident.globalControllers;

import incident.payload.request.SearchRequestTelegraph;
import incident.payload.response.APIResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/Telegraph")
public interface TelegraphController {
    @PostMapping("search")
    @PreAuthorize("hasAuthority('TghIncident.view')")
    public ResponseEntity<APIResponse>search(@RequestBody SearchRequestTelegraph searchRequest,@RequestParam Integer pageNo,@RequestParam Integer pageSize);
    @GetMapping("getTelegraphById")
    @PreAuthorize("hasAnyAuthority('TghIncident.view','TghIncident.create','ArchivedIncident.view')")
    public ResponseEntity<APIResponse> getTelegraphById(@RequestParam long tghId);
}
