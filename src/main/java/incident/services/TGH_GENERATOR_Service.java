package incident.services;

import incident.models.TGH_GENERATOR;
import incident.payload.response.APIResponse;
import org.springframework.http.ResponseEntity;

public interface TGH_GENERATOR_Service {
    public ResponseEntity<APIResponse> getGeneratorById(long genId);
}
