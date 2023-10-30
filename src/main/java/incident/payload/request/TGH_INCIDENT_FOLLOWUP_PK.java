package incident.payload.request;

import incident.models.TGH_INCIDENT;
import incident.models.TGH_INCIDENT_STATUS;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class TGH_INCIDENT_FOLLOWUP_PK  implements Serializable {
    private String incident_status;
    private Long tgh_incident ;
    private Date actionDate;
}
