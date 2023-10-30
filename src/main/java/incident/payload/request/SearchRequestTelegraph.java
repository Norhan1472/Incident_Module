package incident.payload.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.stereotype.Service;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SearchRequestTelegraph {
    @JsonProperty("tghCode")
    private String tghCode;
    @JsonProperty("thgDate")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private String thgDate;
    @JsonProperty("callerTelNo")
    private String callerTelNo;
    @JsonProperty("callerName")
    private String callerName;
    @JsonProperty("senderName")
    private String senderName;
    @JsonProperty("recipientName")
    private String recipientName;
    @JsonProperty("nationalId")
    private String nationalId;
    @JsonProperty("billTelNo")
    private String billTelNo;
    private String seqNo;
    private String officeCode;
    private String tghDateFrom;
    private String tghDateTo;
}
