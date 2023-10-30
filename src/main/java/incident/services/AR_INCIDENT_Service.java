package incident.services;

import incident.models.AR_INCIDENT;
import incident.payload.request.AR_INCIDENT_search_Req;
import incident.payload.response.APIResponse;
import incident.payload.response.AR_INCIDENT_Search_Response;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AR_INCIDENT_Service {
    public List<Object> searchArIncident(AR_INCIDENT_search_Req searchRequest, Pageable pageable);
    public ResponseEntity<APIResponse>getDataByCode(long code);
}
