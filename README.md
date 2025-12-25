🚀 Desafio DIO — API de Pagamentos com Design Patterns (Java & Spring Boot)

Este repositório contém a solução do Desafio de Projeto da DIO, desenvolvida com foco em boas práticas de arquitetura, organização de código, Design Patterns e implementação de uma API REST realista utilizando Java e Spring Boot.

O projeto foi estruturado para demonstrar tanto o conhecimento conceitual dos padrões de projeto quanto a aplicação prática em um cenário de negócio.

🎯 Objetivo do Projeto

Demonstrar domínio prático em:

Java moderno (Java 17)

Maven e projetos multi-módulo

Design Patterns (GoF)

Spring Boot

Arquitetura REST

Organização em camadas

Tratamento global de erros

Validação de dados

Testes manuais de API

Documentação técnica clara e objetiva

🧱 Estrutura do Repositório
Desafio-dio-api-java/
├── core-patterns/
│   └── Exemplos de Design Patterns em Java puro
├── payments-api/
│   └── API REST de pagamentos com Spring Boot
├── evidencias-postman/
│   └── Evidências e documentação dos testes
├── pom.xml
└── README.md

📦 Módulos do Projeto
🔹 core-patterns

Módulo dedicado ao estudo e implementação de Design Patterns clássicos (GoF) utilizando Java puro, sem frameworks.

Padrões implementados:

Singleton

Strategy

Facade

Cada padrão possui uma classe *Demo para execução direta e validação do comportamento no console.

🔹 payments-api

Módulo principal do projeto, contendo uma API REST de pagamentos, com regras de negócio reais, persistência em banco de dados e aplicação prática dos padrões de projeto.

🧠 Conhecimentos Técnicos Aplicados
✅ Java

Java 17

Programação Orientada a Objetos

Encapsulamento e imutabilidade

Uso de enum para regras de domínio

UUID como identificador único

✅ Maven

Projeto multi-módulo

Separação clara de responsabilidades

Gerenciamento de dependências

Build e empacotamento padronizados

✅ Spring Boot

Spring Boot 3.x

Inversão de Controle (IoC)

Injeção de Dependência

Component Scan

Configuração via application.yml

✅ API REST

Endpoints RESTful

Versionamento de API (/api/v1)

Uso correto de métodos HTTP:

POST

GET

DTOs para entrada e saída de dados

✅ Validação e Tratamento de Erros

Bean Validation (@Valid)

Validação de dados de entrada

Tratamento global de exceções com @RestControllerAdvice

Padronização de respostas de erro:

400 — Erro de validação

404 — Recurso não encontrado

422 — Erro de regra de negócio

500 — Erro interno

✅ Persistência

Spring Data JPA

H2 Database (em memória)

Entidades JPA (@Entity)

Repositórios com JpaRepository

Controle transacional com @Transactional

🧩 Design Patterns Aplicados na API
🔸 Strategy

Cada método de pagamento possui sua própria estratégia:

PixPaymentProcessor

CardPaymentProcessor

BoletoPaymentProcessor

Todas implementam a interface:

PaymentProcessor

🔸 Factory

A classe PaymentProcessorFactory é responsável por:

Registrar automaticamente os processadores

Retornar a estratégia correta com base no PaymentMethod

Eliminar condicionais (if / switch)

Centralizar a lógica de decisão

🔸 Template Method

A classe abstrata BasePaymentProcessor define o fluxo padrão:

Marcar pagamento como PROCESSING

Verificar fraude

Processar pagamento

Confirmar pagamento (quando aplicável)

Enviar recibo

Cada método de pagamento implementa apenas o comportamento específico.

💳 Funcionalidades da API

Criar pagamento (PIX, CARD, BOLETO)

Consultar pagamento por ID

Confirmar pagamento (necessário para CARD e BOLETO)

PIX é confirmado automaticamente no processamento

🔌 Endpoints Disponíveis
Criar pagamento
POST /api/v1/payments

{
  "method": "CARD",
  "amount": 99.90
}

Consultar pagamento
GET /api/v1/payments/{id}

Confirmar pagamento
POST /api/v1/payments/{id}/confirm

{
  "confirmationCode": "123456"
}

🗄️ Banco de Dados

H2 Database em memória

Ideal para desenvolvimento e testes

Dados são recriados a cada inicialização

Console H2 (se habilitado):

http://localhost:8080/h2

🧪 Testes

Todos os testes da API foram realizados manualmente utilizando Postman.

📁 A documentação completa dos testes está disponível em:

evidencias-postman/README-TESTES.md


Inclui:

Fluxo principal

Casos de erro

Validações

Evidências visuais

Collection do Postman

▶️ Como Executar
Pré-requisitos

Java 17

Maven

IntelliJ IDEA (recomendado)

Executar a aplicação

Rodar a classe:

PaymentsApiApplication


A API ficará disponível em:

http://localhost:8080

👤 Autor

Luiz Carvalho
Projeto desenvolvido durante o Bootcamp da DIO, com foco em aprendizado sólido, boas práticas e organização de código.
