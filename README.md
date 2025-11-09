#  Task Manager API

Uma API REST completa para gerenciamento de tarefas com autenticação JWT.

##  Sobre o Projeto

API desenvolvida com Spring Boot para gerenciamento de tarefas pessoais, incluindo autenticação segura com JWT e banco de dados em memória H2.

##  Tecnologias Utilizadas

- **Java 21**
- **Spring Boot 3.4.1**
- **Spring Security** - Autenticação e autorização
- **JWT** - Tokens de autenticação
- **Spring Data JPA** - Persistência de dados
- **H2 Database** - Banco em memória
- **Maven** - Gerenciamento de dependências
- **ModelMapper** - Mapeamento de DTOs

##  Estrutura do Projeto

task-manager-api/  
├── src/main/java/com/taskmanager/taskmanagerapi/  
│ ├── controller/ # Endpoints REST  
│ ├── entity/ # Entidades JPA (Task, User)  
│ ├── repository/ # Interfaces Spring Data JPA  
│ ├── service/ # Lógica de negócio  
│ ├── security/ # Configurações de segurança  
│ └── dto/ # Objetos de transferência de dados  
├── src/main/resources/  
│ └── application.yml # Configurações da aplicação  
└── pom.xml # Dependências Maven  


##  Como Executar

### Pré-requisitos
- Java 21
- Maven 3.6+

### Passos
```bash
# Clonar repositório
git clone https://github.com/seu-usuario/task-manager-api.git

# Entrar no diretório
cd task-manager-api

# Executar a aplicação
mvn spring-boot:run

Endpoints da API
Autenticação
POST /api/auth/login - Autenticar usuário

POST /api/auth/register - Registrar novo usuário

Tarefas (Requer autenticação)
GET /api/tasks - Listar todas as tarefas

POST /api/tasks - Criar nova tarefa

PUT /api/tasks/{id} - Atualizar tarefa

DELETE /api/tasks/{id} - Excluir tarefa

 Autenticação
A API usa JWT (JSON Web Token) para autenticação. Inclua o token no header:

Authorization: Bearer <seu-token-jwt>

 Banco de Dados
H2 Console: http://localhost:8080/h2-console

JDBC URL: jdbc:h2:mem:taskdb

Usuário: sa

Senha: (vazio)

 Exemplo de Uso
1. Login
bash
POST http://localhost:8080/api/auth/login
Content-Type: application/json

{
    "username": "usuario",
    "password": "senha"
}
2. Criar Tarefa (com token)
bash
POST http://localhost:8080/api/tasks
Authorization: Bearer <token>
Content-Type: application/json

{
    "title": "Minha primeira tarefa",
    "description": "Descrição da tarefa",
    "completed": false
}

Funcionalidades
✅ Autenticação JWT

✅ CRUD completo de tarefas

✅ Segurança com Spring Security

✅ Banco de dados em memória H2

✅ Validação de dados

✅ Tratamento de erros

✅ Documentação da API

 Autor
Marcella - Lilithcurious
