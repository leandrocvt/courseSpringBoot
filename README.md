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
| `login` | `string` | Login do novo usuário. |
| `password` | `string` | Senha do novo usuário. |

- **Authenticate _User_**:

```http
  POST api/users/auth
```

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `login` | `string` | Login do usuário. |
| `password` | `string` | Senha do usuário. |

<h3>📌 Client-controller</h3>
O Client-Controller é um componente do sistema responsável por gerenciar as requisições relacionadas aos clientes. Ele implementa uma série de endpoints que permitem criar, consultar, atualizar e deletar clientes da aplicação. <br><br>