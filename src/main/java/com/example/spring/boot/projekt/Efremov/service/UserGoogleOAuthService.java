package com.example.spring.boot.projekt.Efremov.service;

import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public interface UserGoogleOAuthService {

    RedirectView getRedirectView();

    String getJsonGoogleUser(String code, String state) throws InterruptedException, ExecutionException, IOException;
}
