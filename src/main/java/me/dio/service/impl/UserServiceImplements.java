package me.dio.service.impl;

import me.dio.domain.model.User;

import me.dio.domain.repository.UserRepository;
import me.dio.service.UserService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserServiceImplements implements UserService {
    //Instanciar um UserRepository
    private final UserRepository userRepository;
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
        if (userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber())) {
            throw new IllegalArgumentException("This Account number already exists.");
        }
        return userRepository.save(userToCreate);

    }
}
