package incident.services.implementation;

import incident.models.TGH_INCIDENT_TYPE;
import incident.repos.TGH_INCIDENT_TYPE_REPO;
import incident.services.TGH_INCIDENT_TYPE_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TGH_INCIDENT_TYPE_Service_Impl implements TGH_INCIDENT_TYPE_Service {
    private final TGH_INCIDENT_TYPE_REPO incidentTypeCodeRepo;
    @Autowired
    public TGH_INCIDENT_TYPE_Service_Impl(TGH_INCIDENT_TYPE_REPO incidentTypeCodeRepo) {
        this.incidentTypeCodeRepo = incidentTypeCodeRepo;
    }

    @Override
    public List<TGH_INCIDENT_TYPE> getAllTypes() {
        return incidentTypeCodeRepo.findAll();
    }
}
