package hello;


import com.google.gson.Gson;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class userInformation {
    private String name;
    private int age;
    private String password;
    private int points = 0;
    private double Kilometers=0;
    private ArrayList<String> friendsList = new ArrayList<>();

    public userInformation(String password, String name, int age) {
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

    public int getPoints()
    {
        return points;
    }
    public void setKilometers(double kilo)
    {
        Kilometers= kilo;
    }
    public double getKilometers()
    {
        return Kilometers;
    }

    public void addFriend(String newFriend)
    {
        friendsList.add(newFriend);
    }

    public String getPassword()
    {
        return password;
    }

    public String getFriendsList()
    {
        Gson gson = new Gson();
        String friendsString = gson.toJson(friendsList);
        return friendsString;
    }

}

//-Dspring.profiles.active=https