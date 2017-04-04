package task.domian;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Order implements Serializable {
    private String idOrder;
    private String filmNameOrder;
    private String timeOrder;
    private int numberOfTickets;
    private String  idSession;

    @Override
    public String toString() {
        return "Order id: " + idOrder
                + ". Film: " + filmNameOrder
                + ". Time: " + timeOrder
                + ". Tickets: " + numberOfTickets + "\n";
    }
}
