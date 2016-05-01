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

}
