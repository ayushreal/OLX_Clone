package api.v1.location.location.CountryConvertor;

import api.v1.location.location.DTO.cityDTO;
import api.v1.location.location.entity.city;
import org.modelmapper.ModelMapper;

//======================================================================================================================
public class cityConvertor {
    public static cityDTO cityToDTO(city City)
    {
        ModelMapper mapper=new ModelMapper();
        return mapper.map(City, cityDTO.class);
    }

 //=====================================================================================================================

    public static city dtoToEntity(cityDTO dto)
    {
        ModelMapper mapper=new ModelMapper();
        return mapper.map(dto, city.class);
    }
}

//======================================================================================================================