# Spring Framework 6: Beginner to Guru
Spring é um framework Java leve e abrangente, criado por Rod Johnson em 2003, que visa simplificar o desenvolvimento de aplicativos empresariais. O Spring Framework é um dos frameworks mais populares para o desenvolvimento de aplicativos Java EE. Devido à sua popularidade e facilidade de uso, o Spring Framework está sendo usado para criar aplicativos corporativos Java em grande escala.

## Dependencias
Dependencias utilizadas ate agora

- Spring Web
- Spring Data JPA
- H2 Database
- Thymeleaf

## JPA
Java Persistence API (JPA) é uma especificação Java que descreve uma interface comum para frameworks de persistência de dados. A JPA foi desenvolvida como parte da plataforma Java EE, mas pode ser usada em aplicativos Java SE também. A JPA é uma especificação e não uma implementação. Existem várias implementações de JPA, como Hibernate, EclipseLink, OpenJPA, etc.

## Domain
O domínio é a camada de negócios de um aplicativo. Ele contém as classes de negócios ou entidades que representam tabelas no banco de dados. As classes de domínio são geralmente anotadas com a anotação @Entity. As classes de domínio também podem conter métodos de negócios.

### @Entity
Anotação que indica que a classe é uma entidade. Uma entidade representa uma tabela no banco de dados.

### @Id
Anotação que indica que o atributo é uma chave primária.

### @GeneratedValue
Anotação que indica que o valor do atributo é gerado automaticamente.

### @Column
Anotação que indica que o atributo é uma coluna no banco de dados.

### @OneToMany
Anotação que indica que a relação entre duas entidades é de um para muitos.

### @ManyToOne
Anotação que indica que a relação entre duas entidades é de muitos para um.

### @ManyToMany
Anotação que indica que a relação entre duas entidades é de muitos para muitos.

### @JoinTable
Anotação que indica que a relação entre duas entidades é de muitos para muitos e que a tabela de junção deve ser usada para mapear a relação.

### @JoinColumn
Anotação que indica que a coluna de junção deve ser usada para mapear a relação.

## Repository
O repositório é uma camada de persistência de dados. Ele contém interfaces que permitem que você execute operações de banco de dados sem escrever código SQL. As interfaces do repositório são anotadas com a anotação @Repository.

## Service
A camada de serviço é uma camada intermediária entre a camada de apresentação e a camada de persistência de dados. Ele contém classes de serviço que contêm a lógica de negócios. As classes de serviço são anotadas com a anotação @Service.

## Controller
A camada de apresentação é a camada superior de um aplicativo. Ele contém classes de controlador que processam as solicitações HTTP. As classes de controlador são anotadas com a anotação @Controller.

### @RequestMapping
Anotação que mapeia uma solicitação HTTP para um método de controlador.

### Model
A classe Model é usada para passar dados do controlador para a visualização.

## Bootstrap
O Bootstrap é um mecanismo de inicialização que é executado quando o aplicativo é iniciado. Ele é usado para inicializar dados no banco de dados.

### CommandLineRunner
A interface CommandLineRunner é usada para executar o código de inicialização quando o aplicativo é iniciado.

## View
A camada de visualização é a camada inferior de um aplicativo. Ele contém arquivos de visualização que são usados para renderizar a resposta HTTP. Os arquivos de visualização são geralmente arquivos HTML, JSP, XML ou JSON.

Ela fica dentro da pasta resources/templates.

### Thymeleaf
Thymeleaf é um mecanismo de modelo Java que pode ser usado para renderizar arquivos de visualização. Ele pode ser usado para renderizar arquivos HTML, JSP, XML ou JSON. O Thymeleaf é um mecanismo de modelo baseado em servidor. Isso significa que os arquivos de visualização são renderizados no servidor e o HTML resultante é enviado para o navegador.

    <!DOCTYPE html>
    <html lang="en" xmlns:th="http://www.thymeleaf.org">
    <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Livros</title>
    </head>
    <body>

    <h1>Book List</h1>

    <table>
        <thead>
            <tr>
                <th>Id</th>
                <th>Title</th>
                <!--<th>Author</th>-->
                <th>Publisher</th>
                <th>Isbn</th>
            </tr>
        </thead>
        <tbody>
            <tr th:each="book : ${books}">
                <td th:text="${book.id}">Id</td>
                <td th:text="${book.name}">Title</td>
                <!--<td th:text="${book.authors}">Author</td>-->
                <td th:text="${book.publisher.publisherName}">Publisher</td>
                <td th:text="${book.isbn}">isbn</td>
            </tr>
        </tbody>
    </table>

    </body>
    </html>