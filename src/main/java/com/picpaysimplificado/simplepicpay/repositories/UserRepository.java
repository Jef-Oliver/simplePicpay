package com.picpaysimplificado.simplepicpay.repositories;

import com.picpaysimplificado.simplepicpay.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User>findUserByDocument(String document); //método para buscar usuário por documento
    Optional<User>findUserById(Long id); //método para buscar usuário por id
}
