package task.container;

import org.junit.Before;
import org.junit.Test;
import task.domian.Day;
import task.domian.Order;

import java.util.List;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertEquals;

public class ContainerTest {

    private static Container container;

    private static List<Day> timetable;
    private static List<Order> orders;
    private static Order order;

    @Before
    public void create() {
        container = new Container();
        timetable = container.getTimetable();
        orders = container.getOrders();
        order = container.getOrder("100");
    }

    @Test
    public void orderBy() throws Exception {
        assertNotNull(container.orderBy("10", 2));
    }

    @Test
    public void getOrder() throws Exception {
        assertEquals(order, container.getOrder("100"));
    }

    @Test
    public void deleteOrder() throws Exception {
        assertTrue(container.deleteOrder("1"));
    }

    @Test
    public void getTimetable() throws Exception {
        assertEquals(timetable, container.getTimetable());
    }

}