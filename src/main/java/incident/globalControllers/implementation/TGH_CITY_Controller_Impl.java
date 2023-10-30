package incident.globalControllers.implementation;

import incident.globalControllers.TGH_CITY_Controller;
import incident.models.TGH_CITY;
import incident.models.TGH_INCIDENT_STATUS;
import incident.payload.request.TGH_CITY_Search_Request;
import incident.payload.response.APIResponse;
import incident.repos.TGH_CITY_Repo;
import incident.repos.TGH_CITY_Specification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TGH_CITY_Controller_Impl implements TGH_CITY_Controller {
    private final TGH_CITY_Repo tghCityRepo;
    @Autowired
    public TGH_CITY_Controller_Impl(TGH_CITY_Repo tghCityRepo) {
        this.tghCityRepo = tghCityRepo;
    }

    @Override
    public ResponseEntity<List<TGH_CITY>> getAll() {
        return new ResponseEntity<>(tghCityRepo.findAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<APIResponse> searchTghCity(TGH_CITY_Search_Request tghCitySearchRequest) {
        /*TGH_CITY_Specification tghCitySpecification = new TGH_CITY_Specification(tghCitySearchRequest);
       List<TGH_CITY>result =  tghCityRepo.findAll(tghCitySpecification);
        return new ResponseEntity<>(tghCityRepo.findAll(), HttpStatus.OK);*/
        System.out.println("mm");
        APIResponse apiResponse = new APIResponse();
        try {
            TGH_CITY_Specification tghCitySpecification = new TGH_CITY_Specification(tghCitySearchRequest);
            List<TGH_CITY>result =  tghCityRepo.findAll(tghCitySpecification);

            if (result.isEmpty()) {
                apiResponse.setStatus(HttpStatus.OK);
                apiResponse.setStatusCode(HttpStatus.OK.value());
                apiResponse.setClientMessage("No data found");
                return new ResponseEntity<APIResponse>(apiResponse, HttpStatus.OK);
            } else {
                apiResponse.setStatus(HttpStatus.OK);
                apiResponse.setStatusCode(HttpStatus.OK.value());
                apiResponse.setClientMessage("cities retrieved successfully");
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
