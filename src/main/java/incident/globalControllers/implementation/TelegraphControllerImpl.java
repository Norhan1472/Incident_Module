package incident.globalControllers.implementation;

import incident.globalControllers.TelegraphController;
import incident.models.TGH_TELEGRAPH;
import incident.payload.request.SearchRequestTelegraph;
import incident.payload.response.APIResponse;
import incident.payload.response.TGH_TELEGRAPH_Custom_Search_Response;
import incident.services.TelegraphService;
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
public class TelegraphControllerImpl implements TelegraphController {
    private final TelegraphService telegraphService;
    @Autowired
    public TelegraphControllerImpl(TelegraphService telegraphService) {
        this.telegraphService = telegraphService;
    }

    /*@Override
    public ResponseEntity<APIResponse> search(SearchRequestTelegraph searchRequest) {
        APIResponse apiResponse = new APIResponse();
        try{
           List<TGH_TELEGRAPH>result =  telegraphService.searchOnTelegraph(searchRequest);
            if(result.isEmpty()){
                apiResponse.setStatus(HttpStatus.NOT_FOUND);
                apiResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
                apiResponse.setClientMessage("No data found");
                return new ResponseEntity<APIResponse>(apiResponse, HttpStatus.NOT_FOUND);
            }else{
                apiResponse.setStatus(HttpStatus.OK);
                apiResponse.setStatusCode(HttpStatus.OK.value());
                apiResponse.setBody(result);
                return new ResponseEntity<APIResponse>(apiResponse, HttpStatus.OK);
            }
        }catch (Exception ex){
            ex.printStackTrace();
            apiResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            apiResponse.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            apiResponse.setClientMessage(ex.getMessage());
            apiResponse.setDeveloperMessage(ex.getCause().toString());
            return new ResponseEntity<APIResponse>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }*/

    @Override
    public ResponseEntity<APIResponse> search(SearchRequestTelegraph searchRequest,Integer pageNo,Integer pageSize) {
        System.out.println("kkk");
        System.out.println(searchRequest.getThgDate());
        APIResponse apiResponse = new APIResponse();
        try {
            Pageable pageable = PageRequest.of(pageNo,pageSize);
            List<TGH_TELEGRAPH_Custom_Search_Response> search = (List<TGH_TELEGRAPH_Custom_Search_Response>) telegraphService.searchOnTelegraph(searchRequest,pageable).get(0);
            Long total = (Long) telegraphService.searchOnTelegraph(searchRequest,pageable).get(1);
            Integer pageSizeSearch = (Integer) telegraphService.searchOnTelegraph(searchRequest,pageable).get(2);
            Integer pageNumberSearch = (Integer) telegraphService.searchOnTelegraph(searchRequest,pageable).get(3);
            Map<String,Object> resultSearch = new HashMap<>();
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
                apiResponse.setClientMessage("telegraphs retrieved successfully");
                apiResponse.setBody(resultSearch);
                return new ResponseEntity<APIResponse>(apiResponse, HttpStatus.OK);
            }
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
    public ResponseEntity<APIResponse> getTelegraphById(long tghId) {
        APIResponse apiResponse = new APIResponse();
        try {

            return telegraphService.getTelegraphById(tghId);
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
