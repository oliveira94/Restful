package hello;

import org.omg.CORBA.Object;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class Handler {

    Users users = new Users();


    //Function to create account
    //If it returns true    -> Account was created successfully!
    //If it returns false   -> Username already exists!
    @RequestMapping("/create")
    public boolean createAccount(@RequestParam(value="username") String username, @RequestParam(value="name") String name,
                          @RequestParam(value="age") String age, @RequestParam(value="password") String password)
    {
        return users.createAccount(username, password, name, age);
    }

    @RequestMapping("/logIn")
    public String logIn(@RequestParam(value="username") String username)
    {
        return users.logIn(username);
    }

    @RequestMapping("/getProfile")
    public String getProfile(@RequestParam(value="username") String username)
    {
        return users.getProfile(username);
    }

    @RequestMapping("/addPoints")
    public void addPoints(@RequestParam(value="username") String username, @RequestParam(value="points") int newPoints)
    {
        users.addPoints(username, newPoints);
    }

    @RequestMapping("/checkPoints")
    public int getPoints(@RequestParam(value="username") String username)
    {
        return users.getPoints(username);
    }

    @RequestMapping("/addFriend")
    public String addFriend(@RequestParam(value="username") String username, @RequestParam(value="newFriend") String newFriend)
    {
        if (username.equals(newFriend))
            return "yourself";
        return users.addFriend(username, newFriend);
    }

    @RequestMapping("/getFriends")
    public String getFriends(@RequestParam(value="username") String username)
    {
        return users.getFriendsList(username);
    }

    @RequestMapping("/addDistance")
    public  void setDistance(@RequestParam("username") String username,@RequestParam(value="newDistance") double newDistance)
    {
        users.addDistance(username,newDistance);
    }
    @RequestMapping("/getDistance")
    public double getDistance(@RequestParam("username") String username)
    {
        return users.getDistance(username);
    }

    @RequestMapping("/setHistory")
    public void setHistory(@RequestParam("username") String username, @RequestParam("history") String history)
    {
        users.setHistory(username, history);
    }

    @RequestMapping("/getHistory")
    public String getHistory(@RequestParam("username") String username)
    {
        return users.getHistory(username);
    }


}