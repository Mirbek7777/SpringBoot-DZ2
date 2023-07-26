package ru.netology.springbootdz2.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter; этот класс устарел
import ru.netology.springbootdz2.mapping.AccountHandlerMethodArgumentResolver;

import java.util.List;

//Прежде чем мы сможем использовать наш новый класс HandlerMethodArgumentResolver , мы должны настроить контекст нашего веб-приложения.

//Мы можем зарегистрировать класс FoobarHandlerMethodArgument в качестве преобразователя аргументов метода,
// внеся следующие изменения в «класс приложения» нашего веб-приложения Spring Boot:

//1.Расширьте интерфейс WebMvcConfigurer
//2.Переопределите метод addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentsResolvers) интерфейса WebMvcConfigurer
//3.Зарегистрируйте преобразователь аргументов пользовательского метода, создав новый объект FooBarHandlerMethodArgumentResolver и добавив созданный объект в список ,
// указанный в качестве параметра метода.
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(new AccountHandlerMethodArgumentResolver());
    }
}