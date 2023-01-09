package br.com.study.api.services.impl;

import br.com.study.api.domain.User;
import br.com.study.api.domain.dto.UserDTO;
import br.com.study.api.repository.UserRepository;
import br.com.study.api.services.UserService;
import br.com.study.api.services.exceptions.DataIntegratyViolationException;
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
        findByEmail(obj);
        User user = mapper.map(obj, User.class);
        return userRepository.save(user);
    }

    @Override
    public User update(UserDTO obj) {
        findByEmail(obj);
        User user = mapper.map(obj, User.class);
        return userRepository.save(user);
    }

    private void findByEmail(UserDTO obj) {
        Optional<User> user = userRepository.findByEmail(obj.getEmail());
        if(user.isPresent() && !user.get().getId().equals(obj.getId())) {
            throw new DataIntegratyViolationException("O e-mail já foi cadastrado na nossa base de dados.");
        }
    }
}
