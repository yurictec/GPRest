package task.utils;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import task.container.Container;
import task.domian.Day;
import task.domian.Order;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {
    private static final Logger LOGGER = Logger.getLogger(Container.class.getName());

    public static void writeTimetable(List<Day> list) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new FileOutputStream(
                    System.getProperty("user.dir") + File.separator
                            + "../timetable.json"), list);
        } catch (IOException ex) {
            LOGGER.log(Level.ERROR, ex);
        }
    }

    public static List<Day> readTimetable() {
        ObjectMapper mapper = new ObjectMapper();
        String filepath = System.getProperty("user.dir") + File.separator
                + "../timetable.json";
        List<Day> list = null;
        try {
            list = mapper.readValue(new FileInputStream(filepath),
                    ArrayList.class);
        } catch (IOException ex) {
            LOGGER.log(Level.ERROR, ex);
        }
        return list;
    }

    public static void writeOrders(List<Order> list) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new FileOutputStream(
                    System.getProperty("user.dir") + File.separator
                            + "../orders.json"), list);
        } catch (IOException ex) {
            LOGGER.log(Level.ERROR, ex);
        }
    }

    public static List<Order> readOrderes() {
        ObjectMapper mapper = new ObjectMapper();
        String filepath = System.getProperty("user.dir") + File.separator
                + "../orders.json";
        List<Order> list = null;
        try {
            list = mapper.readValue(new FileInputStream(filepath),
                    ArrayList.class);
        } catch (IOException ex) {
            LOGGER.log(Level.ERROR, ex);
        }
        return list;
    }
}
