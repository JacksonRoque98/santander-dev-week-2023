package estacionamento.service.impl;

import estacionamento.domain.model.User;
import estacionamento.domain.repository.UserRepository;
import estacionamento.service.UserService;
import estacionamento.service.exception.BusinessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    @Transactional(readOnly = true)
    public List<User> findAll() {
        return this.userRepository.findAll();
    }
    @Transactional(readOnly = true)
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }
    @Transactional
    public User create(User userCreate) {
        return this.userRepository.save(userCreate);
    }
    @Transactional
    public User update(Long id, User userUpdate) {
        User userDb = this.findById(id);
        if(!userDb.getId().equals(userUpdate.getId())){
            throw new BusinessException("To change data, the IDs must have the same value.");
        }
        userDb.setId(userUpdate.getId());
        userDb.setName(userUpdate.getName());
        userDb.setCpf(userUpdate.getCpf());
        userDb.setCar(userUpdate.getCar());
        return this.userRepository.save(userDb);
    }
    @Transactional
    public void delete(Long id) {
        User userDelete = this.findById(id);
        this.userRepository.delete(userDelete);
    }
}
