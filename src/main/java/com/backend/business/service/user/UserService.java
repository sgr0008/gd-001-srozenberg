package com.backend.business.service.user;

import com.backend.domain.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> findAll();

    User save(String name, int fechaCreacion);

    User save(User usuaroAlta);

    Optional<User> findById(Long id);

    void deleteById(Long id);

    User updateuser(long userID, User user);

}
