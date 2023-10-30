package incident.services.implementation;

import incident.models.TGH_TELEGRAPH;
import incident.models.TGH_TELEGRAPH_ARCHIVE;
import incident.payload.request.SearchRequestTelegraph;
import incident.payload.response.APIResponse;
import incident.payload.response.TGH_TELEGRAPH_Custom_Search_Response;
import incident.payload.response.Telegraph_Response;
import incident.repos.TelegraphArchiveRepo;
import incident.repos.TelegraphRepo;
import incident.services.TelegraphService;
import incident.wrapper.TelegraphDTO;
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
import java.util.concurrent.atomic.AtomicLong;

@Service
@Transactional
public class TelegraphServiceImpl implements TelegraphService {
    private final TelegraphRepo telegraphRepo;
    @Autowired
    private TelegraphArchiveRepo telegraphArchiveRepo;
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    public TelegraphServiceImpl(TelegraphRepo telegraphRepo) {
        this.telegraphRepo = telegraphRepo;
    }

    public List<Object> searchOnTelegraph(SearchRequestTelegraph search, Pageable pageable) {
        StringBuilder queryBuilder = new StringBuilder("SELECT COUNT(*) OVER () AS TotalRowCount , " +
                "tgh.TGH_ID,tgh.TGH_CODE,tgh.NATIONAL_ID," +
                "tgh.CALLER_NAME,tgh.CALLER_TEL_NO,tgh.REC_NAME,tgh.CALL_DATE,tgh.TGH_DATE," +
                "tgh.NATIONAL_ID,tgh.BILL_TEL_NO"+
                 " FROM TELEGRAPH_ALL tgh "
                + " WHERE 1=1 ");


        List<Object> queryParams = new ArrayList<>();


        if (!(search.getTghCode() == null || search.getTghCode().equals(""))) {
            queryBuilder.append(" AND tgh.TGH_CODE= ?");
            queryParams.add(search.getTghCode());
        }

        if (!(search.getCallerName()== null || search.getCallerName().equals(""))) {
            queryBuilder.append(" AND tgh.CALLER_NAME= ? ");
            queryParams.add(search.getCallerName());
        }

        if (!(search.getCallerTelNo() == null || search.getCallerTelNo().equals(""))) {
            queryBuilder.append(" AND tgh.CALLER_TEL_NO = ?");
            queryParams.add(search.getCallerTelNo());
        }

        if (!(search.getThgDate() == null || search.getThgDate().equals(""))) {
            queryBuilder.append(" AND (to_char(tgh.TGH_DATE, 'dd/MM/yyyy')=?)");
            String[] data = search.getThgDate().split("/");
            String thgDate = search.getThgDate();
            if(data[0].length()==1){
                data[0]="0"+data[0];
                //System.out.println(data[0]);
                //System.out.println(thgDate.substring(0,1));
                thgDate= thgDate.replace(thgDate.substring(0,1),data[0]);
                //System.out.println("jjj");
                //System.out.println(thgDate);
            }
            if(data[1].length()==1){
                data[1]="0"+data[1];
                //System.out.println(data[1]);
                //System.out.println(thgDate.substring(3,4));
                thgDate= thgDate.replace(thgDate.substring(3,4),data[1]);
                //System.out.println("jjj");
                //System.out.println(thgDate);
            }
            queryParams.add(thgDate);
        }

        if (!(search.getSenderName() == null || search.getSenderName().equals(""))) {
            queryBuilder.append(" AND tgh.SENDER_NAME= ?");
            queryParams.add(search.getSenderName());
        }
        if (!(search.getRecipientName() == null || search.getRecipientName().equals(""))) {
            queryBuilder.append(" AND tgh.REC_NAME= ?");
            queryParams.add(search.getRecipientName());
        }
        if (!(search.getNationalId() == null || search.getNationalId().equals(""))) {
            queryBuilder.append(" AND tgh.NATIONAL_ID= ?");
            queryParams.add(search.getNationalId());
        }
        if (!(search.getBillTelNo() == null || search.getBillTelNo().equals(""))) {
            queryBuilder.append(" AND tgh.BILL_TEL_NO= ?");
            queryParams.add(search.getBillTelNo());
        }
        if (!(search.getOfficeCode() == null || search.getOfficeCode().equals(""))) {
            queryBuilder.append(" AND tgh.OFFICE_CODE= ?");
            queryParams.add(search.getOfficeCode());
        }
        if (!(search.getSeqNo() == null || search.getSeqNo().equals(""))) {
            queryBuilder.append(" AND tgh.SEQ_NO= ?");
            queryParams.add(search.getSeqNo());
        }
        if (!(search.getTghDateFrom() == null || search.getTghDateFrom().equals("")||search.getTghDateTo() == null || search.getTghDateTo().equals(""))) {
            queryBuilder.append(" AND tgh.TGH_DATE BETWEEN TO_DATE(?,'dd/MM/yyyy') AND TO_DATE(?,'dd/MM/yyyy')+1");
            queryParams.add(search.getTghDateFrom());
            queryParams.add(search.getTghDateTo());
        }
//        System.out.println("pageable.getOffset() "+pageable.getPageNumber());
//        System.out.println("pageable.getPageSize() "+pageable.getPageSize());

        queryBuilder.append("OFFSET ").append(pageable.getPageNumber()).
                append(" ROWS  FETCH NEXT ").append(pageable.getPageSize()).append(" ROWS ONLY");

        String query = queryBuilder.toString();
        System.out.println("query="+query);

        Object[] params = queryParams.toArray();
        final long[] totalResult = {0};
        // Execute the query
        @SuppressWarnings("deprecation")
        List<TGH_TELEGRAPH_Custom_Search_Response> results = jdbcTemplate.query(query, params, (rs, rowNum) -> {
            // Map the result rows to your Result class
            TGH_TELEGRAPH_Custom_Search_Response result = new TGH_TELEGRAPH_Custom_Search_Response();
            totalResult[0] = (rs.getLong("TotalRowCount"));
            result.setTghId(rs.getLong("TGH_ID"));
            result.setTghCode(rs.getString("TGH_CODE"));
            String pattern = "dd/MM/yyyy";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

            String thgDate = simpleDateFormat.format(rs.getDate("TGH_DATE"));
            result.setThgDate(thgDate);
            result.setCallDate(String.valueOf(rs.getDate("CALL_DATE")));
            result.setRecipientName(rs.getString("REC_NAME"));
            result.setCallerTelNo(rs.getString("CALLER_TEL_NO"));
            result.setCallerName(rs.getString("CALLER_NAME"));
//            String callDate = simpleDateFormat.format(rs.getDate("CALL_DATE"));
//            result.setCallDate(callDate);
            result.setNationalId(rs.getString("NATIONAL_ID"));
            result.setBillTelNo(rs.getString("BILL_TEL_NO"));

            return result;
        });

        int total = jdbcTemplate.queryForObject("SELECT count(*) " +
                " FROM TELEGRAPH_ALL tgh " +
                " WHERE 1=1 ", Integer.class);
        // return results;
        Page<TGH_TELEGRAPH_Custom_Search_Response> page = new PageImpl<>(results, pageable, total);
        List<Object> data = new ArrayList<>();
        data.add(page.getContent());
        data.add(totalResult[0]);
        data.add(page.getPageable().getPageSize());
        data.add(page.getPageable().getPageNumber());
        
       return data;
       
    }

    @Override
    public ResponseEntity<APIResponse> getTelegraphById(long tghId) {
        TGH_TELEGRAPH_ARCHIVE telegraph = telegraphArchiveRepo.findTelegraphById(tghId);
        TelegraphDTO telegraphDTO = new TelegraphDTO();
        Telegraph_Response response =  telegraphDTO.mapTelegraphIntoResponse(telegraph);
        APIResponse apiResponse = new APIResponse();
        if(Objects.isNull(telegraph)){
            apiResponse.setStatus(HttpStatus.BAD_REQUEST);
            apiResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
            apiResponse.setClientMessage("This id isn't exist");
            return new ResponseEntity<APIResponse>(apiResponse, HttpStatus.BAD_REQUEST);
        }else {
            apiResponse.setStatus(HttpStatus.OK);
            apiResponse.setStatusCode(HttpStatus.OK.value());
            apiResponse.setClientMessage("telegraph retrieved successfully");
            apiResponse.setBody(response);
            return new ResponseEntity<APIResponse>(apiResponse, HttpStatus.OK);
        }
    }

}
