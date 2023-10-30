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
@Table(name = "TGH_LANGUAGE")
public class TGH_LANGUAGE {
    @Id
    @Column(name = "LANG_CODE")
    private String languageCode;
    @Column(name = "LANG_NAME")
    private String languageName;
    @OneToMany(mappedBy = "tgh_language")
    @JsonIgnore
    private Set<TGH_TELEGRAPH>tgh_telegraphs = new HashSet<>();
}
