package edu.estu.petmates.api.controllers.v1;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequiredArgsConstructor
public class MainController {

    @SneakyThrows
    @RequestMapping("/")
    void redirect(HttpServletResponse response) {
        response.sendRedirect("/swagger-ui/index.html#/");
    }

}
