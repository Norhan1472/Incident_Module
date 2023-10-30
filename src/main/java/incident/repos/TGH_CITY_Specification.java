package incident.repos;

import incident.models.TGH_CITY;
import incident.models.TGH_COUNTRY;
import incident.payload.request.TGH_CITY_Search_Request;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;


public class TGH_CITY_Specification implements Specification<TGH_CITY> {
    private final TGH_CITY_Search_Request tghCitySearchRequest;
    @Autowired
    public TGH_CITY_Specification(TGH_CITY_Search_Request tghCitySearchRequest) {
        this.tghCitySearchRequest = tghCitySearchRequest;
    }

    @Override
    public Predicate toPredicate(Root<TGH_CITY> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates1=new ArrayList<>();
        Predicate predicateForSearch;
        System.out.println("here");
        if(tghCitySearchRequest.getCityCode()!=null &&!tghCitySearchRequest.getCityCode().isEmpty()) {
            predicates1.add(criteriaBuilder.like(root.get("cityCode"), "%" + tghCitySearchRequest.getCityCode() + "%"));
        }

        if(tghCitySearchRequest.getCityName()!=null &&!tghCitySearchRequest.getCityName().isEmpty()) {
            predicates1.add(criteriaBuilder.like(root.get("cityName"), "%" +tghCitySearchRequest.getCityName() + "%"));
        }
        if(tghCitySearchRequest.getCountryCode()!=null &&!tghCitySearchRequest.getCountryCode().isEmpty()) {
            TGH_COUNTRY tgh = new TGH_COUNTRY();
            tgh.setCountryCode(tghCitySearchRequest.getCountryCode());
            predicates1.add(criteriaBuilder.equal(root.get("countryCode"),tgh));
        }
        predicateForSearch=criteriaBuilder.and(predicates1.toArray(new Predicate[0]));

        query.multiselect(root.get("cityCode").as(String.class), root.get("cityName").as(String.class));
        query.where(predicateForSearch);

        return criteriaBuilder.and(predicateForSearch);
    }
}
