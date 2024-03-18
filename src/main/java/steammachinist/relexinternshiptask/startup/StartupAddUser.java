package steammachinist.relexinternshiptask.startup;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import steammachinist.relexinternshiptask.dto.request.RegisterRequest;
import steammachinist.relexinternshiptask.entity.Role;
import steammachinist.relexinternshiptask.service.authentication.AuthenticationService;
import steammachinist.relexinternshiptask.service.persistence.UserService;

@Component
@RequiredArgsConstructor
public class StartupAddUser implements ApplicationRunner {
    private final AuthenticationService authenticationService;
    private final UserService userService;

    @Value("${initial-account.email}")
    private String email;

    @Value("${initial-account.password}")
    private String password;

    @Override
    public void run(ApplicationArguments args) {
        if (userService.getAll().isEmpty()) {
            authenticationService.register(new RegisterRequest("Менеджер", email, password, Role.ROLE_MANAGER.name()));
        }
    }
}
