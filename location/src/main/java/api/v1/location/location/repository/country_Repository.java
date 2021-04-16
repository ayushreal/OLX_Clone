package api.v1.location.location.repository;
import api.v1.location.location.entity.country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//======================================================================================================================

@Repository
public interface country_Repository extends JpaRepository<country, Integer> {
}

//======================================================================================================================
