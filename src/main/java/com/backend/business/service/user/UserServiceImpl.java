package com.backend.business.service.user;

import com.backend.domain.model.User;
import com.backend.infrastructure.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User save(String name,int fechaCreacion) {
        User usuaroAlta=new User();
        usuaroAlta.setName(name);
        usuaroAlta.setFechaCreacion(fechaCreacion);
        return userRepository.save(usuaroAlta);
    }
    @Override
    public  User updateuser(long id, User user){
        user.setId(id);
        return userRepository.save(user);
    }

    @Override
    public User save(User usuaroAlta) {
        return userRepository.save(usuaroAlta);
    }
    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }


    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }


}