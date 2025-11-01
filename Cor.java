/**
 * Enumeração que define as cores possíveis para os nós de uma Árvore Rubro-Negra.
 *
 * <p>Na estrutura de dados Árvore Rubro-Negra, cada nó possui uma cor que pode ser
 * vermelha ou preta. Essas cores são essenciais para manter as propriedades de
 * balanceamento da árvore durante operações de inserção e remoção.</p>
 *
 * @author Alysson M. Bruno <alysson.mb@unitins.br>
 * @version 1.0
 * @since 2025-10-25
 */
public enum Cor {
    /**
     * Representa a cor vermelha de um nó.
     * <p>Nós vermelhos não podem ter filhos vermelhos (propriedade 4 das Árvores Rubro-Negras).</p>
     */
    VERMELHO,

    /**
     * Representa a cor preta de um nó.
     * <p>A raiz e todas as folhas (nós sentinela) devem ser pretas.</p>
     */
    PRETO,
}
