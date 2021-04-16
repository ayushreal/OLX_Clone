package api.v1.location.location.controller;
import api.v1.location.location.CountryConvertor.countryConvertor;
import api.v1.location.location.DTO.countryDTO;
import api.v1.location.location.entity.country;
import api.v1.location.location.service.country_Service;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

//======================================================================================================================

@RestController
public class country_Controller {

    private final country_Service countryService;

    public country_Controller(country_Service countryService) {
        this.countryService = countryService;
    }

//======================================================================================================================

    @PostMapping("api/v1/location/country")
    public countryDTO addCountry(@RequestBody country Country){
        try {
            return countryConvertor.countryToDTO(countryService.addCountry(Country));
        }
        catch(Exception e)
        {
            throw new ResponseStatusException(HttpStatus.BAD_GATEWAY, e.getMessage());
        }
    }

//======================================================================================================================

    @GetMapping("api/v1/location/state")
    public countryDTO getAllStates(@RequestBody country countryID){
        try {
            return countryConvertor.countryToDTO(countryService.getAllStates(countryID));
        }
        catch(Exception e)
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

//======================================================================================================================

    @GetMapping("api/v1/location/currency")
    public countryDTO getCurrency(@RequestBody country Currency){
        try {
            return countryConvertor.countryToDTO(countryService.getCurrency(Currency));
        }
        catch(Exception e)
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

//======================================================================================================================

    @PostMapping("api/v1/location/country_new")
    public country updateLocation(@RequestBody country location){
        try {
            return countryService.updateLocation(location);
        }
        catch(Exception e)
        {
            throw new ResponseStatusException(HttpStatus.BAD_GATEWAY, e.getMessage());
        }
    }
}

//======================================================================================================================
