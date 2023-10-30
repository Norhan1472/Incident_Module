package incident.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import incident.models.WLSConfig;


@Repository
public interface SysConfigDAO extends JpaRepository<WLSConfig, String>{

	@Query(value="select * from  MTS_SECURITY.web_logic_conf" , nativeQuery = true)
	public WLSConfig getWLSConfig();

}
