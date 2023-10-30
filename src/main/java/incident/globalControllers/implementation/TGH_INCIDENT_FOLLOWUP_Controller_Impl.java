package incident.globalControllers.implementation;

import incident.globalControllers.TGH_INCIDENT_FOLLOWUP_Controller;
import incident.payload.request.TGH_INCIDENT_FOLLOWUP_Req;
import incident.payload.response.APIResponse;
import incident.services.TGH_INCIDENT_FOLLOWUP_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TGH_INCIDENT_FOLLOWUP_Controller_Impl implements TGH_INCIDENT_FOLLOWUP_Controller {
    private final TGH_INCIDENT_FOLLOWUP_Service tgh_incident_followup_service;
    @Autowired
    public TGH_INCIDENT_FOLLOWUP_Controller_Impl(TGH_INCIDENT_FOLLOWUP_Service tghIncidentFollowupService) {
        tgh_incident_followup_service = tghIncidentFollowupService;
    }

    @Override
    public ResponseEntity<APIResponse> getIncidentFollowUpByIncidentId(long incidentId) {

        APIResponse apiResponse = new APIResponse();
        try {
            return tgh_incident_followup_service.getIncidentFollowUpByIncidentId(incidentId);
        }catch (Exception ex){
            ex.printStackTrace();
            apiResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            apiResponse.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            apiResponse.setClientMessage(ex.getMessage());
           // apiResponse.setDeveloperMessage(ex.getCause().toString());
            return new ResponseEntity<APIResponse>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<APIResponse> insertIncidentFollowUp(TGH_INCIDENT_FOLLOWUP_Req followup_req) {
        APIResponse apiResponse = new APIResponse();
        try {
            return tgh_incident_followup_service.insertIncidentFollowUp(followup_req);
        }catch (Exception ex){
            ex.printStackTrace();
            apiResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            apiResponse.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            apiResponse.setClientMessage(ex.getMessage());
          //  apiResponse.setDeveloperMessage(ex.getCause().toString());
            return new ResponseEntity<APIResponse>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
