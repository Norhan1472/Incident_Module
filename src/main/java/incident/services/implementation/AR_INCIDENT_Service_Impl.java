package incident.services.implementation;

import incident.models.AR_INCIDENT;
import incident.models.TGH_INCIDENT_TYPE;
import incident.payload.request.AR_INCIDENT_search_Req;
import incident.payload.response.APIResponse;
import incident.payload.response.AR_INCIDENT_Search_Response;
import incident.repos.AR_INCIDENT_Repo;
import incident.repos.TGH_INCIDENT_STATUS_REPO;
import incident.repos.TGH_INCIDENT_TYPE_REPO;
import incident.services.AR_INCIDENT_Service;
import incident.wrapper.AR_TELEGRAPH_DTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
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
public class AR_INCIDENT_Service_Impl implements AR_INCIDENT_Service {
    private final AR_INCIDENT_Repo ar_incident_repo;

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    TGH_INCIDENT_STATUS_REPO incident_status_repo;
    @Autowired
    TGH_INCIDENT_TYPE_REPO tgh_incident_type_repo;
    @Autowired
    public AR_INCIDENT_Service_Impl(AR_INCIDENT_Repo arIncidentRepo) {
        ar_incident_repo = arIncidentRepo;
    }

    @Override
    public List<Object> searchArIncident(AR_INCIDENT_search_Req searchRequest, Pageable pageable) {
        StringBuilder queryBuilder = new StringBuilder("SELECT COUNT(*) OVER () AS TotalRowCount,"
                + "ar.INCIDENT_ID,ar.RECIEVED_DATE,ar.RECIEVED_BY,"
                + "ar.TGH_ID,"
                + "ar.INCIDENT_TYPE_CODE,ar.ARCHIVED_BY "
                + "FROM AR_INCIDENT ar "
                + "LEFT JOIN TGH_TELEGRAPH tgh "
                + "ON ar.TGH_ID = tgh.TGH_ID "
                + " WHERE 1=1");


        List<Object> queryParams = new ArrayList<>();

        //INCIDENT_ID
        if (searchRequest.getCode() != 0) {
            queryBuilder.append(" AND ar.INCIDENT_ID= ?");
            queryParams.add(searchRequest.getCode());
        }
        //TGH_ID
        if (searchRequest.getTghId() != 0) {
            queryBuilder.append(" AND ar.TGH_ID= ?");
            queryParams.add(searchRequest.getTghId());
        }
        //CALLER_NAME
        if (!(searchRequest.getCallerName()== null || searchRequest.getCallerName().equals(""))) {
            queryBuilder.append(" AND ar.CALLER_NAME= ? ");
            queryParams.add(searchRequest.getCallerName());
        }
        //CALLER_ADDRESS
        if (!(searchRequest.getCallerAddress()== null || searchRequest.getCallerAddress().equals(""))) {
            queryBuilder.append(" AND ar.CALLER_ADDRESS= ? ");
            queryParams.add(searchRequest.getCallerAddress());
        }
        //CALLER_TEL_NO
        if (!(searchRequest.getCallerTelNo() == null || searchRequest.getCallerTelNo().equals(""))) {
            queryBuilder.append(" AND ar.CALLER_TEL_NO = ?");
            queryParams.add(searchRequest.getCallerTelNo());
        }
        //INCIDENT_TYPE_CODE
        if (!(searchRequest.getIncidentTypeCode() == null || searchRequest.getIncidentTypeCode().equals(""))) {
            queryBuilder.append(" AND ar.INCIDENT_TYPE_CODE = ?");
            queryParams.add(searchRequest.getIncidentTypeCode());
        }

        //RECIEVED_BY
        if (!(searchRequest.getReceivedBy() == null || searchRequest.getReceivedBy().equals(""))) {
            queryBuilder.append(" AND ar.RECIEVED_BY = ?");
            queryParams.add(searchRequest.getReceivedBy());
        }
        //ARCHIVED_BY
        if (!(searchRequest.getArchivedBy() == null || searchRequest.getArchivedBy().equals(""))) {
            queryBuilder.append(" AND ar.ARCHIVED_BY = ?");
            queryParams.add(searchRequest.getArchivedBy());
        }
        //RECIEVED_DATE
        if (!(searchRequest.getReceivedDate() == null || searchRequest.getReceivedDate().equals(""))) {
            queryBuilder.append(" AND (to_char(ar.RECIEVED_DATE, 'dd/MM/yyyy')=?)");
            String[] data = searchRequest.getReceivedDate().split("/");
            String receivedDate = searchRequest.getReceivedDate();
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
        //ARCHIVE_DATE
        if (!(searchRequest.getArchiveDate() == null || searchRequest.getArchiveDate().equals(""))) {
            queryBuilder.append(" AND (to_char(ar.ARCHIVE_DATE, 'dd/MM/yyyy')=?)");
            String[] data = searchRequest.getArchiveDate().split("/");
            String archiveDate = searchRequest.getArchiveDate();
            if(data[0].length()==1){
                data[0]="0"+data[0];
                archiveDate= archiveDate.replace(archiveDate.substring(0,1),data[0]);
            }
            if(data[1].length()==1){
                data[1]="0"+data[1];
                archiveDate= archiveDate.replace(archiveDate.substring(3,4),data[1]);
            }
            queryParams.add(archiveDate);
        }
        //TGH_DATE
        if (!(searchRequest.getTghDate() == null || searchRequest.getTghDate().equals(""))) {
            queryBuilder.append(" AND (to_char(tgh.TGH_DATE, 'dd/MM/yyyy')=?)");
            String[] data = searchRequest.getTghDate().split("/");
            String tghDate = searchRequest.getTghDate();
            if(data[0].length()==1){
                data[0]="0"+data[0];
                tghDate= tghDate.replace(tghDate.substring(0,1),data[0]);
            }
            if(data[1].length()==1){
                data[1]="0"+data[1];
                tghDate= tghDate.replace(tghDate.substring(3,4),data[1]);
            }
            queryParams.add(tghDate);
        }
        System.out.println("pageable.getOffset() "+pageable.getOffset());
        System.out.println("pageable.getPageSize() "+pageable.getPageSize());
        queryBuilder.append("OFFSET ").append(pageable.getPageNumber()).
                append(" ROWS  FETCH NEXT ").append(pageable.getPageSize()).append(" ROWS ONLY");
       // queryBuilder.append(" and LIMIT ? OFFSET ?");
//        queryParams.add(pageable.getPageSize());
//        queryParams.add(pageable.getOffset());

        String query = queryBuilder.toString();
        //System.out.println("query="+query);

        Object[] params = queryParams.toArray();
        final long[] totalResult = {0};
        // Execute the query
        @SuppressWarnings("deprecation")
        List<AR_INCIDENT_Search_Response> results = jdbcTemplate.query(query, params, (rs, rowNum) -> {
            // Map the result rows to your Result class
            AR_INCIDENT_Search_Response result = new AR_INCIDENT_Search_Response();
            totalResult[0] = (rs.getLong("TotalRowCount"));
            //code
            result.setCode(rs.getLong("INCIDENT_ID"));
            //RECIEVED_BY
            result.setRecievedBy(rs.getString("RECIEVED_BY"));
            //RECIEVED_DATE
            String pattern = "dd-MM-yyyy HH:mm";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            String receivedDate = simpleDateFormat.format(rs.getDate("RECIEVED_DATE"));
            result.setRecievedDate(receivedDate);
            //TGH_ID
            result.setTghId(rs.getLong("TGH_ID"));
            String type="";
            if(rs.getString("INCIDENT_TYPE_CODE")!=null){
                 type = tgh_incident_type_repo.findById(rs.getString("INCIDENT_TYPE_CODE")).get().getIncidentTypeName();
            }
            result.setIncidentTypeCode(type);
            result.setArchivedBy(rs.getString("ARCHIVED_BY"));

            return result;
        });

        int total = jdbcTemplate.queryForObject("SELECT count(*) " +
                " FROM AR_INCIDENT ar " +
                " LEFT JOIN TGH_TELEGRAPH tgh " +
                " ON ar.TGH_ID = tgh.TGH_ID" +
                "  WHERE 1=1", Integer.class);
        // return results;
        Page<AR_INCIDENT_Search_Response> page = new PageImpl<>(results, pageable, total);
        List<Object> data = new ArrayList<>();
        data.add(page.getContent());
        data.add(totalResult[0]);
        data.add(page.getPageable().getPageSize());
        data.add(page.getPageable().getPageNumber());
       // data.add(page.getPageable())
//        data.add(total);
        return data;
    }

    /*
    ALTER TABLE your_table
ALTER CONSTRAINT constraint_name <new_constraint_definition>;

     */

    @Override
    public ResponseEntity<APIResponse> getDataByCode(long code) {
        System.out.println("here1");

        // Step 1: Retrieve AR_INCIDENT from the repository
        AR_INCIDENT ar_incident = ar_incident_repo.findById(code).orElse(null);

        APIResponse apiResponse = new APIResponse();

        if (Objects.isNull(ar_incident)) {
            // Step 2: Handle the case when AR_INCIDENT is not found
            apiResponse.setStatus(HttpStatus.BAD_REQUEST);
            apiResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
            apiResponse.setClientMessage("This id doesn't exist");
            return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
        } else {
            AR_TELEGRAPH_DTO telegraphDto =new AR_TELEGRAPH_DTO();
            System.out.println("here2");
            AR_INCIDENT ar2 = new AR_INCIDENT();
            String statusName="";
            String typeName="";
            if(ar_incident.getStatusCode()!=null){
                statusName = incident_status_repo.findById(ar_incident.getStatusCode()).get().getStatusName();
            }
            if(ar_incident.getIncidentTypeCode()!=null) {
                typeName = tgh_incident_type_repo.findById(ar_incident.getIncidentTypeCode()).get().getIncidentTypeName();
            }
            ar2 = telegraphDto.mapTelegraphIntoResponse(ar_incident,statusName,typeName);
            // Step 3: Retrieve status and type names from repositories

            // Step 5: Update AR_INCIDENT properties in the copy
            ar2.setStatusCode(statusName);

            System.out.println("here3");
            System.out.println(typeName);

            // Step 6: Populate the APIResponse with the modified AR_INCIDENT copy
            apiResponse.setStatus(HttpStatus.OK);
            apiResponse.setStatusCode(HttpStatus.OK.value());
            apiResponse.setClientMessage("Archived incident retrieved successfully");
            apiResponse.setBody(ar2); // Return the modified copy

            // Step 7: Return a response with the modified AR_INCIDENT copy
            return new ResponseEntity<>(apiResponse, HttpStatus.OK);
        }
    }

}
/*
select * from tgh_post_office p , OFFICIAL_Telegraph tgh,TGH_POST_OFFICE p1
where    tgh.ORIGIN_OFFICE = p.OFFICE_CODE
                        AND tgh.OFFICE_CODE=p1.OFFICE_CODE
--                        and tgh_id=1000112568
                        and   tgh.SEQ_NO= :seqNo
                        and  ((
                            SELECT COUNT(*)
                            FROM MTS_SECURITY.SC_USER_PERMISSION sec
                            WHERE
                                lower(sec.USER_NAME) = lower('superuser')
                                AND sec.MODULE_ID = 7
                                AND sec.permission_Name = 'OfficialTelegraph.view'

                        ) = 1
                        and p.office_code in (SELECT s.VALUE
                            FROM MTS_SECURITY.SC_USERS u, MTS_SECURITY.SC_USERROLE r, MTS_SECURITY.SC_ROLESCOPES s
                            WHERE
                                u.USER_ID = r.USER_ID
                                AND r.ROLE_ID = s.ROLE_ID
                                AND s.SCOPE_ID = 2
                                AND u.USER_NAME = 'superuser' ) or (
                            SELECT COUNT(*)
                            FROM MTS_SECURITY.SC_USER_PERMISSION sec
                            WHERE
                                lower(sec.USER_NAME) = lower('superuser')
                                AND sec.MODULE_ID = 7
                                AND sec.permission_Name in  ('OfficialTelegraph.viewAll','OfficialTelegraph.view')

                        ) = 2);
 */


//    nvl(tgh_incident.ARCHIVE_BY,v_ARCHIVED_BY)