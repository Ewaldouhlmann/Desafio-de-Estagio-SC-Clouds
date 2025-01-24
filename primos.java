import java.util.ArrayList;
import java.util.List;

public class Primos {

    /**
     * Lista todos os números primos entre 1 e o número especificado (incluso).
     *
     * @param number O número até o qual os primos serão encontrados (deve ser positivo).
     * @return Uma lista contendo todos os números primos entre 1 e o número especificado.
     */
    public static List<Integer> listarPrimos(int number) {
        // Retorna lista vazia se o número for menor que 1
        if (number < 1) {
            return new ArrayList<>();
        }
        
        // Inicia a lista de primos vazia, e itera por todos os valores de 2 a n procurando por primos
        List<Integer> primos = new ArrayList<>();
        for (int i = 2; i <= number; i++) {
            if (isPrime(i)) {
                primos.add(i);
            }
        }
        return primos;
    }

    /**
     * Função que inicializa as variáveis necessárias e chama a função recursiva que encontra os primos menores ou iguais a n
     *
     * @param number O número até o qual os primos serão encontrados (deve ser positivo).
     * @return Uma lista contendo todos os números primos entre 1 e o número especificado.
     */
    public static List<Integer> iniciarListagemPrimosRec(int number) {
        // Inicializa a lista de primos vazia e com o numero atual sendo igual a 2
        return listarPrimosRec(number, new ArrayList<>(), 2); 
    }

    /**
     * Lista todos os números primos entre 1 e o número especificado (incluso) de forma recursiva.
     *
     * @param number O número até o qual os primos serão encontrados (deve ser positivo).
     * @param primos A lista de números primos encontrados até agora.
     * @param current O número atual sendo verificado (começa em 2).
     * @return Uma lista contendo todos os números primos entre 1 e o número especificado.
     */
    public static List<Integer> listarPrimosRec(int number, List<Integer> primos, int current) {
        // Retorna lista vazia se o número for menor que 1
        if (number < 1) {
            return primos; 
        }

        // Se o número atual ultrapassar o limite, retorna a lista.
        if (current > number) {
            return primos;
        }

        // Adiciona à lista se for primo
        if (isPrime(current)) {
            primos.add(current);
        }

        // Chama recursivamente para o próximo número da sequência
        return listarPrimosRec(number, primos, current + 1);
    }

    /**
     * Verifica se um número é primo.
     *
     * @param number O número a ser verificado.
     * @return `true` se o número for primo, caso contrário `false`.
     */
    public static boolean isPrime(int number) {
        // 2 é único número primo par, retorna true para 2 e false para outros pares
        if (number == 2) return true;
        if (number <= 1 || number % 2 == 0) return false;

        // Itera sobre os impares entre a raiz do numero atual e 3, verificando se o número em questão é divisivel por algum deles
        // Retornando false se algum número entre o intervalo dividir o número atual
        int limit = (int) Math.sqrt(number);
        for (int i = 3; i <= limit; i += 2) {
            if (number % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        // Testando valores inválidos
        System.out.println(listarPrimos(0)); 
        System.out.println(listarPrimos(-10)); 

        // Testando a função iterativa
        System.out.println(listarPrimos(100)); 

        // Testando a função recursiva com inicialização separada
        System.out.println(iniciarListagemPrimosRec(100)); 
    }
}
