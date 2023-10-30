package incident.payload.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import incident.models.TGH_INCIDENT;
import incident.models.TGH_INCIDENT_STATUS;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TGH_INCIDENT_FOLLOWUP_Response {
    private String statusCode;
    private String actionBy;
    private String actionDate;
    private String actionTaken;
    private String comments;
}
