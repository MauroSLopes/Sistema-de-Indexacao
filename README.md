# SISTEMA DE INDEXAÇÃO ALFABÉTICA COM ÁRVORES E ESTRUTURAS LINEARES

---

## Descrição do problema:

A sua equipe foi contratada para desenvolver um módulo de indexação de um sistema de
busca. **O sistema deve processar uma lista de nomes e organizá-los alfabeticamente com
base na sua letra inicial**

A arquitetura da solução deve ser estruturada em dois níveis:
1. Nível Macro (Árvore Binária): Cada nó da árvore binária representará uma letra do
   alfabeto (ex: 'A', 'B', 'C'). A árvore será a estrutura principal de índice.
2. Nível Micro (Estrutura Linear): Dentro de cada nó da árvore, haverá uma estrutura
   de dados linear responsável por armazenar todos os nomes que começam com a
   letra correspondente àquele nó.

---

## Entregáveis e Relatório Técnico

### Sessões

#### 1. [Arvore Binária](./src/Binaria)
#### 2. [Lista Encadeada](./src/ListaEncadeada)

### Explicações

- Qual estrutura linear foi escolhida para compor os nós da árvore?

**R:** Lista encadeada.

- Por que essa estrutura é a mais eficiente/adequada considerando que o
  ambiente possui muitas inserções? (Analise a complexidade de tempo de
  inserção no pior/melhor caso.

**R:** Foi escolhido por sua facilidade de codificação e por ter tempo de inserção, no seu pior caso, 0(1).
Isso se deve pela forma em como são inseridos elementos na estrutura de dados, tendo em vista que, para inserir um novo elemento
é necessário apenas:

1. Criar o novo nó;
2. Caso a lista esteja vazia ele se torna o início, caso não define ele como incio da lista;
3. Fazer ele apontar para o antigo início da lista;

```java
public void inserir(String valor) {
    No novo = new No();
    novo.valor = valor;
    if (inicio == null) {
        inicio = novo;
        return;
    }

    novo.prox = inicio;
    inicio = novo;
}
```