package edu.estu.petmates;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	/*@Bean
	CommandLineRunner createInitialUsers(UserServiceImpl userService){
		return (args) -> {
			 User user = new User();
			 user.setUsername("user1");
			 user.setPassword("P4ssword");
			 userService.save(user);
		};*/

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}

