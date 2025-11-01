import java.util.ArrayList;
import java.util.List;

/**
 * Implementação da estrutura de dados Árvore Rubro-Negra.
 *
 * <p>Esta classe implementa uma árvore binária de busca auto-balanceada que mantém
 * as seguintes propriedades invariantes:</p>
 *
 * <ul>
 *   <li><b>Invariante 1:</b> Cada nó é ou vermelho ou preto.</li>
 *   <li><b>Invariante 2:</b> A raiz é sempre preta.</li>
 *   <li><b>Invariante 3:</b> Todas as folhas (nós nulos/sentinela) são pretas.</li>
 *   <li><b>Invariante 4:</b> Se um nó é vermelho, então ambos os seus filhos são pretos.</li>
 *   <li><b>Invariante 5:</b> Para cada nó, todos os caminhos do nó até as folhas
 *       descendentes contêm o mesmo número de nós pretos.</li>
 * </ul>
 *
 * <p>A árvore utiliza um nó sentinela (TNULL) para representar todas as folhas,
 * simplificando a implementação e garantindo que todas as folhas sejam pretas.</p>
 *
 * @param <T> o tipo dos elementos armazenados na árvore, que deve implementar
 *            a interface {@link Comparable}
 *
 * @author Alysson M. Bruno <alysson.mb@unitins.br>
 * @version 1.0
 * @since 2025-10-25
 */
