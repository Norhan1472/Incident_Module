package incident.services.implementation;

import incident.models.TGH_INCIDENT;
import incident.models.TGH_INCIDENT_STATUS;
import incident.models.TGH_INCIDENT_TYPE;
import incident.models.TGH_TELEGRAPH;
import incident.payload.request.Incident_Search_Request;
import incident.payload.request.TGH_INCIDENT_Insert_Req;
import incident.payload.response.APIResponse;
import incident.payload.response.Incident_Search_Response;
import incident.payload.response.TGH_TELEGRAPH_Custom_Search_Response;
import incident.repos.TGH_INCIDENT_Repo;
import incident.services.AuthServiceImpl;
import incident.services.TGH_INCIDENT_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class TGH_INCIDENT_Service_Impl implements TGH_INCIDENT_Service {
    private final TGH_INCIDENT_Repo tghIncidentRepo;
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    AuthServiceImpl authService;
    @Autowired
    public TGH_INCIDENT_Service_Impl(TGH_INCIDENT_Repo tghIncidentRepo) {
        this.tghIncidentRepo = tghIncidentRepo;
    }

    @Override
    public BigDecimal getNextValINC_SEQ() {
        return tghIncidentRepo.getNextValINC_SEQ();
    }

    @Override
    public ResponseEntity<APIResponse> createTghIncident(TGH_INCIDENT_Insert_Req incident_insert_req) {
        APIResponse apiResponse = new APIResponse();

        try{
            if(incident_insert_req.getCallerCityCode()==""||incident_insert_req.getCallerCityCode()==null){
                apiResponse.setStatus(HttpStatus.BAD_REQUEST);
                apiResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
                apiResponse.setClientMessage("You Must Enter Caller City Code");
                return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
            }
            if(incident_insert_req.getCallerTelNo()==""||incident_insert_req.getCallerTelNo()==null){
                apiResponse.setStatus(HttpStatus.BAD_REQUEST);
                apiResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
                apiResponse.setClientMessage("You Must Enter Caller Tel No");
                return new ResponseEntity<APIResponse>(apiResponse, HttpStatus.BAD_REQUEST);
            }
            if(incident_insert_req.getStatusCode()==null){
                apiResponse.setStatus(HttpStatus.BAD_REQUEST);
                apiResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
                apiResponse.setClientMessage("You Must Enter Status Code");
                return new ResponseEntity<APIResponse>(apiResponse, HttpStatus.BAD_REQUEST);
            }

            else{
                TGH_INCIDENT tgh_incident = new TGH_INCIDENT();
                System.out.println(incident_insert_req.getCode());
                //incident id
                tgh_incident.setIncidentId(incident_insert_req.getCode());
                //caller city code
                tgh_incident.setCallerCityCode(incident_insert_req.getCallerCityCode());
                //caller tel no
                tgh_incident.setCallerTelNo(incident_insert_req.getCallerTelNo());
                //status code
                TGH_INCIDENT_STATUS statusCode = new TGH_INCIDENT_STATUS();
                statusCode.setStatusCode(incident_insert_req.getStatusCode());
                tgh_incident.setStatusCode(statusCode);
                //receivedDate
                /*String receivedDate= String.valueOf(incident_insert_req.getRecievedDate());
                System.out.println("mmnn");
                System.out.println(receivedDate);*/
//                if(incident_insert_req.getRecievedDate().matches("MM/dd/yyyy HH:mm")){
//                    apiResponse.setStatus(HttpStatus.BAD_REQUEST);
//                    apiResponse.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
//                    apiResponse.setClientMessage("not match pattern");
//                    return new ResponseEntity<APIResponse>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
//                }
                Date date1=new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(incident_insert_req.getRecievedDate());
                tgh_incident.setRecievedDate(date1);
                //receivedBy
                tgh_incident.setRecievedBy(incident_insert_req.getRecievedBy());
                //query flag
                tgh_incident.setQueryFlag(incident_insert_req.getQueryFlag());
                //tghId
                tgh_incident.setTghId(incident_insert_req.getTghId());
                //caller name
                tgh_incident.setCallerName(incident_insert_req.getCallerName());
                //caller address
                tgh_incident.setCallerAddress(incident_insert_req.getCallerAddress());
                if(!(incident_insert_req.getIncidentTypeCode() == null||incident_insert_req.getIncidentTypeCode().equals(""))){
                    TGH_INCIDENT_TYPE type = new TGH_INCIDENT_TYPE();
                    type.setIncidentTypeCode(incident_insert_req.getIncidentTypeCode());
                    tgh_incident.setIncidentTypeCode(type);
                }
                tgh_incident.setIncidentNotes(incident_insert_req.getIncidentNotes());
                tgh_incident.setRecordStatus("N");
                if(incident_insert_req.getCustomerMobileNumber()!=null&&incident_insert_req.getCustomerMobileNumber().length()!=11){
                    apiResponse.setStatus(HttpStatus.OK);
                    apiResponse.setStatusCode(HttpStatus.OK.value());
                    apiResponse.setClientMessage("Customer Mobile Number Must be 11 digit");
                    return new ResponseEntity<APIResponse>(apiResponse, HttpStatus.OK);
                }else if(incident_insert_req.getCustomerMobileNumber()!=null&&incident_insert_req.getCustomerMobileNumber().length()==11){
                    tgh_incident.setCustomerMobileNumber(incident_insert_req.getCustomerMobileNumber());
                }
                //code
               /*
                tgh_incident_temp.setIncidentId(tghIncident.getIncidentId());
                //receivedDate
                tgh_incident_temp.setRecievedDate(tghIncident.getRecievedDate());
                //receivedBy
                tgh_incident_temp.setRecievedBy(tghIncident.getRecievedBy());
                //query flag
                tgh_incident_temp.setQueryFlag(tghIncident.getQueryFlag());
                //tghId
                tgh_incident_temp.setTghId(tghIncident.getTghId());
                //caller name
                tgh_incident_temp.setCallerName(tghIncident.getCallerName());
                //caller address
                tgh_incident_temp.setCallerAddress(tghIncident.getCallerAddress());
                //caller city code
                tgh_incident_temp.setCallerCityCode(tghIncident.getCallerCityCode());
                //caller tel no
                tgh_incident_temp.setCallerTelNo(tghIncident.getCallerTelNo());
                //incident type code
                tgh_incident_temp.setIncidentTypeCode(tghIncident.getIncidentTypeCode());
                //status code
                if(tghIncident.getStatusCode()==null){
                    TGH_INCIDENT_STATUS statusCode = new TGH_INCIDENT_STATUS();
                    tgh_incident_temp.setStatusCode(statusCode);
                }else{
                    tgh_incident_temp.setStatusCode(tghIncident.getStatusCode());
                }
                //incident notes
                tgh_incident_temp.setIncidentNotes(tghIncident.getIncidentNotes());
                //incident recordStatus
               // tgh_incident_temp.setRecordStatus("N");*/

                TGH_INCIDENT result = tghIncidentRepo.save(tgh_incident);
                apiResponse.setStatus(HttpStatus.OK);
                apiResponse.setStatusCode(HttpStatus.OK.value());
                apiResponse.setClientMessage("Incident Added Successfully");
                apiResponse.setBody(result);
                return new ResponseEntity<APIResponse>(apiResponse, HttpStatus.OK);
            }
        }catch (Exception ex){
            ex.printStackTrace();
            apiResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            apiResponse.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            apiResponse.setClientMessage(ex.getMessage());
          //  apiResponse.setDeveloperMessage(ex.getCause().toString());
            return new ResponseEntity<APIResponse>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public List<Incident_Search_Response> searchTghIncident(Incident_Search_Request searchRequest) {
        StringBuilder queryBuilder = new StringBuilder("SELECT\n" +
                "    inc.INCIDENT_ID,\n" +
                "    inc.TGH_ID,\n" +
                "   type.incident_type_NAME,\n" +
                "   status.STATUS_NAME , " +
                "    inc.RECIEVED_BY,\n" +
                "    inc.RECIEVED_DATE,\n" +
                "    tgh.TGH_CODE,\n" +
                "    tgh.TGH_DATE \n" +
                " FROM\n" +
                "    TGH_INCIDENT inc\n" +
                "LEFT JOIN\n" +
                "    TGH_TELEGRAPH tgh ON inc.TGH_ID = tgh.TGH_ID\n" +
                "LEFT JOIN\n" +
                "    TGH_INCIDENT_TYPE type ON type.incident_type_code = inc.INCIDENT_TYPE_CODE " +
                "LEFT JOIN\n" +
                "    TGH_INCIDENT_STATUS status ON status.STATUS_CODE = inc.STATUS_CODE " +
                "where 1=1 " +
                "AND inc.RECORD_STATUS = 'N' ");

        List<Object> queryParams = new ArrayList<>();
        // incident id
        if (!(searchRequest.getIncidentId() == 0 )) {
            queryBuilder.append(" AND inc.INCIDENT_ID= ?");
            queryParams.add(searchRequest.getIncidentId());
        }
        // tgh_Id
        if (!(searchRequest.getTelegraphId() == 0 )) {
            queryBuilder.append(" AND inc.TGH_ID= ?");
            queryParams.add(searchRequest.getTelegraphId());
        }
        // tgh_Code
        if (!(searchRequest.getTghCode() == null || searchRequest.getTghCode().equals(""))) {
            queryBuilder.append(" AND tgh.TGH_CODE= ?");
            queryParams.add(searchRequest.getTghCode());
        }
        // tgh_date
        if (!(searchRequest.getTghDate() == null || searchRequest.getTghDate().equals(""))) {
            queryBuilder.append(" AND (to_char(tgh.TGH_DATE, 'dd/MM/yyyy')=?)");
            String[] data = searchRequest.getTghDate().split("/");
            String tghDate = searchRequest.getTghDate();
            if(data.length==3){
                if(data[0].length()==1){
                    data[0]="0"+data[0];
                    tghDate= tghDate.replace(tghDate.substring(0,1),data[0]);
                }
                if(data[1].length()==1){
                    data[1]="0"+data[1];
                    tghDate= tghDate.replace(tghDate.substring(3,4),data[1]);
                }
                System.out.println(tghDate);
                queryParams.add(tghDate);
            }
        }
        //seq no
        if (!(searchRequest.getSeqNo()== 0 )) {
            queryBuilder.append(" AND tgh.SEQ_NO= ? ");
            queryParams.add(searchRequest.getSeqNo());
        }
        //caller name
        if (!(searchRequest.getCallerName()== null || searchRequest.getCallerName().equals(""))) {
            queryBuilder.append(" AND inc.CALLER_NAME= ? ");
            queryParams.add(searchRequest.getCallerName());
        }
        //caller address
        if (!(searchRequest.getCallerAddress() == null || searchRequest.getCallerAddress().equals(""))) {
            queryBuilder.append(" AND inc.CALLER_ADDRESS= ?");
            queryParams.add(searchRequest.getCallerAddress());
        }
        //caller tel no
        if (!(searchRequest.getCallerTelNo() == null || searchRequest.getCallerTelNo().equals(""))) {
            queryBuilder.append(" AND inc.CALLER_TEL_NO = ?");
            queryParams.add(searchRequest.getCallerTelNo());
        }
        //status Code
        if (!(searchRequest.getStatusCode() == null || searchRequest.getStatusCode().equals(""))) {
            queryBuilder.append(" AND inc.STATUS_CODE = ?");
            queryParams.add(searchRequest.getStatusCode());
        }
        //incident Type Code
        if (!(searchRequest.getIncidentTypeCode() == null || searchRequest.getIncidentTypeCode().equals(""))) {
            queryBuilder.append(" AND inc.INCIDENT_TYPE_CODE = ?");
            queryParams.add(searchRequest.getIncidentTypeCode());
        }
        //caller City Code
        if (!(searchRequest.getCallerCityCode() == null || searchRequest.getCallerCityCode().equals(""))) {
            queryBuilder.append(" AND inc.CALLER_CITY_CODE = ?");
            queryParams.add(searchRequest.getCallerCityCode());
        }
        //RECIEVED_BY
        if (!(searchRequest.getRecievedBy() == null || searchRequest.getRecievedBy().equals(""))) {
            System.out.println("kk");
            queryBuilder.append(" AND inc.RECIEVED_BY = ?");
            queryParams.add(searchRequest.getRecievedBy());
        }
        //RECIEVED_DATE
        if (!(searchRequest.getRecievedDate() == null || searchRequest.getRecievedDate().equals(""))) {
            /*queryBuilder.append(" AND inc.RECIEVED_DATE = ?");
            queryParams.add(searchRequest.getRecievedDate());*/
            queryBuilder.append(" AND (to_char(inc.RECIEVED_DATE, 'dd/MM/yyyy')=?)");
            String[] data = searchRequest.getRecievedDate() .split("/");
            String receivedDate = searchRequest.getRecievedDate();
            if(data.length==3){
                if(data[0].length()==1){
                    data[0]="0"+data[0];
                    receivedDate= receivedDate.replace(receivedDate.substring(0,1),data[0]);
                }
                if(data[1].length()==1){
                    data[1]="0"+data[1];
                    receivedDate= receivedDate.replace(receivedDate.substring(3,4),data[1]);

                }
                queryParams.add(receivedDate);
            }
        }
        //customer mobile number
        if (!(searchRequest.getCustomerMobileNumber() == null || searchRequest.getCustomerMobileNumber().equals(""))) {
            if(searchRequest.getCustomerMobileNumber().length()==11){
                queryBuilder.append(" AND inc.CUSTOMER_MOBILE_NUMBER = ?");
                queryParams.add(searchRequest.getCustomerMobileNumber());
            }
        }
        String query = queryBuilder.toString();
        //System.out.println("query="+query);

        Object[] params = queryParams.toArray();

        // Execute the query
        @SuppressWarnings("deprecation")
        List<Incident_Search_Response> results = jdbcTemplate.query(query, params, (rs, rowNum) -> {
            // Map the result rows to your Result class
            Incident_Search_Response result = new Incident_Search_Response();
            result.setCode(rs.getLong("INCIDENT_ID"));
            result.setTghCode(rs.getString("TGH_CODE"));
            result.setTghId(rs.getLong("TGH_ID"));
            result.setRecievedBy(rs.getString("RECIEVED_BY"));
            String pattern = "dd-MM-yyyy HH:mm";
            System.out.println("here");
            System.out.println(rs.getString("RECIEVED_DATE"));
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            if(rs.getDate("RECIEVED_DATE")!=null){
                String recievedDate = simpleDateFormat.format(rs.getDate("RECIEVED_DATE"));
                result.setRecievedDate(recievedDate);
            }
            if(rs.getDate("TGH_DATE")!=null){
                String tghDate = simpleDateFormat.format(rs.getDate("TGH_DATE"));
                result.setTghDate(tghDate);
            }
            /*String tghDate = simpleDateFormat.format(rs.getDate("TGH_DATE"));
            result.setTghDate(String.valueOf(rs.getDate("TGH_DATE")));*/
            result.setIncidentTypeCode(rs.getString("INCIDENT_TYPE_NAME"));
            result.setStatusCode(rs.getString("STATUS_NAME"));
            return result;
        });

        return results;
    }
    public ResponseEntity<APIResponse> updateTghIncident(TGH_INCIDENT_Insert_Req incident_insert_req) {
        APIResponse apiResponse = new APIResponse();
        System.out.println("mnbv");
        System.out.println(incident_insert_req.getCode());
        TGH_INCIDENT tgh_incident = tghIncidentRepo.findById(incident_insert_req.getCode()).orElse(null);
        try{
            if(Objects.isNull(tgh_incident)){
                apiResponse.setStatus(HttpStatus.NOT_FOUND);
                apiResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
                apiResponse.setClientMessage("This Incident isn't exist");
                return new ResponseEntity<APIResponse>(apiResponse, HttpStatus.NOT_FOUND);
            }
            if(tgh_incident.getCallerCityCode()==""||tgh_incident.getCallerCityCode()==null){
                apiResponse.setStatus(HttpStatus.BAD_REQUEST);
                apiResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
                apiResponse.setClientMessage("You Must Enter Caller City Code");
                return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
            }
            if(tgh_incident.getCallerTelNo()==""||tgh_incident.getCallerTelNo()==null){
                apiResponse.setStatus(HttpStatus.BAD_REQUEST);
                apiResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
                apiResponse.setClientMessage("You Must Enter Caller Tel No");
                return new ResponseEntity<APIResponse>(apiResponse, HttpStatus.BAD_REQUEST);
            }
            if(tgh_incident.getStatusCode()==null){
                apiResponse.setStatus(HttpStatus.BAD_REQUEST);
                apiResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
                apiResponse.setClientMessage("You Must Enter Status Code");
                return new ResponseEntity<APIResponse>(apiResponse, HttpStatus.BAD_REQUEST);
            }
            else{
                //caller city code
                if(!(incident_insert_req.getCallerCityCode().equals("") || incident_insert_req.getCallerCityCode()== null)){
                    tgh_incident.setCallerCityCode(incident_insert_req.getCallerCityCode());
                }
                //caller tel no
                if(!(incident_insert_req.getCallerTelNo().isEmpty() || incident_insert_req.getCallerTelNo()== null)){
                    tgh_incident.setCallerTelNo(incident_insert_req.getCallerTelNo());
                }
                //status code
                if(!(incident_insert_req.getStatusCode().isEmpty() || incident_insert_req.getStatusCode()== null)){
                    TGH_INCIDENT_STATUS statusCode = new TGH_INCIDENT_STATUS();
                    statusCode.setStatusCode(incident_insert_req.getStatusCode());
                    tgh_incident.setStatusCode(statusCode);
                }

                //receivedDate
                /*String receivedDate= String.valueOf(incident_insert_req.getRecievedDate());
                System.out.println("mmnn");
                System.out.println(receivedDate);
                Date date1=new SimpleDateFormat("MM-dd-yyyy").parse(receivedDate);*/
                if(!(incident_insert_req.getRecievedDate()== null)){
                    Date date1=new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(incident_insert_req.getRecievedDate());
                    tgh_incident.setRecievedDate(date1);
                }
                //receivedBy
                if(!(incident_insert_req.getRecievedBy().isEmpty() ||incident_insert_req.getRecievedBy()== null)){
                    tgh_incident.setRecievedBy(incident_insert_req.getRecievedBy());
                }
                //query flag
                if(!(incident_insert_req.getQueryFlag()==0)){
                    tgh_incident.setQueryFlag(incident_insert_req.getQueryFlag());
                }
                //tghId
                if(!(incident_insert_req.getTghId()==0)){
                    tgh_incident.setTghId(incident_insert_req.getTghId());
                }
                //caller name
                if(!(incident_insert_req.getCallerName()== null||incident_insert_req.getCallerName().isEmpty() )){
                    tgh_incident.setCallerName(incident_insert_req.getCallerName());
                }
                if(!(incident_insert_req.getIncidentTypeCode() == null||incident_insert_req.getIncidentTypeCode().equals(""))){
                    TGH_INCIDENT_TYPE type = new TGH_INCIDENT_TYPE();
                    type.setIncidentTypeCode(incident_insert_req.getIncidentTypeCode());
                    tgh_incident.setIncidentTypeCode(type);
                }
                //caller address
//                tgh_incident.setCallerAddress(incident_insert_req.getCallerAddress());
                if(!(incident_insert_req.getCallerAddress() == null||incident_insert_req.getCallerAddress().equals(""))){
                    tgh_incident.setCallerAddress(incident_insert_req.getCallerAddress());
                }
                //Incident Notes
                if(!(incident_insert_req.getIncidentNotes() == null||incident_insert_req.getIncidentNotes().equals(""))){
                    tgh_incident.setIncidentNotes(incident_insert_req.getIncidentNotes());
                }
                //Incident Notes
                if(!(incident_insert_req.getCustomerMobileNumber() == null||incident_insert_req.getCustomerMobileNumber().equals(""))){
                    tgh_incident.setCustomerMobileNumber(incident_insert_req.getCustomerMobileNumber());
                }
                //Customer Mobile Number
                if(incident_insert_req.getCustomerMobileNumber()!=null&&incident_insert_req.getCustomerMobileNumber().length()!=11){
                    apiResponse.setStatus(HttpStatus.OK);
                    apiResponse.setStatusCode(HttpStatus.OK.value());
                    apiResponse.setClientMessage("Customer Mobile Number Must be 11 digit");
                    return new ResponseEntity<APIResponse>(apiResponse, HttpStatus.OK);
                }else if(incident_insert_req.getCustomerMobileNumber()!=null&&incident_insert_req.getCustomerMobileNumber().length()==11){
                    tgh_incident.setCustomerMobileNumber(incident_insert_req.getCustomerMobileNumber());
                }
                /*tgh_incident.setRecordStatus("N");*/
                //code
               /*
                tgh_incident_temp.setIncidentId(tghIncident.getIncidentId());
                //receivedDate
                tgh_incident_temp.setRecievedDate(tghIncident.getRecievedDate());
                //receivedBy
                tgh_incident_temp.setRecievedBy(tghIncident.getRecievedBy());
                //query flag
                tgh_incident_temp.setQueryFlag(tghIncident.getQueryFlag());
                //tghId
                tgh_incident_temp.setTghId(tghIncident.getTghId());
                //caller name
                tgh_incident_temp.setCallerName(tghIncident.getCallerName());
                //caller address
                tgh_incident_temp.setCallerAddress(tghIncident.getCallerAddress());
                //caller city code
                tgh_incident_temp.setCallerCityCode(tghIncident.getCallerCityCode());
                //caller tel no
                tgh_incident_temp.setCallerTelNo(tghIncident.getCallerTelNo());
                //incident type code
                tgh_incident_temp.setIncidentTypeCode(tghIncident.getIncidentTypeCode());
                //status code
                if(tghIncident.getStatusCode()==null){
                    TGH_INCIDENT_STATUS statusCode = new TGH_INCIDENT_STATUS();
                    tgh_incident_temp.setStatusCode(statusCode);
                }else{
                    tgh_incident_temp.setStatusCode(tghIncident.getStatusCode());
                }
                //incident notes
                tgh_incident_temp.setIncidentNotes(tghIncident.getIncidentNotes());
                //incident recordStatus
               // tgh_incident_temp.setRecordStatus("N");*/

                TGH_INCIDENT result = tghIncidentRepo.save(tgh_incident);
                apiResponse.setStatus(HttpStatus.OK);
                apiResponse.setStatusCode(HttpStatus.OK.value());
                apiResponse.setClientMessage("Incident Updated Successfully");
                apiResponse.setBody(result);
                return new ResponseEntity<APIResponse>(apiResponse, HttpStatus.OK);
            }
        }catch (Exception ex){
            ex.printStackTrace();
            apiResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            apiResponse.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            apiResponse.setClientMessage(ex.getMessage());
           // apiResponse.setDeveloperMessage(ex.getCause().toString());
            return new ResponseEntity<APIResponse>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<APIResponse> getTghIncidentById(long incidentId) {
        TGH_INCIDENT incident = tghIncidentRepo.findById(incidentId).orElse(null);

        APIResponse apiResponse = new APIResponse();
        if(Objects.isNull(incident)){
            apiResponse.setStatus(HttpStatus.BAD_REQUEST);
            apiResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
            apiResponse.setClientMessage("This id isn't exist");
            return new ResponseEntity<APIResponse>(apiResponse, HttpStatus.BAD_REQUEST);
        }else {
            apiResponse.setStatus(HttpStatus.OK);
            apiResponse.setStatusCode(HttpStatus.OK.value());
            apiResponse.setClientMessage("retrieved incident successfully");
            apiResponse.setBody(incident);
            return new ResponseEntity<APIResponse>(apiResponse, HttpStatus.OK);
        }
    }

    @Override
    public ResponseEntity<APIResponse> archiveIncident(long incidentId) {
        TGH_INCIDENT incident = tghIncidentRepo.findById(incidentId).orElse(null);
        APIResponse apiResponse = new APIResponse();
        if(Objects.isNull(incident)){
            apiResponse.setStatus(HttpStatus.BAD_REQUEST);
            apiResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
            apiResponse.setClientMessage("This id isn't exist");
            return new ResponseEntity<APIResponse>(apiResponse, HttpStatus.BAD_REQUEST);
        }else {
            incident.setRecordStatus("D");
            incident.setArchivedBy(authService.getUserNameData());
            tghIncidentRepo.save(incident);
            apiResponse.setStatus(HttpStatus.OK);
            apiResponse.setStatusCode(HttpStatus.OK.value());
            apiResponse.setClientMessage("archived incident successfully");
            apiResponse.setBody(incident);
            return new ResponseEntity<APIResponse>(apiResponse, HttpStatus.OK);
        }
    }
}
