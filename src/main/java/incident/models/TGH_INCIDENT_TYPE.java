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
@Table(name = "TGH_INCIDENT_TYPE")
public class TGH_INCIDENT_TYPE {
    @Id
    @Column(name = "INCIDENT_TYPE_CODE")
    private String incidentTypeCode;
    @Column(name = "INCIDENT_TYPE_NAME")
    private String incidentTypeName;
    @OneToMany(mappedBy = "incidentTypeCode")//,fetch = FetchType.EAGER
    @JsonIgnore
    private Set<TGH_INCIDENT>tghIncidents = new HashSet<>();

}
