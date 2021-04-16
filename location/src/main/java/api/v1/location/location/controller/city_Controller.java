package api.v1.location.location.controller;

import api.v1.location.location.CountryConvertor.cityConvertor;
import api.v1.location.location.DTO.cityDTO;
import api.v1.location.location.entity.city;

import api.v1.location.location.service.city_Service;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

//======================================================================================================================

@RestController
public class city_Controller {
    private final city_Service cityService;

    public city_Controller(city_Service cityService) {
        this.cityService = cityService;
    }

//======================================================================================================================

    @PostMapping("api/v1/location/neighbourhoods/city_id")
    public cityDTO addCity(@RequestBody city CityId){
        try {
            return cityConvertor.cityToDTO(cityService.addCity(CityId));
        }
        catch(Exception e)
        {
            throw new ResponseStatusException(HttpStatus.BAD_GATEWAY, e.getMessage());
        }
    }

//======================================================================================================================

    @GetMapping("api/v1/location/neighbourhoods/city_id")
    public cityDTO getAllNeighbourhood(@RequestBody city CityId){
        try {
            return cityConvertor.cityToDTO(cityService.getAllNeighbourhood(CityId));
        }
        catch (Exception e)
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

//======================================================================================================================

    @PostMapping("api/v1/location/neighbourhoods/city_id_new")
    public cityDTO updateLocation(@RequestBody city location){
        try {
            return cityConvertor.cityToDTO(cityService.updateLocation(location));
        }
        catch (Exception e)
        {
            throw new ResponseStatusException(HttpStatus.BAD_GATEWAY, e.getMessage());
        }
    }
}

//======================================================================================================================