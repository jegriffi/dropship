package objects;

/**
 * Created by james on 9/16/2016.
 */
public class Account {
    private int id;
    private String name;
    private String user;
    private String password;
    private String url;

    public Account(int id, String name, String user, String password, String url) {
        this.id = id;
        this.name = name;
        this.user = user;
        this.password = password;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
