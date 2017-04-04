package task.utils;

import task.domian.Day;
import task.domian.MovieShow;
import task.domian.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JsonParser {
    public static List<Day> jsonToPojoTimetable(List timetableJson) {
        List<Day> timetable = new ArrayList<>();
        for (Object o : timetableJson) {
            Map map = (Map) o;
            Day day = new Day();
            day.setDate((String) map.get("date"));
            Map shows = (Map) map.get("session");
            MovieShow show = new MovieShow();
            show.setId((String) shows.get("id"));
            show.setFilmName((String) shows.get("filmName"));
            show.setTime((String) shows.get("time"));
            show.setFreePlaces((Integer) shows.get("freePlaces"));
            show.setAllPlaces((Integer) shows.get("allPlaces"));
            day.setSession(show);
            timetable.add(day);
        }
        return timetable;
    }

    public static List<Order> jsonToPojoOrder(List ordersJson) {
        List<Order> orders = new ArrayList<>();
        for (Object o : ordersJson) {
            Map map = (Map) o;
            Order order = new Order();
            order.setIdOrder((String) map.get("idOrder"));
            order.setFilmNameOrder((String) map.get("filmNameOrder"));
            order.setTimeOrder((String) map.get("timeOrder"));
            order.setNumberOfTickets((Integer) map.get("numberOfTickets"));
            order.setIdSession((String) map.get("idSession"));
            orders.add(order);
        }
        return orders;
    }
}
