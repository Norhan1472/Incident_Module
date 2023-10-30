package incident.globalControllers.implementation;

import incident.globalControllers.TGH_GENERATOR_Controller;
import incident.payload.response.APIResponse;
import incident.services.TGH_GENERATOR_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TGH_GENERATOR_Controller_Impl implements TGH_GENERATOR_Controller {
    private final TGH_GENERATOR_Service tgh_generator_service;
    @Autowired
    public TGH_GENERATOR_Controller_Impl(TGH_GENERATOR_Service tghGeneratorService) {
        tgh_generator_service = tghGeneratorService;
    }

    @Override
    public ResponseEntity<APIResponse> getGeneratorById(long genId) {
        APIResponse apiResponse = new APIResponse();
        try {
            return tgh_generator_service.getGeneratorById(genId);
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
