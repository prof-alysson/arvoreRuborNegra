import java.util.List;

/**
 * Interface que define o Tipo Abstrato de Dados (TAD) para uma Árvore Rubro-Negra.
 *
 * <p>Uma Árvore Rubro-Negra é uma árvore binária de busca balanceada que mantém
 * as seguintes propriedades invariantes:</p>
 *
 * <ul>
 *   <li><b>Invariante 1:</b> Cada nó é ou vermelho ou preto.</li>
 *   <li><b>Invariante 2:</b> A raiz é sempre preta.</li>
 *   <li><b>Invariante 3:</b> Todas as folhas (nós nulos/sentinela) são pretas.</li>
 *   <li><b>Invariante 4:</b> Se um nó é vermelho, então ambos os seus filhos são pretos
 *       (não podem existir dois nós vermelhos consecutivos no caminho da raiz até uma folha).</li>
 *   <li><b>Invariante 5:</b> Para cada nó, todos os caminhos do nó até as folhas descendentes
 *       contêm o mesmo número de nós pretos (altura negra).</li>
 * </ul>
 *
 * <p>Essas propriedades garantem que a árvore permanece aproximadamente balanceada,
 * assegurando que operações de busca, inserção e remoção tenham complexidade O(log n)
 * no pior caso.</p>
 *
 * @param <T> o tipo dos elementos armazenados na árvore, que deve implementar
 *            a interface {@link Comparable} para permitir a ordenação
 *
 * @author Alysson M. Bruno <alysson.mb@unitins.br>
 * @version 1.0
 * @since 2025-10-25
 */
public interface IArvoreRubroNegra<T extends Comparable<T>> {
    /**
     * Insere um novo elemento na árvore rubro-negra, mantendo as propriedades
     * da árvore.
     *
     * <p><b>Pré-condições:</b></p>
     * <ul>
     *   <li>O elemento não pode ser nulo.</li>
     * </ul>
     *
     * <p><b>Pós-condições:</b></p>
     * <ul>
     *   <li>O elemento é inserido na posição correta de acordo com a ordenação.</li>
     *   <li>Todas as invariantes da árvore rubro-negra são mantidas.</li>
     *   <li>A raiz da árvore é sempre preta após a inserção.</li>
     *   <li>O tamanho da árvore aumenta em 1 se o elemento não existia anteriormente.</li>
     * </ul>
     *
     * <p><b>Complexidade:</b> O(log n) no pior caso, onde n é o número de elementos.</p>
     *
     * @param elemento o elemento a ser inserido na árvore
     * @throws IllegalArgumentException se o elemento for nulo
     */
    void inserir(T elemento);

    /**
     * Remove um elemento da árvore rubro-negra, mantendo as propriedades da árvore.
     *
     * <p><b>Pré-condições:</b></p>
     * <ul>
     *   <li>O elemento não pode ser nulo.</li>
     * </ul>
     *
     * <p><b>Pós-condições:</b></p>
     * <ul>
     *   <li>Se o elemento existir, ele é removido da árvore.</li>
     *   <li>Todas as invariantes da árvore rubro-negra são mantidas.</li>
     *   <li>O tamanho da árvore diminui em 1 se o elemento foi encontrado e removido.</li>
     *   <li>Se o elemento não existir, a árvore permanece inalterada.</li>
     * </ul>
     *
     * <p><b>Complexidade:</b> O(log n) no pior caso, onde n é o número de elementos.</p>
     *
     * @param elemento o elemento a ser removido da árvore
     * @return {@code true} se o elemento foi encontrado e removido, {@code false} caso contrário
     * @throws IllegalArgumentException se o elemento for nulo
     */
    boolean remover(T elemento);

    /**
     * Busca um elemento na árvore rubro-negra.
     *
     * <p><b>Pré-condições:</b></p>
     * <ul>
     *   <li>O elemento não pode ser nulo.</li>
     * </ul>
     *
     * <p><b>Pós-condições:</b></p>
     * <ul>
     *   <li>A árvore permanece inalterada.</li>
     *   <li>Retorna {@code true} se o elemento existe na árvore, {@code false} caso contrário.</li>
     * </ul>
     *
     * <p><b>Complexidade:</b> O(log n) no pior caso, onde n é o número de elementos.</p>
     *
     * @param elemento o elemento a ser buscado na árvore
     * @return {@code true} se o elemento está presente na árvore, {@code false} caso contrário
     * @throws IllegalArgumentException se o elemento for nulo
     */
    boolean buscar(T elemento);

    /**
     * Verifica se a árvore está vazia.
     *
     * <p><b>Pré-condições:</b></p>
     * <ul>
     *   <li>Nenhuma.</li>
     * </ul>
     *
     * <p><b>Pós-condições:</b></p>
     * <ul>
     *   <li>A árvore permanece inalterada.</li>
     *   <li>Retorna {@code true} se a árvore não contém elementos, {@code false} caso contrário.</li>
     * </ul>
     *
     * <p><b>Complexidade:</b> O(1).</p>
     *
     * @return {@code true} se a árvore está vazia, {@code false} caso contrário
     */
    boolean estaVazia();

