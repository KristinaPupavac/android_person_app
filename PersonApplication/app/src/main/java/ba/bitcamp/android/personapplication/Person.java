package ba.bitcamp.android.personapplication;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

/**
 * Created by Kristina Pupavac on 10/21/2015.
 */
public class Person implements Serializable {
    private UUID id;
    private String name;
    private String surname;
    private Date date;

    public Person(String name, String surname){
        id = UUID.randomUUID();
        this.name = name;
        this.surname = surname;
        date = Calendar.getInstance().getTime();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
