package hello;


import com.google.gson.Gson;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;

public class Users {

    private HashMap<String, userInformation> accounts = new HashMap<>();
    private HashMap<String, Integer> bikes = new HashMap<>();
    private Gson gson = new Gson();

    public Users()
    {
        bikes.put("Alameda", 20);
        bikes.put("Alvalade", 20);
        bikes.put("Benfica", 20);
    }

    public String bookBike(String username, String station)
    {
        if (accounts.get(username).getBike())
        {
            int bikesAvailable = bikes.get(station);
            bikesAvailable++;
            bikes.replace(station, bikesAvailable);
            accounts.get(username).cancelBike();
            return "Canceled";
        }
        else
        {
            int bikesAvailable = bikes.get(station);
            if (bikesAvailable > 0)
            {
                accounts.get(username).bookBike();
                bikesAvailable--;
                bikes.replace(station, bikesAvailable);
                return "Booked";
            }
            else
                return "Busy";
        }

    }

    public boolean createAccount(String username, String password, String name, String age)
    {
        if (!accounts.containsKey(username))
        {
            userInformation _userInformation = new userInformation(password, name, age);
            accounts.put(username, _userInformation);
            return true;
        }
        else
            return false;

    }

    //Function to check the points that the user currently has
    public int getPoints(String username)
    {
        if (accounts.containsKey(username))
        {
            return accounts.get(username).getPoints();
        }
        else
        {
            System.err.println("Username does not exist in database!");
            return -1;
        }
    }


    //function to add kilometers on the database
    public void addDistance(String username , double newDistance)
    {
        if (accounts.containsKey(username))
        {
            double distance = accounts.get(username).getDistance();
            distance += newDistance;
            accounts.get(username).setDistance(distance);
        }
        else
            System.err.println("Wrong operation");
    }

    public double getDistance(String username)
    {
        return accounts.get(username).getDistance();
    }

    //Function to add points to the user account
    public void addPoints(String username, int newPoints)
    {
        if (accounts.containsKey(username))
        {
            accounts.get(username).addPoints(newPoints);
        }
        else
        {
            System.err.println("Username does not exist in database!");
        }
    }

    //Function to add a new friend to their list
    public String addFriend(String username, String newFriend)
    {
        if(accounts.containsKey(newFriend))
            return accounts.get(username).addFriend(newFriend);
        else
            return "false";
    }

    public String getProfile(String username)
    {
        return accounts.get(username).getProfile();
    }

    public String logIn(String username)
    {
        String result = "noUsername";

        if(accounts.containsKey(username))
        {
            result = accounts.get(username).getName() + ":";
            result += accounts.get(username).getPassword() + ":";
            result += accounts.get(username).getPoints() + ":";
            result += accounts.get(username).getAge();
            return result;
        }
        else
            return result;
    }

    public String getFriendsList(String username)
    {
        return accounts.get(username).getFriendsList();
    }

    public void setHistory(String username, String history)
    {
        accounts.get(username).setHistory(history);
    }

    public String getHistory(String username)
    {
        return accounts.get(username).getHistory();
    }

    public String actProfile(String username, int points, double totalDistance, String history)
    {
        accounts.get(username).setDistance(totalDistance);
        accounts.get(username).setPoints(points);
        accounts.get(username).setHistory(history);
        return "success";
    }

    public String receivedPoints(String username, String sender, int points, byte[] mac) throws InvalidKeyException, NoSuchAlgorithmException {
        String message = username + sender + String.valueOf(points);
        if (accounts.get(sender).verifyMAC(message, mac))
        {
            accounts.get(sender).subtractPoints(points);
            accounts.get(username).addPoints(points);
            return "success";
        }
        else
            return "integrityFail";

    }

    public void addDistance(String username, String distance)
    {
        accounts.get(username).addDistance(distance);
    }

    public String updateProfile(String username, int points, double totaldistance){
        accounts.get(username).setPoints(points);
        accounts.get(username).setDistance(totaldistance);
        return "success";
    }

}
