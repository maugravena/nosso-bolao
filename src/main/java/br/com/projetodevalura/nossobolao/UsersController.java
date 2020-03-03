package br.com.projetodevalura.nossobolao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api")
public class UsersController {

  @Autowired
  private UserRepository userRepository;

  @InitBinder("newUserForm")
  public void init(WebDataBinder dataBinder) {
    dataBinder.addValidators(new NoUserWithDuplicateLoginValidator(userRepository));
  }

  @PostMapping(value = "/users")
  public void create(@Valid @RequestBody NewUserForm form) {
    User newUser = form.build();
    userRepository.save(newUser);
  }
}
