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
@Table(name = "TGH_CITY")
public class TGH_CITY {
    @Id
    @Column(name = "CITY_CODE")
    private String cityCode;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "COUNTRY_CODE")
    private TGH_COUNTRY countryCode;
    @Column(name = "CITY_NAME")
    private String cityName;
}
