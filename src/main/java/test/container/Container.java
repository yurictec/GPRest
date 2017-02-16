package test.container;

import org.springframework.stereotype.Repository;
import test.entity.User;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Администратор on 16.02.2017.
 */
@Repository
public class Container {

    private final Map<Integer, User> users = new ConcurrentHashMap<Integer, User>();

    private final AtomicInteger ids = new AtomicInteger(0);

    public Container(){}

    public User create(User user) {
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        user.setId(this.ids.incrementAndGet());
        users.put(user.getId(), user);
        return user;
    }

    public User get(int id) {
        return this.users.get(id);
    }

    public void update(User user) {
        this.users.put(user.getId(), user);
    }
}

