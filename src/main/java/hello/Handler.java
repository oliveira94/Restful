package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Handler {

    Users users = new Users();


    //Function to create account
    //If it returns true    -> Account was created successfully!
    //If it returns false   -> Username already exists!
    @RequestMapping("/create")
    public boolean createAccount(@RequestParam(value="username") String username, @RequestParam(value="name") String name,
                          @RequestParam(value="age") int age, @RequestParam(value="password") byte[] password)
    {
        return users.createAccount(username, password, name, age);
    }

    @RequestMapping("/checkPoints")
    public int checkPoints(@RequestParam(value="username") String username)
    {
        return users.checkPoints(username);
    }

    @RequestMapping("/addPoints")
    public void addPoints(@RequestParam(value="username") String username, @RequestParam(value="points") int newPoints)
    {
        users.addPoints(username, newPoints);
    }

    @RequestMapping("/test")
    public String test()
    {
        return "it Works!";
    }

}