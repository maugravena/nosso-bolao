package br.com.projetodevalura.nossobolao.forms;

import br.com.projetodevalura.nossobolao.models.Championship;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

public class NewChampionshipForm {

  @NotBlank
  private String name;
  @FutureOrPresent
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
  private LocalDate startDate;

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

  public Championship build() {
    return new Championship(name, startDate);
  }
}
