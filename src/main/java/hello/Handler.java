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
                          @RequestParam(value="age") int age, @RequestParam(value="password") String password)
    {
        return users.createAccount(username, password, name, age);
    }

    @RequestMapping("/checkPoints")
    public int getPoints(@RequestParam(value="username") String username)
    {
        return users.getPoints(username);
    }

    @RequestMapping("/logIn")
    public String logIn(@RequestParam(value="username") String username)
    {
        return users.logIn(username);
    }

    @RequestMapping("/addPoints")
    public void addPoints(@RequestParam(value="username") String username, @RequestParam(value="points") int newPoints)
    {
        users.addPoints(username, newPoints);
    }

    @RequestMapping("/addFriend")
    public void addFriend(@RequestParam(value="username") String username, @RequestParam(value="newFriend") String newFriend)
    {
        users.addFriend(username, newFriend);
    }

    @RequestMapping("/getProfile")
    public userInformation getProfile(@RequestParam(value="username") String username)
    {
        return users.getProfile(username);
    }
    @RequestMapping("/setKilometers")
    public  void setKilometers(@RequestParam("username") String username,@RequestParam(value="kilometers") double Kilometers)
    {
        users.setKilometers(username,Kilometers);
    }

    @RequestMapping("/getKilometers")
    public double getKilometers(@RequestParam("username") String username)
    {
        return users.getKilometers(username);
    }

    @RequestMapping("/getFriends")
    public String getFriends(@RequestParam(value="username") String username)
    {
        return users.getFriendsList(username);
    }


}