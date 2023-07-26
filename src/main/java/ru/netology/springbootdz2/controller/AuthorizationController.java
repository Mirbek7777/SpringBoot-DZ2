package ru.netology.springbootdz2.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.springbootdz2.exception.InvalidCredentials;
import ru.netology.springbootdz2.exception.UnauthorizedUser;
import ru.netology.springbootdz2.model.Account;
import ru.netology.springbootdz2.permissions.Authorities;
import ru.netology.springbootdz2.service.AuthorizationService;

import java.util.List;

@RestController
public class AuthorizationController {
    AuthorizationService service;

    public AuthorizationController(AuthorizationService service){
        this.service = service;
    }

//    @GetMapping("/authorize")
//    public List<Authorities> getAuthorities(@RequestParam("user") String user, @RequestParam("password") String password) {
//        return service.getAuthorities(user, password);
//    }

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(Account account) {
        return service.getAuthorities(account);
    }

    @ExceptionHandler(InvalidCredentials.class)
    public ResponseEntity<String> iaeHandler(InvalidCredentials e) {
        return new ResponseEntity<>( "EXCEPTION: " + e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UnauthorizedUser.class)
    public ResponseEntity<String> reHandler(UnauthorizedUser e) {
        System.out.println("EXCEPTION: " + e.getMessage());
        return new ResponseEntity<>("EXCEPTION: " + e.getMessage(), HttpStatus.UNAUTHORIZED);
    }
}