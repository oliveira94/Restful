package hello;


import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;

public class userInformation {

    private String name;
    private int age;
    private String password;
    private int points = 0;
    private double distance = 0;
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

    public void setDistance(double distance)
    {
        this.distance = distance;
    }
    public double getDistance()
    {
        return distance;
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
        if(friendsList.isEmpty())
            return "noFriends";
        else
        {
            Gson gson = new Gson();
            String friendsString = gson.toJson(friendsList);
            return friendsString;
        }
    }

}

//-Dspring.profiles.active=https