public class ArvoreRubroNegra<T extends Comparable<T>>
    implements IArvoreRubroNegra<T> {

    /**
     * Referência para o nó raiz da árvore.
     */
    private No<T> raiz;

    /**
     * Nó sentinela que representa todas as folhas da árvore.
     * Sempre tem cor preta e dado nulo.
     */
    private final No<T> TNULL;

    /**
     * Contador do número de elementos na árvore.
     */
    private int tamanho;

    /**
     * Construtor que inicializa uma árvore rubro-negra vazia.
     *
     * <p><b>Pós-condições:</b></p>
     * <ul>
     *   <li>A árvore é criada vazia com tamanho 0.</li>
     *   <li>O nó sentinela TNULL é criado com cor preta.</li>
     *   <li>A raiz aponta para o nó sentinela.</li>
     * </ul>
     */
    public ArvoreRubroNegra() {
        TNULL = new No<T>(null);
        TNULL.cor = Cor.PRETO;
        TNULL.esquerda = null;
        TNULL.direita = null;
        raiz = TNULL;
        tamanho = 0;
    }

    /**
     * Realiza uma rotação à esquerda no nó especificado.
     *
     * <p>A rotação à esquerda é uma operação local que preserva a propriedade
     * de busca binária e é usada para rebalancear a árvore.</p>
     *
     * <p><b>Pré-condições:</b></p>
     * <ul>
     *   <li>O nó x não pode ser nulo.</li>
     *   <li>O filho direito de x não pode ser TNULL.</li>
     * </ul>
     *
     * <p><b>Pós-condições:</b></p>
     * <ul>
     *   <li>O filho direito de x torna-se o novo pai de x.</li>
     *   <li>A propriedade de busca binária é mantida.</li>
     * </ul>
     *
     * @param x o nó a ser rotacionado
     */
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

    /**
     * Realiza uma rotação à direita no nó especificado.
     *
     * <p>A rotação à direita é uma operação local que preserva a propriedade
     * de busca binária e é usada para rebalancear a árvore.</p>
     *
     * <p><b>Pré-condições:</b></p>
     * <ul>
     *   <li>O nó x não pode ser nulo.</li>
     *   <li>O filho esquerdo de x não pode ser TNULL.</li>
     * </ul>
     *
     * <p><b>Pós-condições:</b></p>
     * <ul>
     *   <li>O filho esquerdo de x torna-se o novo pai de x.</li>
     *   <li>A propriedade de busca binária é mantida.</li>
     * </ul>
     *
     * @param x o nó a ser rotacionado
     */
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

    /**
     * Corrige as violações das propriedades rubro-negras após uma inserção.
     *
     * <p>Este método restaura as propriedades da árvore rubro-negra que podem
     * ter sido violadas após a inserção de um novo nó vermelho. Ele trata
     * diferentes casos usando recoloração e rotações.</p>
     *
     * <p><b>Pré-condições:</b></p>
     * <ul>
     *   <li>O nó k foi recém-inserido e tem cor vermelha.</li>
     *   <li>O nó k não pode ser nulo.</li>
     * </ul>
     *
     * <p><b>Pós-condições:</b></p>
     * <ul>
     *   <li>Todas as propriedades da árvore rubro-negra são restauradas.</li>
     *   <li>A raiz sempre fica preta.</li>
     * </ul>
     *
     * @param k o nó recém-inserido que pode estar causando violações
     */
    private void corrigirInsercao(No<T> k) {
        No<T> u;
        while (k.pai != null && k.pai.cor == Cor.VERMELHO) {
            if (k.pai == k.pai.pai.direita) {
                u = k.pai.pai.esquerda; // tio
                if (u.cor == Cor.VERMELHO) {
                    // Caso 1: tio é vermelho - recoloração
                    u.cor = Cor.PRETO;
                    k.pai.cor = Cor.PRETO;
                    k.pai.pai.cor = Cor.VERMELHO;
                    k = k.pai.pai;
                } else {
                    // Caso 2 e 3: tio é preto
                    if (k == k.pai.esquerda) {
                        // Caso 2: transforma no caso 3
                        k = k.pai;
                        rotacaoDireita(k);
                    }
                    // Caso 3: rotação e recoloração
                    k.pai.cor = Cor.PRETO;
                    k.pai.pai.cor = Cor.VERMELHO;
                    rotacaoEsquerda(k.pai.pai);
                }
            } else {
                u = k.pai.pai.direita; // tio
                if (u.cor == Cor.VERMELHO) {
                    // Caso 1: tio é vermelho - recoloração
                    u.cor = Cor.PRETO;
                    k.pai.cor = Cor.PRETO;
                    k.pai.pai.cor = Cor.VERMELHO;
                    k = k.pai.pai;
                } else {
                    // Caso 2 e 3: tio é preto
                    if (k == k.pai.direita) {
                        // Caso 2: transforma no caso 3
                        k = k.pai;
                        rotacaoEsquerda(k);
                    }
                    // Caso 3: rotação e recoloração
                    k.pai.cor = Cor.PRETO;
                    k.pai.pai.cor = Cor.VERMELHO;
                    rotacaoDireita(k.pai.pai);
                }
            }
            if (k == raiz) {
                break;
            }
        }
        raiz.cor = Cor.PRETO;
    }

    @Override
    public void inserir(T elemento) {
        // Validação de entrada
        if (elemento == null) {
            throw new IllegalArgumentException(
                "Não é permitido inserir elementos nulos na árvore."
            );
        }

        No<T> no = new No<T>(elemento);
        no.pai = null;
        no.esquerda = TNULL;
        no.direita = TNULL;
        no.cor = Cor.VERMELHO;

        No<T> y = null;
        No<T> x = this.raiz;

        // Busca a posição correta para inserção
        while (x != TNULL) {
            y = x;
            if (no.dado.compareTo(x.dado) < 0) {
                x = x.esquerda;
            } else {
                x = x.direita;
            }
        }

        // Insere o novo nó
        no.pai = y;
        if (y == null) {
            raiz = no;
        } else if (no.dado.compareTo(y.dado) < 0) {
            y.esquerda = no;
        } else {
            y.direita = no;
        }

        tamanho++; // Incrementa o tamanho

        // Se o nó é a raiz, colore de preto e retorna
        if (no.pai == null) {
            no.cor = Cor.PRETO;
            return;
        }

        // Se o avô é nulo, não há violações
        if (no.pai.pai == null) {
            return;
        }

        // Corrige possíveis violações
        corrigirInsercao(no);
    }

    /**
     * Busca um nó com o elemento especificado na subárvore enraizada em no.
     *
     * @param no o nó raiz da subárvore
     * @param elemento o elemento a ser buscado
     * @return o nó contendo o elemento, ou TNULL se não encontrado
     */
    private No<T> buscarHelper(No<T> no, T elemento) {
        if (no == TNULL || elemento.compareTo(no.dado) == 0) {
            return no;
        }

        if (elemento.compareTo(no.dado) < 0) {
            return buscarHelper(no.esquerda, elemento);
        }
        return buscarHelper(no.direita, elemento);
    }

    @Override
    public boolean buscar(T elemento) {
        if (elemento == null) {
            throw new IllegalArgumentException(
                "Não é permitido buscar elementos nulos na árvore."
            );
        }
        return buscarHelper(raiz, elemento) != TNULL;
    }

    /**
     * Encontra o nó com o menor valor na subárvore enraizada em no.
     *
     * @param no o nó raiz da subárvore
     * @return o nó com o menor valor
     */
    private No<T> minimoHelper(No<T> no) {
        while (no.esquerda != TNULL) {
            no = no.esquerda;
        }
        return no;
    }

    /**
     * Encontra o nó com o maior valor na subárvore enraizada em no.
     *
     * @param no o nó raiz da subárvore
     * @return o nó com o maior valor
     */
    private No<T> maximoHelper(No<T> no) {
        while (no.direita != TNULL) {
            no = no.direita;
        }
        return no;
    }

    /**
     * Substitui a subárvore enraizada em u pela subárvore enraizada em v.
     *
     * @param u nó a ser substituído
     * @param v nó substituto
     */
    private void transplantar(No<T> u, No<T> v) {
        if (u.pai == null) {
            raiz = v;
        } else if (u == u.pai.esquerda) {
            u.pai.esquerda = v;
        } else {
            u.pai.direita = v;
        }
        v.pai = u.pai;
    }

    /**
     * Corrige as violações das propriedades rubro-negras após uma remoção.
     *
     * @param x o nó que pode estar causando violações
     */
    private void corrigirRemocao(No<T> x) {
        No<T> s;
        while (x != raiz && x.cor == Cor.PRETO) {
            if (x == x.pai.esquerda) {
                s = x.pai.direita;
                if (s.cor == Cor.VERMELHO) {
                    s.cor = Cor.PRETO;
                    x.pai.cor = Cor.VERMELHO;
                    rotacaoEsquerda(x.pai);
                    s = x.pai.direita;
                }

                if (s.esquerda.cor == Cor.PRETO && s.direita.cor == Cor.PRETO) {
                    s.cor = Cor.VERMELHO;
                    x = x.pai;
                } else {
                    if (s.direita.cor == Cor.PRETO) {
                        s.esquerda.cor = Cor.PRETO;
                        s.cor = Cor.VERMELHO;
                        rotacaoDireita(s);
                        s = x.pai.direita;
                    }

                    s.cor = x.pai.cor;
                    x.pai.cor = Cor.PRETO;
                    s.direita.cor = Cor.PRETO;
                    rotacaoEsquerda(x.pai);
                    x = raiz;
                }
            } else {
                s = x.pai.esquerda;
                if (s.cor == Cor.VERMELHO) {
                    s.cor = Cor.PRETO;
                    x.pai.cor = Cor.VERMELHO;
                    rotacaoDireita(x.pai);
                    s = x.pai.esquerda;
                }

                if (s.direita.cor == Cor.PRETO && s.esquerda.cor == Cor.PRETO) {
                    s.cor = Cor.VERMELHO;
                    x = x.pai;
                } else {
                    if (s.esquerda.cor == Cor.PRETO) {
                        s.direita.cor = Cor.PRETO;
                        s.cor = Cor.VERMELHO;
                        rotacaoEsquerda(s);
                        s = x.pai.esquerda;
                    }

                    s.cor = x.pai.cor;
                    x.pai.cor = Cor.PRETO;
                    s.esquerda.cor = Cor.PRETO;
                    rotacaoDireita(x.pai);
                    x = raiz;
                }
            }
        }
        x.cor = Cor.PRETO;
    }

    /**
     * Remove o nó especificado da árvore.
     *
     * @param no o nó a ser removido
     */
    private void removerHelper(No<T> no) {
        No<T> x, y;
        y = no;
        Cor corOriginalY = y.cor;

        if (no.esquerda == TNULL) {
            x = no.direita;
            transplantar(no, no.direita);
        } else if (no.direita == TNULL) {
            x = no.esquerda;
            transplantar(no, no.esquerda);
        } else {
            y = minimoHelper(no.direita);
            corOriginalY = y.cor;
            x = y.direita;
            if (y.pai == no) {
                x.pai = y;
            } else {
                transplantar(y, y.direita);
                y.direita = no.direita;
                y.direita.pai = y;
            }
            transplantar(no, y);
            y.esquerda = no.esquerda;
            y.esquerda.pai = y;
            y.cor = no.cor;
        }
        tamanho--; // Decrementa o tamanho
        if (corOriginalY == Cor.PRETO) {
            corrigirRemocao(x);
        }
    }

    @Override
    public boolean remover(T elemento) {
        if (elemento == null) {
            throw new IllegalArgumentException(
                "Não é permitido remover elementos nulos da árvore."
            );
        }

        No<T> no = buscarHelper(raiz, elemento);
        if (no == TNULL) {
            return false; // Elemento não encontrado
        }

        removerHelper(no);
        return true;
    }

    @Override
    public boolean estaVazia() {
        return raiz == TNULL;
    }

    @Override
    public int tamanho() {
        return tamanho;
    }

    @Override
    public void limpar() {
        raiz = TNULL;
        tamanho = 0;
    }

    /**
     * Calcula a altura da subárvore enraizada em no.
     *
     * @param no o nó raiz da subárvore
     * @return a altura da subárvore
     */
    private int alturaHelper(No<T> no) {
        if (no == TNULL) {
            return 0;
        }
        int alturaEsquerda = alturaHelper(no.esquerda);
        int alturaDireita = alturaHelper(no.direita);
        return 1 + Math.max(alturaEsquerda, alturaDireita);
    }

    @Override
    public int altura() {
        if (estaVazia()) {
            return 0;
        }
        return alturaHelper(raiz) - 1; // -1 porque contamos arestas, não nós
    }

    @Override
    public T minimo() {
        if (estaVazia()) {
            throw new IllegalStateException("A árvore está vazia.");
        }
        return minimoHelper(raiz).dado;
    }

    @Override
    public T maximo() {
        if (estaVazia()) {
            throw new IllegalStateException("A árvore está vazia.");
        }
        return maximoHelper(raiz).dado;
    }

    /**
     * Percorre a árvore em ordem (esquerda, raiz, direita) e adiciona
     * os elementos à lista.
     *
     * @param no o nó raiz da subárvore
     * @param lista a lista para armazenar os elementos
     */
    private void emOrdemHelper(No<T> no, List<T> lista) {
        if (no != TNULL) {
            emOrdemHelper(no.esquerda, lista);
            lista.add(no.dado);
            emOrdemHelper(no.direita, lista);
        }
    }

    @Override
    public List<T> emOrdem() {
        List<T> lista = new ArrayList<>();
        emOrdemHelper(raiz, lista);
        return lista;
    }

    /**
     * Percorre a árvore em pré-ordem (raiz, esquerda, direita) e adiciona
     * os elementos à lista.
     *
     * @param no o nó raiz da subárvore
     * @param lista a lista para armazenar os elementos
     */
    private void preOrdemHelper(No<T> no, List<T> lista) {
        if (no != TNULL) {
            lista.add(no.dado);
            preOrdemHelper(no.esquerda, lista);
            preOrdemHelper(no.direita, lista);
        }
    }

    public List<T> preOrdem() {
        List<T> lista = new ArrayList<>();
        preOrdemHelper(raiz, lista);
        return lista;
    }

    /**
     * Percorre a árvore em pós-ordem (esquerda, direita, raiz) e adiciona
     * os elementos à lista.
     *
     * @param no o nó raiz da subárvore
     * @param lista a lista para armazenar os elementos
     */
    private void posOrdemHelper(No<T> no, List<T> lista) {
        if (no != TNULL) {
            posOrdemHelper(no.esquerda, lista);
            posOrdemHelper(no.direita, lista);
            lista.add(no.dado);
        }
    }

    public List<T> posOrdem() {
        List<T> lista = new ArrayList<>();
        posOrdemHelper(raiz, lista);
        return lista;
    }

    /**
     * Método auxiliar recursivo para imprimir a árvore.
     *
     * @param no o nó atual
     * @param prefixo o prefixo para indentação
     * @param tipo o tipo de nó (raiz, esquerdo ou direito)
     */
    private void imprimirHelper(No<T> no, String prefixo, String tipo) {
        if (no != TNULL) {
            String cor = no.cor == Cor.VERMELHO ? "VERMELHO" : "PRETO";
            System.out.println(prefixo + tipo + no.dado + " (" + cor + ")");

            if (no.esquerda != TNULL || no.direita != TNULL) {
                if (no.esquerda != TNULL) {
                    imprimirHelper(no.esquerda, prefixo + "    ", "├── [E] ");
                } else {
                    System.out.println(prefixo + "    " + "├── [E] (vazio)");
                }

                if (no.direita != TNULL) {
                    imprimirHelper(no.direita, prefixo + "    ", "└── [D] ");
                } else {
                    System.out.println(prefixo + "    " + "└── [D] (vazio)");
                }
            }
        }
    }

    @Override
    public void imprimirArvore() {
        if (raiz == TNULL) {
            System.out.println("Árvore vazia!");
            return;
        }

        System.out.println("=== ÁRVORE RUBRO-NEGRA ===");
        String cor = raiz.cor == Cor.VERMELHO ? "VERMELHO" : "PRETO";
        System.out.println("[RAIZ] " + raiz.dado + " (" + cor + ")");

        if (raiz.esquerda != TNULL || raiz.direita != TNULL) {
            if (raiz.esquerda != TNULL) {
                imprimirHelper(raiz.esquerda, "", "├── [E] ");
            } else {
                System.out.println("├── [E] (vazio)");
            }

            if (raiz.direita != TNULL) {
                imprimirHelper(raiz.direita, "", "└── [D] ");
            } else {
                System.out.println("└── [D] (vazio)");
            }
        }
        System.out.println();
    }
}
