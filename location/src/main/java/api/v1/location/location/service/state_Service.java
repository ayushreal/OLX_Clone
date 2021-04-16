package api.v1.location.location.service;
import api.v1.location.location.entity.state;
import api.v1.location.location.repository.city_Repository;
import api.v1.location.location.repository.state_Repository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.Optional;

//======================================================================================================================

@Service
public class state_Service {
    final
    city_Repository cityRepository;

    final
    state_Repository stateRepository;

//======================================================================================================================

    public state_Service(city_Repository cityRepository, state_Repository stateRepository) {
        this.cityRepository = cityRepository;
        this.stateRepository = stateRepository;
    }

//======================================================================================================================

    public state getAllCities(state stateId) {
        Optional<state> check=stateRepository.findById(stateId.getId());
        if(check.isPresent())
        {
            return stateRepository.findById(stateId.getId()).get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,"State for which you are searching cities does not exist ");
    }

//======================================================================================================================

    public state addState(state State) {
        Optional<state> check=stateRepository.findById(State.getId());
        if(check.isPresent())
        {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,"State already exist ");
        }
        return stateRepository.save(State);
    }

//======================================================================================================================

    public state updateLocation(state location) {
        Optional<state> check=stateRepository.findById(location.getId());
        if(check.isPresent()) {
            state updateLocation = stateRepository.findById(location.getId()).get();
            updateLocation.setState_Name(location.getState_Name());
            stateRepository.save(updateLocation);
            return updateLocation;
        }
        throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,"State for which you want to update location does not exist ");
    }
}

//======================================================================================================================