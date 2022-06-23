package herb.bank.payday.service;

import herb.bank.payday.entity.User;
import herb.bank.payday.repo.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepo;

    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public void addUser(User user) {
        userRepo.save(user);
    }

    public void deleteById(int id) {
        userRepo.deleteById(id);
    }

    public User getUser(int id) {
        Optional<User> optionalUser = userRepo.findById(id);
        return optionalUser.orElseGet(User::new);
    }

    public ArrayList<User> getAll() {
        ArrayList<User> users = new ArrayList<>();
        userRepo.findAll().forEach(users::add);
        return users;
    }
}
