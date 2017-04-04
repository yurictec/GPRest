package task.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;
import task.container.Container;
import task.domian.Day;
import task.domian.Order;
import task.exception.Error;
import task.response.ResponseCreator;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import java.util.List;

@RestController
@ComponentScan("task")
public class TestController {

    private static final Logger LOGGER = Logger.getLogger(TestController.class.getName());

    @Autowired
    private Container container;

    @Context
    private HttpHeaders httpHeaders;

    @RequestMapping(value = "/schedule", method = RequestMethod.GET)
    public Response getSchedule() {
        List<Day> list = container.getTimetable();
        return list != null ? ResponseCreator.success(getHeaderVersion(), list)
                : ResponseCreator.error(404, Error.NOT_FOUND.getCode(),
                getHeaderVersion());
    }

    @RequestMapping(value = "/orders/{id}", method = RequestMethod.GET)
    public Response getById(@PathVariable String id) {
        Order order = container.getOrder(id);
        return order != null ? ResponseCreator.success(getHeaderVersion(), order)
                : ResponseCreator.success(getHeaderVersion(), "no such id");
    }


    @RequestMapping(value = "/bookit/{id}&{tickets}", method = RequestMethod.POST)
    public Response createOrder(@PathVariable String id, @PathVariable String tickets) {
        String ibOrder = container.orderBy(id, Integer.parseInt(tickets));
        return ibOrder != null ? ResponseCreator.success(getHeaderVersion(), ibOrder)
                : ResponseCreator.error(404, Error.NOT_FOUND.getCode(),
                getHeaderVersion());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Response removeOrder(@PathVariable String id) {
        return container.deleteOrder(id) ? ResponseCreator.success(getHeaderVersion(), "Canceled")
                : ResponseCreator.success(getHeaderVersion(), "no such id");
    }

    @ExceptionHandler(Exception.class)
    public Response hendleException(Exception e) {
        LOGGER.error("ERROR CONTROLLER", e);
        return ResponseCreator.error(501, Error.FATAL_ERROR.getCode(), getHeaderVersion());
    }

    private String getHeaderVersion() {
        return "version";
    }
}
