package incident.services;

import incident.models.TGH_INCIDENT;
import incident.payload.request.Incident_Search_Request;
import incident.payload.request.TGH_INCIDENT_Insert_Req;
import incident.payload.response.APIResponse;
import incident.payload.response.Incident_Search_Response;
import incident.payload.response.TGH_TELEGRAPH_Custom_Search_Response;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.List;

public interface TGH_INCIDENT_Service {
    public BigDecimal getNextValINC_SEQ();
    public ResponseEntity<APIResponse> createTghIncident(TGH_INCIDENT_Insert_Req incident_insert_req);
    public List<Incident_Search_Response> searchTghIncident(Incident_Search_Request incidentSearchRequest);
    public ResponseEntity<APIResponse> updateTghIncident(TGH_INCIDENT_Insert_Req incident_insert_req);
    public ResponseEntity<APIResponse> getTghIncidentById(long incidentId);
    public ResponseEntity<APIResponse> archiveIncident(long incidentId);
}
