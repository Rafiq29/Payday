package herb.bank.payday.controller;

import herb.bank.payday.entity.User;
import herb.bank.payday.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable("id") User user) {
        return service.getUser(user.getId());
    }

    @GetMapping
    public Iterable<User> getAll() {
        return service.getAll();
    }

    @PostMapping
    public String addUser(@RequestBody User user) {
        service.addUser(user);
        return "User added";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        service.deleteById(id);
        return "Deleted";
    }
}
