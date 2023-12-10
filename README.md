### Upload de arquivos com Spring Boot

<p align="center">
<img src="https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white" />
<img src="https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white" />
</p>
<br>

A aplicação roda no seguinte endereço `http://localhost:8080` e possui 3 endpoints simples. Para funcionar deve criar uma pasta chamada `uploads` no raiz do projeto.

O endpoint de envio de arquivos `/api/files/uploads`, utilizando o metódo **POST**. Usuário deve enviar um arquivo e enviar o prefixo **file**.

<img src="https://i.ibb.co/VDzW4XC/post-method.png" />

O endpoint de listagem de um arquivo baixados `/api/files/download/nome-do-arquivo.formato-do-arquivo`, utilizando o metódo **GET**.

Lembre-se de colocar o nome do arquivo e o formato no final do endpoint, atualmente a Api aceita arquivos de até *20MB*.

<img src="https://i.ibb.co/xDzwTg4/get-file.png" />

O endpoint de listagem de todos os arquivos baixados `/api/files/list`, utilizando o metódo **GET**. 

<img src="https://i.ibb.co/8Xf0nNV/get-all-method.png" />
</br>

> Como testar o projeto na sua máquina
- Clone o projeto com o comando `git clone https://github.com/black-adm/spring-boot-mongodb`.

- Instale as dependências do projeto com o **Maven** e inicie o projeto.

- Verifique se criou a pasta *uploads* na raiz do projeto.
