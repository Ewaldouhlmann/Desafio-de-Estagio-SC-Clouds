import java.util.ArrayList;
import java.util.List;

public class Primos {

    /**
     * Lista todos os números primos entre 1 e o número especificado (inclusivo).
     *
     * @param number O número até o qual os primos serão encontrados (deve ser positivo).
     * @return Uma lista contendo todos os números primos entre 1 e o número especificado.
     * @throws IllegalArgumentException Se o número for menor que 1.
     */
    public static List<Integer> listarPrimos(int number) {
        validateInput(number);
        List<Integer> primos = new ArrayList<>();
        for (int i = 2; i <= number; i++) {
            if (isPrime(i)) {
                primos.add(i);
            }
        }
        return primos;
    }

    /**
     * Lista todos os números primos entre 1 e o número especificado (inclusivo) de forma recursiva.
     *
     * @param number O número até o qual os primos serão encontrados (deve ser positivo).
     * @param primos A lista de números primos encontrados até agora.
     * @param current O número atual sendo verificado (começa em 2).
     * @return Uma lista contendo todos os números primos entre 1 e o número especificado.
     * @throws IllegalArgumentException Se o número for menor que 1.
     */
    public static List<Integer> listarPrimosRec(int number, List<Integer> primos, int current) {
        if (current == 2) {
            validateInput(number);
        }

        // Caso base: se o número atual ultrapassar o limite, retorna a lista.
        if (current > number) {
            return primos;
        }

        // Adiciona à lista se for primo.
        if (isPrime(current)) {
            primos.add(current);
        }

        // Chamada recursiva para o próximo número.
        return listarPrimosRec(number, primos, current + 1);
    }

    /**
     * Verifica se um número é primo.
     *
     * @param number O número a ser verificado.
     * @return `true` se o número for primo, caso contrário `false`.
     */
    public static boolean isPrime(int number) {
        if (number == 2) return true;
        if (number <= 1 || number % 2 == 0) return false;

        // Verifica divisores entre 2 e a raiz quadrada do número.
        int limit = (int) Math.sqrt(number);
        for (int i = 3; i <= limit; i += 2) {
            if (number % i == 0) return false;
        }
        return true;
    }

    /**
     * Valida se o número fornecido é um inteiro positivo.
     *
     * @param number O número a ser validado.
     * @throws IllegalArgumentException Se o número não for um inteiro positivo.
     */
    public static void validateInput(int number) {
        if (number < 1) {
            throw new IllegalArgumentException("O número deve ser um inteiro positivo.");
        }
    }

    public static void main(String[] args) {
        // Testando valores inválidos
        try {
            System.out.println(listarPrimos(0));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println(listarPrimos(-10));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // Testando a função iterativa
        System.out.println(listarPrimos(10)); // [2, 3, 5, 7]

        // Testando a função recursiva
        System.out.println(listarPrimosRec(10, new ArrayList<>(), 2)); // [2, 3, 5, 7]
    }
}
