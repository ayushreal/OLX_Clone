package api.v1.location.location.repository;
import api.v1.location.location.entity.city;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//======================================================================================================================

@Repository
public interface city_Repository extends JpaRepository<city, Integer>{
}

//======================================================================================================================
