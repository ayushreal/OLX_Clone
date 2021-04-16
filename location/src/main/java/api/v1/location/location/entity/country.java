package api.v1.location.location.entity;
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
@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class, scope = state.class)
public class  country {

        @Id
        @GeneratedValue(strategy=GenerationType.IDENTITY)
        @Column(unique=true)
        private Integer country_Id;
        private String country_Name;
        private String country_Currency;

//======================================================================================================================

    @OneToMany(mappedBy = "Country", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JsonManagedReference
    List<state>stateList;
    {
        stateList = new ArrayList<>();
    }
    public Integer getId() {
        return country_Id;
    }
}

//======================================================================================================================
