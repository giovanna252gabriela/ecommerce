# E-commerce

## Visão Geral

Este projeto demonstra uma implementação simples de uma API REST com autenticação JWT (JSON Web Token) usando Spring Boot. A API inclui papéis de usuários e controle de acesso para diferentes endpoints.

## Pré-requisitos

- Java 8 ou superior
- Maven ou Gradle
- IDE (IntelliJ IDEA, Eclipse, etc.)

## Estrutura do Projeto

O projeto está dividido em vários pacotes, cada um com responsabilidades específicas:

1. **application**: Contém a classe principal para executar a aplicação Spring Boot.
2. **config**: Contém classes de configuração para as configurações de segurança.
3. **controller**: Contém controladores REST para manipulação de requisições HTTP.
4. **model**: Contém modelos de dados para requisições e respostas.
5. **security**: Contém classes utilitárias para operações JWT.
6. **service**: Contém classes de serviço para lógica de negócios.

## Componentes Principais

### Ponto de Entrada da Aplicação

- `JwtRestApiApplication`: A classe principal que inicializa a aplicação Spring Boot.

### Configuração de Segurança

- `SecurityConfig`: Configura as definições de segurança HTTP, detalhes do usuário e codificação de senhas.

### Controladores

- `AuthController`: Manipula requisições relacionadas à autenticação.

### Modelos

- `LoginRequest`: Representa a carga útil da requisição de login.

### Utilitário de Segurança

- `JwtUtil`: Contém métodos para gerar e extrair informações de JWTs.

### Serviços

- `AuthService`: Fornece métodos para gerar tokens e extrair nomes de usuário.

## Descrição Detalhada

### Ponto de Entrada da Aplicação

O ponto de entrada da aplicação é a classe `JwtRestApiApplication`. Ela utiliza a anotação `@SpringBootApplication` para habilitar a configuração automática e a varredura de componentes.

### Configuração de Segurança

A classe `SecurityConfig` configura o seguinte:

- **Proteção CSRF**: Desativada para simplicidade.
- **Segurança dos Endpoints**: Configura quais endpoints são acessíveis para quais papéis:
  - `/login/**`, `/username/**`, `/user/**`, `/admin/**`, `/gerentedeprodutos/**` , `/vendedor/** e ´/cliente/** ` são todos acessíveis sem autenticação.
  - `/admin/**` é restrito a usuários com o papel "ADMIN".
  - `/gerentedeprodutos/**` é restrito a usuários com o papel "GERENTEDEPRODUTOS".
  - `/vendedor/**` é restrito a usuários com o papel "VENDEDOR".
   - `/cliente/**` é restrito a usuários com o papel "CLIENTE".
  - Todas as outras requisições requerem autenticação.

A classe também configura um serviço de detalhes do usuário em memória com três usuários tendo diferentes papéis e um codificador de senhas.

### Controladores

O `AuthController` fornece os seguintes endpoints:

- **POST /login**: Autentica um usuário e retorna um token JWT.
- **GET /username/{token}**: Extrai o nome de usuário de um token JWT fornecido.
- **GET /user**: Retorna as informações do usuário autenticado.
- **GET /admin**: Restrito a usuários administradores; retorna informações específicas do administrador.
- **GET /gerentedeprodutos**: Restrito a usuários moderados; retorna informações específicas do gerentedeproduto.
- **GET /vendedor**: Acessível a usuários comuns; retorna informações específicas do vendedor.
- **GET /cliente**: Acessível a usuários comuns; retorna informações específicas do cliente.


### Modelos

A classe `LoginRequest` representa a carga útil para a requisição de login, contendo um nome de usuário e uma senha.

### Utilitário de Segurança

A classe `JwtUtil` fornece métodos para:

- Gerar um token JWT para um determinado nome de usuário.
- Extrair o nome de usuário de um token JWT fornecido.
- Extrair o ID de um token JWT fornecido (método não utilizado na implementação atual).

### Serviços

A classe `AuthService` atua como intermediária entre o controlador e a classe utilitária. Ela utiliza o `JwtUtil` para gerar tokens e extrair nomes de usuário de tokens.

## Uso

1. **Executar a Aplicação**: Use sua IDE ou linha de comando para executar a classe `JwtRestApiApplication`.
2. **Autenticar**: Envie uma requisição POST para `/login` com uma carga JSON contendo `username` e `password`. Exemplo:
    ```json
    {
      "username": "Larissa",
      "password": "4321"
    }
    ```
3. **Acessar Endpoints Seguros**: Use o token JWT retornado para acessar outros endpoints, incluindo-o no cabeçalho `Authorization` como um token Bearer.

## Exemplos de Requisições

1. **Requisição de Login**:
    ```sh
    curl -X POST http://localhost:8080/login -H "Content-Type: application/json" -d '{"username": "Larissa", "password": "4321"}'
    ```
2. **Extrair Nome de Usuário**:
    ```sh
    curl -X GET http://localhost:8080/username/{token}
    ```
3. **Acessar Endpoint de Administrador**:
    ```sh
    curl -X GET http://localhost:8080/admin -H "Authorization: Bearer {token}"
    ```

## Conclusão

Este projeto fornece uma compreensão fundamental de como implementar autenticação JWT em uma aplicação Spring Boot. Inclui controle de acesso baseado em papéis e demonstra o manuseio seguro da autenticação e autorização de um E-commerce.

Para mais detalhes, consulte o código e os comentários dentro de cada classe.

## Diagrama 

!![diagrama-ecommerce](https://github.com/Lellis17/E-commerce/assets/111644936/dffe792f-9fce-4d4d-95b0-9d3542fb06d9)



## Imagens do Insomnia em execução

![e1](https://github.com/Lellis17/E-commerce/assets/111644936/2e09117c-2a2b-4fde-8238-06f2ee232ef9)
![e4](https://github.com/Lellis17/E-commerce/assets/111644936/6cadbfac-09df-40bf-bf3a-d126ce0742f7)
![e3](https://github.com/Lellis17/E-commerce/assets/111644936/fb653886-e720-4a80-a1a9-f20fcfd547e3)
![e2](https://github.com/Lellis17/E-commerce/assets/111644936/a6c0a19f-d019-463d-bcc9-77a6bab0bdbd)

![e5](https://github.com/Lellis17/E-commerce/assets/111644936/5b643bac-4600-4963-91e1-256e3ebf1db2)



