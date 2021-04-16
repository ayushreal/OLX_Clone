package api.v1.location.location.controller;
import api.v1.location.location.CountryConvertor.stateConvertor;
import api.v1.location.location.DTO.stateDTO;
import api.v1.location.location.entity.state;
import api.v1.location.location.service.state_Service;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

//======================================================================================================================

@RestController
public class state_Controller {

    state_Service stateService;

//======================================================================================================================

    @PostMapping("api/v1/location/cities/state_id")
    public stateDTO addState(@RequestBody state State){
        try {
            return stateConvertor.stateToDTO(stateService.addState(State));
        }
        catch(Exception e)
        {
            throw new ResponseStatusException(HttpStatus.BAD_GATEWAY, e.getMessage());
        }
    }

//======================================================================================================================

    @GetMapping("api/v1/location/cities/state_id")
    public stateDTO getAllCities(@RequestBody state stateId){
        try {
            return stateConvertor.stateToDTO(stateService.getAllCities(stateId));
        }
        catch(Exception e)
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

//======================================================================================================================

    @PostMapping("api/v1/location/cities/state_id_new")
    public stateDTO updateLocation(@RequestBody state location){
        try {
            return stateConvertor.stateToDTO(stateService.updateLocation(location));
        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_GATEWAY, e.getMessage());
        }
    }
}

//======================================================================================================================
