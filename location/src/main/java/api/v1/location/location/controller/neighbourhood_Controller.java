package api.v1.location.location.controller;
import api.v1.location.location.CountryConvertor.neighbourhoodConvertor;
import api.v1.location.location.DTO.neighbourhoodDTO;
import api.v1.location.location.entity.neighbourhood;
import api.v1.location.location.service.neighbourhood_Service;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

//======================================================================================================================
@RestController
public class neighbourhood_Controller {

    private final neighbourhood_Service neighbourhoodService;

    public neighbourhood_Controller(neighbourhood_Service neighbourhoodService) {
        this.neighbourhoodService = neighbourhoodService;
    }

//======================================================================================================================

    @PostMapping("api/v1/location/pincode")
    public neighbourhoodDTO addNeighbourhood(@RequestBody neighbourhood Neighbourhood){
        try {
            return neighbourhoodConvertor.neighbourhoodToDTO(neighbourhoodService.addNeighbourhood(Neighbourhood));
        }
        catch(Exception e)
        {
            throw new ResponseStatusException(HttpStatus.BAD_GATEWAY, e.getMessage());
        }
    }

//======================================================================================================================

    @GetMapping("api/v1/location/pincode")
    public neighbourhoodDTO getAllLocations(@RequestBody neighbourhood neighbourhoodId){
        try {
            return neighbourhoodConvertor.neighbourhoodToDTO(neighbourhoodService.getAllLocations(neighbourhoodId));
        }
        catch(Exception e)
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

//======================================================================================================================
    @PostMapping("api/v1/location/pincode_new")
    public neighbourhoodDTO updateLocation(@RequestBody neighbourhood location){
        try {
            return neighbourhoodConvertor.neighbourhoodToDTO(neighbourhoodService.updateLocation(location));
        }
        catch(Exception e)
        {
            throw new ResponseStatusException(HttpStatus.BAD_GATEWAY, e.getMessage());
        }
    }
}

//======================================================================================================================