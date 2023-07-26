package ru.netology.springbootdz2.repository;

import org.springframework.stereotype.Repository;
import ru.netology.springbootdz2.model.Account;
import ru.netology.springbootdz2.permissions.Authorities;

import java.util.*;

@Repository
public class UserRepository {
    public List<Authorities> getUserAuthorities(Account account) {
        List<Authorities> authorities = new ArrayList<>();
        if (account.getUser().equals("Vasya") && account.getPassword().equals("1234")) {
            Collections.addAll(authorities, Authorities.READ, Authorities.WRITE, Authorities.DELETE);
        } else if (account.getUser().equals("Olya") && account.getPassword().equals("2345")) {
            Collections.addAll(authorities, Authorities.READ, Authorities.WRITE);
        } else if (account.getUser().equals("Mariy") && account.getPassword().equals("3456")) {
            Collections.addAll(authorities, Authorities.READ);
        }
        return authorities;
    }


}
