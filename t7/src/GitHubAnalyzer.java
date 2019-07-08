import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class GitHubAnalyzer {

    private static ObservableList<Repository> repositories;

    public GitHubAnalyzer() {

        List<Repository> list = new ArrayList<>();
        this.repositories = FXCollections.observableArrayList(list);

    }


    public static void setCreateRepositories(List<String> urls) {

        for (String url : urls) {

            repositories.add(new Repository(url));

        }
    }

    public ObservableList<Repository> getRepositories() {

        if (this.repositories == null) return null;
        return this.repositories;

    }

    private static Repository connection(String repositoryUrl, Repository repository) throws Exception {

        URL url = null;
        url = new URL(repositoryUrl);
        HttpURLConnection con = null;
        con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        BufferedReader in = null;
        in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        JsonParser parser = new JsonParser();
        JsonArray results = null;
        results = parser.parse(in.readLine()).getAsJsonArray();
        for (JsonElement e : results) {

            JsonObject Jcommit = e.getAsJsonObject().getAsJsonObject("commit");
            CommitMessage commitMessage = new CommitMessage(Jcommit.get("message").getAsString());
            repository.addCommit(commitMessage);

        }

        repository.setMessageMediumSize();
        in.close();
        String link;
        try {

            link = con.getHeaderFields().get("Link").get(0);

        } catch (Exception e) {

            return repository;

        }

        if (!link.contains("rel=\"last\"")){

            return repository;

        }

        String nextPage = link
                .split(";")[0]
                .replace("<", "")
                .replace(">", "");
        return connection(nextPage, repository);

    }

    public static void getRepositoriesCommits() throws Exception {

        System.out.println("Searching for repositories");
        for (Repository repository : repositories) {

            connection(repository.getUrl(), repository);

        }

        System.out.println("Repositories found");

    }


    public static void printRepositories() {

        for (Repository repository : repositories) {

            System.out.println(repository.toString());

        }

    }

    public List<String> getPrintableFieldNames() {

        return List.of("Repository", "Commits", "Message Medium Size");

    }

    public List<String> getFieldNames() {

        return List.of("url", "commits", "messageMediumSize");

    }


}