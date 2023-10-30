package incident.globalControllers;

import incident.models.TGH_CITY;
import incident.payload.request.TGH_CITY_Search_Request;
import incident.payload.response.APIResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("TGH_CITY")
public interface TGH_CITY_Controller {
    @GetMapping("/getAll")
    @PreAuthorize("hasAnyAuthority('TghIncident.create','TghIncident.view','TghIncident.update')")
    public ResponseEntity<List<TGH_CITY>> getAll();
    @PostMapping("/search")
    @PreAuthorize("hasAnyAuthority('TghIncident.create','TghIncident.view','TghIncident.update')")
    public ResponseEntity<APIResponse>searchTghCity(@RequestBody TGH_CITY_Search_Request tghCitySearchRequest);
}
