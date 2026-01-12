# API de Gerenciamento de Veículos e Clientes 🚗

Desafio técnico para Analista de Desenvolvimento Java PL. Esta API REST robusta permite o gerenciamento completo de veículos e seus respectivos donos (clientes), protegida por autenticação JWT.

## 🚀 Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3.x**
- **Spring Security & JWT** (Json Web Token)
- **Hibernate/JPA** (ORM)
- **MySQL 8.x** (Banco de dados)
- **Lombok** (Produtividade)
- **Jakarta Validation** (Validações de entrada)

## 🛠️ Arquitetura do Projeto

O projeto segue o padrão de camadas para garantir manutenibilidade e separação de responsabilidades:
- **Controller:** Exposição dos endpoints REST.
- **Service:** Regras de negócio e intermediação.
- **Repository:** Interface de comunicação com o banco de dados.
- **DTO (Data Transfer Object):** Segurança e controle sobre os dados trafegados.
- **Entity:** Representação das tabelas do banco de dados.

## ⚙️ Como Executar o Projeto

1. **Configurar o Banco de Dados:**
   - Certifique-se de que o MySQL está rodando na porta padrão (ou ajuste em `application.yml`).
   - Execute o script contido no arquivo `ddl.sql` (na raiz do projeto) para criar as tabelas.

