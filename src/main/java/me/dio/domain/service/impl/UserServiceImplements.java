package me.dio.domain.service.impl;

import me.dio.domain.model.User;

import me.dio.domain.repository.UserRepository;
import me.dio.domain.service.UserService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserServiceImplements implements UserService {
    //Instanciar um UserRepository
    private UserRepository userRepository;
    //Criar um construtor para injetar todos os metodos do JPA que está implementado ao UserRepository
    //No UserImplements, além dos métodos criados no UserInterface
    public UserServiceImplements(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    @Override
    public User findById(Long id) {
        //Retorna um usuario pelo id, caso não encontre o Id, irá lancer uma exception que não encontrou
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }
    @Override
    public User create(User userToCreate) {
        //Se o id for diferente de nulo & existir o id
        if(userToCreate.getId() != null && userRepository.existsById(userToCreate.getId())){
            //Lança uma Exception
            throw new IllegalArgumentException("This User ID alredy exists.");
        }
        //Se o ID não existir, ignora o if, e ira criar um usuário.
        return userRepository.save(userToCreate);
    }
}
