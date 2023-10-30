package incident.globalControllers.implementation;

import incident.globalControllers.TGH_INCIDENT_Controller;
import incident.models.TGH_INCIDENT;
import incident.models.TGH_INCIDENT_STATUS;
import incident.payload.request.Incident_Search_Request;
import incident.payload.request.TGH_INCIDENT_Insert_Req;
import incident.payload.response.APIResponse;
import incident.payload.response.Incident_Search_Response;
import incident.payload.response.TGH_TELEGRAPH_Custom_Search_Response;
import incident.services.TGH_INCIDENT_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class TGH_INCIDENT_Controller_Impl implements TGH_INCIDENT_Controller {
    private final TGH_INCIDENT_Service tghIncidentService;
    @Autowired
    public TGH_INCIDENT_Controller_Impl(TGH_INCIDENT_Service tghIncidentService) {
        this.tghIncidentService = tghIncidentService;
    }

    @Override
    public ResponseEntity<APIResponse> getNextValINC_SEQ() {
        APIResponse apiResponse = new APIResponse();
        try {
            BigDecimal result = tghIncidentService.getNextValINC_SEQ();
                apiResponse.setStatus(HttpStatus.OK);
                apiResponse.setStatusCode(HttpStatus.OK.value());
                apiResponse.setClientMessage("retrieved Sequence successfully");
                apiResponse.setBody(result);
                return new ResponseEntity<APIResponse>(apiResponse, HttpStatus.OK);

        } catch (Exception ex) {
            ex.printStackTrace();
            apiResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            apiResponse.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            apiResponse.setClientMessage(ex.getMessage());
            // apiResponse.setDeveloperMessage(ex.getCause().toString());
            return new ResponseEntity<APIResponse>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<APIResponse> createTghIncident(TGH_INCIDENT_Insert_Req incident_insert_req) {
        APIResponse apiResponse = new APIResponse();
        try {

            return tghIncidentService.createTghIncident(incident_insert_req);
            /*apiResponse.setStatus(HttpStatus.OK);
            apiResponse.setStatusCode(HttpStatus.OK.value());
            apiResponse.setBody(result);
            return new ResponseEntity<APIResponse>(apiResponse, HttpStatus.OK);*/

        } catch (Exception ex) {
            ex.printStackTrace();
            apiResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            apiResponse.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            apiResponse.setClientMessage(ex.getMessage());
            //apiResponse.setDeveloperMessage(ex.getCause().toString());
            return new ResponseEntity<APIResponse>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @Override
    public ResponseEntity<APIResponse> searchTghIncident(Incident_Search_Request incidentSearchRequest){
        APIResponse apiResponse = new APIResponse();
        System.out.println(incidentSearchRequest.getRecievedBy());
//        if(incidentSearchRequest.getCustomerMobileNumber()!=null&&incidentSearchRequest.getCustomerMobileNumber().length()!=11){
//            apiResponse.setStatus(HttpStatus.OK);
//            apiResponse.setStatusCode(HttpStatus.OK.value());
//            apiResponse.setClientMessage("Customer Mobile Number Must be 11 digit");
//            return new ResponseEntity<APIResponse>(apiResponse, HttpStatus.OK);
//        }
        try {
            List<Incident_Search_Response> search = tghIncidentService.searchTghIncident(incidentSearchRequest);

            if (search.isEmpty()) {
                apiResponse.setStatus(HttpStatus.OK);
                apiResponse.setStatusCode(HttpStatus.OK.value());
                apiResponse.setClientMessage("No data found");
                return new ResponseEntity<APIResponse>(apiResponse, HttpStatus.OK);
            } else {
                apiResponse.setStatus(HttpStatus.OK);
                apiResponse.setStatusCode(HttpStatus.OK.value());
                apiResponse.setClientMessage("retrieved data successfully");
                apiResponse.setBody(search);
                return new ResponseEntity<APIResponse>(apiResponse, HttpStatus.OK);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            apiResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            apiResponse.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            apiResponse.setClientMessage(ex.getMessage());
            //apiResponse.setDeveloperMessage(ex.getCause().toString());
            return new ResponseEntity<APIResponse>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<APIResponse> updateTghIncident(TGH_INCIDENT_Insert_Req incident_insert_req) {
        APIResponse apiResponse = new APIResponse();
        try {
            return tghIncidentService.updateTghIncident(incident_insert_req);
        } catch (Exception ex) {
            ex.printStackTrace();
            apiResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            apiResponse.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            apiResponse.setClientMessage(ex.getMessage());
            //apiResponse.setDeveloperMessage(ex.getCause().toString());
            return new ResponseEntity<APIResponse>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<APIResponse> getTghIncidentById(long incidentId) {
        APIResponse apiResponse = new APIResponse();
        try {
            return tghIncidentService.getTghIncidentById(incidentId);
        } catch (Exception ex) {
            ex.printStackTrace();
            apiResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            apiResponse.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            apiResponse.setClientMessage(ex.getMessage());
            //apiResponse.setDeveloperMessage(ex.getCause().toString());
            return new ResponseEntity<APIResponse>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<APIResponse> archiveIncident(long incidentId) {
        APIResponse apiResponse = new APIResponse();
        try {
            return tghIncidentService.archiveIncident(incidentId);
        } catch (Exception ex) {
            ex.printStackTrace();
            apiResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            apiResponse.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            apiResponse.setClientMessage(ex.getMessage());
           // apiResponse.setDeveloperMessage(ex.getCause().toString());
            return new ResponseEntity<APIResponse>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
