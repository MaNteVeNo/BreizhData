package model.data;

public class User {

    private String login;
    private String pwd;

    public User(String login , String pwd) {
        this.login = login;
        this.pwd = pwd;
    }

    public String getLogin () {
        return login;
    }
    
    public void setLogin(String login) {
        this.login = login;
    }

    public String getPwd () {
        return pwd;
    }
    
    public void setMdp(String pwd) {
        this.pwd = pwd;
    }
}