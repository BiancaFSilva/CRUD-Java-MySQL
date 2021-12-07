# Projeto em JAVA com acesso a uma base de dados MySQL
Aplicação CRUD desenvolvida para simular um sistema de controle de Ordens de Serviço com emissão e acesso aos relatórios das ordens geradas e implementação de um sistema de login com gerenciamento e verificação de nível de usuário 

### CRUD 
É um acrônimo para "Create, Read, Update and Delete" que representa as quatro operações básicas (criação, consulta, atualização e destruição de dados) utilizadas em bases de dados relacionais fornecidas aos utilizadores do sistema.

```sql
INSERT INTO table (column, column1) VALUES ('', '');
SELECT * FROM table;
UPDATE table SET column = '' WHERE (condition);
DELETE FROM table WHERE (condition);
```

### DER - Diagrama Entidade Relacionamento
![DER do Banco de Dados](https://user-images.githubusercontent.com/60801421/141180225-51fd84e3-3cc9-44d6-8261-bb39044275a2.png)

### TECNOLOGIAS
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white)
![MySQL](https://camo.githubusercontent.com/b46e59b09c063a31380646688a68018381767a7a206547c93f896df4643671e9/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f6d7973716c2d2532333030303030662e7376673f7374796c653d666f722d7468652d6261646765266c6f676f3d6d7973716c266c6f676f436f6c6f723d7768697465) <br>
Abaixo estão listadas os programas utilizados para a realização e desenvolvimento do projeto e as bibliotecas complementares a estes:

| Programas                                         | Bibliotecas                                                                       |
|---------------------------------------------------|:---------------------------------------------------------------------------------:|
| Apache Netbeans IDE 12.4 <br> Xampp (phpMyAdmin)  | JDK 16 <br> mysql-connector-java-8.0.26 <br> protobuf-java-3.11.4 <br> rs2xml     |

### SISTEMA
Todas as telas do possuem as funcionalidades das operações do CRUD. A partir da tela OS, foram incluídas algumas funcionalidades como por exemplo a desabilitação e a habilitação de alguns botões e a pesquisa avançada por registros a partir de um caracter digitado.

<p align="center"> Login <br> <img src="https://user-images.githubusercontent.com/60801421/144069040-575a317f-de72-48b9-bfd9-4c952bcdde37.png"></img> </p>
<p align="center"> Tela Principal <br> <img src="https://user-images.githubusercontent.com/60801421/144068562-e1cbdbd4-5341-4273-a2d0-2cff047a6ddc.png"></img> </p>
<div class="row">
  <p align="center"> 
    Formulário de Clientes <br> 
    <img width="50%" src="https://user-images.githubusercontent.com/60801421/144070143-98b91376-6bfb-4924-9b60-4207c2713d91.png"></img> 
  </p>
  <p align="center"> 
    Formulário de Ordens de Serviço <br> 
    <img width="50%" src="https://user-images.githubusercontent.com/60801421/144070537-b9ce8aa4-e9dd-4053-bbda-23d1d8b016a0.png"></img> <br>
    <img width="50%" src="https://user-images.githubusercontent.com/60801421/144070939-aee5b7e9-85c9-4cb1-b961-c084b88ce3a3.png"></img>
  </p>
  <p align="center"> 
    Formulário de Usuários <br>
    <img width="50%" src="https://user-images.githubusercontent.com/60801421/144069897-42db6371-1915-4df0-9a59-1498536d190a.png"></img>
  </p>
</div>
<p align="center"> Sobre <br> <img src="https://user-images.githubusercontent.com/60801421/144068755-a2903061-6566-44d3-8fbf-4d1089797783.png"></img> </p>
<p align="center"> Sair <br> <img src="https://user-images.githubusercontent.com/60801421/144068848-866da3d9-4288-4c22-9ce1-51db7abf4af2.png"></img> </p>

---
<p align="center"> @BiancaFSilva 2021 </p>
