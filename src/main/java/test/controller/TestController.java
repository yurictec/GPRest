package test.controller;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;
import test.container.Container;
import test.entity.User;

/**
 * Created by Администратор on 16.02.2017.
 */
@RestController
@ComponentScan("test")
public class TestController {
    private static final Container users = new Container();

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Object getById(@PathVariable int id) {
        User user = this.users.get(id);
        return user != null ? user : new Object() {
            public String getError() {
                return "not found";
            }
        };
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Object create(@RequestBody String full_name, String email) {
        User user = new User(full_name, email, "online");
        this.users.create(user);
        return new Object() {
            public int getId() {
                return user.getId();
            }
        };
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Object updat(int id, String stat) {
        User user = this.users.get(id);
        if (user != null && !user.getStat().equals(stat)) {
            user.setStat(stat);
            this.users.update(user);
        }
        if (user != null) {
            return new Object() {
                public int getId() {
                    return user.getId();
                }

                public String getStatus() {
                    return user.getStat();
                }
            };
        } else {
            return new Object() {
                public String getError() {
                    return "not found";
                }
            };
        }
    }
}
