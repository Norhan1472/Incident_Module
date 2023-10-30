package incident.payload.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.NaturalIdCache;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class TGH_CITY_Search_Request {
    private String countryCode;
    private String cityCode;
    private String cityName;

}
