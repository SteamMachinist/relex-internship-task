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
    private final UserRepository userRepository;

    public User add(User user) {
        return userRepository.save(user);
    }

    public User getByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("No user with email " + email));
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public UserDetailsService userDetailsService() {
        return this::getByEmail;
    }
}
