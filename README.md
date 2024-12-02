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


| Método | Nome do endpoint | route | Body Request | Body Response | Path Variable
|-----------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------| -----------------------------------------------------------------------------------------------------------------| -----------------------------------------------------------------------------------------------------------------|
| POST | savePagamento |  | application/json | application/json | |
| GET | getPagePagamentos |  |  |  application/json | |
| GET | getPagamento | |  | application/json | ```{id}``` |
| PUT | aprovaPagamento |```/confirmar``` || application/json |```{id}``` |


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






