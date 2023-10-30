package incident.services.implementation;

import incident.models.TGH_INCIDENT;
import incident.models.TGH_INCIDENT_FOLLOWUP;
import incident.models.TGH_INCIDENT_STATUS;
import incident.payload.request.TGH_INCIDENT_FOLLOWUP_Req;
import incident.payload.response.APIResponse;
import incident.payload.response.TGH_INCIDENT_FOLLOWUP_Response;
import incident.repos.TGH_INCIDENT_FOLLOWUP_Repo;
import incident.repos.TGH_INCIDENT_Repo;
import incident.services.TGH_INCIDENT_FOLLOWUP_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service

@Transactional
public class TGH_INCIDENT_FOLLOWUP_Service_Impl implements TGH_INCIDENT_FOLLOWUP_Service {
    private final TGH_INCIDENT_Repo incident_repo;
    private final TGH_INCIDENT_FOLLOWUP_Repo tgh_incident_followup_repo;
//    private TGH_INCIDENT_Repo incident_repo;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    public TGH_INCIDENT_FOLLOWUP_Service_Impl(TGH_INCIDENT_Repo incident_repo, TGH_INCIDENT_FOLLOWUP_Repo tghIncidentFollowupRepo) {
        this.incident_repo = incident_repo;
        this.tgh_incident_followup_repo = tghIncidentFollowupRepo;
    }

    @Override
    public ResponseEntity<APIResponse> getIncidentFollowUpByIncidentId(long incidentId) {
        APIResponse apiResponse = new APIResponse();
        if (incidentId == 0) {
            apiResponse.setStatus(HttpStatus.BAD_REQUEST);
            apiResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
            apiResponse.setClientMessage("YOU MUST ENTER INCIDENT ID");
            return new ResponseEntity<APIResponse>(apiResponse, HttpStatus.BAD_REQUEST);
        }
        TGH_INCIDENT tgh_incident = incident_repo.findById(incidentId).orElse(null);
        if(Objects.isNull(tgh_incident)){
                apiResponse.setStatus(HttpStatus.BAD_REQUEST);
                apiResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
                apiResponse.setClientMessage("This id isn't exist");
                return new ResponseEntity<APIResponse>(apiResponse, HttpStatus.BAD_REQUEST);
        }


        StringBuilder queryBuilder = new StringBuilder("SELECT " +
                "follow.STATUS_CODE " +
                ",follow.ACTION_BY,follow.ACTION_DATE, " +
                "follow.ACTION_TAKEN, " +
                "follow.COMMENTS " +
                "FROM TGH_INCIDENT_FOLLOWUP follow " +
                "where follow.INCIDENT_ID =?"
        );

        List<Object> queryParams = new ArrayList<>();
        queryParams.add(incidentId);

        String query = queryBuilder.toString();

        Object[] params = queryParams.toArray();
        // Execute the query
        @SuppressWarnings("deprecation")
        List<TGH_INCIDENT_FOLLOWUP_Response> results = jdbcTemplate.query(query, params, (rs, rowNum) -> {
            // Map the result rows to your Result class
            TGH_INCIDENT_FOLLOWUP_Response result = new TGH_INCIDENT_FOLLOWUP_Response();
            //StatusCode
            result.setStatusCode(rs.getString("STATUS_CODE"));
            //RECIEVED_BY
            result.setActionBy(rs.getString("ACTION_BY"));
            //RECIEVED_DATE
            String pattern = "dd-MM-yyyy HH:mm";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            String actionDate = simpleDateFormat.format(rs.getDate("ACTION_DATE"));
            result.setActionDate(actionDate);
            //TGH_ID
            result.setActionTaken(rs.getString("ACTION_TAKEN"));
            result.setComments(rs.getString("COMMENTS"));

            return result;
        });

        if (results.isEmpty()) {
            apiResponse.setStatus(HttpStatus.OK);
            apiResponse.setStatusCode(HttpStatus.OK.value());
            apiResponse.setClientMessage("No data found");
            return new ResponseEntity<APIResponse>(apiResponse, HttpStatus.OK);
        } else {
            apiResponse.setStatus(HttpStatus.OK);
            apiResponse.setStatusCode(HttpStatus.OK.value());
            apiResponse.setClientMessage("retrieved followup successfully");
            apiResponse.setBody(results);
            return new ResponseEntity<APIResponse>(apiResponse, HttpStatus.OK);
        }
    }

    @Override
    public ResponseEntity<APIResponse> insertIncidentFollowUp(TGH_INCIDENT_FOLLOWUP_Req followup_req) throws ParseException {
        APIResponse apiResponse = new APIResponse();
        if (followup_req.getIncidentId() == 0) {
            apiResponse.setStatus(HttpStatus.BAD_REQUEST);
            apiResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
            apiResponse.setClientMessage("YOU MUST ENTER INCIDENT ID");
            return new ResponseEntity<APIResponse>(apiResponse, HttpStatus.BAD_REQUEST);
        }
        System.out.println("llkk");
        System.out.println(followup_req.getStatusCode().isEmpty());
        System.out.println(followup_req.getStatusCode()==null);
        System.out.println(!(followup_req.getStatusCode().isEmpty()|| followup_req.getStatusCode()==null));
        if ((followup_req.getStatusCode().isEmpty()|| followup_req.getStatusCode()==null)
                ||followup_req.getStatusCode().equals(null)){
            apiResponse.setStatus(HttpStatus.BAD_REQUEST);
            apiResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
            apiResponse.setClientMessage("YOU MUST ENTER Status Code");
            return new ResponseEntity<APIResponse>(apiResponse, HttpStatus.BAD_REQUEST);

        }
        if ((followup_req.getActionBy().isEmpty()||
                followup_req.getActionBy()==null) ||
                followup_req.getActionBy()==""|| followup_req.getActionBy().equals(null)){
            apiResponse.setStatus(HttpStatus.BAD_REQUEST);
            apiResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
            apiResponse.setClientMessage("YOU MUST ENTER Action By");
            return new ResponseEntity<APIResponse>(apiResponse, HttpStatus.BAD_REQUEST);

        }
        if ((followup_req.getActionDate()==null||followup_req.getActionDate().isEmpty()
                ||followup_req.getActionDate()=="" ||followup_req.getActionDate().equals(null))){
            apiResponse.setStatus(HttpStatus.BAD_REQUEST);
            apiResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
            apiResponse.setClientMessage("YOU MUST ENTER Action Date");
            return new ResponseEntity<APIResponse>(apiResponse, HttpStatus.BAD_REQUEST);
        }
        TGH_INCIDENT_FOLLOWUP tgh_incident_followup = new TGH_INCIDENT_FOLLOWUP();
        TGH_INCIDENT tgh_incident = new TGH_INCIDENT();
        tgh_incident = incident_repo.findById(followup_req.getIncidentId()).get();
        // Incident Id
//        tgh_incident.setIncidentId(followup_req.getIncidentId());

        if (tgh_incident != null) {
            // Now, set tghIncident to tgh_incident_followup
            tgh_incident_followup.setTgh_incident(tgh_incident);
        }
        // Action Date
        Date date1=new SimpleDateFormat("dd-MM-yyyy HH:mm").parse(followup_req.getActionDate());
        tgh_incident_followup.setActionDate(date1);
        //Action Taken
        tgh_incident_followup.setActionTaken(followup_req.getActionTaken());
        //Comment
        tgh_incident_followup.setComments(followup_req.getComments());
        //Action By
        tgh_incident_followup.setActionBy(followup_req.getActionBy());
        //Status Code
        TGH_INCIDENT_STATUS incident_status = new TGH_INCIDENT_STATUS();
        incident_status.setStatusCode(followup_req.getStatusCode());
        tgh_incident_followup.setIncident_status(incident_status);
        // Record Status
        tgh_incident_followup.setRecordStatus("N");
        TGH_INCIDENT_FOLLOWUP f = tgh_incident_followup_repo.save(tgh_incident_followup);
            apiResponse.setStatus(HttpStatus.OK);
            apiResponse.setStatusCode(HttpStatus.OK.value());
            apiResponse.setClientMessage("TGH Incident FollowUp inserted Successfully");
            apiResponse.setBody(f);
            return new ResponseEntity<APIResponse>(apiResponse, HttpStatus.OK);
    }
}
