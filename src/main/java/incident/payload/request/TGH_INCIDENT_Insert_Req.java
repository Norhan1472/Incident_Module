package incident.payload.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class TGH_INCIDENT_Insert_Req {
    private long code;
    private String callerCityCode;
    private String callerTelNo;
    private String statusCode;
    private String recievedDate;
    private String recievedBy;
    private int queryFlag;
    private long tghId;
    private String callerName;
    private String incidentTypeCode;
    private String callerAddress;
    private String incidentNotes;
    private String customerMobileNumber;
}
