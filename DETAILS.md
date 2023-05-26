# 💻 Mais sobre o projeto / Rotas e Métodos



## 📍 Client

- **New _Client_**:

```http
  POST api/clients
```

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `name` | `String` | Nome do cliente |
| `cpf` | `String` | CPF do cliente. |


```json
    {
      "name": "Luciano Hulk",
      "cpf": "28976408047",
    }
```

- **Find by id _Client_**:

```http
  GET api/clients/${id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `Integer` | O ID do cliente que você quer buscar. |

- **Find _Client_**:

```http
  GET api/clients
```
 Query Params - Consulta por parâmetros. Caso queira consultar um cliente pelo nome ou CPF basta adicionar chave e valor conforme o exemplo a seguir: 

![query-client](https://github.com/leandrocvt/assets/blob/main/vendas/query-client.png)

- **Update _Client_**:

```http
  PUT api/clients/${id}
```

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `id`      | `Integer` | O ID do cliente que você quer alterar. |
| `name` | `String` | Nome do cliente atualizado |
| `cpf` | `String` | CPF do cliente atualizado. |

```json
    {
      "name": "Cristiano Ronaldo",
      "cpf": "58942695043",
    }
```

- **DELETE by id _Client_**:

```http
  DELETE api/clients/${id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `Integer` | O ID do cliente que você quer apagar. |

## 📍 Product

- **New _Product_**:

```http
  POST api/preoducts
```

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `description` | `String` | Nome do produto |
| `priceUnity` | `Double` | Preço unitário do produto. |


```json
    {
      "description": "Game",
      "priceUnity": 70.00
    }
```

- **Find by id _Product_**:

```http
  GET api/preoducts/${id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `Integer` | O ID do produto que você quer consultar. |

- **Find _Product_**:

```http
  GET api/products
```
 Query Params - Consulta por parâmetros. Caso queira consultar um produto pelo nome basta adicionar chave e valor conforme o exemplo a seguir: 

![query-product](https://github.com/leandrocvt/assets/blob/main/vendas/query-product.png)

- **Update _Product_**:

```http
  PUT api/products/${id}
```

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `id`      | `Integer` | O ID do produto que você quer alterar. |
| `description` | `String` | Nome do produto atualizado |
| `priceUnity` | `Double` | Preço unitário do produto atualizado. |

```json
    {
      "description": "Game - Good of War",
      "priceUnity": 150.00
    }
```

- **DELETE by id _Product_**:

```http
  DELETE api/products/${id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `Integer` | O ID do produto que você quer apagar. |


## 📍 Order

- **New _Order_**:

```http
  POST api/orders
```

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `client`      | `Integer` | O ID do cliente que está fazendo o pedido. |
| `total` | `String` | Total do pedido.  |
| `items` | `List` | Uma lista de items relacionados ao pedido. |
| `product` | `Integer` | O ID do produto. |
| `quantity` | `Integer` | Quantidade do produto. |

```json
    {
        "client": 1,
        "total": 300.00,
        "items": [
            {
                "product": 1,
                "quantity": 2
            }   
        ]
    }
```

- **Find by id _Order_**:

```http
  GET api/orders/${id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `Integer` | O ID do pedido que você quer consultar. |

- **Update order status _Order_**:

```http
  PATH api/orders/${id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `Integer` | O ID do pedido que você quer atualizar. |
| `newStatus` | `String` | Novo status do pedido |

```json
    {
        "newStatus": "CANCELED"
    }
```

[Voltar](https://github.com/leandrocvt/courseSpringBoot/tree/main)