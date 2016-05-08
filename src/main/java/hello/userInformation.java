package hello;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.omg.CORBA.Object;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class userInformation {

    private String name;
    private String age;
    private String password;
    private int points = 0;
    private int authorizedPoints = 0;
    private double distance = 0;
    private ArrayList<Object> history = new ArrayList<>();
    private ArrayList<String> friendsList = new ArrayList<>();
    private Gson gson = new Gson();
    private SecretKey secretKey;
    private String bike = "noBike";


    public userInformation(String password, String name, String age) {
        this.name = name;
        this.age = age;
        this.password = password;
        byte[] encoded = (password + name + age).getBytes();
        secretKey = new SecretKeySpec(encoded, "HmacMD5");
    }

    public void setBike(String bike)
    {
        this.bike = bike;
    }

    public String getBike()
    {
        return bike;
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
        authorizedPoints += newPoints;
    }

    public void subtractPoints(int points)
    {
        this.points -= points;
    }

    public void setPoints(int points)
    {
        this.points = points;
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
        userData.put("points", String.valueOf(authorizedPoints));
        userData.put("distance", String.valueOf(distance));
        userData.put("history", history);
        userData.put("friendsList", friendsList);

        return gson.toJson(userData);
    }

    public boolean verifyMAC(String message, byte[] macReceived) throws NoSuchAlgorithmException, InvalidKeyException {
        Mac mac = Mac.getInstance(this.secretKey.getAlgorithm());
        mac.init(this.secretKey);
        if (Arrays.equals(mac.doFinal(message.getBytes()), macReceived))
            return true;
        else
            return false;
    }

    public void addDistance(String distance)
    {
        double newDistance = Double.valueOf(distance);
        this.distance += newDistance;
    }
}