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
@Table(name = "TGH_COUNTRY")
public class TGH_COUNTRY {
    @Id
    @Column(name = "COUNTRY_CODE")
    private String countryCode;
    @Column(name = "COUNTRY_NAME")
    private String countryName;
    @OneToMany(mappedBy = "countryCode")
    @JsonIgnore
    private Set<TGH_CITY>tghCities = new HashSet<>();
    @OneToMany(mappedBy = "tgh_country")
    @JsonIgnore
    private Set<TGH_TELEGRAPH>tgh_telegraphs = new HashSet<>();
    @OneToMany(mappedBy = "tghCountry")
    @JsonIgnore
    private Set<TGH_COUNTRY_VIP>countryVips = new HashSet<>();
}
