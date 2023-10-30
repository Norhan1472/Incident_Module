package incident.globalControllers.implementation;

import incident.globalControllers.AR_INCIDENT_Controller;
import incident.models.AR_INCIDENT;
import incident.payload.request.AR_INCIDENT_search_Req;
import incident.payload.response.APIResponse;
import incident.payload.response.AR_INCIDENT_Search_Response;
import incident.payload.response.TGH_TELEGRAPH_Custom_Search_Response;
import incident.services.AR_INCIDENT_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
public class AR_INCIDENT_Controller_Impl implements AR_INCIDENT_Controller {
    private final AR_INCIDENT_Service arIncidentService;

    @Autowired
    public AR_INCIDENT_Controller_Impl(AR_INCIDENT_Service arIncidentService) {
        this.arIncidentService = arIncidentService;
    }

    @Override
    public ResponseEntity<APIResponse> searchArIncident(AR_INCIDENT_search_Req searchRequest,Integer pageNo,Integer pageSize) {
        APIResponse apiResponse = new APIResponse();
        try {
            Pageable pageable = PageRequest.of(pageNo,pageSize);
            List<AR_INCIDENT_Search_Response> search = (List<AR_INCIDENT_Search_Response>) arIncidentService.searchArIncident(searchRequest,pageable).get(0);
            Long total = (Long) arIncidentService.searchArIncident(searchRequest,pageable).get(1);
            Integer pageSizeSearch = (Integer) arIncidentService.searchArIncident(searchRequest,pageable).get(2);
            Integer pageNumberSearch = (Integer) arIncidentService.searchArIncident(searchRequest,pageable).get(3);
            Map<String,Object>resultSearch = new HashMap<>();
            resultSearch.put("result",search);
            resultSearch.put("totalSize",total);
            resultSearch.put("size",pageSizeSearch);
            resultSearch.put("pageNumber",pageNumberSearch);
            if (search.isEmpty()) {
                apiResponse.setStatus(HttpStatus.OK);
                apiResponse.setStatusCode(HttpStatus.OK.value());
                apiResponse.setClientMessage("No data found");
                return new ResponseEntity<APIResponse>(apiResponse, HttpStatus.OK);
            } else {

                apiResponse.setStatus(HttpStatus.OK);
                apiResponse.setStatusCode(HttpStatus.OK.value());
                apiResponse.setClientMessage("archive incident retrieved successfully");
                apiResponse.setBody(resultSearch);
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
    public ResponseEntity<APIResponse> getDataByCode(long code) {
        APIResponse apiResponse = new APIResponse();
        try {
             return arIncidentService.getDataByCode(code);


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
