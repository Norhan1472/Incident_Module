package incident.payload.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TGH_TELEGRAPH_Custom_Search_Response {
    @JsonProperty("tghId")
    private long tghId;
    @JsonProperty("tghCode")
    private String tghCode;
    @JsonProperty("thgDate")
    @JsonFormat(pattern="dd/MM/yyyy")
    private String thgDate;
    @JsonProperty("callerTelNo")
    private String callerTelNo;
    @JsonProperty("callerName")
    private String callerName;
    @JsonProperty("recipientName")
    private String recipientName;
    @JsonProperty("callDate")
    @JsonFormat(pattern="dd/MM/yyyy")
    private String callDate;
    private String nationalId;
    private String billTelNo;
}
