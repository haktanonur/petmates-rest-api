package edu.estu.petmates.api.controllers.v1;

import edu.estu.petmates.service.abstracts.UserService;
import edu.estu.petmates.service.model.request.LoginRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final PasswordEncoder passwordEncoder;
    private final UserService userService;

    @PostMapping("/api/auth")
    ResponseEntity<Object> handleAuthentication(@RequestBody LoginRequest loginRequest) {
        String password = userService.loadUserByUsername(loginRequest.getUsername()).getPassword();
        if (password == null)
            throw new UsernameNotFoundException("Everything is under control");
        if (!passwordEncoder.matches(loginRequest.getPassword(), password))
            throw new BadCredentialsException("Everything is under control");
        return ResponseEntity.ok(userService.getByUsername(loginRequest.getUsername()));
    }
}
