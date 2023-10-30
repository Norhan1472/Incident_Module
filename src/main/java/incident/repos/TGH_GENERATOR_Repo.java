package incident.repos;

import incident.models.TGH_GENERATOR;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TGH_GENERATOR_Repo extends JpaRepository<TGH_GENERATOR,Long> {
}
