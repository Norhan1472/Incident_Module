package incident.repos;

import incident.models.TGH_INCIDENT_TYPE;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TGH_INCIDENT_TYPE_REPO extends JpaRepository<TGH_INCIDENT_TYPE,String> {
}
