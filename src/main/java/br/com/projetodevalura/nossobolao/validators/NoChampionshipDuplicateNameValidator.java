package br.com.projetodevalura.nossobolao.validators;

import br.com.projetodevalura.nossobolao.forms.NewChampionshipForm;
import br.com.projetodevalura.nossobolao.models.Championship;
import br.com.projetodevalura.nossobolao.repositories.ChampionshipRepository;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

public class NoChampionshipDuplicateNameValidator implements Validator {
  private ChampionshipRepository championshipRepository;

  public NoChampionshipDuplicateNameValidator(ChampionshipRepository championshipRepository) {
    this.championshipRepository = championshipRepository;
  }

  @Override
  public boolean supports(Class<?> clazz) {
    return NewChampionshipForm.class.isAssignableFrom(clazz);
  }

  @Override
  public void validate(Object target, Errors errors) {
    NewChampionshipForm form = (NewChampionshipForm) target;
    Optional<Championship> possibleChampionship = championshipRepository.findByName(form.getName());

    if (possibleChampionship.isPresent()) {
      errors.rejectValue("name", null, "Já existe um campeonato com esse nome");
    }
  }
}
