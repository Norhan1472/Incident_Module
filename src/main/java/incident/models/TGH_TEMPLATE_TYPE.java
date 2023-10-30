package incident.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TGH_TEMPLATE_TYPE")
public class TGH_TEMPLATE_TYPE {
    @Id
    @Column(name = "TEMP_TYPE_CODE")
    private String tempTypeCode;
    @Column(name = "TEMP_TYPE_NAME")
    private String tempTypeName;
    @OneToMany(mappedBy = "")
    private Set<TGH_TELEGRAPH>telegraphs = new HashSet<>();
}
