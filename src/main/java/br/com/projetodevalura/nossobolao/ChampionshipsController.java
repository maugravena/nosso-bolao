package br.com.projetodevalura.nossobolao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api")
public class ChampionshipsController {

  @Autowired
  private ChampionshipRepository championshipRepository;

  @InitBinder("newChampionshipForm")
  public void init(WebDataBinder dataBinder) {
    dataBinder.addValidators(new NoChampionshipDuplicateNameValidator(championshipRepository));
  }

  @PostMapping(value = "/championships" )
  public void create(@Valid @RequestBody NewChampionshipForm form) {
    Championship newChampionship = form.build();
    championshipRepository.save(newChampionship);
  }
}
