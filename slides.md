---
marp: true
theme: default
paginate: true
backgroundColor: #1a1a2e
size: 16:9
style: |
  @import url('https://fonts.googleapis.com/css2?family=Inter:wght@400;600;700&family=JetBrains+Mono:wght@400;500&display=swap');

  section {
    background: linear-gradient(135deg, #1a1a2e 0%, #16213e 100%);
    color: #eee;
    font-family: 'Inter', -apple-system, BlinkMacSystemFont, 'Segoe UI', sans-serif;
    font-size: 24px;
    padding: 40px 60px;
    line-height: 1.5;
    border: 2px solid rgba(233, 69, 96, 0.3);
    border-radius: 12px;
    box-shadow:
      0 3px 6px rgba(0, 0, 0, 0.16),
      0 3px 6px rgba(0, 0, 0, 0.23),
      inset 0 1px 0 rgba(255, 255, 255, 0.05);
    margin: 10px;
  }

  h1 {
    color: #ffffff;
    font-size: 52px;
    font-weight: 700;
    border-bottom: 3px solid #e94560;
    padding-bottom: 12px;
    margin-bottom: 25px;
    letter-spacing: -1px;
    line-height: 1.1;
  }

  h2 {
    color: #f8f8f8;
    font-size: 42px;
    font-weight: 700;
    margin-top: 20px;
    margin-bottom: 18px;
    letter-spacing: -0.5px;
    line-height: 1.2;
  }

  h3 {
    color: #e94560;
    font-size: 36px;
    font-weight: 600;
    margin-bottom: 15px;
    line-height: 1.2;
  }

  strong {
    color: #f39c12;
    font-weight: 700;
  }

  code {
    background-color: #2d2d2d;
    color: #9cdcfe;
    padding: 3px 8px;
    border-radius: 4px;
    font-family: 'JetBrains Mono', 'Consolas', 'Monaco', monospace;
    font-size: 20px;
    font-weight: 500;
  }

  pre {
    background-color: #1e1e1e;
    border: 1px solid #3c3c3c;
    border-radius: 6px;
    padding: 20px;
    font-size: 19px;
    line-height: 1.5;
    box-shadow: 0 2px 8px rgba(0, 0, 0, 0.4);
    margin: 15px 0;
    position: relative;
  }

  pre::before {
    content: '';
    position: absolute;
    top: 0;
    left: 0;
    right: 0;
    height: 30px;
    background: linear-gradient(to bottom, #323233 0%, #1e1e1e 100%);
    border-radius: 6px 6px 0 0;
    border-bottom: 1px solid #3c3c3c;
  }

  pre code {
    background-color: transparent;
    border: none;
    padding: 0;
    padding-top: 35px;
    display: block;
    font-size: 19px;
    color: #d4d4d4;
  }

  table {
    border-collapse: collapse;
    border: 2px solid #e94560;
    border-radius: 6px;
    overflow: hidden;
    box-shadow: 0 4px 12px rgba(0, 0, 0, 0.2);
    font-size: 22px;
    width: auto;
    margin: 20px auto;
    display: table;
  }

  th, td {
    border: 1px solid #e94560;
    padding: 10px 18px;
    text-align: left;
  }

  th {
    background-color: #e94560;
    color: #ffffff;
    font-weight: 700;
    font-size: 24px;
  }

  td {
    background-color: #0f3460;
    color: #ffffff;
  }

  tr:nth-child(even) td {
    background-color: #1a4d7a;
  }

  ul, ol {
    line-height: 1.6;
    font-size: 24px;
    margin-left: 20px;
    margin-bottom: 10px;
  }

  li {
    margin-bottom: 8px;
  }

  li::marker {
    color: #e94560;
    font-weight: bold;
  }

  /* Links */
  a {
    color: #5eead4;
    text-decoration: none;
    border-bottom: 2px solid #5eead4;
    transition: all 0.3s ease;
  }

  a:hover {
    color: #f39c12;
    border-bottom-color: #f39c12;
  }

  /* Ênfase */
  em {
    color: #f39c12;
    font-style: italic;
    font-weight: 600;
  }

  p {
    font-size: 24px;
    line-height: 1.5;
    margin-bottom: 12px;
  }

  .columns {
    display: grid;
    grid-template-columns: repeat(2, minmax(0, 1fr));
    gap: 1.5rem;
  }

  /* Paginação */
  section::after {
    color: #e94560;
    font-weight: 600;
    font-size: 18px;
  }

  /* Destaque para blocos importantes */
  blockquote {
    border-left: 4px solid #e94560;
    padding-left: 18px;
    margin: 20px 0;
    font-style: italic;
    color: #f8f8f8;
  }
---

# Árvores Binárias e Árvores Rubro-Negras

**Estruturas de Dados Avançadas**

Apresentação sobre Árvores Binárias e implementação de Árvore Rubro-Negra em Java

---

## Sumário

1. Árvores Binárias - Conceitos Fundamentais
2. Árvores Binárias de Busca (BST)
3. Limitações das BST
4. Árvores Rubro-Negras - Teoria
5. Propriedades das Árvores Rubro-Negras
6. Como Implementar - Estratégia e Conceitos
7. Implementação em Java com Generics
8. Exemplos de Execução com Múltiplos Tipos

---

# Árvores Binárias - Conceitos Fundamentais

---

## O que é uma Árvore Binária?

Uma **árvore binária** é uma estrutura de dados hierárquica composta por nós, onde:

- Cada nó possui **no máximo dois filhos** (esquerdo e direito)
- Existe um nó especial chamado **raiz** (topo da árvore)
- Nós sem filhos são chamados de **folhas**
- Cada nó (exceto a raiz) tem exatamente **um pai**

---

## Terminologia Essencial

**Nó**: Elemento básico da árvore que contém dados e referências
**Raiz**: Primeiro nó da árvore (não tem pai)
**Folha**: Nó sem filhos
**Subárvore**: Árvore formada por um nó e seus descendentes
**Altura**: Número de arestas no caminho mais longo da raiz até uma folha
**Profundidade**: Número de arestas da raiz até um nó específico

---

## Exemplo Visual de Árvore Binária

```
        10
       /  \
      5    15
     / \   / \
    3   7 12  20
```

- **Raiz**: 10
- **Filhos de 10**: 5 (esquerda) e 15 (direita)
- **Folhas**: 3, 7, 12, 20
- **Altura**: 2

---

# Árvores Binárias de Busca (BST)

---

## Propriedade Fundamental da BST

Uma **Árvore Binária de Busca (Binary Search Tree - BST)** é uma árvore binária especial onde:

**Para cada nó:**
- Todos os valores na **subárvore esquerda** são **menores** que o valor do nó
- Todos os valores na **subárvore direita** são **maiores** que o valor do nó

Esta propriedade permite busca eficiente!

---

## Exemplo de BST

```
        50
       /  \
      30   70
     / \   / \
   20  40 60  80
```

**Verificação:**
- Subárvore esquerda de 50: {20, 30, 40} < 50 ✓
- Subárvore direita de 50: {60, 70, 80} > 50 ✓
- Propriedade mantida em todos os níveis!

---

## Operações em BST

### Busca
- Complexidade no **melhor caso**: O(log n) - árvore balanceada
- Complexidade no **pior caso**: O(n) - árvore degenerada

### Inserção
- Segue o mesmo princípio da busca
- Insere sempre como folha

### Remoção
- Mais complexa (3 casos: folha, 1 filho, 2 filhos)

---

## Problema: Árvore Degenerada

Inserindo valores em ordem crescente (10, 20, 30, 40, 50):

```
10
 \
  20
   \
    30
     \
      40
       \
        50
```

**Problema:** Vira uma lista encadeada!
**Complexidade:** O(n) para todas as operações

---

# Limitações das BST

---

## Necessidade de Balanceamento

**Problema Principal:**
- BST não garante balanceamento automático
- Inserções ordenadas criam árvores degeneradas
- Desempenho degrada de O(log n) para O(n)

**Solução:**
Árvores Auto-Balanceadas!

- AVL Trees
- **Árvores Rubro-Negras (Red-Black Trees)** ← Nosso foco!
- B-Trees

---

# Árvores Rubro-Negras

---

## O que são Árvores Rubro-Negras?

Uma **Árvore Rubro-Negra** é uma BST auto-balanceada onde:

- Cada nó tem uma **cor**: VERMELHO ou PRETO
- Propriedades específicas garantem balanceamento
- Usadas em bibliotecas padrão (Java TreeMap, C++ map, kernel Linux)

**Vantagem:** Garantem O(log n) para busca, inserção e remoção!

---

## Propriedades das Árvores Rubro-Negras

**5 Propriedades Fundamentais:**

1. Todo nó é VERMELHO ou PRETO
2. A raiz é sempre PRETA
3. Todas as folhas (NIL/NULL) são PRETAS
4. Nós VERMELHOS têm filhos PRETOS (não há dois nós vermelhos consecutivos)
5. Todos os caminhos da raiz até as folhas têm o mesmo número de nós PRETOS (altura negra)

---

## Propriedade 4: Regra dos Vermelhos

**Não permitido:**
```
    10(V)
   /
  5(V)  ← ERRO! Dois vermelhos consecutivos
```

**Permitido:**
```
    10(P)
   /
  5(V)  ✓ Vermelho pode ter pai preto
 /
3(P)
```

---

## Propriedade 5: Altura Negra

Todos os caminhos da raiz até folhas NIL têm o mesmo número de nós pretos:

```
       10(P)
      /     \
    5(V)    15(P)
   /  \     /   \
 3(P) 7(P) NIL  NIL
 / \  / \
NIL NIL NIL NIL
```

Altura negra = 2 em todos os caminhos!

---

## Balanceamento Automático

Quando as propriedades são violadas após inserção/remoção:

**Operações de Correção:**

1. **Recoloração**: Mudar cores de nós
2. **Rotação Esquerda**: Reorganizar nós à direita
3. **Rotação Direita**: Reorganizar nós à esquerda

Estas operações restauram as propriedades em O(log n)!

---

## Rotação Esquerda

**Antes:**
```
    x
     \
      y
       \
        z
```

**Depois:**
```
      y
     / \
    x   z
```

Mantém a propriedade de BST enquanto rebalanceia!

---

## Rotação Direita

**Antes:**
```
      z
     /
    y
   /
  x
```

**Depois:**
```
      y
     / \
    x   z
```

---

# Como Implementar uma Árvore Rubro-Negra

---

## Estrutura do Projeto

Vamos criar **3 componentes principais:**

1. **Enum de Cores** - Definir VERMELHO e PRETO
2. **Classe Nó** - Estrutura de dados para cada nó
3. **Classe Árvore** - Lógica principal e algoritmos

---

## Componente 1: Enum de Cores

**Objetivo:** Representar as duas cores possíveis

**O que precisamos:**
- Duas constantes: VERMELHO e PRETO
- Tipo seguro (enum em Java)

**Por que usar enum:**
- Evita erros com strings ou números
- Auto-documentado
- Type-safe em tempo de compilação

---

## Componente 2: Classe Nó

**Objetivo:** Representar cada elemento da árvore

**Atributos necessários:**
- `dado` - O valor armazenado (int)
- `cor` - A cor do nó (VERMELHO ou PRETO)
- `pai` - Referência ao nó pai
- `esquerda` - Referência ao filho esquerdo
- `direita` - Referência ao filho direito

**Decisão de design:** Novos nós sempre começam VERMELHOS

---

## Componente 3: Classe Árvore - Estrutura

**Atributos principais:**
- `raiz` - Ponteiro para o nó raiz
- `TNULL` - Nó sentinela (representa folhas NIL)

**Por que usar sentinela (TNULL):**
- Simplifica verificações (evita null checks)
- Reduz casos especiais no código

---

## Componente 3: Classe Árvore - Métodos

**Métodos públicos:**
- `inserir(int chave)` - Adicionar novo elemento
- `imprimirArvore()` - Visualizar a estrutura

**Métodos privados (auxiliares):**
- `rotacaoEsquerda(No x)` - Rotação à esquerda
- `rotacaoDireita(No x)` - Rotação à direita
- `corrigirInsercao(No k)` - Restaurar propriedades
- `*Helper(...)` - Recursão para Métodos

---

## Algoritmo de Inserção - Visão Geral

**Passo 1:** Inserir como BST normal
- Percorrer árvore comparando valores
- Inserir novo nó como folha
- Novo nó é sempre VERMELHO

**Passo 2:** Verificar casos especiais
- Se é a raiz → mudar para PRETO
- Se pai é PRETO → nada a fazer

**Passo 3:** Corrigir violações
- Aplicar recolorações e rotações
- Garantir que propriedades sejam mantidas

---

## Algoritmo de Correção - Estratégia

**Identificar o problema:**
- Nó vermelho com pai vermelho (violação!)
- Localizar o "tio" (irmão do pai)

**Caso 1: Tio é VERMELHO**
- Recolorir: pai e tio → PRETO
- Recolorir: avô → VERMELHO
- Continuar verificando a partir do avô

**Caso 2: Tio é PRETO**
- Aplicar rotações (esquerda ou direita)
- Recolorir após rotação
- Propriedades restauradas

---

## Rotações - Conceito

**Rotação Esquerda:**
- Usada quando desbalanceamento à direita
- Filho direito sobe, pai desce à esquerda
- Mantém ordenação BST

**Rotação Direita:**
- Usada quando desbalanceamento à esquerda
- Filho esquerdo sobe, pai desce à direita
- Mantém ordenação BST

**Importante:** Sempre ajustar ponteiros (pai, esquerda, direita)

---

## Visualização - Estratégia

**Objetivo:** Mostrar estrutura hierárquica clara

**Elementos a exibir:**
- Identificar RAIZ explicitamente
- Indicar lado esquerdo [E] e direito [D]
- Mostrar cor de cada nó
- Usar indentação para hierarquia
- Caracteres especiais (├──, └──) para visual

---

# Implementação em Java com Generics

---

**Usando Generics:**
```java
ArvoreRubroNegra<Integer> arvoreInt = new ArvoreRubroNegra<>();
ArvoreRubroNegra<String> arvoreStr = new ArvoreRubroNegra<>();
ArvoreRubroNegra<Double> arvoreDbl = new ArvoreRubroNegra<>();
```

**Benefício**: Uma única implementação, múltiplos tipos!

---

## Cor.java - Enum de Cores

```java
public enum Cor {
    VERMELHO,
    PRETO
}
```

Define as duas cores possíveis para os nós.

---

## No.java - Estrutura do Nó com Generics

```java
public class No<T extends Comparable<T>> {
    T dado;              // Valor armazenado (qualquer tipo comparável)
    Cor cor;             // Cor do nó
    No<T> pai;           // Referência ao pai
    No<T> esquerda;      // Filho esquerdo
    No<T> direita;       // Filho direito

    public No(T dado) {
        this.dado = dado;
        this.cor = Cor.VERMELHO; // Novos nós são vermelhos
    }
}
```

**Generics**: Aceita qualquer tipo que implemente `Comparable<T>`

---

## ArvoreRubroNegra.java - Estrutura Principal

```java
public class ArvoreRubroNegra<T extends Comparable<T>> {
    private No<T> raiz;
    private final No<T> TNULL; // Nó sentinela (folhas)

    public ArvoreRubroNegra() {
        TNULL = new No<T>(null);
        TNULL.cor = Cor.PRETO;
        raiz = TNULL;
    }

    // Métodos: inserir, rotações, correção...
}
```

**TNULL**: Sentinela para representar folhas NIL (sempre preto)
**Generics**: Árvore pode armazenar qualquer tipo comparável

---

## Método de Inserção com Generics

```java
public void inserir(T chave) {
    No<T> no = new No<T>(chave);
    no.esquerda = TNULL;
    no.direita = TNULL;
    no.cor = Cor.VERMELHO; // Novo nó é vermelho

    // Inserção BST normal usando compareTo
    while (x != TNULL) {
        y = x;
        if (no.dado.compareTo(x.dado) < 0) { // Usa Comparable
            x = x.esquerda;
        } else {
            x = x.direita;
        }
    }
    // Correção das propriedades rubro-negras
    corrigirInsercao(no);
}
```

---

## Rotação Esquerda - Código

```java
private void rotacaoEsquerda(No<T> x) {
    No<T> y = x.direita;
    x.direita = y.esquerda;

    if (y.esquerda != TNULL) {
        y.esquerda.pai = x;
    }

    y.pai = x.pai;
    if (x.pai == null) {
        this.raiz = y;
    } else if (x == x.pai.esquerda) {
        x.pai.esquerda = y;
    } else {
        x.pai.direita = y;
    }

    y.esquerda = x;
    x.pai = y;
}
```

---

## Rotação Direita - Código

```java
private void rotacaoDireita(No<T> x) {
    No<T> y = x.esquerda;
    x.esquerda = y.direita;

    if (y.direita != TNULL) {
        y.direita.pai = x;
    }

    y.pai = x.pai;
    if (x.pai == null) {
        this.raiz = y;
    } else if (x == x.pai.direita) {
        x.pai.direita = y;
    } else {
        x.pai.esquerda = y;
    }

    y.direita = x;
    x.pai = y;
}
```

---

## Correção após Inserção

```java
private void corrigirInsercao(No<T> k) {
    No<T> u;
    while (k.pai.cor == Cor.VERMELHO) {
        // Caso 1: Pai é filho direito do avô
        if (k.pai == k.pai.pai.direita) {
            u = k.pai.pai.esquerda; // Tio
            if (u.cor == Cor.VERMELHO) {
                // Recoloração
                u.cor = Cor.PRETO;
                k.pai.cor = Cor.PRETO;
                k.pai.pai.cor = Cor.VERMELHO;
                k = k.pai.pai;
            } else {
                // Rotações (esquerda/direita)
                // ...
            }
        }
        // Caso simétrico para pai à esquerda
    }
    raiz.cor = Cor.PRETO; // Raiz sempre preta
}
```

---

## Visualização da Árvore

```java
public void imprimirArvore() {
    System.out.println("=== ÁRVORE RUBRO-NEGRA ===");
    System.out.println("[RAIZ] " + raiz.dado + " (" + cor + ")");

    if (raiz.esquerda != TNULL) {
        imprimirHelper(raiz.esquerda, "", "├── [E] ");
    }

    if (raiz.direita != TNULL) {
        imprimirHelper(raiz.direita, "", "└── [D] ");
    }
}
```

- **[E]** indica subárvore esquerda
- **[D]** indica subárvore direita

---

# Exemplo de Execução

---

## Main.java - Programa de Teste com Generics

```java
public class Main {
    public static void main(String[] args) {
        // Árvore com Integer
        ArvoreRubroNegra<Integer> arvoreInt = new ArvoreRubroNegra<>();
        arvoreInt.inserir(10);
        arvoreInt.inserir(20);
        arvoreInt.inserir(30);

        // Árvore com String
        ArvoreRubroNegra<String> arvoreStr = new ArvoreRubroNegra<>();
        arvoreStr.inserir("Maçã");
        arvoreStr.inserir("Banana");
        arvoreStr.inserir("Laranja");

        // Árvore com Double
        ArvoreRubroNegra<Double> arvoreDouble = new ArvoreRubroNegra<>();
        arvoreDouble.inserir(10.5);
        arvoreDouble.inserir(5.2);
    }
}
```

**Vantagem**: Uma única implementação funciona com múltiplos tipos!

---

## Execução Passo a Passo

### Passo 1: Inserir 10

```
=== ÁRVORE RUBRO-NEGRA ===
[RAIZ] 10 (PRETO)
```

- Primeiro nó inserido
- Automaticamente se torna raiz PRETA
- Propriedades satisfeitas ✓

---

## Execução Passo a Passo

### Passo 2: Inserir 20

```
=== ÁRVORE RUBRO-NEGRA ===
[RAIZ] 10 (PRETO)
├── [E] (vazio)
└── [D] 20 (VERMELHO)
```

- 20 > 10, inserido à direita
- Novo nó é VERMELHO
- Pai é PRETO, sem violação ✓

---

## Execução Passo a Passo

### Passo 3: Inserir 30

**Antes da correção:**
```
    10(P)
      \
      20(V)
        \
        30(V) ← Violação! Dois vermelhos consecutivos
```

**Solução:** Rotação esquerda em 10 + Recoloração

---

## Execução Passo a Passo

### Passo 3: Inserir 30 (continuação)

**Após correção:**
```
=== ÁRVORE RUBRO-NEGRA ===
[RAIZ] 20 (PRETO)
├── [E] 10 (VERMELHO)
└── [D] 30 (VERMELHO)
```

- Árvore balanceada!
- Propriedades rubro-negras restauradas ✓

---

## Execução Passo a Passo

### Passo 4: Inserir 40

```
=== ÁRVORE RUBRO-NEGRA ===
[RAIZ] 20 (PRETO)
├── [E] 10 (PRETO)
└── [D] 30 (PRETO)
    ├── [E] (vazio)
    └── [D] 40 (VERMELHO)
```

- Recoloração de 10 e 30 para PRETO
- 40 inserido como VERMELHO à direita de 30

---

## Execução Passo a Passo

### Passo 5: Inserir 50

```
=== ÁRVORE RUBRO-NEGRA ===
[RAIZ] 20 (PRETO)
├── [E] 10 (PRETO)
└── [D] 40 (PRETO)
    ├── [E] 30 (VERMELHO)
    └── [D] 50 (VERMELHO)
```

- Rotação esquerda em 30
- 40 sobe para substituir 30
- Recoloração aplicada

---

## Execução Passo a Passo

### Passo 6: Inserir 60

```
=== ÁRVORE RUBRO-NEGRA ===
[RAIZ] 20 (PRETO)
├── [E] 10 (PRETO)
└── [D] 40 (PRETO)
    ├── [E] 30 (PRETO)
    └── [D] 50 (PRETO)
        ├── [E] (vazio)
        └── [D] 60 (VERMELHO)
```

---

## Análise da Árvore Final

**Propriedades Verificadas:**

1. ✓ Todos nós são VERMELHO ou PRETO
2. ✓ Raiz (20) é PRETA
3. ✓ Folhas (TNULL) são PRETAS
4. ✓ Nós VERMELHOS têm filhos PRETOS
5. ✓ Altura negra consistente = 2

**Altura da árvore:** 3
**Altura de BST degenerada seria:** 6

---

## Exemplo com Strings - Árvore de Frutas

```java
ArvoreRubroNegra<String> arvoreStr = new ArvoreRubroNegra<>();
arvoreStr.inserir("Maçã");
arvoreStr.inserir("Banana");
arvoreStr.inserir("Laranja");
arvoreStr.inserir("Uva");
```

**Resultado:**
```
=== ÁRVORE RUBRO-NEGRA ===
[RAIZ] Maçã (PRETO)
├── [E] Banana (PRETO)
│   ├── [E] (vazio)
│   └── [D] Laranja (VERMELHO)
└── [D] Uva (PRETO)
```

**Ordenação alfabética automática!**

---

## Comparação: BST vs Rubro-Negra

**BST Normal (valores 10-60):**
```
10
 \
  20
   \
    30
     \
      40
       \
        50
         \
          60
```
Altura: 5 (degenerada)

---

## Comparação: BST vs Rubro-Negra

**Rubro-Negra (valores 10-60):**
```
       20(P)
      /     \
   10(P)    40(P)
           /     \
        30(P)    50(P)
                    \
                    60(V)
```
Altura: 3 (balanceada)

**Ganho de eficiência:** ~40% de redução!

---

## Complexidade de Tempo

| Operação | BST (pior caso) | Rubro-Negra |
|----------|-----------------|-------------|
| Busca    | O(n)            | O(log n)    |
| Inserção | O(n)            | O(log n)    |
| Remoção  | O(n)            | O(log n)    |

**Rubro-Negra garante O(log n) sempre!**

---

## Aplicações Práticas

**Onde são usadas Árvores Rubro-Negras:**

- `java.util.TreeMap` e `TreeSet` (Java)
- `std::map` e `std::set` (C++)
- Escalonador de processos do kernel Linux
- Implementação de bancos de dados em memória
- Compiladores (tabelas de símbolos)

---

## Vantagens de Usar Generics

**Reusabilidade:**
- Uma única implementação serve para múltiplos tipos
- Não precisa reescrever código para cada tipo

**Type Safety:**
- Erros de tipo detectados em tempo de compilação
- Sem necessidade de casting manual

**Flexibilidade:**
- Funciona com Integer, String, Double, ou qualquer classe Comparable
- Pode criar classes personalizadas que implementem Comparable

---

## Vantagens de Usar Generics

**Exemplo:**
```java
class Pessoa implements Comparable<Pessoa> {
    String nome;
    int idade;
    public int compareTo(Pessoa p) { return this.idade - p.idade; }
}
ArvoreRubroNegra<Pessoa> arvore = new ArvoreRubroNegra<>();
```

---

## Vantagens das Árvores Rubro-Negras

**Vantagens:**
- Garantia de O(log n) para todas as operações
- Auto-balanceamento automático
- Menos rotações que AVL (melhor para inserções frequentes)
- Implementação em bibliotecas padrão comprovada
- **Com Generics**: Funciona com qualquer tipo comparável

**Desvantagens:**
- Implementação complexa
- Overhead de armazenamento (cor adicional)
- AVL pode ser mais rápido para buscas intensivas

---

## Resumo

- **Árvores Binárias**: Estrutura hierárquica fundamental
- **BST**: Propriedade de ordenação, mas pode degenerar
- **Rubro-Negras**: Auto-balanceamento via cores e rotações
- **5 Propriedades**: Garantem balanceamento O(log n)
- **Generics**: Implementação genérica com type safety
- **Aplicações**: Amplamente usadas em sistemas reais
- **Implementação**: Java com visualização clara da estrutura

---

## Referências e Estudos Adicionais

**Recursos Online:**
- Visualizador: visualgo.net/en/bst

**Próximos Passos:**
- Comparar com AVL Trees
- Estudar B-Trees

---

# Obrigado!

**Dúvidas?**
