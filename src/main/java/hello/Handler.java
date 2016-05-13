package hello;

import org.omg.CORBA.Object;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
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

    @RequestMapping("/actProfile")
    public String actProfile(@RequestParam("username") String username, @RequestParam("points") int points,
                             @RequestParam("distance") double totalDistance, @RequestParam("history") String history)
    {
        return users.actProfile(username, points, totalDistance, history);
    }

    @RequestMapping("/receivedPoints")
    public String receivedPoints(@RequestParam("username") String username, @RequestParam("sender") String sender,
                                 @RequestParam("points") int points, @RequestParam("mac") byte[] mac) throws NoSuchAlgorithmException, InvalidKeyException {
        return users.receivedPoints(username, sender, points, mac);
    }


    @RequestMapping("/BookBike")
    public String bookBike(@RequestParam("username") String username, @RequestParam("station") String station)
    {
        return users.bookBike(username, station);
    }

    @RequestMapping("/addDistance")
    public void addDistance(@RequestParam("username") String username, @RequestParam("newDistance") String distance)
    {
        users.addDistance(username, distance);
    }
}