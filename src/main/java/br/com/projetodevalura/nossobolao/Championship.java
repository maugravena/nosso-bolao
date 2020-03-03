package br.com.projetodevalura.nossobolao;

import javax.persistence.*;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Entity
@Table(name = "tb_championship")
public class Championship {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @NotBlank @Column(unique = true)
  private String name;
  @FutureOrPresent
  private LocalDate dateStart;

  public Championship(@NotBlank String name, @FutureOrPresent LocalDate dateStart) {
    this.name = name;
    this.dateStart = dateStart;
  }

  @Deprecated
  public Championship() {  }

  @Override
  public String toString() {
    return "Championship{" +
        "name='" + name + '\'' +
        ", dateStart=" + dateStart +
        '}';
  }
}
