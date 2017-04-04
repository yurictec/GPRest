package task.container;

import org.springframework.stereotype.Repository;
import task.domian.Day;
import task.domian.Order;
import task.utils.FileHandler;
import task.utils.JsonParser;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class Container {

    private static List<Order> orders;
    private static List<Day> timetable;
    private static AtomicInteger integer = new AtomicInteger();

    static {
        timetable = JsonParser.jsonToPojoTimetable(FileHandler.readTimetable());
        orders = JsonParser.jsonToPojoOrder(FileHandler.readOrderes());
    }

    public Container() {
    }

    public static void main(String[] args) {
        System.out.println(new Container().getTimetable());
    }

    public String orderBy(String numberSession, int numberPlaces) {
        Order order = null;
        for (Day day : timetable) {
            String id = day.getSession().getId();
            int tick = day.getSession().getFreePlaces();
            if (id.equals(numberSession) && tick >= numberPlaces) {
                order = new Order();
                order.setIdOrder(integer.incrementAndGet() + "");
                order.setFilmNameOrder(day.getSession().getFilmName());
                order.setTimeOrder(day.getSession().getTime());
                order.setNumberOfTickets(numberPlaces);
                order.setIdSession(numberSession);
                day.getSession().setFreePlaces(day.getSession().getFreePlaces() - numberPlaces);
                break;
            }
        }
        if (order.getIdOrder() == null) {
            return null;
        }
        orders.add(order);
        save();
        return order.getIdOrder();
    }

    public Order getOrder(String id) {
        Order order = null;
        for (Order o : orders) {
            if (o.getIdOrder().equals(id)) {
                order = o;
                break;
            }
        }
        return order;
    }

    public boolean deleteOrder(String id) {
        boolean stat = false;
        int tickets = 0;
        String idSession = null;
        for (Order o : orders) {
            if (o.getIdOrder().equals(id)) {
                tickets = o.getNumberOfTickets();
                idSession = o.getIdSession();
                orders.remove(o);
                stat = true;
                break;
            }
        }
        if (stat) {
            Container.backTickets(idSession, tickets);
            save();
        }
        return stat;
    }

    private void save() {
        FileHandler.writeOrders(orders);
        FileHandler.writeTimetable(timetable);
    }

    private static void backTickets(String idSession, int tickets) {
        for (Day day : timetable) {
            if (day.getSession().getId().equals(idSession)) {
                day.getSession().setFreePlaces(day.getSession().getFreePlaces() + tickets);
                break;
            }
        }
    }

    public List<Day> getTimetable() {
        return timetable;
    }

    public List<Order> getOrders() {
        return orders;
    }
}