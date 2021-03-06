package br.com.projetodevalura.nossobolao.forms;

import br.com.projetodevalura.nossobolao.models.User;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class NewUserForm {

  private @NotBlank @Email String login;
  private @NotBlank @Size(min = 6) String password;

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
