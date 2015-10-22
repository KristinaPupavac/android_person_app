package ba.bitcamp.android.personapplication;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Kristina Pupavac on 10/22/2015.
 */
public class PersonList {
    private List<Person> lista;
    private static PersonList personList;

    public PersonList (){
        lista = new ArrayList<Person>();
    }

    public static PersonList getInstance(){
        if (personList == null){
            personList = new PersonList();
        }
        return personList;
    }

    public void addPerson(Person person) {
        lista.add(person);
    }

    public List<Person> getPersons() {
        return lista;
    }

    public void removePerson(Person person) {
        lista.remove(person);
    }


    public Person getPersonById(UUID id) {
        for (Person person : lista) {
            if (person.getId().equals(id)) {
                return person;
            }
        }
        return null;
    }

    public int findPosition(Person person) {
        for (int i = 0; i < lista.size(); i++) {
            if (person.getId().equals(lista.get(i).getId())) {
                return i;
            }
        }

        return -1;
    }
}
