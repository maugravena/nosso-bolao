package br.com.projetodevalura.nossobolao;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_user")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private @NotBlank @NotNull @Email @Column(unique = true) String login;
  private @NotBlank @NotNull @Size(min = 6) String password;
  @PastOrPresent
  private LocalDateTime createdAt = LocalDateTime.now();

  public User(@NotBlank @Email @NotNull String login, @NotBlank @NotNull @Size(min = 6) String password) {
    this.login = login;
    this.password = password;
  }

  public User() {  }

  @Override
  public String toString() {
    return "User{" +
        "login='" + login + '\'' +
        ", password='" + password + '\'' +
        ", createdAt=" + createdAt +
        '}';
  }
}