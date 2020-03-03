package br.com.projetodevalura.nossobolao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api")
public class TeamsController {

  @Autowired
  private TeamRepository teamRepository;

  @InitBinder("newTeamForm")
  public void init(WebDataBinder dataBinder) {
    dataBinder.addValidators(new NoTeamWithDuplicateNameValidator(teamRepository));
  }

  @PostMapping(value = "/teams")
  public void create(@Valid @RequestBody NewTeamForm form) {
    Team newTeam = form.build();
    teamRepository.save(newTeam);
  }
}
