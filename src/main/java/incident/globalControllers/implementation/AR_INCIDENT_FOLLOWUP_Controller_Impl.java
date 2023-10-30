package incident.globalControllers.implementation;

import incident.globalControllers.AR_INCIDENT_FOLLOWUP_Controller;
import incident.payload.response.APIResponse;
import incident.services.AR_INCIDENT_FOLLOWUP_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AR_INCIDENT_FOLLOWUP_Controller_Impl implements AR_INCIDENT_FOLLOWUP_Controller {
    private final AR_INCIDENT_FOLLOWUP_Service ar_incident_followup_service;
    @Autowired
    public AR_INCIDENT_FOLLOWUP_Controller_Impl(AR_INCIDENT_FOLLOWUP_Service arIncidentFollowupService) {
        ar_incident_followup_service = arIncidentFollowupService;
    }

    @Override
    public ResponseEntity<APIResponse> getArIncidentFollowUpByIncidentId(long incidentId) {
        APIResponse apiResponse = new APIResponse();
        try {
            return ar_incident_followup_service.getArIncidentFollowUpByIncidentId(incidentId);
        }catch (Exception ex){
            ex.printStackTrace();
            apiResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            apiResponse.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            apiResponse.setClientMessage(ex.getMessage());
            //apiResponse.setDeveloperMessage(ex.getCause().toString());
            return new ResponseEntity<APIResponse>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