    /**
     * Retorna o número de elementos armazenados na árvore.
     *
     * <p><b>Pré-condições:</b></p>
     * <ul>
     *   <li>Nenhuma.</li>
     * </ul>
     *
     * <p><b>Pós-condições:</b></p>
     * <ul>
     *   <li>A árvore permanece inalterada.</li>
     *   <li>Retorna um valor não negativo representando a quantidade de elementos.</li>
     * </ul>
     *
     * <p><b>Complexidade:</b> O(1).</p>
     *
     * @return o número de elementos na árvore
     */
    int tamanho();

    /**
     * Remove todos os elementos da árvore, deixando-a vazia.
     *
     * <p><b>Pré-condições:</b></p>
     * <ul>
     *   <li>Nenhuma.</li>
     * </ul>
     *
     * <p><b>Pós-condições:</b></p>
     * <ul>
     *   <li>A árvore fica vazia (tamanho = 0).</li>
     *   <li>Todas as invariantes da árvore rubro-negra são mantidas.</li>
     *   <li>A raiz torna-se o nó sentinela (TNULL).</li>
     * </ul>
     *
     * <p><b>Complexidade:</b> O(1).</p>
     */
    void limpar();

    /**
     * Retorna a altura da árvore (número de arestas no caminho mais longo da raiz até uma folha).
     *
     * <p><b>Pré-condições:</b></p>
     * <ul>
     *   <li>Nenhuma.</li>
     * </ul>
     *
     * <p><b>Pós-condições:</b></p>
     * <ul>
     *   <li>A árvore permanece inalterada.</li>
     *   <li>Retorna 0 se a árvore estiver vazia, caso contrário retorna a altura.</li>
     * </ul>
     *
     * <p><b>Complexidade:</b> O(n) no pior caso.</p>
     *
     * @return a altura da árvore
     */
    int altura();

    /**
     * Retorna o menor elemento armazenado na árvore.
     *
     * <p><b>Pré-condições:</b></p>
     * <ul>
     *   <li>A árvore não pode estar vazia.</li>
     * </ul>
     *
     * <p><b>Pós-condições:</b></p>
     * <ul>
     *   <li>A árvore permanece inalterada.</li>
     *   <li>Retorna o menor elemento de acordo com a ordenação natural.</li>
     * </ul>
     *
     * <p><b>Complexidade:</b> O(log n) no pior caso.</p>
     *
     * @return o menor elemento da árvore
     * @throws IllegalStateException se a árvore estiver vazia
     */
    T minimo();

    /**
     * Retorna o maior elemento armazenado na árvore.
     *
     * <p><b>Pré-condições:</b></p>
     * <ul>
     *   <li>A árvore não pode estar vazia.</li>
     * </ul>
     *
     * <p><b>Pós-condições:</b></p>
     * <ul>
     *   <li>A árvore permanece inalterada.</li>
     *   <li>Retorna o maior elemento de acordo com a ordenação natural.</li>
     * </ul>
     *
     * <p><b>Complexidade:</b> O(log n) no pior caso.</p>
     *
     * @return o maior elemento da árvore
     * @throws IllegalStateException se a árvore estiver vazia
     */
    T maximo();

    /**
     * Retorna uma lista com os elementos da árvore em ordem crescente (percurso em ordem).
     *
     * <p><b>Pré-condições:</b></p>
     * <ul>
     *   <li>Nenhuma.</li>
     * </ul>
     *
     * <p><b>Pós-condições:</b></p>
     * <ul>
     *   <li>A árvore permanece inalterada.</li>
     *   <li>Retorna uma lista contendo todos os elementos em ordem crescente.</li>
     *   <li>Se a árvore estiver vazia, retorna uma lista vazia.</li>
     * </ul>
     *
     * <p><b>Complexidade:</b> O(n), onde n é o número de elementos.</p>
     *
     * @return lista com os elementos em ordem crescente
     */
    List<T> emOrdem();

    /**
     * Imprime a estrutura visual da árvore no console, mostrando a hierarquia
     * dos nós e suas respectivas cores.
     *
     * <p><b>Pré-condições:</b></p>
     * <ul>
     *   <li>Nenhuma.</li>
     * </ul>
     *
     * <p><b>Pós-condições:</b></p>
     * <ul>
     *   <li>A árvore permanece inalterada.</li>
     *   <li>A representação visual da árvore é exibida no console.</li>
     * </ul>
     *
     * <p><b>Complexidade:</b> O(n), onde n é o número de elementos.</p>
     */
    void imprimirArvore();
}
