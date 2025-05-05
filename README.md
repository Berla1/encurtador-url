# Encurtador de URL

Este projeto é um **encurtador de URLs** desenvolvido em **Java** com persistência em **MongoDB**. Ele permite criar links curtos temporários com expiração automática em **1 minuto**.

## 🔗 Funcionalidades

- Criar URLs curtas a partir de URLs longas
- Redirecionamento automático da URL curta para a URL original
- Expiração automática das URLs após 1 minuto
- Armazenamento e gerenciamento no MongoDB

## ⏳ Expiração

As URLs encurtadas têm **validade de 1 minuto** após sua criação. Após esse tempo, o redirecionamento deixa de funcionar.

## 🛠️ Tecnologias Utilizadas

- Java 17+
- Spring Boot
- MongoDB
- Maven

## 📦 Como rodar o projeto localmente

### Pré-requisitos

- Java 17 ou superior instalado
- MongoDB em execução localmente ou em um servidor acessível
- Maven instalado

### Passos

1. Clone o repositório:

```bash
git clone https://github.com/Berla1/encurtador-url.git
cd encurtador-url
```

2. Configure o `application.properties` com os dados de acesso ao MongoDB.

Exemplo (`src/main/resources/application.properties`):

```properties
spring.data.mongodb.uri=mongodb://localhost:27017/shortenurl
```

3. Rode o projeto com Maven:

```bash
./mvnw spring-boot:run
```


## 📌 Endpoints

- `POST /shorten-url` — Recebe uma URL longa no corpo da requisição e retorna a versão encurtada
- `GET /{codigo}` — Redireciona para a URL original associada ao código informado (se ainda estiver válida)

## 🧪 Exemplo de uso

### Requisição

```http
Content-Type: application/json

{
  "url": "https://www.example.com"
}
```

### Resposta

```json
{
    "url": "http://localhost:8080/TkizYkj"
}
```
