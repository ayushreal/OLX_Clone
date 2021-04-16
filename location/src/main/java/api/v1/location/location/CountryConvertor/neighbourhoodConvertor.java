package api.v1.location.location.CountryConvertor;
import api.v1.location.location.DTO.neighbourhoodDTO;
import api.v1.location.location.entity.neighbourhood;
import org.modelmapper.ModelMapper;

//======================================================================================================================
public class neighbourhoodConvertor {
    public static neighbourhoodDTO neighbourhoodToDTO(neighbourhood Neighbourhood)
    {
        ModelMapper mapper=new ModelMapper();
        return mapper.map(Neighbourhood, neighbourhoodDTO.class);
    }

//======================================================================================================================

    public static neighbourhood dtoToEntity(neighbourhoodDTO dto)
    {
        ModelMapper mapper=new ModelMapper();
        return mapper.map(dto, neighbourhood.class);
    }
}

//======================================================================================================================