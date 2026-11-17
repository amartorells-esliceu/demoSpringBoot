package cat.liceu.demo.service;

import cat.liceu.demo.models.User;
import cat.liceu.demo.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    UserRepo userRepo;

    public boolean checkLogin(String username, String password) {
        User u = userRepo.findByUsername(username);
        if (u == null) return false;
        return password.equals(u.getPassword());
    }

    public void saveUser(String username, String password) {
        if (userRepo.findByUsername(username) == null) {
            User user = new User(username, password);
            userRepo.save(user);
        }
    }
}