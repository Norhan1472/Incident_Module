package incident.repos;

import incident.models.TGH_INCIDENT_STATUS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TGH_INCIDENT_STATUS_REPO extends JpaRepository<TGH_INCIDENT_STATUS,String> {
    @Query(value = "select tgh.* from TGH_INCIDENT_STATUS tgh\n" +
            "where tgh.status_code IN (\n" +
            " SELECT s.VALUE AS status_code\n" +
            " FROM MTS_SECURITY.SC_USERS u, MTS_SECURITY.SC_USERROLE r, MTS_SECURITY.SC_ROLESCOPES s\n" +
            " WHERE u.USER_ID = r.USER_ID AND r.ROLE_ID = s.ROLE_ID AND s.SCOPE_ID = 1 AND u.USER_NAME = :userName\n" +
            " )",nativeQuery = true)
    List<TGH_INCIDENT_STATUS> findStatusWithScope(String userName);
    /*@Query("Select status.statusName from TGH_INCIDENT_STATUS status ")
    public List<String>findAllStatusNames();*/
}
