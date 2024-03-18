package steammachinist.relexinternshiptask.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import steammachinist.relexinternshiptask.dto.request.LoginRequest;
import steammachinist.relexinternshiptask.dto.request.RegisterRequest;
import steammachinist.relexinternshiptask.dto.response.JwtAuthenticationResponse;
import steammachinist.relexinternshiptask.service.authentication.AuthenticationService;
import steammachinist.relexinternshiptask.service.persistence.UserService;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<JwtAuthenticationResponse> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(
                authenticationService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<JwtAuthenticationResponse> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(
                authenticationService.login(request));
    }

    @PreAuthorize("hasRole('ROLE_MANAGER')")
    @PostMapping("/enable")
    public ResponseEntity<Void> enableUser(@RequestParam String userEmail) {
        userService.enableUser(userEmail);
        return ResponseEntity.ok().build();
    }

    @PreAuthorize("hasRole('ROLE_MANAGER')")
    @PostMapping("/block")
    public ResponseEntity<Void> blockUser(@RequestParam String userEmail) {
        userService.blockUser(userEmail);
        return ResponseEntity.ok().build();
    }
}
