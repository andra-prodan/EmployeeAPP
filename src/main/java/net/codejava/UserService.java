package net.codejava;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepo;

    public List<User> listAll() {
        return userRepo.findAll();
    }

    public void save(User user) {
        userRepo.save(user);
    }

    public User get(Long id) {
        return userRepo.findById(id).get();
    }

    public void delete(Long id) {
        userRepo.deleteById(id);
    }
}
