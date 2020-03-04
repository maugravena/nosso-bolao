package br.com.projetodevalura.nossobolao.models;

import javax.persistence.*;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_championship")
public class Championship {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @NotBlank @Column(unique = true)
  private String name;
  @FutureOrPresent
  private LocalDate startDate;
  private Integer numberOfTeams;
  @ElementCollection
  private Set<Integer> teams = new HashSet<>();

  public Championship(@NotBlank String name, @FutureOrPresent LocalDate startDate, Integer numberOfTeams, Set<Integer> teams) {
    this.name = name;
    this.startDate = startDate;
    this.numberOfTeams = numberOfTeams;
    this.teams.addAll(teams);
  }

  @Deprecated
  public Championship() {  }

  @Override
  public String toString() {
    return "Championship{" +
        "name='" + name + '\'' +
        ", startDate=" + startDate +
        ", numberOfTeams=" + numberOfTeams +
        ", teams=" + teams +
        '}';
  }
}
