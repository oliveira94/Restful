package hello;


import java.util.ArrayList;
import java.util.HashMap;

public class Users {

    private HashMap<String, userInformation> accounts = new HashMap<>();


    public boolean createAccount(String username, String password, String name, int age)
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
    public boolean addFriend(String username, String newFriend)
    {
        try {
            accounts.get(username).addFriend(newFriend);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public userInformation getProfile(String username)
    {
        return accounts.get(username);
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

}
