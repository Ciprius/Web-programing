package webubb.domain;

/**
 * Created by forest.
 */
public class User {
    private int id;
    private String username;
    private String password;
    private String completedTests;
    private Integer best;

    public User(int id, String username, String password, String completedTests){
        this.id = id;
        this.username = username;
        this.password = password;
        this.completedTests = completedTests;
    }

    public User(int id, String username, String password, Integer best){
        this.id = id;
        this.username = username;
        this.password = password;
        this.best = best;
    }

    public Integer getBest() {
        return best;
    }

    public void setBest(Integer best) {
        this.best = best;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id=id; }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCompletedTests() { return completedTests;}

    public void setCompletedTests(String completedTests) {
        this.completedTests = completedTests;
    }
}