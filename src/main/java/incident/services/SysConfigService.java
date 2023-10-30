package incident.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import incident.models.WLSConfig;
import incident.repos.SysConfigDAO;

@Service
public class SysConfigService {

	@Autowired
	SysConfigDAO dao;


	public WLSConfig getWLSConfig() {
		return dao.getWLSConfig();
	}

}
