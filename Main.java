/**
 * Classe principal para testar a implementação da Árvore Rubro-Negra.
 *
 * <p>Esta classe demonstra o uso completo da estrutura de dados Árvore Rubro-Negra,
 * testando operações de inserção, busca, remoção, percursos e outras funcionalidades.</p>
 *
 * @author Alysson M. Bruno <alysson.mb@unitins.br>
 * @version 1.0
 * @since 2025-10-25
 */
public class Main {

    /**
     * Método principal que executa os testes da Árvore Rubro-Negra.
     *
     * @param args argumentos da linha de comando (não utilizados)
     */
    public static void main(String[] args) {
        // ==========================================
        // Teste 1: Operações Básicas com Integer
        // ==========================================
        System.out.println("========================================");
        System.out.println("TESTE 1: OPERAÇÕES BÁSICAS COM INTEGERS");
        System.out.println("========================================\n");

        ArvoreRubroNegra<Integer> arvoreInt = new ArvoreRubroNegra<>();

        System.out.println("Inserindo elementos: 10, 20, 30, 40, 50, 60");
        arvoreInt.inserir(10);
        arvoreInt.inserir(20);
        arvoreInt.inserir(30);
        arvoreInt.inserir(40);
        arvoreInt.inserir(50);
        arvoreInt.inserir(60);

        arvoreInt.imprimirArvore();

        System.out.println("Tamanho da árvore: " + arvoreInt.tamanho());
        System.out.println("Altura da árvore: " + arvoreInt.altura());
        System.out.println("Menor elemento: " + arvoreInt.minimo());
        System.out.println("Maior elemento: " + arvoreInt.maximo());
        System.out.println();

        // ==========================================
        // Teste 2: Operações de Busca
        // ==========================================
        System.out.println("========================================");
        System.out.println("TESTE 2: OPERAÇÕES DE BUSCA");
        System.out.println("========================================\n");

        System.out.println("Buscando elemento 30: " + arvoreInt.buscar(30));
        System.out.println("Buscando elemento 25: " + arvoreInt.buscar(25));
        System.out.println("Buscando elemento 60: " + arvoreInt.buscar(60));
        System.out.println("Buscando elemento 100: " + arvoreInt.buscar(100));
        System.out.println();

        // ==========================================
        // Teste 3: Percursos
        // ==========================================
        System.out.println("========================================");
        System.out.println("TESTE 3: PERCURSOS DA ÁRVORE");
        System.out.println("========================================\n");

        System.out.println("Percurso em ordem: " + arvoreInt.emOrdem());
        System.out.println("Percurso pré-ordem: " + arvoreInt.preOrdem());
        System.out.println("Percurso pós-ordem: " + arvoreInt.posOrdem());
        System.out.println();

        // ==========================================
        // Teste 4: Operações de Remoção
        // ==========================================
        System.out.println("========================================");
        System.out.println("TESTE 4: OPERAÇÕES DE REMOÇÃO");
        System.out.println("========================================\n");

        System.out.println("Removendo elemento 20: " + arvoreInt.remover(20));
        arvoreInt.imprimirArvore();
        System.out.println("Tamanho após remoção: " + arvoreInt.tamanho());
        System.out.println();

        System.out.println("Removendo elemento 40: " + arvoreInt.remover(40));
        arvoreInt.imprimirArvore();
        System.out.println("Tamanho após remoção: " + arvoreInt.tamanho());
        System.out.println();

        System.out.println("Tentando remover elemento inexistente (100): " + arvoreInt.remover(100));
        System.out.println();

        // ==========================================
        // Teste 5: Árvore com Strings
        // ==========================================
        System.out.println("========================================");
        System.out.println("TESTE 5: ÁRVORE COM STRINGS");
        System.out.println("========================================\n");

        ArvoreRubroNegra<String> arvoreStr = new ArvoreRubroNegra<>();

        System.out.println("Inserindo frutas...");
        arvoreStr.inserir("Maçã");
        arvoreStr.inserir("Banana");
        arvoreStr.inserir("Laranja");
        arvoreStr.inserir("Uva");
        arvoreStr.inserir("Abacaxi");
        arvoreStr.inserir("Pera");

        arvoreStr.imprimirArvore();

        System.out.println("Percurso em ordem (ordenação alfabética): " + arvoreStr.emOrdem());
        System.out.println("Menor elemento (alfabeticamente): " + arvoreStr.minimo());
        System.out.println("Maior elemento (alfabeticamente): " + arvoreStr.maximo());
        System.out.println();

        System.out.println("Removendo 'Banana'...");
        arvoreStr.remover("Banana");
        arvoreStr.imprimirArvore();

        // ==========================================
        // Teste 6: Verificações de Estado
        // ==========================================
        System.out.println("========================================");
        System.out.println("TESTE 6: VERIFICAÇÕES DE ESTADO");
        System.out.println("========================================\n");

        ArvoreRubroNegra<Double> arvoreDouble = new ArvoreRubroNegra<>();
        System.out.println("Árvore vazia? " + arvoreDouble.estaVazia());
        System.out.println("Tamanho: " + arvoreDouble.tamanho());

        arvoreDouble.inserir(10.5);
        arvoreDouble.inserir(5.2);
        arvoreDouble.inserir(15.7);

        System.out.println("\nApós inserir 3 elementos:");
        System.out.println("Árvore vazia? " + arvoreDouble.estaVazia());
        System.out.println("Tamanho: " + arvoreDouble.tamanho());
        arvoreDouble.imprimirArvore();

        System.out.println("Limpando árvore...");
        arvoreDouble.limpar();
        System.out.println("Árvore vazia? " + arvoreDouble.estaVazia());
        System.out.println("Tamanho: " + arvoreDouble.tamanho());
        System.out.println();

        // ==========================================
        // Teste 7: Validação de Entrada
        // ==========================================
        System.out.println("========================================");
        System.out.println("TESTE 7: VALIDAÇÃO DE ENTRADA");
        System.out.println("========================================\n");

        ArvoreRubroNegra<Integer> arvoreValidacao = new ArvoreRubroNegra<>();

        try {
            System.out.println("Tentando inserir elemento nulo...");
            arvoreValidacao.inserir(null);
        } catch (IllegalArgumentException e) {
            System.out.println("Exceção capturada: " + e.getMessage());
        }

        try {
            System.out.println("Tentando buscar elemento nulo...");
            arvoreValidacao.buscar(null);
        } catch (IllegalArgumentException e) {
            System.out.println("Exceção capturada: " + e.getMessage());
        }

        try {
            System.out.println("Tentando remover elemento nulo...");
            arvoreValidacao.remover(null);
        } catch (IllegalArgumentException e) {
            System.out.println("Exceção capturada: " + e.getMessage());
        }
        System.out.println();

        // ==========================================
        // Teste 8: Teste de Stress com Muitos Elementos
        // ==========================================
        System.out.println("========================================");
        System.out.println("TESTE 8: TESTE DE STRESS");
        System.out.println("========================================\n");

        ArvoreRubroNegra<Integer> arvoreStress = new ArvoreRubroNegra<>();

        System.out.println("Inserindo 100 elementos...");
        for (int i = 1; i <= 100; i++) {
            arvoreStress.inserir(i);
        }

        System.out.println("Tamanho: " + arvoreStress.tamanho());
        System.out.println("Altura: " + arvoreStress.altura());
        System.out.println("Menor: " + arvoreStress.minimo());
        System.out.println("Maior: " + arvoreStress.maximo());

        System.out.println("\nBuscando alguns elementos:");
        System.out.println("Buscar 1: " + arvoreStress.buscar(1));
        System.out.println("Buscar 50: " + arvoreStress.buscar(50));
        System.out.println("Buscar 100: " + arvoreStress.buscar(100));
        System.out.println("Buscar 101: " + arvoreStress.buscar(101));

        System.out.println("\nRemovendo 50 elementos...");
        for (int i = 1; i <= 50; i++) {
            arvoreStress.remover(i);
        }

        System.out.println("Tamanho após remoções: " + arvoreStress.tamanho());
        System.out.println("Altura após remoções: " + arvoreStress.altura());
        System.out.println("Novo menor: " + arvoreStress.minimo());
        System.out.println("Maior: " + arvoreStress.maximo());

        System.out.println("\n========================================");
        System.out.println("TODOS OS TESTES CONCLUÍDOS COM SUCESSO!");
        System.out.println("========================================");
    }
}
