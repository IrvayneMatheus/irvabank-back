# IrvaBack - Aplicação Java com Spring Boot
Bem-vindo ao IrvaBack! Este é um projeto Java com Spring Boot que oferece funcionalidades baseadas em API. Abaixo estão informações importantes sobre a configuração e utilização do projeto.

## Dependências
O projeto utiliza as seguintes dependências:

Spring Boot Starter Data JPA: Suporte ao acesso a dados usando o Hibernate.
H2 Database: Um banco de dados em memória para desenvolvimento e testes.
Spring Boot Starter Validation: Suporte à validação de dados.
Spring Boot Starter Web: Starter para criar aplicativos da web com Spring MVC.
Lombok: Biblioteca para reduzir o código boilerplate em classes Java.
Spring Boot Starter Test: Starter para testes em projetos Spring Boot.
Springdoc OpenAPI: Geração automática de documentação Swagger para APIs Spring Boot.
Acesso ao Banco de Dados
Após executar a aplicação, você pode acessar o console H2 Database em http://localhost:8080/h2-console/. As configurações do banco podem ser encontradas no arquivo application.properties e podem ser editadas por meio das variáveis de ambiente. Exemplo:

properties
```sh
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=password
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.h2.console.enabled=true
```
Documentação Swagger (Springdoc OpenAPI)
A documentação Swagger está disponível em http://localhost:8080/swagger-ui/index.html após a execução da aplicação.

Execução do Projeto
Para executar o projeto, utilize sua IDE favorita ou execute o seguinte comando na linha de comando:

bash
```sh
./mvnw spring-boot:run
```
Após a inicialização, a aplicação estará disponível em http://localhost:8080/.

Nota: Certifique-se de ajustar as configurações conforme necessário, especialmente em um ambiente de produção. Consulte a documentação oficial do Spring Boot para mais detalhes sobre implantação e configuração avançada.