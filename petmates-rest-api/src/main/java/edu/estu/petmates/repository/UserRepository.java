package edu.estu.petmates.repository;

import edu.estu.petmates.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String email);

    @Modifying
    @Query("UPDATE User s SET s.phoneNumber = :phoneNumber WHERE s.username = :username")
    int updatePhoneNumber(String username, String phoneNumber);

    @Modifying
    @Query("UPDATE User s SET s.name = :name WHERE s.username = :username")
    int updateName(String username, String name);

    @Modifying
    @Query("UPDATE User s SET s.surname = :surname WHERE s.username = :username")
    int updateSurname(String username, String surname);

    @Modifying
    @Query("UPDATE User s SET s.password = :password WHERE s.username = :username")
    int updatePassword(String username, String password);

    @Modifying
    @Query("UPDATE User s SET s.image = :image WHERE s.username = :username")
    int updateImage(String username, String image);

    @Modifying
    @Query("UPDATE User s SET s.username = :newUsername WHERE s.username = :username")
    int updateUsername(String username, String newUsername);

}
