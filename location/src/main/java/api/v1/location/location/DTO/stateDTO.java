package api.v1.location.location.DTO;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

//======================================================================================================================

@Data
public class stateDTO {
    private String state_Name;
    private List<cityDTO> City=new ArrayList<>();
}

//======================================================================================================================
