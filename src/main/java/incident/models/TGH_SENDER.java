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
@Table(name = "TGH_SENDER")
public class TGH_SENDER {
    @Id
    @Column(name = "SENDER_ID")
    @JsonIgnore
    private long senderId;
    @ManyToOne
    @JoinColumn(name = "GEN_ID")
    @JsonIgnore
    private TGH_GENERATOR tgh_generator;
    @Column(name = "SENDER_NAME")
    private String senderName;
    @Column(name = "BILL_TEL_NO")
    private String billTelNo;
    @Column(name = "NOTES")
    private String notes;
}
