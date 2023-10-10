package me.dio.domain.controller;

import me.dio.domain.model.User;
import me.dio.domain.service.UserService;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
//Quando acessar a aplicação/users irá acessar as funcionalidades do UserService
@RequestMapping("/users")
public class UserController {
    private UserService userService;
    //Criamos o construtor do UserController para injetar todas as depedencias do UserService no Controller
    public UserController(UserService userService){
        this.userService = userService;
    }

    //@GetMapping o spring ja identifica que esse metodo é um get, e irá fazer um get pelo id
    @GetMapping("/{id}")              //irá mapear e converter para um Long
    public ResponseEntity<User> findById(@PathVariable Long id){
        var user = userService.findById(id);
        return ResponseEntity.ok(user);
    }

    //@PostMapping o spring ja identifica que esse metodo é um post, e irá fazer um post do user
    @PostMapping
    public ResponseEntity<User> create(@RequestBody User userToCreate){
        //var = User
        var userCreated = userService.create(userToCreate);
        //URI location atribui o path{id} com o id do usuario criado
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                //build and expande o usuario criado
                .buildAndExpand(userCreated)
                //para a Uri
                .toUri();
        //Retorna a localização criada(id) e os dados do usuario
        return ResponseEntity.created(location).body(userCreated);
    }
}
