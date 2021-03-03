package com.example.spring.boot.projekt.Efremov.controller;

import com.example.spring.boot.projekt.Efremov.service.UserGoogleOAuthService;
import com.example.spring.boot.projekt.Efremov.service.UserService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

@Controller
@Data
@AllArgsConstructor
public class LoginController {

    //@Autowired
    private final UserGoogleOAuthService userGoogleOAuthService;

    @GetMapping(value = "/login")
    public String loginPage() {
        return "loginPage";
    }

    @GetMapping(value = "/oauth2/authorization/google")
    public RedirectView oauth2() {
        return userGoogleOAuthService.getRedirectView();
    }

    @GetMapping(value = "/login/oauth2/code/google", produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    String googleCallback(@RequestParam("code") String code,
                          @RequestParam("state") String state) throws InterruptedException, ExecutionException, IOException {
        return userGoogleOAuthService.getJsonGoogleUser(code, state);
    }
}
