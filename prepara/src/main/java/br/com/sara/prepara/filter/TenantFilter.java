package br.com.sara.prepara.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import br.com.sara.prepara.TenantContext;

@Component
public class TenantFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // Determine o inquilino atual com base na solicitação
        String tenantIdentifier = determineTenantIdentifier(request);

        // Defina o inquilino atual no contexto do inquilino
        TenantContext.setCurrentTenant(tenantIdentifier);

        try {
            filterChain.doFilter(request, response);
        } finally {
            // Limpe o inquilino atual após a conclusão da solicitação
            TenantContext.clear();
        }
    }

    private String determineTenantIdentifier(HttpServletRequest request) {
        // Implemente a lógica para determinar o identificador do inquilino com base na solicitação
        // Pode ser um cabeçalho, parâmetro de consulta, autenticação, etc.
        // Retorna o identificador do inquilino ou null se não for encontrado
        return request.getServerName();
    }
}
