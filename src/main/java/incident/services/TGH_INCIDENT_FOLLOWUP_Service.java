package incident.services;

import incident.models.TGH_INCIDENT_FOLLOWUP;
import incident.payload.request.TGH_INCIDENT_FOLLOWUP_Req;
import incident.payload.response.APIResponse;
import org.springframework.http.ResponseEntity;

import java.text.ParseException;

public interface TGH_INCIDENT_FOLLOWUP_Service {
    public ResponseEntity<APIResponse>getIncidentFollowUpByIncidentId(long incidentId);
    public ResponseEntity<APIResponse>insertIncidentFollowUp(TGH_INCIDENT_FOLLOWUP_Req followup_req) throws ParseException;
}
