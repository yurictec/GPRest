package task.domian;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class MovieShow implements Serializable {

    private String id;
    private String filmName;
    private String time;
    private int freePlaces;
    private int allPlaces;
}
