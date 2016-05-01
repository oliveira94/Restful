package hello;


public class userInformation {
    private String name;
    private int age;
    private byte[] password;

    public userInformation(byte[] password, String name, int age) {
        this.name = name;
        this.age = age;
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

}
