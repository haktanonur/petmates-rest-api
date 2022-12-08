package edu.estu.petmates.service.concretes;

import edu.estu.petmates.domain.entities.User;
import edu.estu.petmates.repository.UserRepository;
import edu.estu.petmates.service.abstracts.UserService;
import edu.estu.petmates.service.model.request.UserCreateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User getByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public void save(UserCreateRequest userCreateRequest) {
        User user = new User();
        user.setUsername(userCreateRequest.getUsername());
        user.setSurname(userCreateRequest.getSurname());
        user.setName(userCreateRequest.getName());
        user.setPhoneNumber(userCreateRequest.getPhoneNumber());
        user.setImage(userCreateRequest.getImage());
        user.setPassword(userCreateRequest.getPassword());
        user.setPassword(this.passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User inDB = userRepository.findByUsername(username);
        if(inDB == null){
            throw new UsernameNotFoundException("User not found");
        }
        return new org.springframework.security.core.userdetails.User(inDB.getUsername(), inDB.getPassword(), true, true, true, true, inDB.getAuthorities());
    }

    @Override
    public boolean updatePhoneNumber(String username, String phoneNumber) {
        return userRepository.updatePhoneNumber(username, phoneNumber) > 0;
    }

    @Override
    public boolean updateUsername(String username, String newUserName) {
        return userRepository.updateUsername(username, newUserName) > 0;
    }

    @Override
    public boolean updatePassword(String username, String password) {
        return userRepository.updatePassword(username, password) > 0;
    }

    @Override
    public boolean updateName(String username, String name) {
        return userRepository.updateName(username, name) > 0;
    }

    @Override
    public boolean updateSurname(String username, String surname) {
        return userRepository.updateSurname(username, surname) > 0;
    }

    @Override
    public boolean updateImage(String username, String image) {
        return userRepository.updateImage(username, image) > 0;
    }

}
