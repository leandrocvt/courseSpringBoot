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

![client-controller](https://github.com/leandrocvt/assets/blob/main/vendas/usercontroller.png)

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
      "name": "Leandro Cavalcanti",
      "cpf": "28976408047",
    }
```

- **Find by id _Client_**:

```http
  GET api/clients/{id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `Integer` | O ID do cliente que você busca. |

- **Find _Client_**:

```http
  GET api/clients
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `Integer` | O ID do cliente que você busca. |