# language: pt

Funcionalidade: Pesquisar livros na biblioteca da UDESC

  Contexto:
    Dado a inicialização da biblioteca
    E ela possui mais de 0 livros

  Cenario: Remover um livro
    Dado a inicialização da biblioteca
    E ela possui mais de 0 livros
    Quando eu removo um livro
    Entao eu encontro o livro adicionado

  Cenario: Pesquisa de um livro por titulo
    Dado a inicialização da biblioteca
    E ela possui mais de 0 livros
    Quando Eu pesquiso o livro "O Cortiço"
    Entao eu encontro o livro

  Cenario: Contagem de quantidade de livros por genero
    Dado a inicialização da biblioteca
    E ela possui mais de 0 livros
    Quando eu conto a quantidade de livros por genero
    Entao eu tenho 5 livros de ROMANCE
    Entao eu tenho 3 livros de DRAMA
    Entao eu tenho 2 livros de FICTION
    Mas eu nao encontro nenhum outro genero

  Esquema do Cenario: Contagem de quantidade de livros por genero
    Dado a inicialização da biblioteca
    E ela possui mais de 0 livros
    Quando eu conto a quantidade de livros por genero
    Entao eu tenho <quantidade> livros de <genero>
    Mas eu nao encontro nenhum outro genero
    Exemplos:
      | quantidade  | genero |
      | 5  | ROMANCE |
      | 3  | DRAMA |
      | 2  | FICTION |

  Cenario: Adicionar um livro
    Dado a seguinte tabela de livros a serem adicionados:
      | title | numberOfPages | genre | publicationDate | authors |
      | O pequeno príncipe | 230 | FANTASY | 1943       | Antoine de Saint-Exupéry |
    Quando Eu pesquiso o livro "O pequeno príncipe"
    Entao eu encontro o livro