package api.v1.location.location.service;
import api.v1.location.location.entity.city;
import api.v1.location.location.repository.city_Repository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.Optional;

//======================================================================================================================

@Service
public class city_Service {

    final
    city_Repository cityRepository;

//======================================================================================================================

    public city_Service(city_Repository cityRepository) {
        this.cityRepository = cityRepository;
    }

//======================================================================================================================

    public city getAllNeighbourhood(city CityId) {
        Optional<city> check=cityRepository.findById(CityId.getId());
        if(check.isPresent())
        {
            return cityRepository.findById(CityId.getId()).get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,"City for which you are searching neighbourhood does not exist ");

    }

//======================================================================================================================

    public city addCity(city City) {
        Optional<city> check=cityRepository.findById(City.getId());
        if(check.isPresent())
        {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,"City already exist ");
        }
            return cityRepository.save(City);
    }

//======================================================================================================================

    public city updateLocation(city location) {
        Optional<city> check=cityRepository.findById(location.getId());
        if(check.isPresent()) {
            city updateLocation = cityRepository.findById(location.getId()).get();
            updateLocation.setCity_Name(location.getCity_Name());
            cityRepository.save(updateLocation);
            return updateLocation;
        }
        throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,"City for which you want to update location does not exist ");
    }
}

//======================================================================================================================
