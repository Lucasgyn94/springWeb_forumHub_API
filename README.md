# ForumHub - Backend System
ForumHub é uma aplicação backend desenvolvida durante a Clallenge ministrada pela plataforma Alura em Java com Spring Boot, destinada a gerenciar operações CRUD em um sistema de fórum. A aplicação é projetada para manipular entidades como Topico, Curso, Resposta, Usuario e Perfil, seguindo o padrão de arquitetura MVC (Model-View-Controller).

## Extras
Implementação das rotas de usuários e respostas que permiti criar, listar, atualizar e excluir os mesmos.

## Funcionalidades
Gerenciamento de Tópicos: Criação, listagem, atualização e exclusão de tópicos.
Gerenciamento de Usuários: Criação, listagem, atualização e exclusão de usuários.
Gerenciamento de Respostas: Criação, listagem, atualização e exclusão de respostas.
Autenticação e Autorização: Implementação de autenticação via JWT e autorização baseada em papéis.
Documentação da API: Integração com SpringDoc e Swagger para documentação e testes da API.

## Tecnologias Utilizadas
Java 17
Spring Boot
Spring Security
Spring Data JPA
Hibernate
PostgreSQL
Maven
Swagger e SpringDoc para documentação


## Configuração do Ambiente<br>
### Clone o Repositório:
sh<br>
git clone https://github.com/seu-usuario/forumhub.git<br>

### Navegue até o Diretório do Projeto:
sh<br>
cd forumhub<br>

### Configure o Banco de Dados:
Crie um banco de dados PostgreSQL e atualize as configurações no arquivo application.properties.<br>

### Execute as Migrações do Banco de Dados:
sh<br>
./mvnw flyway:migrate<br>

### Inicie a Aplicação:
sh<br>
./mvnw spring-boot:run<br>

## Rotas da API Autenticação:

<table>
  <tr>
    <th>Entidade</th>
    <th>Rota</th>
    <th>Método HTTP</th>
    <th>Descrição</th>
  </tr>
  <tr>
    <td>Autenticação</td>
    <td>/login</td>
    <td>POST</td>
    <td>Efetua login e retorna um token JWT</td>
  </tr>
  <tr>
    <td>Tópicos</td>
    <td>/topicos</td>
    <td>GET</td>
    <td>Lista todos os tópicos</td>
  </tr>
  <tr>
    <td>Tópicos</td>
    <td>/topicos</td>
    <td>POST</td>
    <td>Cria um novo tópico</td>
  </tr>
  <tr>
    <td>Tópicos</td>
    <td>/topicos/{id}</td>
    <td>GET</td>
    <td>Retorna um tópico pelo ID</td>
  </tr>
  <tr>
    <td>Tópicos</td>
    <td>/topicos/{id}</td>
    <td>PUT</td>
    <td>Atualiza um tópico pelo ID</td>
  </tr>
  <tr>
    <td>Tópicos</td>
    <td>/topicos/{id}</td>
    <td>DELETE</td>
    <td>Deleta um tópico pelo ID</td>
  </tr>
  <tr>
    <td>Usuários</td>
    <td>/usuarios</td>
    <td>GET</td>
    <td>Lista todos os usuários</td>
  </tr>
  <tr>
    <td>Usuários</td>
    <td>/usuarios</td>
    <td>POST</td>
    <td>Cria um novo usuário</td>
  </tr>
  <tr>
    <td>Usuários</td>
    <td>/usuarios/{id}</td>
    <td>GET</td>
    <td>Retorna um usuário pelo ID</td>
  </tr>
  <tr>
    <td>Usuários</td>
    <td>/usuarios/{id}</td>
    <td>PUT</td>
    <td>Atualiza um usuário pelo ID</td>
  </tr>
  <tr>
    <td>Usuários</td>
    <td>/usuarios/{id}</td>
    <td>DELETE</td>
    <td>Deleta um usuário pelo ID</td>
  </tr>
  <tr>
    <td>Respostas</td>
    <td>/respostas</td>
    <td>GET</td>
    <td>Lista todas as respostas</td>
  </tr>
  <tr>
    <td>Respostas</td>
    <td>/respostas</td>
    <td>POST</td>
    <td>Cria uma nova resposta</td>
  </tr>
  <tr>
    <td>Respostas</td>
    <td>/respostas/{id}</td>
    <td>GET</td>
    <td>Retorna uma resposta pelo ID</td>
  </tr>
  <tr>
    <td>Respostas</td>
    <td>/respostas/{id}</td>
    <td>PUT</td>
    <td>Atualiza uma resposta pelo ID</td>
  </tr>
  <tr>
    <td>Respostas</td>
    <td>/respostas/{id}</td>
    <td>DELETE</td>
    <td>Deleta uma resposta pelo ID</td>
  </tr>
</table>

## Contribuição
Contribuições são bem-vindas! Sinta-se à vontade para abrir issues e pull requests.

## Licença
Este projeto está licenciado sob a Licença Apache 2.0. Consulte o arquivo LICENSE para mais detalhes.

## Contato
Para mais informações, entre em contato com nosso time de backend em needslucas944@gmail.com.
