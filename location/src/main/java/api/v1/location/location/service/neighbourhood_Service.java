package api.v1.location.location.service;
import api.v1.location.location.entity.neighbourhood;
import api.v1.location.location.repository.city_Repository;
import api.v1.location.location.repository.country_Repository;
import api.v1.location.location.repository.neighbourhood_Repository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.Optional;

//======================================================================================================================

@Service
public class neighbourhood_Service  {

    final
    neighbourhood_Repository neighbourhoodRepository;

    final
    country_Repository countryRepository;

    final
    city_Repository cityRepository;

//======================================================================================================================

    public neighbourhood_Service(neighbourhood_Repository neighbourhoodRepository, country_Repository countryRepository, city_Repository cityRepository) {
        this.neighbourhoodRepository = neighbourhoodRepository;
        this.countryRepository = countryRepository;
        this.cityRepository = cityRepository;
    }

//======================================================================================================================

    public neighbourhood getAllLocations(neighbourhood neighbourhoodId) {
        Optional<neighbourhood> check=neighbourhoodRepository.findById(neighbourhoodId.getId());
        if(check.isPresent())
        {
            return neighbourhoodRepository.findById(neighbourhoodId.getId()).get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,"Neighbourhood for which you are searching area does not exist ");
    }

//=====================================================================================================================

    public neighbourhood updateLocation(neighbourhood location) {
        Optional<neighbourhood> check=neighbourhoodRepository.findById(location.getId());
        if(check.isPresent()) {
            neighbourhood updateLocation = neighbourhoodRepository.findById(location.getId()).get();
            updateLocation.setNeighbourhood_Name(location.getNeighbourhood_Name());
            neighbourhoodRepository.save(updateLocation);
            return updateLocation;
        }
        throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,"Neighbourhood for which you want to update area does not exist ");
    }

//======================================================================================================================

    public neighbourhood addNeighbourhood(neighbourhood Neighbourhood) {
        Optional<neighbourhood> check=neighbourhoodRepository.findById(Neighbourhood.getId());
        if(check.isPresent())
        {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,"Neighbourhood already exist ");
        }
            return neighbourhoodRepository.save(Neighbourhood);
    }
}

//======================================================================================================================