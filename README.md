# Table of Contents
1. [Spring Framework 6: Beginner to Guru](#spring-framework-6-beginner-to-guru)
2. [Dependency Injection](#dependency-injection)


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

## SOLID
SOLID é um acrônimo para os cinco princípios de design de classe orientada a objetos. 

SOLID significa:

- S - Princípio da responsabilidade única
- O - Princípio do aberto / fechado
- L - Princípio da substituição de Liskov
- I - Princípio da segregação da interface
- D - Princípio da inversão de dependência

### Princípio da responsabilidade única
O princípio da responsabilidade única afirma que uma classe deve ter apenas uma única responsabilidade.

### Princípio do aberto / fechado
O princípio do aberto / fechado afirma que uma classe deve ser aberta para extensão, mas fechada para modificação. Isso significa que você pode estender uma classe adicionando novos comportamentos, mas não deve modificar o comportamento existente.

### Princípio da substituição de Liskov
O princípio da substituição de Liskov afirma que você deve ser capaz de substituir uma classe base por uma classe derivada sem quebrar o comportamento do programa.

### Princípio da segregação da interface
O princípio da segregação da interface afirma que você deve dividir uma interface grande em interfaces menores e mais específicas, para que as classes que a implementam não precisem implementar métodos que não usam.

### Princípio da inversão de dependência
O princípio da inversão de dependência afirma que você deve depender de abstrações e não de implementações. Isso significa que você deve usar interfaces em vez de classes concretas.

# Dependency Injection
A injeção de dependência é um padrão de design que é usado para injetar dependências em um objeto. A injeção de dependência permite que você injete dependências em um objeto em vez de criar o objeto dentro do objeto. Isso torna o código mais flexível e fácil de testar.

A injeção de dependência pode ser feita de três maneiras:

- Construtor
- Setter
- Método

## Construtor
A injeção de dependência por meio do construtor é a maneira preferida de injetar dependências em um objeto. A injeção de dependência por meio do construtor é feita passando as dependências como parâmetros para o construtor.

    public class BookService {

        private final BookRepository bookRepository;

        public BookService(BookRepository bookRepository) {
            this.bookRepository = bookRepository;
        }
    }

## Setter
A injeção de dependência por meio do setter é feita chamando o método setter do objeto e passando a dependência como um parâmetro.

    public class BookService {

        private BookRepository bookRepository;

        public void setBookRepository(BookRepository bookRepository) {
            this.bookRepository = bookRepository;
        }
    }

### @Autowired
A anotação @Autowired é usada para injetar dependências em um objeto. A anotação @Autowired pode ser usada para injetar dependências em um construtor, método setter ou campo.

### @Qualifier
A anotação @Qualifier é usada para especificar qual bean deve ser injetado quando há mais de um bean do mesmo tipo.

### @Primary
A anotação @Primary é usada para especificar qual bean deve ser injetado quando há mais de um bean do mesmo tipo.

### Profiles
Os perfis são usados para definir um conjunto de beans que devem ser carregados para um ambiente específico. Os perfis são definidos usando a anotação @Profile.

    @Configuration
    @Profile("dev")
    public class DevConfig {

    }

    @Configuration
    @Profile("prod")
    public class ProdConfig {

    }