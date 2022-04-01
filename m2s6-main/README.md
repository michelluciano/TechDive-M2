# Módulo 2 - semana 6:

#### HTTP:
  - [Apresentação](https://docs.google.com/presentation/d/17uViROVO2GkzrQDYR7W9_-NayeetKJA7ipMf-CVlwnk)
  - [Arquivos do projeto](src/main/java/dive/tech/projeto/aula1)

#### Servlets:
  - [Apresentação](https://docs.google.com/presentation/d/1fcKjKTDqt0UTdTcyIiw-xzZFbi5rSTZmPkh3NjiaRaU)
  - [Arquivos do projeto](src/main/java/dive/tech/projeto/aula2)

### MVC:
  - [Apresentação](https://docs.google.com/presentation/d/1tIvgsEc_xXK6nQCwUcCLtsJvlSEro_wdhI4_Q2v9rrY)
  - [Arquivos do projeto](src/main/java/dive/tech/projeto/aula3)

### Exercícios:
- [Onde colocar os exercícios](src/main/java/dive/tech/projeto/exercicios)

---

## Instalação

Para rodar o projeto, é necessário utilizar o servidor WildFly. 
Para isso, execute os passos abaixo:
- Acesse https://www.wildfly.org/downloads/ e baixe a última versão 
disponível indo no quadro da última versão (26.0.1.Final, no momento) 
e clicando em "zip" ao lado do texto "Jakarta EE 8 Full & Web Distribution":
![img.png](src/main/resources/wildfly-download.png)
- Após o download, extraia o servidor em uma pasta de sua escolha;
- No IntelliJ, clique em "Edit configurations" no canto superior direito, 
depois clique em "+" > "JBoss/WildFly server" > "Local";
- Na configuração que abrirá, ao lado de "Application server", clique em "Configure" para adicionarmos o novo servidor;
- Clique em "+" e busque pelo diretório onde você excluir o servidor. Se o diretório estiver correto, aparecerá a versão 26.0.1.Final abaixo da caixinha;
- Clique em OK duas vezes para fechar a configuração do novo servidor;
- Certifique-se de que o servidor selecionado em "Application server" seja o WildFly 26.0.1.Final;
- No final da tela, estará aparecendo um erro dizendo que nenhum artefado foi marcado para colocarmos no servidor. 
Clique em "Fix", escolha "projeto.war " e clique em "OK" para finalizar a configuração;
- Para testar se tudo funcionou corretamente, tente rodar o sistema clicando em "Run" ou "Debug".

Caso encontre algum problema ou dúvida durante a instalação ou utilização do projeto, entre em contato com o professor via Slack.