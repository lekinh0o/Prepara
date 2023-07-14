package br.com.sara.prepara.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sara.prepara.model.Contrato;
import br.com.sara.prepara.model.LoginSenhaDTO;
import br.com.sara.prepara.service.ContratoService;

@RestController
@RequestMapping("/prepara/api/contratos/v1")
public class ContratoController {
    private final ContratoService contratoService;

    public ContratoController(ContratoService contratoService) {
        this.contratoService = contratoService;
    }

    @PostMapping("/adm")
    public ResponseEntity<Contrato> buscarAdm(@RequestBody LoginSenhaDTO loginSenhaDTO) {
        String login = loginSenhaDTO.getLogin();
        String senha = loginSenhaDTO.getSenha();

        if (login == null || senha == null) {
            // Retorna um erro de requisição inválida caso o login ou senha estejam ausentes
            return ResponseEntity.badRequest().build();
        }

        Contrato contrato = contratoService.obterContrato(login, senha);

        return ResponseEntity.ok(contrato);
    }

     @PostMapping("/adm/cadastrar")
    public ResponseEntity<Contrato> cadastrarAdm(@RequestBody LoginSenhaDTO loginSenhaDTO) {
        String login = loginSenhaDTO.getLogin();
        String senha = loginSenhaDTO.getSenha();

        if (login == null || senha == null) {
            // Retorna um erro de requisição inválida caso o login ou senha estejam ausentes
            return ResponseEntity.badRequest().build();
        }

        Contrato contrato = contratoService.criarContrato(login, senha);

        return ResponseEntity.ok(contrato);
    }
}
