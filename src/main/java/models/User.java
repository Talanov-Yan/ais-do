package models;

public class User {
    private final String pass;
    private final String login;

    public User(String login, String pass) {
        this.login = login;
        this.pass = pass;
    }

    public String getPass() {
        return pass;
    }

    public String getLogin() {
        return login;
    }
}
