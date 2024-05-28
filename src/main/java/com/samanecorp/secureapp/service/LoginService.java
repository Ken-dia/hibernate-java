package com.samanecorp.secureapp.service;

import com.samanecorp.secureapp.dao.LoginDao;
import com.samanecorp.secureapp.dto.UserDTO;
import com.samanecorp.secureapp.entities.UserEntity;
import com.samanecorp.secureapp.exception.EntityNotFoundException;
import com.samanecorp.secureapp.mapper.UserMapper;
import com.samanecorp.secureapp.repository.Repository;
import com.samanecorp.secureapp.repository.RepositoryImpl;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.util.Optional;

public class LoginService {
    private static Logger logger = LoggerFactory.getLogger(LoginService.class);

    private Repository<UserEntity> repository = new RepositoryImpl();

    private LoginDao loginDao = new LoginDao();
    public Optional<UserDTO> loginUser (String email, String password) {

        logger.info("Tentative email : {} pwd : {}", email, password);

        return loginDao.loginUser(email, password)
                .map(user -> {
                    UserDTO userDto = UserMapper.userEntityToUserDTO(user);
                    logger.info("infos correct !");
                    return Optional.of(userDto) ;
                }).orElseThrow( () -> new EntityNotFoundException("login ou mot de passe incorrect."));
    }

    public boolean saveUser(UserDTO userDto) {
        return repository.add(UserMapper.userDtoToUserEntity(userDto));
    }

}
