package api.v1.location.location.DTO;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

//======================================================================================================================

@Data
public class cityDTO {
    private String city_Name;
    private List<neighbourhoodDTO> Neighbourhood=new ArrayList<>();
}

//======================================================================================================================
