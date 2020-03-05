package br.com.projetodevalura.nossobolao;

import br.com.projetodevalura.nossobolao.models.User;
import br.com.projetodevalura.nossobolao.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DatabaseLoader implements ApplicationRunner {

  private UserRepository userRepository;

  @Autowired
  public DatabaseLoader(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public void run(ApplicationArguments args) throws Exception {

    List<User> users = Arrays.asList(
        new User("joao@email.com", "123456"),
        new User("maria@email.com", "123456"),
        new User("pedro@email.com", "123456"),
        new User("marcos@email.com", "123456")
    );

    userRepository.saveAll(users);
  }
}
