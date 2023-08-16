package com.picpaysimplificado.simplepicpay.services;

import com.picpaysimplificado.simplepicpay.domain.user.User;
import com.picpaysimplificado.simplepicpay.domain.user.UserType;
import com.picpaysimplificado.simplepicpay.dtos.UserDTO;
import com.picpaysimplificado.simplepicpay.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void validateTransaction(User sender, BigDecimal amount) throws Exception {
        if (sender.getUserType() == UserType.MERCHANT) {
            throw new Exception("Usuário do tipo MERCHANT não pode realizar transações");
        }

        if (sender.getBalance().compareTo(amount) < 0) {
            throw new Exception("Saldo insuficiente");
        }
    }

    //método findUserById usado para validar se o usuário existe
    public User findUserById(Long id) throws Exception {
        return this.userRepository.findById(id).orElseThrow(() -> new Exception("Usuário não encontrado"));
    }

    //método criar usuário
    public User createUser(UserDTO data) {
        User newUser = new User(data);
        this.saveUser(newUser);
        return newUser;
    }

    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    //método para persistir as alterações no usuário, no banco de dados
    //método salvar usuário
    public void saveUser(User user) {
        this.userRepository.save(user);
    }

}
