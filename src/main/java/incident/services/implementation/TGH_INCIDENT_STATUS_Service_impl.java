package incident.services.implementation;

import incident.models.TGH_INCIDENT_STATUS;
import incident.repos.TGH_INCIDENT_STATUS_REPO;
import incident.services.AuthServiceImpl;
import incident.services.TGH_INCIDENT_STATUS_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TGH_INCIDENT_STATUS_Service_impl implements TGH_INCIDENT_STATUS_Service {
    private final TGH_INCIDENT_STATUS_REPO tghIncidentStatusRepo;
    @Autowired
    private AuthServiceImpl authService;
    @Autowired
    public TGH_INCIDENT_STATUS_Service_impl(TGH_INCIDENT_STATUS_REPO tghIncidentStatusRepo) {
        this.tghIncidentStatusRepo = tghIncidentStatusRepo;
    }
    @Override
    public List<TGH_INCIDENT_STATUS> findAllStatus() {
        String userName =authService.getUserNameData();
        return tghIncidentStatusRepo.findStatusWithScope(userName);
    }
}
