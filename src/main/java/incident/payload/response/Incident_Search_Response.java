package incident.payload.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Incident_Search_Response {
    private long code;
    private long tghId;
    private String recievedDate;
    private String recievedBy;
    private String tghCode;
    private String tghDate;
    private String IncidentTypeCode;
    private String statusCode;
}
