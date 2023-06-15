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

<h3>📌 Product-controller</h3>
O Product-Controller é um componente do sistema responsável por gerenciar as requisições relacionadas aos produtos. Ele implementa uma série de endpoints que permitem criar, consultar, atualizar e deletar produtos da aplicação. <br><br>

![product-controller](https://github.com/leandrocvt/assets/blob/main/vendas/productcontroller.png)

<h3>📌 Order-controller</h3>
O Order-Controller é um componente do sistema responsável por gerenciar as requisições relacionadas aos pedidos. Ele implementa uma série de endpoints que permitem criar, consultar, atualizar o status do pedido na aplicação. <br><br>

![order-controller](https://github.com/leandrocvt/assets/blob/main/vendas/ordercontroller.png)

[Rotas e Métodos](https://github.com/leandrocvt/courseSpringBoot/blob/main/DETAILS.md)

# 💻 Funcionalidades

- [x] adiciona usuário
- [x] autentica usuário cadastrado
- [x] adiciona um novo cliente
- [x] retorna todos os clientes
- [x] retorna cliente por id
- [x] retorna cliente por nome
- [x] retorna cliente por CPF
- [x] remove cliente por ID
- [x] atualiza cliente por ID
- [x] adiciona um novo produto
- [x] retorna todos os produtos
- [x] retorna produto por descrição (nome)
- [x] retorna produto por ID
- [x] remove produto por ID
- [x] atualiza produto por ID
- [x] adiciona um novo pedido
- [x] consulta pedido por ID
- [x] atualiza status do pedido

# ⚒️ Tecnologias

- Java
- Framework: Spring Boot
- Spring-web
- Spring Data JPA
- Spring Security
- H2 Database
- MySQL
- Validation
- Lombok
- JWT
- Swagger

# 👦 Autor

- Linkedin: https://www.linkedin.com/in/leandrocavalcantidev/
- Email: leandrocavalcanti499@gmail.com
