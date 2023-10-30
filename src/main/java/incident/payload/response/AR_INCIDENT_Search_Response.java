package incident.payload.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AR_INCIDENT_Search_Response {
    private long code;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
    private String recievedDate;
    private String recievedBy;
    private long tghId;
    private String incidentTypeCode;
    private String archivedBy;

}
