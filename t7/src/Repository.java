import java.util.ArrayList;
import java.util.List;

public class Repository {


    private String url;
    private int messageTotalSize;
    private int commits;
    private float messageMediumSize;
    private List<CommitMessage> commitList;

    public Repository(String url) {

        this.url = url;
        messageTotalSize = 0;
        commits = 0;
        messageMediumSize = 0;
        commitList = new ArrayList<>();

    }

    public float getMessageMediumSize() {

        return this.messageMediumSize;

    }

    public void setMessageMediumSize() {

        this.messageMediumSize = messageTotalSize / commits;

    }

    public String getUrl() {

        return url;

    }

    public void setUrl(String url) {

        this.url = url;

    }

    public int getCommits() {

        return commits;

    }

    public void setCommits(int commits) {

        this.commits = commits;

    }

    public void addCommit(CommitMessage commitMessage) {

        commitList.add(commitMessage);
        messageTotalSize = messageTotalSize + commitMessage.getMessage().length();
        commits++;

    }

    @Override
    public String toString() {

        return "Repository{" + "Url='" + url + ", Commits=" + commits + ", Message medium size=" + messageMediumSize + '}';

    }

}
