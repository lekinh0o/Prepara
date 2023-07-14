package br.com.sara.prepara.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sara.prepara.model.Contrato;
import br.com.sara.prepara.model.IContratoService;
import br.com.sara.prepara.repository.ContratoRepository;

@Service
public class ContratoService implements IContratoService {
    
    @Autowired
    private ContratoRepository contratoRepository;

  

    public Contrato obterContrato(String login, String senha) {
        Optional<Contrato> contratoExistente = this.findByLoginAndSenha(login, senha);

        if (contratoExistente.isPresent()) {
            return contratoExistente.get();
        } else {
            throw new RuntimeException("Contrato não encontrado");
        }
    }

    public Contrato criarContrato(String login, String senha) {

        Contrato novoContrato = new Contrato();
        novoContrato.setLogin(login);
        novoContrato.setSenha(senha);
        // Gerar uma nova chaveMultiTenant
        novoContrato.setChaveMultiTenant(UUID.randomUUID());

        return contratoRepository.save(novoContrato);
    }


    @Override
    public Optional<Contrato> findByLoginAndSenha(String login, String senha) {
        
        return Optional.ofNullable(contratoRepository.findByLoginAndSenha(login, senha));
    }



}

