package incident.repos;

import incident.models.AR_INCIDENT_FOLLOWUP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface AR_INCIDENT_FOLLOWUP_Repo extends JpaRepository<AR_INCIDENT_FOLLOWUP, Date> {
}
