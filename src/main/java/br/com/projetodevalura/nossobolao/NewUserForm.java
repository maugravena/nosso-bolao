package br.com.projetodevalura.nossobolao;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class NewUserForm {

  private @NotBlank @NotNull @Email String login;
  private @NotBlank @NotNull @Size(min = 6) String password;

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public User build() {
    return new User(login, password);
  }
}
