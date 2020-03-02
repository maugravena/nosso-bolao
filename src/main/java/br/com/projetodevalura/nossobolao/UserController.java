package br.com.projetodevalura.nossobolao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api")
public class UserController {

  @Autowired
  private UserRepository userRepository;

  @PostMapping(value = "/users")
  @Transactional
  public void create(@Valid @RequestBody NewUserForm form) {
    User newUser = form.build();
    userRepository.save(newUser);
  }
}
