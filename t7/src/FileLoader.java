import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileLoader {

    private List<String> urlList;

    public boolean load(String path){

        try {

            FileReader fr = new FileReader(path);
            BufferedReader bufferedReader = new BufferedReader(fr);

            String line;
            while ((line = bufferedReader.readLine()) != null) {

                System.out.println(line);
                this.urlList.add(line);

            }

            return true;

        }catch (IOException e){

            e.printStackTrace();
            return false;

        }

    }

    public boolean isEmpty() {

        return urlList.isEmpty();

    }

    public FileLoader() {

        this.urlList = new ArrayList<>();

    }

    public List<String> getUrlList() {

        return urlList;

    }

}

