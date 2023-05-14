package ie.emeraldjava.dualctxs.domain.repo;

import ie.emeraldjava.dualctxs.domain.jpa.RegionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegionRepo extends JpaRepository<RegionEntity, Long> {

}
