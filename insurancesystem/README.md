
# Documentação do Projeto - Insurance System

## Visão Geral
Este projeto é uma aplicação Java baseada em Spring Framework (versão 3.1.5) que segue a arquitetura de Domain-Driven Design (DDD). Ele é projetado para fornecer cálculos de um valor de seguro com base em diversas regras de negócio.

## Regras de Negócio
O orçamento do seguro deve ser calculado com base em algumas premissas, estas premissas serão listadas a seguir:

* O valor base de cálculo do orçamento é de 6% com base no valor da tabela FIPE do veículo.
* Quanto maior o risco maior será o valor do seguro, e para cada item de risco mapeado, 2% a mais será acrescentado na base de cálculo. São estes os riscos que devem ser mapeados.
## Riscos
Os riscos a serem considerados são:

* O motorista principal se encontra na faixa etária de 18 a 25 anos.
* O motorista possui sinistro em seu nome.
* O veículo ao qual será segurado possui sinistro.

## Estrutura do Projeto
O projeto é organizado em vários pacotes e componentes:

### `controller`
O pacote `controller` contém classes que atuam como controladores RESTful, lidando com as solicitações HTTP e a interação com a camada de serviço.

### `service`
O pacote `service` é onde a lógica de negócios principal do projeto reside. Ele contém serviços que orquestram a funcionalidade, aplicando regras de negócios e interagindo com a camada de domínio.

### `repository`
O pacote `repository` é responsável pela comunicação com o banco de dados. Ele contém interfaces e implementações de repositórios que permitem a persistência e recuperação de dados.

### `domain`
O pacote `domain` é onde as entidades do domínio são definidas. As entidades representam os objetos principais do domínio de negócios e encapsulam o estado e o comportamento relacionados a esses objetos.

## Requisitos de Pré-requisito
Para executar este projeto, você precisará das seguintes ferramentas e tecnologias:

- Java 20
- Spring Framework 3.1.5
- Dependencias do build.gradle

## Instruções de Configuração

1. Clone o repositório: `git clone https://github.com/seu-usuario/seu-projeto.git`
2. Acesse o diretório: `cd seu-projeto`
3. Certifique-se de que o [Gradle](https://gradle.org/) esteja instalado em seu sistema. Se você não tiver o Gradle instalado, siga as etapas abaixo para configurar o projeto:

### Configurando o Projeto com o Gradle

1. Faça o download e instale o Gradle em seu sistema. Você pode encontrar instruções de instalação [aqui](https://gradle.org/install/).
2. Após a instalação do Gradle, certifique-se de que o comando `gradle` está disponível no seu terminal ou prompt de comando.
3. Volte ao diretório do projeto.

Agora você pode usar o Gradle para compilar e construir o projeto. Certifique-se de que as dependências do projeto sejam resolvidas executando:



## Instruções de Compilação e Execução

Execute o projeto com o seguinte comando:

```bash
./gradlew bootRun
```

O projeto estará disponível em `http://localhost:8080` por padrão.

