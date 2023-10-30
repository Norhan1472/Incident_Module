package incident.payload.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.Column;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AR_INCIDENT_search_Req {
    private long code;
    private long tghId;
    private String callerName;
    private String callerAddress;
    private String callerTelNo;
    private String incidentTypeCode;
    private String receivedBy;
    private String receivedDate;
    private String archiveDate;
    private String archivedBy;
    private String tghDate;
}
