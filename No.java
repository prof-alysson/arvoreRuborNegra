/**
 * Classe que representa um nó na Árvore Rubro-Negra.
 *
 * <p>Cada nó armazena um dado genérico, sua cor (vermelha ou preta), e referências
 * para seu nó pai e seus dois filhos (esquerdo e direito). Esta classe é utilizada
 * internamente pela implementação da Árvore Rubro-Negra.</p>
 *
 * <p><b>Invariantes de um nó:</b></p>
 * <ul>
 *   <li>A cor do nó é sempre VERMELHO ou PRETO.</li>
 *   <li>Se o nó tem um pai, então o nó é filho do seu pai (esquerdo ou direito).</li>
 *   <li>Se o nó tem um filho esquerdo, então o filho tem esse nó como pai.</li>
 *   <li>Se o nó tem um filho direito, então o filho tem esse nó como pai.</li>
 *   <li>O dado armazenado pode ser nulo apenas para o nó sentinela (TNULL).</li>
 * </ul>
 *
 * @param <T> o tipo do dado armazenado no nó, que deve implementar {@link Comparable}
 *
 * @author Alysson M. Bruno <alysson.mb@unitins.br>
 * @version 1.0
 * @since 2025-10-25
 */
public class No<T extends Comparable<T>> {

    /**
     * O valor armazenado no nó.
     * Pode ser nulo apenas para o nó sentinela (TNULL).
     */
    T dado;

    /**
     * A cor do nó (VERMELHO ou PRETO).
     * Essencial para manter as propriedades de balanceamento da árvore.
     */
    Cor cor;

    /**
     * Referência para o nó pai.
     * É nulo apenas para a raiz da árvore.
     */
    No<T> pai;

    /**
     * Referência para o filho esquerdo.
     * Todos os valores na subárvore esquerda são menores que o valor deste nó.
     */
    No<T> esquerda;

    /**
     * Referência para o filho direito.
     * Todos os valores na subárvore direita são maiores ou iguais ao valor deste nó.
     */
    No<T> direita;

    /**
     * Construtor para criar um novo nó.
     *
     * <p><b>Pré-condições:</b></p>
     * <ul>
     *   <li>O dado pode ser nulo apenas para nós sentinela.</li>
     * </ul>
     *
     * <p><b>Pós-condições:</b></p>
     * <ul>
     *   <li>Um novo nó é criado com a cor VERMELHO (padrão para novos nós).</li>
     *   <li>As referências pai, esquerda e direita são inicializadas como nulas.</li>
     * </ul>
     *
     * @param dado o valor a ser armazenado no nó
     */
    public No(T dado) {
        this.dado = dado;
        // Por padrão, um novo nó inserido é sempre VERMELHO.
        // Isso simplifica o processo de correção após inserção.
        this.cor = Cor.VERMELHO;
        this.esquerda = null;
        this.direita = null;
        this.pai = null;
    }
}
