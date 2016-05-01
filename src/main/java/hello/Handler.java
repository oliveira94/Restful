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
        System.out.println("Received a request!");
        return users.createAccount(username, password, name, age);
    }
}