package br.com.projetodevalura.nossobolao.forms;

import br.com.projetodevalura.nossobolao.models.Championship;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class NewChampionshipForm {

  @NotBlank
  private String name;
  @FutureOrPresent
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
  private LocalDate startDate;
  private Integer numberOfTeams;
  private Set<Integer> teams = new HashSet<>();

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public LocalDate getStartDate() {
    return startDate;
  }

  public void setStartDate(LocalDate startDate) {
    this.startDate = startDate;
  }

  public Set<Integer> getTeams() {
    return teams;
  }

  public void setTeams(Set<Integer> teams) {
    this.teams = teams;
  }

  public Integer getNumberOfTeams() {
    return numberOfTeams;
  }

  public void setNumberOfTeams(Integer numberOfTeams) {
    this.numberOfTeams = numberOfTeams;
  }

  public Championship build() {
    return new Championship(name, startDate, numberOfTeams, teams);
  }
}
