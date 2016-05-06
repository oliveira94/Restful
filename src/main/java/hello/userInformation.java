package hello;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.omg.CORBA.NameValuePair;
import org.omg.CORBA.Object;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;

public class userInformation {

    private String name;
    private String age;
    private String password;
    private int points = 0;
    private double distance = 0;
    private ArrayList<Object> history = new ArrayList<>();
    private ArrayList<String> friendsList = new ArrayList<>();
    Gson gson = new Gson();


    public userInformation(String password, String name, String age) {
        this.name = name;
        this.age = age;
        this.password = password;
    }

    public String getAge() {
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

    public String addFriend(String newFriend)
    {
        if(!friendsList.contains(newFriend))
        {
            friendsList.add(newFriend);
            return "success";
        }
        else
            return "alreadyFriend";
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
            String friendsString = gson.toJson(friendsList);
            return friendsString;
        }
    }

    public void setHistory(String history)
    {
        Type type = new TypeToken<ArrayList<Object>>() {}.getType();
        this.history = gson.fromJson(history, type);
    }

    public String getHistory()
    {
        return gson.toJson(history);
    }

    public String getProfile()
    {
        HashMap userData = new HashMap();
        userData.put("name", name);
        userData.put("age", age);
        userData.put("points", String.valueOf(points));
        userData.put("distance", String.valueOf(distance));
        userData.put("history", history);
        userData.put("friendsList", friendsList);

        return gson.toJson(userData);
    }

}

//-Dspring.profiles.active=https