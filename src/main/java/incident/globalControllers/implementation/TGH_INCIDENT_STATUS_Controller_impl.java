package incident.globalControllers.implementation;

import incident.globalControllers.TGH_INCIDENT_STATUS_Controller;
import incident.models.TGH_INCIDENT_STATUS;
import incident.payload.response.APIResponse;
import incident.services.TGH_INCIDENT_STATUS_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TGH_INCIDENT_STATUS_Controller_impl implements TGH_INCIDENT_STATUS_Controller {
    private final TGH_INCIDENT_STATUS_Service tghIncidentStatusService;
    @Autowired
    public TGH_INCIDENT_STATUS_Controller_impl(TGH_INCIDENT_STATUS_Service tghIncidentStatusService) {
        this.tghIncidentStatusService = tghIncidentStatusService;
    }

    @Override
    public ResponseEntity<APIResponse> findAllStatusNames() {
        APIResponse apiResponse = new APIResponse();
        try {
            List<TGH_INCIDENT_STATUS> result = tghIncidentStatusService.findAllStatus();

            if (result.isEmpty()) {
                apiResponse.setStatus(HttpStatus.OK);
                apiResponse.setStatusCode(HttpStatus.OK.value());
                apiResponse.setClientMessage("No data found");
                return new ResponseEntity<APIResponse>(apiResponse, HttpStatus.OK);
            } else {
                apiResponse.setStatus(HttpStatus.OK);
                apiResponse.setStatusCode(HttpStatus.OK.value());
                apiResponse.setClientMessage("retrieved status code successfully");
                apiResponse.setBody(result);
                return new ResponseEntity<APIResponse>(apiResponse, HttpStatus.OK);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            apiResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            apiResponse.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            apiResponse.setClientMessage(ex.getMessage());
          //  apiResponse.setDeveloperMessage(ex.getCause().toString());
            return new ResponseEntity<APIResponse>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
