package br.com.projetodevalura.nossobolao;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;

import java.time.LocalDate;

@Entity
@Table(name = "tb_team")
public class Team {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @NotBlank @Column(unique = true)
  private String name;
  @Past
  private LocalDate foundationDate;

  public Team(@NotBlank String name, @Past LocalDate foundationDate) {
    this.name = name;
    this.foundationDate = foundationDate;
  }

  @Deprecated
  public Team() {  }

  @Override
  public String toString() {
    return "Team{" +
        "name='" + name + '\'' +
        ", foundationDate=" + foundationDate +
        '}';
  }
}
