package RiderSharing;

import java.util.Random;
import java.util.UUID;

public class Person {
    private String id;
    private String name;

    public Person(String name) {
        this.name = name;
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
