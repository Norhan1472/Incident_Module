package incident.payload.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class TGH_INCIDENT_FOLLOWUP_Req {
    private long incidentId;
    private String statusCode;
    private String actionBy;
    private String actionDate;
    private String actionTaken;
    private String comments;
}
