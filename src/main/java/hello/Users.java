package hello;


import java.util.HashMap;

public class Users {

    private HashMap<String, userInformation> accounts = new HashMap<>();


    public boolean createAccount(String username, byte[] password, String name, int age)
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
    public int checkPoints(String username)
    {
        if (accounts.containsKey(username))
        {
            return accounts.get(username).checkPoints();
        }
        else
        {
            System.err.println("Username does not exist in database!");
            return -1;
        }
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
    

}
