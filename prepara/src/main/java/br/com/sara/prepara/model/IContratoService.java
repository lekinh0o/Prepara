package br.com.sara.prepara.model;

import java.util.Optional;

public interface IContratoService {
   Optional<Contrato > findByLoginAndSenha(String login, String senha);

}
