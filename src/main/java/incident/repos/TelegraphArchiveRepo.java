package incident.repos;

import incident.models.TGH_TELEGRAPH_ARCHIVE;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TelegraphArchiveRepo extends JpaRepository<TGH_TELEGRAPH_ARCHIVE,Long> {
    @Query(value = "Select * from TGH_TELEGHRAPH_ARCHIVE where TGH_ID= :tghId",nativeQuery = true)
    TGH_TELEGRAPH_ARCHIVE findTelegraphById(long tghId);
}
