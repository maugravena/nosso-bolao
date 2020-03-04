package br.com.projetodevalura.nossobolao.repositories;

import br.com.projetodevalura.nossobolao.models.Team;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeamRepository extends CrudRepository<Team, Long> {
  Optional<Team> findByName(String name);
}