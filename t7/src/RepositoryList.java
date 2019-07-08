import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class RepositoryList {

    private ArrayList<String> links;
    private ArrayList<String> repositories;
    private ArrayList<String> users;
    private String path;

    public void initLinksList() {
        try {
            FileReader fr = new FileReader(this.path);
            BufferedReader bufferedReader = new BufferedReader(fr);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                links.add(line);
            }

        } catch (FileNotFoundException e) {
            System.err.println("O arquivo não foi encontrado");
        } catch (IOException e) {
            System.err.println("Não foi possivel ler a linha no arquivo");
        }
    }

    public void initUsersList(){

        for (int i = 0; i < links.size(); i++) {

            int k = findIndexMaxUsers(links.get(i));
            //teste apagar
            System.out.println(links.get(i).substring(20,k-1));
            users.add(links.get(i).substring(20,k-1));
        }

    }

    public void initRepositoriesList(){

        for (int i = 0; i < links.size(); i++) {

            int j = findIndexMaxUsers(links.get(i));
            int k = findIndexMaxRepository(links.get(i));
            //teste apagar
            System.out.println(links.get(i).substring(20,k-1));
            repositories.add(links.get(i).substring(j+1,k-1));
        }

    }

    public int findIndexMaxUsers(String str){

        for (int i = 20; i < str.length(); i++) {

            if (str.substring(i).equals("/")){
                return i;
            }

        }

        return 0;
    }

    public int findIndexMaxRepository(String str){

        for (int i = findIndexMaxUsers(str)+1; i < str.length(); i++) {

            if (str.substring(i).equals("/")){
                return i;
            }

        }
        return 0;

    }



}
