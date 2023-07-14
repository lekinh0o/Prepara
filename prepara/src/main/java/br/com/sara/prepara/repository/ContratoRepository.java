package br.com.sara.prepara.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sara.prepara.model.Contrato;

@Repository
public interface ContratoRepository extends JpaRepository<Contrato, UUID> {
    Contrato findByLoginAndSenha(String login, String senha);
}
