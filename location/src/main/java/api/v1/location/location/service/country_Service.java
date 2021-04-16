package api.v1.location.location.service;
import api.v1.location.location.entity.country;
import api.v1.location.location.repository.country_Repository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.Optional;

//======================================================================================================================

@Service
public class country_Service {

    final
    country_Repository countryRepository;

//======================================================================================================================

    public country_Service(country_Repository countryRepository) {
        this.countryRepository = countryRepository;
    }

//======================================================================================================================

    public country getAllStates(country countryId) {
        Optional<country> check=countryRepository.findById(countryId.getId());
        if(check.isPresent())
        {
            return countryRepository.findById(countryId.getId()).get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,"Country for which you are searching states does not exist ");
    }

//======================================================================================================================

    public country getCurrency(country Currency) {
        Optional<country> check=countryRepository.findById(Currency.getId());
        if(check.isPresent())
        {
            return countryRepository.findById(Currency.getId()).get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,"Country for which you are searching currency does not exist ");
    }

//======================================================================================================================

    public country addCountry(country Country) {
        Optional<country> check=countryRepository.findById(Country.getId());
        if(check.isPresent())
        {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,"Country already exist ");
        }
        return countryRepository.save(Country);
    }

//======================================================================================================================

    public country updateLocation(country location) {

        Optional<country> check=countryRepository.findById(location.getId());
        if(check.isPresent()) {
            country updateLocation = countryRepository.findById(location.getId()).get();
            updateLocation.setCountry_Name(location.getCountry_Name());
            countryRepository.save(updateLocation);
            return updateLocation;
        }
        throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,"Country for which you want to update location does not exist ");
    }
}

//======================================================================================================================
