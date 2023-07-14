package br.com.sara.prepara.model;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import org.springframework.data.annotation.Id;

import br.com.sara.prepara.security.AttributeEncryptor;
import lombok.Data;

@Entity@Data
@Table(name = "contratos")
public class Contrato implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "Multi_Tenant", nullable = false, columnDefinition = "BINARY(36) NOT NULL")
    private UUID chaveMultiTenant;

    @Email
    @Column(name = "Login", nullable = false)
    private String login;
    
    @Convert(converter = AttributeEncryptor.class)
    @Column(name = "Senha", nullable = false)
    private String senha;
   
}
