package br.com.projetodevalura.nossobolao.validators;

import br.com.projetodevalura.nossobolao.forms.NewUserForm;
import br.com.projetodevalura.nossobolao.models.User;
import br.com.projetodevalura.nossobolao.repositories.UserRepository;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

public class NoUserWithDuplicateLoginValidator implements Validator {
  private UserRepository userRepository;

  public NoUserWithDuplicateLoginValidator(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public boolean supports(Class<?> clazz) {
    return NewUserForm.class.isAssignableFrom(clazz);
  }

  @Override
  public void validate(Object target, Errors errors) {
    NewUserForm form = (NewUserForm) target;
    Optional<User> possibleUser = userRepository.findByLogin(form.getLogin());

    if (possibleUser.isPresent()) {
      errors.rejectValue("login", null, "Já existe um usuário com esse login");
    }
  }

}
