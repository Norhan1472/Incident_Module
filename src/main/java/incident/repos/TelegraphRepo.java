package incident.repos;

import incident.models.TGH_TELEGRAPH;
import incident.models.TGH_TELEGRAPH_ARCHIVE;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Repository
public interface TelegraphRepo extends JpaRepository<TGH_TELEGRAPH,Long>, JpaSpecificationExecutor<TGH_TELEGRAPH> {

}
