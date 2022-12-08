package edu.estu.petmates.service.abstracts;

import edu.estu.petmates.domain.entities.User;
import edu.estu.petmates.service.model.request.UserCreateRequest;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    User getByUsername(String username);

    List<User> getAll();

    void save(UserCreateRequest userCreateRequest);

    boolean updatePhoneNumber(String username, String phoneNumber);

    boolean updateUsername(String username, String phoneNumber);

    boolean updatePassword(String username, String phoneNumber);

    boolean updateName(String username, String phoneNumber);

    boolean updateSurname(String username, String phoneNumber);

    boolean updateImage(String username, String phoneNumber);
}
