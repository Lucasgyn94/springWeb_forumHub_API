package br.com.alura.forumhub.springdoc;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfigurations {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components()
                        .addSecuritySchemes("bearer-key",
                                new SecurityScheme()
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT")))
                .info(new Info()
                        .title("API Forum Hub")
                        .description("A API Forum Hub é uma aplicação RESTful desenvolvida com Spring Boot para gerenciar um fórum de discussões. " +
                                "Ela permite a criação, listagem, atualização e exclusão de tópicos, bem como a gestão de usuários e respostas. " +
                                "Com uma arquitetura robusta e segura, utilizando autenticação JWT, a API é ideal para ser utilizada como backend de um fórum de discussões " +
                                "em projetos de pequeno a médio porte.\n\n" +
                                "## Recursos Principais:\n" +
                                "- **Gerenciamento de Tópicos:** Criação, listagem, atualização e exclusão de tópicos do fórum.\n" +
                                "- **Autenticação JWT:** Autenticação segura utilizando JSON Web Tokens (JWT).\n" +
                                "- **Gerenciamento de Usuários:** Cadastro e autenticação de usuários.\n" +
                                "- **Gerenciamento de Respostas:** Adição e gestão de respostas para os tópicos.\n" +
                                "- **Documentação Interativa:** Documentação de API interativa e amigável ao desenvolvedor com Swagger UI.\n" +
                                "- **Validações de Dados:** Validação de campos obrigatórios e prevenção de duplicação de tópicos.\n\n" +
                                "Este projeto foi desenvolvido como parte do programa de formação da Alura, aplicando boas práticas de desenvolvimento e segurança.")
                        .contact(new Contact()
                                .name("Time Backend")
                                .email("needslucas944@gmail.com"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://voll.med/api/licenca")));
    }
}
