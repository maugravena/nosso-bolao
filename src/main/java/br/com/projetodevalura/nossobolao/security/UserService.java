package br.com.projetodevalura.nossobolao.security;

import br.com.projetodevalura.nossobolao.models.User;
import br.com.projetodevalura.nossobolao.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserService implements UserDetailsService {

  @Autowired
  UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

    Optional<User> possibleUser = userRepository.findByLogin(username);
    return (UserDetails) possibleUser.orElseThrow(
        () -> new UsernameNotFoundException("email não encontrado: " + username));
  }

}
