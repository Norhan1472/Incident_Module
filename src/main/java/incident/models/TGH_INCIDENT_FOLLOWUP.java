package incident.models;


import com.fasterxml.jackson.annotation.JsonFormat;
import incident.payload.request.TGH_INCIDENT_FOLLOWUP_PK;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "TGH_INCIDENT_FOLLOWUP")
@IdClass(value = TGH_INCIDENT_FOLLOWUP_PK.class)
public class TGH_INCIDENT_FOLLOWUP implements Serializable {
    @ManyToOne
    @JoinColumn(name = "INCIDENT_ID")
    @Id
    private TGH_INCIDENT tgh_incident ;
    @ManyToOne
    @JoinColumn(name = "STATUS_CODE")
    @Id
    private TGH_INCIDENT_STATUS incident_status;
    @Column(name = "ACTION_BY")
    private String actionBy;
    @Column(name = "ACTION_DATE")
    @Id
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private Date actionDate;
    @Column(name = "ACTION_TAKEN")
    private String actionTaken;
    @Column(name = "COMMENTS")
    private String comments;
    @Column(name = "RECORD_STATUS")
    private String recordStatus;

}
