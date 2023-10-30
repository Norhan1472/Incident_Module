package incident.repos;

import incident.models.AR_INCIDENT;
import incident.payload.response.AR_INCIDENT_Search_Response;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AR_INCIDENT_Repo extends JpaRepository<AR_INCIDENT,Long> {
    @Query(value="  SELECT * FROM SYS_AUDIT WHERE (:ACTION_BY IS NULL OR lower(ACTION_BY) LIKE concat('%', concat(lower(:ACTION_BY), '%')))  AND \r\n"
            + "     (:ACTION_NAME IS NULL OR lower(ACTION_NAME) LIKE concat('%', concat(lower(:ACTION_NAME), '%'))) AND\r\n"
            + "     (:ACTION_DATE IS NULL OR to_date(ACTION_DATE) = to_date(:ACTION_DATE)) AND MODULE_ID=32 ORDER BY ACTION_DATE",
            countQuery ="  SELECT count(*) FROM SYS_AUDIT WHERE (:ACTION_BY IS NULL OR lower(ACTION_BY) LIKE concat('%', concat(lower(:ACTION_BY), '%')))  AND \r\n"
            + "     (:ACTION_NAME IS NULL OR lower(ACTION_NAME) LIKE concat('%', concat(lower(:ACTION_NAME), '%'))) AND\r\n"
            + "     (:ACTION_DATE IS NULL OR to_date(ACTION_DATE) = to_date(:ACTION_DATE)) AND MODULE_ID=32 ORDER BY ACTION_DATE",nativeQuery = true)
    public List<AR_INCIDENT_Search_Response> Search$Audit();

}
