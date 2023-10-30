package incident.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "TGH_RECEPIENT")
public class TGH_RECEPIENT {
    @Id
    @Column(name = "REC_ID")
    @JsonIgnore
    private long recId;
    @Column(name = "REC_NAME")
    private String recipientName;
    @Column(name = "REC_TEL_NO")
    private String recipientTelNo;
    @Column(name = "ADDRESS")
    private String address;
    @ManyToOne
    @JoinColumn(name = "GEN_ID")
    @JsonIgnore
    private TGH_GENERATOR tgh_generator;
}
