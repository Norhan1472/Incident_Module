package incident.models;

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
@Table(name = "TGH_COUNTRY_VIP")
public class TGH_COUNTRY_VIP {
    @Id
    @Column(name = "COUNTRY_CODE")
    private String countryCode;
    @Column(name = "PERSON_TITLE")
    private String personTitle;
    @Column(name = "PERSON_NAME")
    private String personName;
    @ManyToOne
    @JoinColumn(name = "COUNTRY_CODE",updatable = false,insertable = false)
    private TGH_COUNTRY tghCountry;
}
