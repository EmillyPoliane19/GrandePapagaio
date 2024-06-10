**Projeto de uma rede social simples que utilize os paradigmas orietados a objetos**
**Descrição da atividade:**

Você foi contratado(a) para desenvolver o software da rede social GrandePapagaio. Essa rede social tem as seguintes funcionalidades:
Caso de uso 1: Usuário pode postar uma frase em seu mural;
Caso de uso 2: Usuário pode ler o mural de outro usuário;
Caso de uso 3: Usuário pode seguir outros usuários. 

Quando um usuário Alice é seguido por outro usuário Bob (Bob segue Alice), então Bob vê em seu mural os posts de Alice.
A primeira versão seria uma interface de linha de comando que permite realizar três operações:

Postar

> Daniel -> Java 22 é massa
Post realizado com sucesso no mural de Daniel
> Raquel -> Streams é a melhor novidade do Java
Post realizado com sucesso no mural de Raquel

Leitura

> mural Daniel
Daniel --> Java 19 é massa (06/04/2023 02:14)

> mural Raquel
Raquel --> Streams é a melhor novidade do Java (07/10/2023 12:15)


Seguir

> Daniel segue Raquel
> mural Daniel
Daniel --> Java 10 é massa (06/04/2023 02:14)
Raquel --> Streams é a melhor novidade do Java (07/10/2023 12:15)

Mais detalhes

Os seguintes comandos são válidos:

Postar: 
<nome do usuario> -> <messagem>

Ler: 
mural <nome do usuário>

Seguir: 
<nome do usuário> segue <outro usuário>

Assuma que o nome do usuário é chave única, então um novo usuário só pode ser adicionado à rede GrandePapagaio se tiver um nome que não foi inserido ainda.
Assuma que o usuário vai sempre digitar comandos válidos. Fique apenas nos cenários corretos. Lance exceções apenas se aparecerem nos comandos nomes de usuários que não existem.
Não se preocupe em fazer o software funcionar em rede. Por enquanto vai rodar em memória (também não precisa usar arquivos), então assuma que todos os usuários usarão o mesmo terminal.
Usuários que não existem devem ser criados ao postar a sua primeira mensagem (a aplicação não começa com uma lista predefinida de usuários).
