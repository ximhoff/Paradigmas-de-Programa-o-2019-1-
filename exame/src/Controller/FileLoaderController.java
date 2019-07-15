package Controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileLoaderController {

    private List<String> personList;

    public  FileLoaderController(){

        this.personList = new ArrayList<>();

    }

    public List<String> getPersonList() {
        return personList;
    }

    public boolean load(String path){

        try {

            FileReader fileReader = new FileReader(path);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line  = bufferedReader.readLine()) != null){

                System.out.println(line);
                this.personList.add(line);

            }

        } catch (FileNotFoundException e) {

            e.printStackTrace();
            return false;

        } catch (IOException e) {

            e.printStackTrace();
            return false;

        }

        return true;

    }
}
