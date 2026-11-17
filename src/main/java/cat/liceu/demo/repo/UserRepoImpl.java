package cat.liceu.demo.repo;

import cat.liceu.demo.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepoImpl implements UserRepo {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public User findByUsername(String username) {
        try {
            User result = jdbcTemplate.queryForObject("SELECT * FROM users where username = ?",
                    (rs, rn) -> {

                        String name = rs.getString("username");
                        String password = rs.getString("password");
                        User user = new User(name, password);
                        return user;
                    },
                    username
            );
            return result;
        } catch (EmptyResultDataAccessException e){
            return null;
        }
    }

    @Override
    public void save(User user) {
        jdbcTemplate.update(
                "INSERT INTO users (username, password) VALUES (?, ?)",
                user.getUsername(),
                user.getPassword()
        );
    }
}