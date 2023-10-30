package incident.payload.request;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import incident.models.TGH_INCIDENT_STATUS;
import incident.models.TGH_INCIDENT_TYPE;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Incident_Search_Request {
    @JsonProperty("code")
    private long incidentId;
    @JsonProperty("tghId")
    private long telegraphId; //tghCode,tghDate,seqNo
    @JsonProperty("tghCode")
    private String tghCode;
    @JsonProperty("tghDate")
    private String tghDate;
    @JsonProperty("seqNo")
    private long seqNo;
    @JsonProperty("callerName")
    private String callerName;
    @JsonProperty("callerAddress")
    private String callerAddress;
    @JsonProperty("callerTelNo")
    private String callerTelNo;
    @JsonProperty("statusCode")
    private String statusCode;
    @JsonProperty("incidentTypeCode")
    private String incidentTypeCode;
    /*@JsonProperty("incidentNotes")
    private String incidentNotes;*/
    @JsonProperty("callerCityCode")
    private String callerCityCode;
    @JsonProperty("recievedBy")
    private String recievedBy;
    @JsonProperty("recievedDate")
    private String recievedDate;
    /*@JsonProperty("recordStatus")
    private String recordStatus;*/
    @JsonProperty("customerMobileNumber")
    private String customerMobileNumber;
}