2. **Compilar e Rodar:**
   ```bash
   mvn clean install
   mvn spring-boot:run

   A API estará disponível em: http://localhost:8080
🔐 Segurança e Autenticação
A API utiliza JWT. Para acessar os endpoints de Clientes e Veículos, você deve:
Realizar login em POST /auth/login.
Copiar o token recebido.
Adicionar o cabeçalho Authorization: Bearer <SEU_TOKEN> nas requisições seguintes.
📸 Evidências dos Testes (Postman)
Aqui estão as validações realizadas no Postman, localizadas na pasta imagens/:


**Postman_Validacao_placa_inexistente**

<img width="1903" height="969" alt="Postman_Validacao_placa_inexistente" src="https://github.com/user-attachments/assets/6dac51a7-3297-4fec-a817-e8a4c96191dd" />

**Postman_UPDATE_veiculo**

<img width="1903" height="969" alt="Postman_UPDATE_veiculo" src="https://github.com/user-attachments/assets/a98bd21e-4e72-453e-89df-4c4d5c545ba8" />

**Postman_testesGeral_API**

<img width="1846" height="984" alt="Postman_testesGeral_API" src="https://github.com/user-attachments/assets/99c49f60-12b1-43bd-9acf-013c9c3cf571" />

**Postman_PUT_veiculo_inexistente**

<img width="1874" height="946" alt="Postman_PUT_veiculo_inexistente" src="https://github.com/user-attachments/assets/7b3170f9-57a8-4260-94ca-d8fee081e8f0" />

**Postman_PUT_cliente_inexistente_erro_tratado**

<img width="1874" height="946" alt="Postman_PUT_cliente_inexistente_erro_tratado" src="https://github.com/user-attachments/assets/0a625368-793a-4551-871c-adc8fffce277" />

**Postman_PUT_cliente**

<img width="1903" height="969" alt="Postman_PU_cliente" src="https://github.com/user-attachments/assets/8690aa96-e839-4d3f-9b84-a87f142e83c9" />

**Postman_POST_veiculo_clinete_inexistente**

<img width="1874" height="946" alt="Postman_POST_veiculo_clinete_inexistente" src="https://github.com/user-attachments/assets/95a74887-eb25-4466-b92b-3bb6093a6912" />

**Postman_POST_veiculo**

<img width="1903" height="969" alt="Postman_POST_veiculo" src="https://github.com/user-attachments/assets/0b609084-448d-401f-81ec-75003700b576" />

**POSTMAN_POST_Login_autenticação**

<img width="1846" height="984" alt="POSTMAN_POST_Login_autenticação" src="https://github.com/user-attachments/assets/e0ed5580-c57d-4187-8a4a-f75d770c8022" />

**Postman_POST_Login_autenticação**

<img width="1846" height="984" alt="Postman_POST_Login_autenticação" src="https://github.com/user-attachments/assets/38cb0d6d-88a2-428a-937f-5db4d207d214" />

**POSTMAN_POST_CLIENTE_COM_AUTENTICAÇÂO**

<img width="1846" height="984" alt="POSTMAN_POST_CLIENTE_COM_AUTENTICAÇÂO" src="https://github.com/user-attachments/assets/c0d4e30b-4b86-47b6-ad76-f302966066e9" />

**Postman_POST_Cliente**

<img width="1903" height="969" alt="Postman_POST_Cliente" src="https://github.com/user-attachments/assets/0f47f2ca-20b9-4ff9-b8e7-7ac155731574" />

**Postman_GET_veiculo_inexistente**

<img width="1874" height="946" alt="Postman_GET_veiculo_inexistente" src="https://github.com/user-attachments/assets/23c70c69-45fa-493f-a7e9-cc5bee814f45" />

**Postman_GET_veiculoDELETADO**

<img width="1903" height="969" alt="Postman_GET_veiculoDELETADO" src="https://github.com/user-attachments/assets/74a9c4ad-d7e1-4a5c-a2e2-f9400518496c" />

**Postman_GET_veiculo_cadastrado_unico**

<img width="1903" height="969" alt="Postman_GET_veiculo_cadastrado_unico" src="https://github.com/user-attachments/assets/5c8cfe69-c1b0-4df5-82d9-999ea0e91a59" />

**Postman_GET_Lista_veiculos**

<img width="1903" height="969" alt="Postman_GET_Lista_veiculos" src="https://github.com/user-attachments/assets/78f6b245-ac0f-4300-b32b-eba2236a0ab7" />

**Postman_GET_lista_CLientes_cadastrados**

<img width="1903" height="969" alt="Postman_GET_lista_CLientes_cadastrados" src="https://github.com/user-attachments/assets/6e14910f-20dd-493b-80e9-1e4810c1a5d1" />

**POSTMAN_GET_LISTA_CLIENTE_COM_AUTENTICAÇÂO**

<img width="1846" height="984" alt="POSTMAN_GET_LISTA_CLIENTE_COM_AUTENTICAÇÂO" src="https://github.com/user-attachments/assets/d0938312-e473-4948-b493-5c183c234d34" />

**Postman_GET_cliente_unico_id**

<img width="1903" height="969" alt="Postman_GET_cliente_unico_id" src="https://github.com/user-attachments/assets/846b8ba8-0865-4ae7-82b4-abcf2d9c6030" />

**POSTMAN_GET_CLIENTE_TOKEN_API**

<img width="1846" height="984" alt="POSTMAN_GET_CLIENTE_TOKEN_API" src="https://github.com/user-attachments/assets/b34d2c3c-2d28-429e-89a1-191c766f9521" />

**Postman_GET_cliente_inexistente**

<img width="1874" height="946" alt="Postman_GET_cliente_inexistente" src="https://github.com/user-attachments/assets/cea1515c-9a5f-4106-89ff-d40da4466660" />

**Postman_DELETE_veiculo_inexistente**

<img width="1874" height="946" alt="Postman_DELETE_veiculo_inexistente" src="https://github.com/user-attachments/assets/83f908de-e9d5-42cc-8f46-7a1b5599fb3e" />

**Postman_DELETE_veiculo**

<img width="1903" height="969" alt="Postman_DELETE_veiculo" src="https://github.com/user-attachments/assets/a9cb2f85-3ef1-4ddb-90d1-1a3355cefa3e" />

**Postman_DELETE_Cliente_com_veiculo_erro_tratado**

<img width="1903" height="969" alt="Postman_DELETE_Cliente_com_veiculo_erro_tratado" src="https://github.com/user-attachments/assets/0366eabb-cff9-465d-9e5a-42b8fc372817" />

**Postman_DELETE_Cliente**

<img width="1903" height="969" alt="Postman_DELETE_Cliente" src="https://github.com/user-attachments/assets/c8c7d940-3d05-444a-ae35-120e4c8edbcd" />








































































