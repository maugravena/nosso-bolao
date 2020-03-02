package br.com.projetodevalura.nossobolao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api")
public class UserController {

  @Autowired
  private UserRepository userRepository;

  @InitBinder("newUserForm")
  public void init(WebDataBinder dataBinder) {
    dataBinder.addValidators(new NoUserWithDuplicateLoginValidator(userRepository));
  }

  @PostMapping(value = "/users")
  @Transactional
  public void create(@Valid @RequestBody NewUserForm form) {
    User newUser = form.build();
    userRepository.save(newUser);
  }
}
