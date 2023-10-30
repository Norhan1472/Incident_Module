package incident.payload.request;

import incident.models.AR_INCIDENT;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class AR_INCIDENT_FOLLOWUP_PK implements Serializable {
    private Date actionDate;
    private String statusCode;
    private long ar_incident;
}
