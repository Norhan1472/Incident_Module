package incident.repos;

import incident.models.TGH_CITY;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TGH_CITY_Repo extends JpaRepository<TGH_CITY,String>, JpaSpecificationExecutor<TGH_CITY> {
}
