package br.com.study.api.services;

import br.com.study.api.domain.User;

public interface UserService {

    User findById(Integer id);
}
