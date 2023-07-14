package br.com.sara.prepara.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class LoginSenhaDTO {

    @JsonProperty("email")
    @Email(message = "O campo 'email' é obrigatório")
    @NotBlank(message = "E-mail não poder ser null")
    private String login;
    
    @JsonProperty("senha")
    @NotBlank(message = "O campo 'senha' é obrigatório")
    @Length(min = 12, max = 16, message = "O senha do cliente deve conter entre 12 e 16 caracteres")
    private String senha;
}
