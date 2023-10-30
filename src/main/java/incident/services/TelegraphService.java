package incident.services;

import incident.models.TGH_TELEGRAPH;
import incident.payload.request.SearchRequestTelegraph;
import incident.payload.response.APIResponse;
import incident.payload.response.TGH_TELEGRAPH_Custom_Search_Response;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TelegraphService {
    public List<Object>searchOnTelegraph(SearchRequestTelegraph search,Pageable pageable);
    public ResponseEntity<APIResponse>getTelegraphById(long tghId);
}
