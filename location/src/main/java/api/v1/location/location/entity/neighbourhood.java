package api.v1.location.location.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

//======================================================================================================================

@Entity
@NoArgsConstructor
@Setter
@Getter
public class neighbourhood {
    @Id
    @Column(unique=true)
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer neighbourhood_Pincode;
    private String neighbourhood_Name;

//======================================================================================================================

    @ManyToOne
    @JsonBackReference
    private city City;
    public Integer getId() {
        return neighbourhood_Pincode;
    }
}

//======================================================================================================================
