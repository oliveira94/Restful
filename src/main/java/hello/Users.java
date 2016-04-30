package hello;


public class Users {

    private final String name;
    private int age;
    private final String username;
    private byte[] password;

    public Users(String name, int age, String username, byte[] password)
    {
        this.name = name;
        this.age = age;
        this.username = username;
        this.password = password;
    }

}
