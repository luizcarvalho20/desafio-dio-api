# 💳 Payment API — Motor de Pagamentos com Spring Boot

Este repositório contém uma **API REST de Pagamentos**, desenvolvida em Java com Spring Boot, que simula um **motor de pagamentos real**, suportando múltiplos métodos (PIX, Cartão e Boleto).

O projeto tem como foco a aplicação prática de **boas práticas de engenharia de software**, **Design Patterns clássicos** e **organização arquitetural**, buscando se aproximar de cenários encontrados em ambientes de produção.

---

## 🧱 Arquitetura e Estrutura do Projeto

A solução foi organizada em uma **estrutura multi-módulo**, separando conceitos fundamentais de uma aplicação funcional:

- **core-patterns**  
  Módulo com implementações puras em Java (Java SE) de Design Patterns clássicos.  
  Utilizado como base conceitual e reutilizável.

- **payments-api**  
  API REST funcional desenvolvida com Spring Boot, contendo:
  - Persistência de dados
  - Validação de regras de negócio
  - Tratamento centralizado de exceções
  - Exposição de endpoints REST

Essa separação melhora a **manutenibilidade**, a **legibilidade** e facilita a evolução do sistema.

---

## 🧩 Design Patterns Aplicados (Diferencial do Projeto)

### 🔹 Strategy
Utilizado para encapsular a lógica específica de cada método de pagamento (PIX, Cartão e Boleto).

**Benefícios:**
- Elimina condicionais complexos (`if/else`, `switch`)
- Facilita a adição de novos métodos de pagamento
- Atende ao **Princípio do Aberto/Fechado (OCP)**

---

### 🔹 Factory (Gerenciada pelo Spring)
A classe `PaymentProcessorFactory` é responsável por resolver dinamicamente qual `Strategy` deve ser utilizada, com base no tipo de pagamento.

**Benefícios:**
- Centraliza a lógica de seleção
- Reduz acoplamento entre camadas
- Mantém o código limpo e extensível

---

### 🔹 Template Method
Validar → Processar → Notificar


**Benefícios:**
- Garante consistência no fluxo de pagamento
- Evita duplicação de código
- Facilita auditoria e manutenção

---

## 💳 Funcionalidades da API

| Recurso | Método | Endpoint | Descrição |
|-------|--------|----------|----------|
| Criar Pagamento | POST | `/api/v1/payments` | Inicia um novo fluxo de pagamento |
| Consultar Pagamento | GET | `/api/v1/payments/{id}` | Retorna detalhes e status atual |
| Confirmar Pagamento | POST | `/api/v1/payments/{id}/confirm` | Confirma pagamentos pendentes (Cartão/Boleto) |

---

## 🧪 Test Strategy

A estratégia de testes foi pensada para garantir **confiabilidade do fluxo de pagamento** e **segurança das regras de negócio**, equilibrando testes rápidos e testes mais próximos do uso real da API.

### 🔹 Testes Unitários
- Focados na **camada de serviço**
- Validação de regras de negócio
- Uso de **JUnit 5** e **Mockito**
- Simulação de dependências para garantir isolamento da lógica

**Objetivo:**  
Garantir que cada regra de negócio funcione corretamente de forma independente.

---

### 🔹 Testes de Controller (API)
- Testes dos endpoints REST utilizando **MockMvc**
- Validação de:
  - Códigos HTTP
  - Estrutura das respostas
  - Cenários de erro e sucesso

**Objetivo:**  
Garantir que a API se comporte corretamente do ponto de vista do consumidor.

---

### 🔹 Testes Manuais (Complementares)
- Collection do **Postman** disponível na pasta `/evidencias-postman`
- Útil para validação exploratória e demonstração funcional da API

---

## 📑 Documentação da API — Swagger / OpenAPI

A API é documentada utilizando **OpenAPI (Swagger)**, permitindo a visualização e o teste interativo dos endpoints diretamente pelo navegador.

### 📍 Acesso à documentação
Após iniciar a aplicação, a documentação pode ser acessada em:
```
http://localhost:8080/swagger-ui.html
```

### O que a documentação inclui
- Lista completa de endpoints
- Estrutura de requests e responses
- Exemplos de payload
- Descrição de códigos de erro
- Tipos de pagamento suportados

**Benefícios:**
- Facilita testes manuais
- Melhora a experiência do desenvolvedor
- Reduz dependência de documentação externa

---

## 🛠️ Tecnologias e Boas Práticas Utilizadas

- **Java 17**
- **Spring Boot**
- **Spring Data JPA**
- **Banco H2** (com console disponível em `/h2`)
- **Records** para DTOs e Value Objects (imutabilidade)
- **@RestControllerAdvice** para tratamento padronizado de erros
- **Clean Code**
  - Responsabilidade única
  - Métodos semânticos
  - Código legível e organizado

---

## 🧪 Como Executar a Aplicação

### Pré-requisitos
- Java 17+
- Maven

### Passos
```
# Clonar o repositório
git clone https://github.com/luizcarvalho20/payment-api.git

# Compilar o projeto
mvn clean compile

# Executar a aplicação
mvn spring-boot:run
```
## 📌 Objetivo do Projeto

Este projeto foi desenvolvido com foco em:

Consolidar conhecimentos em Java e Spring Boot

Aplicar Design Patterns em um cenário realista

Demonstrar boas práticas de testes e documentação

Servir como projeto de portfólio para vagas de Backend Java Júnior e QA Júnior

👤 Autor

**Luiz Felipe Carvalho**
📍 Ouro Branco – MG
🔗 GitHub: https://github.com/luizcarvalho20

🔗 LinkedIn: https://www.linkedin.com/in/luizcarvalho20
Implementado na classe base `BasePaymentProcessor`, definindo o fluxo padrão de processamento de um pagamento:

