package br.com.projetodevalura.nossobolao;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

public class NoTeamWithDuplicateNameValidator  implements Validator {
  private TeamRepository teamRepository;

  public NoTeamWithDuplicateNameValidator(TeamRepository teamRepository) {
    this.teamRepository = teamRepository;
  }

  @Override
  public boolean supports(Class<?> clazz) {
    return NewTeamForm.class.isAssignableFrom(clazz);
  }

  @Override
  public void validate(Object target, Errors errors) {
    NewTeamForm form = (NewTeamForm) target;
    Optional<Team> possibleTeam = teamRepository.findByName(form.getName());

    if (possibleTeam.isPresent()) {
      errors.rejectValue("name", null, "Já existe um time com esse nome");
    }
  }
}
