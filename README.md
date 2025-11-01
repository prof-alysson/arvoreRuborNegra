# Árvore Rubro-Negra (Red-Black Tree)

Implementação de uma Árvore Rubro-Negra em Java com suporte a tipos genéricos (Generics). O projeto inclui uma apresentação de slides completa sobre o funcionamento e implementação desta estrutura de dados.

## Descrição

Uma Árvore Rubro-Negra é uma árvore binária de busca auto-balanceada onde cada nó possui uma cor (vermelha ou preta). O balanceamento é mantido através de propriedades específicas que garantem operações de busca, inserção e remoção em O(log n).

**Características principais:**
- Implementação genérica com `<T extends Comparable<T>>`
- Funciona com Integer, String, Double e qualquer classe que implemente Comparable
- Auto-balanceamento automático
- Visualização em árvore no console
- Garantia de complexidade O(log n) para operações principais

## Pré-requisitos

### Para executar o projeto Java:
- **Java JDK 23** ou superior
- **Maven 3.6+** (para gerenciamento de dependências e build)

### Para gerar PDF dos slides:
- **Node.js 14+** e **npm** (para instalar o Marp CLI)
- **Marp CLI** (ferramenta de conversão Markdown → PDF)

## Como Instalar

### 1. Verificar instalação do Java e Maven

```bash
java -version
```

Se não tiver instalado:
- **Java**: Baixe em [https://adoptium.net/](https://adoptium.net/)
- **Maven**: Baixe em [https://maven.apache.org/download.cgi](https://maven.apache.org/download.cgi)

### 2. Clonar/Baixar o projeto

```bash
git clone https://github.com/prof-alysson/arvoreRuborNegra.git
cd ArvoreRubroNegra
```

## Como Executar o Projeto Java

### Opção 1: Usando Maven (Recomendado)

```bash
# Compilar o projeto
mvn clean compile

# Executar a aplicação
mvn exec:java
```

### Opção 2: Compilar e executar manualmente

```bash
# Compilar
mvn clean package

# Executar o JAR gerado
java -jar target/arvorerubronegra-1.0.0.jar
```

### Opção 3: Usando IDE (IntelliJ IDEA / Eclipse)

1. Abra a pasta do projeto na IDE
2. A IDE irá reconhecer automaticamente o `pom.xml`
3. Execute a classe `Main.java` localizada em:
   ```
   src/main/java/arvorerubronegra/Main.java
   ```

## Estrutura do Projeto

```
ArvoreRubroNegra/
├── src/main/java/arvorerubronegra/
│   ├── Main.java                  # Programa principal com exemplos
│   ├── ArvoreRubroNegra.java      # Implementação da árvore
│   ├── No.java                    # Classe do nó
│   ├── Cor.java                   # Enum para cores (VERMELHO/PRETO)
│   └── IArvoreRubroNegra.java     # Interface da árvore
├── pom.xml                        # Configuração Maven
├── slides.md                      # Slides da apresentação (Marp)
└── README.md                      # Este arquivo
```

## Exemplo de Uso

```java
// Árvore com Integer
ArvoreRubroNegra<Integer> arvoreInt = new ArvoreRubroNegra<>();
arvoreInt.inserir(10);
arvoreInt.inserir(20);
arvoreInt.inserir(30);
arvoreInt.imprimirArvore();

// Árvore com String
ArvoreRubroNegra<String> arvoreStr = new ArvoreRubroNegra<>();
arvoreStr.inserir("Maçã");
arvoreStr.inserir("Banana");
arvoreStr.inserir("Laranja");
arvoreStr.imprimirArvore();

// Árvore com Double
ArvoreRubroNegra<Double> arvoreDouble = new ArvoreRubroNegra<>();
arvoreDouble.inserir(10.5);
arvoreDouble.inserir(5.2);
arvoreDouble.inserir(15.7);
arvoreDouble.imprimirArvore();
```

## Como Gerar o PDF dos Slides

### 1. Instalar Node.js e npm

Baixe e instale em: [https://nodejs.org/](https://nodejs.org/) (versão LTS recomendada)

Verifique a instalação:
```bash
node -v
npm -v
```

### 2. Instalar o Marp CLI globalmente

```bash
npm install -g @marp-team/marp-cli
```

Verifique se foi instalado corretamente:
```bash
marp --version
```

### 3. Gerar o PDF a partir do slides.md

No diretório raiz do projeto, execute:

```bash
marp slides.md -o slides.pdf
```

### 4. Opções adicionais do Marp

```bash
# Gerar HTML ao invés de PDF
marp slides.md -o slides.html

# Gerar PPTX (PowerPoint)
marp slides.md -o slides.pptx
```

**Documentação oficial:** [https://marpit.marp.app/](https://marpit.marp.app/)

## Propriedades das Árvores Rubro-Negras

1. Todo nó é VERMELHO ou PRETO
2. A raiz é sempre PRETA
3. Todas as folhas (NIL/NULL) são PRETAS
4. Nós VERMELHOS têm filhos PRETOS (não há dois vermelhos consecutivos)
5. Todos os caminhos da raiz até as folhas têm o mesmo número de nós PRETOS

## Complexidade de Tempo

| Operação | BST (pior caso) | Rubro-Negra |
|----------|-----------------|-------------|
| Busca    | O(n)            | O(log n)    |
| Inserção | O(n)            | O(log n)    |
| Remoção  | O(n)            | O(log n)    |

## Aplicações Práticas

- `java.util.TreeMap` e `TreeSet` (Java)
- `std::map` e `std::set` (C++)
- Escalonador de processos do kernel Linux
- Bancos de dados em memória
- Compiladores (tabelas de símbolos)

## Troubleshooting

### Erro: "JAVA_HOME não está definido"
Configure a variável de ambiente JAVA_HOME apontando para a instalação do JDK.

### Erro: "mvn não é reconhecido como comando"
Adicione o diretório bin do Maven ao PATH do sistema.

### Erro ao gerar PDF com Marp
- Verifique se o Node.js está instalado corretamente
- Reinstale o Marp CLI: `npm uninstall -g @marp-team/marp-cli && npm install -g @marp-team/marp-cli`
- Tente executar com permissões de administrador

### Fonte não aparece no PDF
O Marp carrega fontes do Google Fonts automaticamente. Certifique-se de ter conexão com a internet ao gerar o PDF.

## Autor

Alysson M. Bruno

## Licença

Este projeto é de código aberto para fins educacionais.
