package api.v1.location.location.CountryConvertor;

import api.v1.location.location.DTO.countryDTO;
import api.v1.location.location.entity.country;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

//======================================================================================================================

@Component
public class countryConvertor {
    public static countryDTO countryToDTO(country Country)
    {
        ModelMapper mapper=new ModelMapper();
        return mapper.map(Country, countryDTO.class);
    }

//======================================================================================================================

    public static country dtoToEntity(countryDTO dto)
    {
        ModelMapper mapper=new ModelMapper();
        return mapper.map(dto, country.class);
    }
}

//======================================================================================================================
