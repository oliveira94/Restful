package hello;


import java.util.ArrayList;

public class userInformation {
    private String name;
    private int age;
    private byte[] password;
    private int points = 0;
    private ArrayList<String> friendsList = new ArrayList<>();

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

    public void addPoints(int newPoints)
    {
        points += newPoints;
    }

    public int checkPoints()
    {
        return points;
    }

    public void addFriend(String newFriend)
    {
        friendsList.add(newFriend);
    }
}

//-Dspring.profiles.active=https