package incident.repos;

import incident.models.TGH_INCIDENT;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface TGH_INCIDENT_Repo extends JpaRepository<TGH_INCIDENT,Long> {
    @Query(value = "SELECT INC_SEQ.nextval FROM dual", nativeQuery = true)
    public BigDecimal getNextValINC_SEQ();
}
