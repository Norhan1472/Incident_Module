package incident.globalControllers.implementation;

import incident.globalControllers.TGH_INCIDENT_TYPE_Controller;
import incident.models.TGH_INCIDENT_STATUS;
import incident.models.TGH_INCIDENT_TYPE;
import incident.payload.response.APIResponse;
import incident.services.TGH_INCIDENT_TYPE_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class TGH_INCIDENT_TYPE_Controller_Impl implements TGH_INCIDENT_TYPE_Controller {
    private final TGH_INCIDENT_TYPE_Service incidentTypeCodeService;
    @Autowired
    public TGH_INCIDENT_TYPE_Controller_Impl(TGH_INCIDENT_TYPE_Service incidentTypeCodeService) {
        this.incidentTypeCodeService = incidentTypeCodeService;
    }

    @Override
    public ResponseEntity<APIResponse> getAllTypes() {
        APIResponse apiResponse = new APIResponse();
        try {
            List<TGH_INCIDENT_TYPE> result = incidentTypeCodeService.getAllTypes();

            if (result.isEmpty()) {
                apiResponse.setStatus(HttpStatus.OK);
                apiResponse.setStatusCode(HttpStatus.OK.value());
                apiResponse.setClientMessage("No data found");
                return new ResponseEntity<APIResponse>(apiResponse, HttpStatus.OK);
            } else {
                apiResponse.setStatus(HttpStatus.OK);
                apiResponse.setStatusCode(HttpStatus.OK.value());
                apiResponse.setClientMessage("retrieved data successfully");
                apiResponse.setBody(result);
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
}
