# Este projeto consiste em um sistema de autenticação e autorização com JWT para aplicação de Ecommerce.

## Estrutura do Projeto
O projeto é organizado em pacotes: 

- application: Contém a classe principal para executar a aplicação Spring Boot.
- config: Contém classes de configuração para segurança.
- controller: Contém os controladores REST para tratamento das requisições HTTP.
- model: Contém modelos de dados para requisições e respostas.
- security: Contém classes utilitárias para operações JWT.
- service: Contém classes de serviço para lógica de negócios.

## Componentes Principais
# Ponto de Entrada da Aplicação
- JwtRestApiApplication: A classe principal que inicializa a aplicação Spring Boot.
# Configuração de Segurança
- SecurityConfig: Define as configurações de segurança HTTP, detalhes do usuário e codificação de senhas.
# Controller
- AuthController: Gerencia requisições relacionadas à autenticação.
# Model
- LoginRequest: Representa os dados da requisição de login.
# Utilitário de Segurança
- JwtUtil: Contém métodos para gerar e extrair informações de JWTs.
# Serviços
- AuthService: Fornece métodos para gerar tokens e extrair nomes de usuário.

# Controladores
O AuthController fornece os seguintes endpoints:
- POST /login: Autentica um usuário e retorna um token JWT.
- GET /username/{token}: Extrai o nome de usuário de um token JWT fornecido.
- GET /user: Retorna as informações do usuário autenticado.
- GET /admin: Restrito a usuários administradores; retorna informações específicas do administrador.
- GET /gerentedeprodutos: Restrito a usuários com papel de gerente de produtos; retorna informações específicas do gerente de produtos.
- GET /vendedor: Acessível a usuários vendedores; retorna informações específicas do vendedor.
- GET /cliente: Acessível a usuários clientes; retorna informações específicas do cliente.

# Modelos
A classe LoginRequest representa a carga útil para a requisição de login, contendo um nome de usuário e uma senha.

# Utilitário de Segurança
A classe JwtUtil fornece métodos para:

Gerar um token JWT para um determinado nome de usuário.
Extrair o nome de usuário de um token JWT fornecido.
Extrair o ID de um token JWT fornecido (método não utilizado na implementação atual).
Serviços
A classe AuthService atua como intermediária entre o controlador e a classe utilitária, utilizando o JwtUtil para gerar tokens e extrair nomes de usuário de tokens.

## Diagrama
![Captura de tela 2024-06-15 181848](https://github.com/giovanna252gabriela/ecommerce/assets/125416536/dbc28990-db06-40ef-b145-7013deb72c47)
