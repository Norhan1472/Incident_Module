package incident.repos;

import incident.models.TGH_INCIDENT_FOLLOWUP;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface TGH_INCIDENT_FOLLOWUP_Repo extends JpaRepository<TGH_INCIDENT_FOLLOWUP, Date> {
}
