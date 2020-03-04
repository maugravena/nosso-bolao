package br.com.projetodevalura.nossobolao.repositories;

import br.com.projetodevalura.nossobolao.models.Championship;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ChampionshipRepository extends CrudRepository<Championship, Long> {
  Optional<Championship> findByName(String name);
}
