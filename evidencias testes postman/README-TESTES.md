# 📑 Evidências de Testes da API

Este diretório contém as evidências dos testes manuais realizados para validar as regras de negócio e a integração com o banco de dados.

## ✅ Testes de Sucesso

### 1. Criação de Pagamento via PIX
* **Cenário:** Solicitação de pagamento utilizando o método PIX.
* **Resultado:** O sistema identificou a estratégia PIX, processou e confirmou o pagamento instantaneamente.
* **Evidência:** [01-criacao-pix.png](https://github.com/luizcarvalho20/desafio-dio-api/blob/master/evidencias%20testes%20postman/Criar%20um%20Novo%20Pagamento%20(PIX).png)

### 2. Fluxo de Cartão de Crédito (Processamento e Confirmação)
* **Cenário:** Criação de pagamento via CARD e posterior confirmação via endpoint de confirmação.
* **Resultado:** O status transicionou de `PROCESSING` para `CONFIRMED` após o envio do `confirmationCode`.
* **Evidência:** [02-confirmacao-cartao.png](https://github.com/luizcarvalho20/desafio-dio-api/blob/master/evidencias%20testes%20postman/criar%20um%20pagamento%20com%20cartão%20(simulação).png)

## 🗄️ Persistência de Dados

### 1. Validação no Banco H2
* **Cenário:** Consulta direta às tabelas do banco de dados em memória.
* **Resultado:** Os registros foram persistidos corretamente com UUIDs e timestamps.
* **Evidência:** [03-h2-database.png](https://github.com/luizcarvalho20/desafio-dio-api/blob/master/evidencias%20testes%20postman/6de8f73c-bcea-4af6-b139-58bd450d26dd.png)
