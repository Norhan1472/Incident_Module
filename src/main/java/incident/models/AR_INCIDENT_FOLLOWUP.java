package incident.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import incident.payload.request.AR_INCIDENT_FOLLOWUP_PK;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "AR_INCIDENT_FOLLOWUP")
//@IdClass(AR_INCIDENT_FOLLOWUP_PK.class)
public class AR_INCIDENT_FOLLOWUP  {
    @ManyToOne
    @JoinColumn(name = "INCIDENT_ID")
    @JsonIgnore
//    @Id
    private AR_INCIDENT ar_incident;
    @Column(name = "STATUS_CODE")
//    @Id
    private String statusCode;
    @Column(name = "ACTION_BY")
    private String actionBy;
    @Column(name = "ACTION_DATE")
    @Id
    private Date actionDate;
    @Column(name = "ACTION_TAKEN")
    private String actionTaken;
    @Column(name = "COMMENTS")
    private String comments;
    @Column(name = "AR_DATE")
    private Date arDate;

}
