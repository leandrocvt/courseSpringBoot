# Vendas API 👩‍💻

Este projeto foi realizado durante o curso Spring Boot Expert da Udemy, ministrado pelo professor Dougllas Sousa. 
No qual foi possível adiquirir bastante conhecimento criando uma api de vendas.

---

# 🕹 Controllers

<h3>📌 User-controller</h3>
Este controlador é responsável por gerenciar as operações relacionadas aos usuários para ter acesso a API. Ele fornece endpoints para criar e autenticar um usuário gerando um token<br><br>

![user-controller](https://github.com/leandrocvt/assets/blob/main/vendas/usercontroller.png)

- **New _User_**:

```http
  POST api/users
```

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `admin` | `boolean` | Se o usuário é administrador ou não. Caso colocar false não terá acesso a API |
| `login` | `String` | Login do novo usuário. |
| `password` | `String` | Senha do novo usuário. |

```json
    {
      "admin": true,
      "login": "Leandro Cavalcanti",
      "password": "1234"
    }
```

- **Authenticate _User_**:

```http
  POST api/users/auth
```

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `login` | `String` | Login do usuário. |
| `password` | `String` | Senha do usuário. |

O json é igual ao de cima, apenas com os parametros: login e password.

<h3>📌 Client-controller</h3>
O Client-Controller é um componente do sistema responsável por gerenciar as requisições relacionadas aos clientes. Ele implementa uma série de endpoints que permitem criar, consultar, atualizar e deletar clientes da aplicação. <br><br>

![client-controller](https://github.com/leandrocvt/assets/blob/main/vendas/clientcontroller.png)

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

<h3>📌 Product-controller</h3>
O Product-Controller é um componente do sistema responsável por gerenciar as requisições relacionadas aos produtos. Ele implementa uma série de endpoints que permitem criar, consultar, atualizar e deletar produtos da aplicação. <br><br>

![query-client](https://github.com/leandrocvt/assets/blob/main/vendas/productcontroller.png)

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

<h3>📌 Order-controller</h3>
O Order-Controller é um componente do sistema responsável por gerenciar as requisições relacionadas aos pedidos. Ele implementa uma série de endpoints que permitem criar, consultar, atualizar o status do pedido na aplicação. <br><br>

![order-controller](https://github.com/leandrocvt/assets/blob/main/vendas/ordercontroller.png)

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