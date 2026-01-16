## 💳 Payment API — Motor de Pagamentos com Spring Boot

Este repositório contém uma API REST de Pagamentos, desenvolvida em Java com Spring Boot, que simula um motor de pagamentos real, suportando múltiplos métodos (PIX, Cartão e Boleto).

O projeto tem como foco a aplicação prática de boas práticas de engenharia de software, Design Patterns clássicos e organização arquitetural, buscando se aproximar de cenários encontrados em ambientes de produção.

## 🧱 Arquitetura e Estrutura do Projeto

A solução foi organizada em uma estrutura multi-módulo, separando conceitos fundamentais de uma aplicação funcional:

core-patterns
Módulo com implementações puras em Java (Java SE) de Design Patterns clássicos.
Utilizado como base conceitual e reutilizável.

payments-api
API REST funcional desenvolvida com Spring Boot, contendo:

Persistência de dados

Validação de regras de negócio

Tratamento centralizado de exceções

Exposição de endpoints REST

Essa separação melhora a manutenibilidade, a legibilidade e facilita a evolução do sistema.

## 🧩 Design Patterns Aplicados (Diferencial do Projeto)
🔹 Strategy

Utilizado para encapsular a lógica específica de cada método de pagamento (PIX, Cartão e Boleto).

Benefícios:

Elimina condicionais complexos (if/else, switch)

Facilita a adição de novos métodos de pagamento

Atende ao Princípio do Aberto/Fechado (OCP)

🔹 Factory (Gerenciada pelo Spring)

A classe PaymentProcessorFactory é responsável por resolver dinamicamente qual Strategy deve ser utilizada, com base no tipo de pagamento.

Benefícios:

Centraliza a lógica de seleção

Reduz acoplamento entre camadas

Mantém o código limpo e extensível

🔹 Template Method

Implementado na classe base BasePaymentProcessor, definindo o fluxo padrão de processamento de um pagamento:

Validar → Processar → Notificar


Benefícios:

Garante consistência no fluxo de pagamento

Evita duplicação de código

Facilita auditoria e manutenção

## 💳 Funcionalidades da API
Recurso	Método	Endpoint	Descrição
Criar Pagamento	POST	/api/v1/payments	Inicia um novo fluxo de pagamento
Consultar Pagamento	GET	/api/v1/payments/{id}	Retorna detalhes e status atual
Confirmar Pagamento	POST	/api/v1/payments/{id}/confirm	Confirma pagamentos pendentes (Cartão/Boleto)
## 🛠️ Tecnologias e Boas Práticas Utilizadas

Java 17

Spring Boot

Spring Data JPA

Banco H2 (com console disponível em /h2)

Records para DTOs e Value Objects (imutabilidade)

@RestControllerAdvice para tratamento padronizado de erros

Clean Code

Responsabilidade única

Métodos semânticos

Código legível e organizado

## 🧪 Como Executar e Testar a Aplicação
Pré-requisitos

Java 17+

Maven

Passos
```
# Clonar o repositório
git clone https://github.com/luizcarvalho20/payment-api.git

# Compilar o projeto
mvn clean compile

# Executar a aplicação
mvn spring-boot:run
```

Testes Manuais

Uma collection do Postman está disponível na pasta /evidencias-postman

O console do banco H2 pode ser acessado em:
```
http://localhost:8080/h2
```
## 📌 Objetivo do Projeto

Este projeto foi desenvolvido com foco em:

Consolidar conhecimentos em Java e Spring Boot

Aplicar Design Patterns em um cenário realista

Demonstrar boas práticas de arquitetura e código limpo

Servir como projeto de portfólio para oportunidades em Backend Java e Qualidade de Software

## 👤 Autor

**Luiz Felipe Carvalho**
📍 Ouro Branco – MG
🔗 GitHub: https://github.com/luizcarvalho20

🔗 LinkedIn: https://www.linkedin.com/in/luizcarvalho20
