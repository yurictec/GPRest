package task.domian;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class Day implements Serializable {
    private String date;
    private MovieShow session;

    @Override
    public String toString() {
        return "\nDate: " + date
                + ". Film: " + session.getFilmName()
                + ". Time: " + session.getTime()
                + ". Free tick: " + session.getFreePlaces()
                + ". id: " + session.getId();
    }
}
