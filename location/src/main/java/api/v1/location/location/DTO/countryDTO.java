package api.v1.location.location.DTO;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

//=====================================================================================================================

@Data
public class countryDTO {
    private String country_Name;
    private String country_Currency;
    private List<stateDTO> State=new ArrayList<>();
}

//======================================================================================================================
