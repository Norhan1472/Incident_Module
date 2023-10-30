package incident.models;

import com.fasterxml.jackson.annotation.JsonFormat;
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
@Table(name = "TGH_MSG_STATUS")
public class TGH_MSG_STATUS {
    @Id
    @Column(name = "STATUS_CODE")
    private String statusCode;
    @Column(name = "STATUS_NAME")
    private String statusName;
    @JsonIgnore
    @OneToMany(mappedBy = "tgh_msg_status")
    private Set<TGH_TELEGRAPH>telegraphs = new HashSet<>();
}
