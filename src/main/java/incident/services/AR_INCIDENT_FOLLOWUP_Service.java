package incident.services;

import incident.payload.response.APIResponse;
import org.springframework.http.ResponseEntity;

public interface AR_INCIDENT_FOLLOWUP_Service {
    public ResponseEntity<APIResponse> getArIncidentFollowUpByIncidentId(long incidentId);
}
