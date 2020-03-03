package br.com.projetodevalura.nossobolao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api")
public class ChampionshipsController {

  @Autowired
  private ChampionshipRepository championshipRepository;

  @PostMapping(value = "/championships" )
  public void create(@Valid @RequestBody NewChampionshipForm form) {
    Championship newChampionship = form.build();
    championshipRepository.save(newChampionship);
  }
}
