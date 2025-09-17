# 🩺 spring-med-api

API para gerenciamento de agendamentos em clínicas médicas.  
O sistema funciona como uma agenda online que permite cadastrar médicos, pacientes e criar agendamentos.

---

## ✨ Funcionalidades
- 🔑 Autenticação  
- ➕ Cadastrar médico  
- 📋 Listar médicos  
- ✏️ Atualizar médico  
- ❌ Deletar médico pelo ID  
- 🔍 Buscar médico pelo ID  
- 🧑‍🤝‍🧑 Cadastrar paciente  
- 📅 Criar agendamento  
- 🕒 Criar agenda de horários  

---

## 🛠️ Tecnologias utilizadas
- Java 17  
- Spring Boot 3  
- Maven  
- Docker Compose (PostgreSQL)  
- Flyway  

---

## 📋 Requisitos
- Docker  
- Docker Compose  
- Java 17  
- Maven  

---

## 🚀 Como rodar o projeto
1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/spring-med-api.git
   ```
2. Suba os containers (Postgres + Flyway):
   ```bash
   docker-compose up -d
   ```
3. Execute a aplicação:
   ```bash
   mvn spring-boot:run
   ```
4. A aplicação estará disponível em:
   ```
   http://localhost:8080
   ```

---

## 📡 Endpoints principais
- `POST /auth/login` → autenticação  
- `POST /medicos` → cadastrar médico  
- `GET /medicos` → listar médicos  
- `GET /medicos/{id}` → buscar médico por ID  
- `PUT /medicos/` → atualizar médico  
- `DELETE /medicos/{id}` → deletar médico  
- `POST /pacientes` → cadastrar paciente  
- `POST /agendamentos` → criar agendamento  
- `POST /agenda` → criar agenda de horários  

---

## 🧪 Testes
O projeto **ainda não possui testes automatizados**.

---

## 📌 Observações
- Projeto em desenvolvimento e voltado para estudos.  
- Futuramente terá:
  - Integração com Redis  
  - Consumo de APIs externas  
  - Interface web própria  
  - Mais funcionalidades ligadas à gestão de clínicas
