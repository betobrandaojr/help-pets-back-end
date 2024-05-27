
# 🐾 Help Pets - Gestão de Abrigos para Animais

Este projeto é um software desenvolvido para a gestão dos animais nos abrigos criados em RS-Brasil no mês de maio de 2024, devido às grandes enchentes no estado. O objetivo é ajudar na gestão, identificação e cuidados dos animais nesses abrigos.

## 🚀 Tecnologias Utilizadas

- **Java 21**
- **Spring Boot 3.3.0**

## 📦 Estrutura do Projeto

O projeto possui uma pasta `docker` na raiz, onde você pode localizar o arquivo `docker-compose.yml`.

## 🐳 Executando com Docker

Para executar o container, você precisa ter o Docker Desktop instalado em seu PC. Siga os passos abaixo:

1. [Baixe e instale o Docker Desktop](https://www.docker.com/products/docker-desktop).
2. Navegue até a pasta `docker`.
3. Execute o comando:

   ```sh
   docker-compose up -d
   ```

## 💻 Executando a Aplicação

Para executar a aplicação localmente, siga os passos abaixo:

1. Clone o repositório:

   ```sh
   git clone [URL_DO_REPOSITORIO]
   ```

2. Navegue até o diretório do projeto e execute o comando para baixar todas as dependências:

   ```sh
   mvn clean install -DskipTests
   ```

3. Execute o projeto conforme a IDE de desenvolvimento que está usando.

## 📖 Documentação

Após executar a aplicação, você pode acessar a documentação Swagger pelo endereço:

[Swagger UI](http://localhost:8090/help-pets/swagger-ui/index.html#/)

![image](https://github.com/betobrandaojr/help-pets/assets/59041231/2cbc5f98-2c54-4d68-92ed-78113c9f1bb2)


## 🌟 Contribuição

Este projeto é uma ferramenta open source. Quem tiver interesse em ajudar, fique à vontade para contribuir!

## 📅 Histórico

Este projeto foi criado em maio de 2024 para ajudar na gestão dos animais afetados pelas enchentes no RS-Brasil.

---

Feito com ❤️ para ajudar os animais em necessidade.
