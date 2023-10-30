package incident.services.implementation;

import incident.models.TGH_GENERATOR;
import incident.payload.response.APIResponse;
import incident.repos.TGH_GENERATOR_Repo;
import incident.services.TGH_GENERATOR_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Objects;

@Service
@Transactional
public class TGH_GENERATOR_Service_Impl implements TGH_GENERATOR_Service {
    private final TGH_GENERATOR_Repo tgh_generator_repo;
    @Autowired
    public TGH_GENERATOR_Service_Impl(TGH_GENERATOR_Repo tghGeneratorRepo) {
        tgh_generator_repo = tghGeneratorRepo;
    }

    @Override
    public ResponseEntity<APIResponse> getGeneratorById(long genId) {
        TGH_GENERATOR tgh_generator =  tgh_generator_repo.findById(genId).orElse(null);
        APIResponse apiResponse = new APIResponse();
        if(Objects.isNull(tgh_generator)){
            apiResponse.setStatus(HttpStatus.BAD_REQUEST);
            apiResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
            apiResponse.setClientMessage("This id isn't exist");
            return new ResponseEntity<APIResponse>(apiResponse, HttpStatus.BAD_REQUEST);
        }else{
            apiResponse.setStatus(HttpStatus.OK);
            apiResponse.setStatusCode(HttpStatus.OK.value());
            apiResponse.setClientMessage("retrieved generator successfully");
            apiResponse.setBody(tgh_generator);
            return new ResponseEntity<APIResponse>(apiResponse, HttpStatus.OK);
        }
    }
}
