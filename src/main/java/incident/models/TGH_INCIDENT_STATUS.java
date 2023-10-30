package incident.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "TGH_INCIDENT_STATUS")
public class TGH_INCIDENT_STATUS {
    @Id
    @Column(name = "STATUS_CODE")
    private String statusCode;
    @Column(name = "STATUS_NAME")
    private String statusName;
    @Column(name = "SUPPORT_ARCHIEVE")
    private Integer supportArchive;
    @Column(name = "IS_CLOSED")
    private Integer isClosed;
    @OneToMany(mappedBy = "statusCode")
    @JsonIgnore
    private Set<TGH_INCIDENT> tghIncidents = new HashSet<>();
    @OneToMany(mappedBy = "incident_status")
    @JsonIgnore
    private Set<TGH_INCIDENT_FOLLOWUP>incident_followups = new HashSet<>();
}
