package br.com.study.api.services.impl;

import br.com.study.api.domain.User;
import br.com.study.api.domain.dto.UserDTO;
import br.com.study.api.repository.UserRepository;
import br.com.study.api.services.UserService;
import br.com.study.api.services.exceptions.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findById(Integer id) {
        Optional<User> obj = userRepository.findById(id);
        return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado.")) ;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User create(UserDTO obj) {
        User user = mapper.map(obj, User.class);
        return userRepository.save(user);
    }
}
