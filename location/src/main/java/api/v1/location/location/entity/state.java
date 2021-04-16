package api.v1.location.location.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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
@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class, scope = city.class)
public class state{
    @Id
    @Column(unique=true)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer state_Id;
    private String state_Name;

//======================================================================================================================

    @OneToMany(mappedBy = "State", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JsonManagedReference
    List<city> cityList;
    {
        cityList = new ArrayList<>();
    }

//======================================================================================================================

    @ManyToOne
    @JsonBackReference
    private country Country;
    public Integer getId() {
        return state_Id;
    }
}

//======================================================================================================================
