package api.v1.location.location.repository;
import api.v1.location.location.entity.neighbourhood;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//======================================================================================================================

@Repository
public interface neighbourhood_Repository extends JpaRepository<neighbourhood, Integer> {
}

//======================================================================================================================
