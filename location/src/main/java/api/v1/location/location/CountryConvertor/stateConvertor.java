package api.v1.location.location.CountryConvertor;
import api.v1.location.location.DTO.stateDTO;
import api.v1.location.location.entity.state;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

//======================================================================================================================

@Component
public class stateConvertor {
    public static stateDTO stateToDTO(state State)
    {
        ModelMapper mapper=new ModelMapper();
        return mapper.map(State, stateDTO.class);
    }

//======================================================================================================================

    public static state dtoToEntity(stateDTO dto)
    {
        ModelMapper mapper=new ModelMapper();
        return mapper.map(dto, state.class);
    }
}

//======================================================================================================================
