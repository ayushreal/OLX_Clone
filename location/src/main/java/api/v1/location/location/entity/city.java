package api.v1.location.location.entity;
import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//======================================================================================================================

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class, scope = neighbourhood.class)
public class city {
    @Id
    @Column(unique=true)
    private Integer city_Id;
    private String city_Name;

//======================================================================================================================

    @OneToMany(mappedBy = "City", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JsonManagedReference
    List<neighbourhood> neighbourhoodList;
    {
        neighbourhoodList = new ArrayList<>();
    }

//======================================================================================================================

    @ManyToOne
    @JsonBackReference
    private state State;

    public Integer getId() {
        return city_Id;
    }
}

//======================================================================================================================