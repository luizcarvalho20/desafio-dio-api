# 🚀 Desafio DIO — API de Pagamentos com Design Patterns
Este repositório contém uma solução robusta para o Desafio de Projeto da DIO. O foco principal foi a aplicação de Design Patterns clássicos em um ecossistema Spring Boot, simulando um motor de pagamentos real com múltiplos métodos (PIX, Cartão e Boleto).

## 🧱 Arquitetura e Estrutura
O projeto utiliza uma estrutura multi-módulo para separar conceitos puramente teóricos de uma implementação de produção:

core-patterns: Implementações puras (Java SE) de Singleton, Strategy e Facade. Ideal para estudo de fundamentos.

payments-api: API REST funcional com persistência, validação e tratamento de exceções.

## 🧩 Design Patterns Aplicados (O Diferencial)
Abaixo, os padrões que elevam a manutenibilidade desta API:

1. Strategy Utilizado para isolar a lógica de processamento de cada método de pagamento.
Benefício: Facilidade para adicionar novos métodos (ex: Cripto) sem alterar o código existente (Open/Closed Principle).

2. Factory (Spring Managed)
A classe PaymentProcessorFactory resolve dinamicamente qual Strategy usar.

Benefício: Elimina blocos gigantes de if/else ou switch, tornando o código limpo e extensível.

3. Template Method
Implementado na BasePaymentProcessor. Define o esqueleto do algoritmo de pagamento (Validar -> Processar -> Notificar).

Benefício: Garante que todos os pagamentos sigam o mesmo fluxo de segurança e auditoria, evitando duplicação de código.

## 💳 Funcionalidades da API
Recurso	Método	Endpoint	Descrição
Criar Pagamento	POST	/api/v1/payments	Inicia um novo fluxo de pagamento.
Consultar	GET	/api/v1/payments/{id}	Retorna os detalhes e o status atual.
Confirmar	POST	/api/v1/payments/{id}/confirm	Finaliza pagamentos pendentes (Card/Boleto).

Exportar para as Planilhas

## 🛠️ Tecnologias e Boas Práticas
Tratamento de Erros: @RestControllerAdvice para respostas padronizadas em JSON.

Imutabilidade: Uso de Records para DTOs e Value Objects.

Persistência: Spring Data JPA com banco H2 (Console disponível em /h2).

Clean Code: Nomes de métodos semânticos e responsabilidade única.

## 🧪 Como Testar
Certifique-se de ter o JDK 17 instalado.

Clone o repositório e execute: mvn clean compile.

Inicie a aplicação via sua IDE ou terminal: mvn spring-boot:run.

Importe a collection do Postman disponível na pasta /evidencias-postman.

Autor: [Luiz Carvalho](https://github.com/luizcarvalho20)
