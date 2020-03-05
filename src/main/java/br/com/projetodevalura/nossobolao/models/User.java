package br.com.projetodevalura.nossobolao.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_user")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  public static final PasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();
  @NotBlank @Email @Column(unique = true)
  private String login;
  @JsonIgnore
  @NotBlank @Size(min = 6)
  private String password;
  @PastOrPresent
  private LocalDateTime createdAt = LocalDateTime.now();


  @Deprecated
  public User() {  }

  public User(@NotBlank @Email String login, @NotBlank @Size(min = 6) String password) {
    this.login = login;
    setPassword(password);
  }

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
    this.password = PASSWORD_ENCODER.encode(password);
  }

  @Override
  public String toString() {
    return "User{" +
        "login='" + login + '\'' +
        ", password='" + password + '\'' +
        ", createdAt=" + createdAt +
        '}';
  }
}
