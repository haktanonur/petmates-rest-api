package edu.estu.petmates.api.controllers.v1;

import edu.estu.petmates.domain.shared.GenericResponse;
import edu.estu.petmates.service.abstracts.UserService;
import edu.estu.petmates.service.model.request.UserCreateRequest;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/api/users")
    public ResponseEntity<Object> getAll() {
        return ResponseEntity.ok(userService.getAll());
    }

    @GetMapping("/getByUsername")
    public ResponseEntity<Object> getByUsername(String username) {
        return ResponseEntity.ok(userService.getByUsername(username));
    }

    @PostMapping("/api/signup")
    public GenericResponse createUser(@Valid @RequestBody UserCreateRequest user) {
        userService.save(user);
        return new GenericResponse("user created");
    }

    @PutMapping("/update/username")
    public ResponseEntity<Object> updateUsername(
            @RequestParam @NotEmpty(message = "e-mail must not be null") String username,
            @Pattern(regexp = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$", message = "e-mail must not be null")
            @RequestParam String newUsername) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(userService.updateUsername(username, newUsername));
    }

    @PutMapping("/update/image")
    public ResponseEntity<Object> updateImage(
            @RequestParam @NotEmpty(message = "successful update") String username,
            @RequestParam String image) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(userService.updateImage(username, image));
    }

    @PutMapping("/update/password")
    public ResponseEntity<Object> updatePassword(
            @RequestParam @NotEmpty(message = "successful update") String username,
            @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$", message = "password must contain uppercase letters, lowercase letters and numbers")
            @RequestParam String password) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(userService.updatePassword(username, password));
    }

    @PutMapping("/update/name")
    public ResponseEntity<Object> updateName(
            @RequestParam @NotEmpty(message = "successful update") String username,
            @RequestParam String name) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(userService.updateName(username, name));
    }

    @PutMapping("/update/surname")
    public ResponseEntity<Object> updateSurname(
            @RequestParam @NotEmpty(message = "successful update") String username,
            @RequestParam String surname) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(userService.updateSurname(username, surname));
    }

    @PutMapping("/update/phoneNumber")
    public ResponseEntity<Object> updatePhoneNumber(
            @RequestParam @NotEmpty(message = "e-mail must not be null") String username,
            @Pattern(regexp = "^\\+(?:[0-9] ?){6,14}[0-9]$", message = "must start with +90")
            @RequestParam String phoneNumber) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(userService.updateSurname(username, phoneNumber));
    }

        /*@ExceptionHandler(MethodArgumentNotValidException.class)
        @ResponseStatus(HttpStatus.BAD_REQUEST)
        public ApiError handleValidationException(MethodArgumentNotValidException exception){
            ApiError error = new ApiError(400,"Validation error", "/api/users");
            Map<String, String> validationErrors = new HashMap<>();

            for (FieldError fieldError : exception.getBindingResult().getFieldErrors()){
                validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
            error.setValidationErrors(validationErrors);
            return error;
    }*/
}
