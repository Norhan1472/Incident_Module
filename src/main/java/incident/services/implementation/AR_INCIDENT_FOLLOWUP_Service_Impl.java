package incident.services.implementation;

import incident.models.AR_INCIDENT_FOLLOWUP;
import incident.models.TGH_INCIDENT;
import incident.payload.response.APIResponse;
import incident.payload.response.TGH_INCIDENT_FOLLOWUP_Response;
import incident.repos.TGH_INCIDENT_Repo;
import incident.services.AR_INCIDENT_FOLLOWUP_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class AR_INCIDENT_FOLLOWUP_Service_Impl implements AR_INCIDENT_FOLLOWUP_Service {
    private final TGH_INCIDENT_Repo incident_repo;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    public AR_INCIDENT_FOLLOWUP_Service_Impl(TGH_INCIDENT_Repo incidentRepo) {
        incident_repo = incidentRepo;
    }

    @Override
    public ResponseEntity<APIResponse> getArIncidentFollowUpByIncidentId(long incidentId) {
        APIResponse apiResponse = new APIResponse();
        if (incidentId == 0) {
            apiResponse.setStatus(HttpStatus.BAD_REQUEST);
            apiResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
            apiResponse.setClientMessage("YOU MUST ENTER INCIDENT ID");
            return new ResponseEntity<APIResponse>(apiResponse, HttpStatus.BAD_REQUEST);
        }
        /*TGH_INCIDENT tgh_incident = incident_repo.findById(incidentId).orElse(null);
        if(Objects.isNull(tgh_incident)){
            apiResponse.setStatus(HttpStatus.BAD_REQUEST);
            apiResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
            apiResponse.setClientMessage("This id isn't exist");
            return new ResponseEntity<APIResponse>(apiResponse, HttpStatus.BAD_REQUEST);
        }*/


        StringBuilder queryBuilder = new StringBuilder("SELECT " +
                "follow.STATUS_CODE " +
                ",follow.ACTION_BY,follow.ACTION_DATE, " +
                "follow.ACTION_TAKEN, " +
                "follow.COMMENTS, " +
                "follow.AR_DATE " +
                "FROM AR_INCIDENT_FOLLOWUP follow " +
                "where follow.INCIDENT_ID =?"
        );

        List<Object> queryParams = new ArrayList<>();
        queryParams.add(incidentId);

        String query = queryBuilder.toString();

        Object[] params = queryParams.toArray();
        // Execute the query
        @SuppressWarnings("deprecation")
        List<AR_INCIDENT_FOLLOWUP> results = jdbcTemplate.query(query, params, (rs, rowNum) -> {
            // Map the result rows to your Result class
            AR_INCIDENT_FOLLOWUP result = new AR_INCIDENT_FOLLOWUP();
            //StatusCode
            result.setStatusCode(rs.getString("STATUS_CODE"));
            //RECIEVED_BY
            result.setActionBy(rs.getString("ACTION_BY"));
            //RECIEVED_DATE
            /*String pattern = "dd-MM-yyyy HH:mm";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            String actionDate = simpleDateFormat.format(rs.getDate("ACTION_DATE"));*/
            result.setActionDate(rs.getDate("ACTION_DATE"));
            //Action Taken
            result.setActionTaken(rs.getString("ACTION_TAKEN"));
            //comments
            result.setComments(rs.getString("COMMENTS"));
            result.setArDate(rs.getDate("AR_DATE"));

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
            apiResponse.setClientMessage("followup archive retrieved successfully");
            apiResponse.setBody(results);
            return new ResponseEntity<APIResponse>(apiResponse, HttpStatus.OK);
        }
    }
}
