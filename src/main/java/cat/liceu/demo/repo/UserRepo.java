package cat.liceu.demo.repo;

import cat.liceu.demo.models.User;

public interface UserRepo {
    User findByUsername(String username);
}