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
@Table(name = "TGH_POST_OFFICE")
public class TGH_POST_OFFICE {
    @Id
    @Column(name = "OFFICE_CODE")
    private String officeCode;
    @Column(name = "OFFICE_NAME")
    private String officeName;
    @OneToMany(mappedBy = "")
    @JsonIgnore
    private Set<TGH_TELEGRAPH>tgh_telegraphs = new HashSet<>();
}
