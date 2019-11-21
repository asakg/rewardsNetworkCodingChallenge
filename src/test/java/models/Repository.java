package models;

public class Repository {

    String id;
    Repository owner;
    String login;


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = owner.login;
    }

    public Repository getOwner() {
        return owner;
    }

    public void setOwner(Repository owner) {
        this.owner = owner;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
