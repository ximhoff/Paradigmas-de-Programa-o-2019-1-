package Controller;

import Model.PersonList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.ArrayList;
import java.util.List;

public class PersonListController {

    private ObservableList<PersonList> personsList;

    public PersonListController(){

        List<PersonList> list = new ArrayList<>();
        this.personsList = FXCollections.observableArrayList(list);

    }

    public void setInititalPersons(List<String> persons) {


        for (int i=1; i < persons.size(); i++ ) {
            String[] str = persons.get(i).split(";");
            String name = str[0];
            String lastname = str[1];
            String grade1 = str[2];
            String grade2 = str[3];
            personsList.add(new PersonList(name,lastname,grade1,grade2));
        }
    }

    public ObservableList<PersonList> getPersons(){

        if (this.personsList == null){

            return null;

        }

        return this.personsList;

    }

    public void setPersonsList(String person) {

        String[] str = person.split(";");
        String name = str[0];
        String lastname = str[1];
        String grade1 = str[2];
        String grade2 = str[3];
        personsList.add(new PersonList(name,lastname,grade1,grade2));

    }

    public List<String> getFieldListPrintableNames(){

        return List.of("Name","Lastname","First Grade","Second Grade");

    }

    public List<String> getFieldListNames(){

        return List.of("name","lastname","grade1","grade2");

    }

}
