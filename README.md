# Microsserviço de Pagamentos

API Rest responsável pelo gerenciamento do microsserviço de pagamentos da aplicação Sergipe-Food


## Informações Gerais

- Registra pagamentos escutando fila criada pelo microsserviço de pedidos ("pedido.registrado")
- Edita Status do pagamento e cria fila ("pagamento.concluido") que será escutada pelo microsserviços de pedidos


## Pagamentos

Recurso que registra o valor total do pedido e a confirmação do pagamento


### URL base para chamadas

```
http://localhost:8082/pagamentos-ms/pagamentos
```

### Endpoints

| Método | Nome do endpoint | Descrição |
|-----------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------|
| POST | savePagamento | Cria um novo pagamento a ser processado |
| GET | getPagePagamentos | Pesquisa por todos os pagamentos realizados | 
| GET | getPagamento | Consulta todas as informações de um pagamento através de um ```id``` | 
| PUT | aprovaPagamento | Acessado na rota ```/confirmar/```. Atualiza o status do pagamento para confirmado através de um ```ìd``` | 


### Body Content

```
Resquest
{
    "valor": Double,
    "pedidoId": Long
}
```

```
Response
{
    "id": Long
    "valor": Double,
    "status": ["CONFIRMADO", "CRIADO"],
    "pedidoId": Long
}
```






