package steammachinist.relexinternshiptask.service.persistence;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import steammachinist.relexinternshiptask.entity.User;
import steammachinist.relexinternshiptask.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repository;

    public User add(User user) {
        return repository.save(user);
    }

    public User getByEmail(String email) {
        return repository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("No user with email " + email));
    }

    public List<User> getAll() {
        return repository.findAll();
    }

    public UserDetailsService userDetailsService() {
        return this::getByEmail;
    }

    public void enableUser(String email) {
        getByEmail(email).setEnabled(true);
    }

    public void blockUser(String email) {
        getByEmail(email).setEnabled(false);
    }
}
