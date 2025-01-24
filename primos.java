import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Primos {

    /**
     * Lista todos os números primos entre 1 e o número especificado (incluso).
     *
     * @param number O número até o qual os primos serão encontrados (deve ser positivo).
     * @return Uma lista contendo todos os números primos entre 1 e o número especificado.
     */
    public static List<Long> listarPrimos(long number) {
        // Retorna lista vazia se o número for menor que 1
        if (number < 1) {
            return new ArrayList<>();
        }
        
        // Inicia a lista de primos vazia, e itera por todos os valores de 2 a n procurando por primos
        List<Long> primos = new ArrayList<>();
        for (long i = 2; i <= number; i++) {
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
    public static List<Long> iniciarListagemPrimosRec(long number) {
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
    public static List<Long> listarPrimosRec(long number, List<Long> primos, long current) {
        // Verifica se o número atual ultrapassou o limite
        if (current > number) {
            return primos;
        }
    
        // Se o número é primo, adiciona à lista
        if (isPrime(current)) {
            primos.add(current);
        }
    
        // Chama recursivamente para o próximo número
        return listarPrimosRec(number, primos, current + 1);
    }

    /**
     * Verifica se um número é primo.
     *
     * @param number O número a ser verificado.
     * @return `true` se o número for primo, caso contrário `false`.
     */
    public static boolean isPrime(long number) {
        // Caso o número seja par e não for 2 retorna False (2 é o único par primo)
        if (number == 2) return true;
        if (number <= 1 || number % 2 == 0) return false;
        
        // Caso o número seja impar, verifica se  algum valor divide ele
        long limit = (long) Math.sqrt(number);
        for (long i = 3; i <= limit; i += 2) {
            if (number % i == 0) return false;
        }
        return true;
    }
    

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // Solicita ao usuário o valor até o qual ele deseja encontrar os números primos.
            System.out.println("Digite um número para listar os primos até esse valor:");
            long numero = scanner.nextLong();

            // Testando valores válidos com entrada do usuário
            System.out.println("Primos até " + numero + " (versão iterativa):");
            System.out.println(listarPrimos(numero)); 

            // Testando a função recursiva com inicialização separada
            System.out.println("Primos até " + numero + " (versão recursiva):");
            System.out.println(iniciarListagemPrimosRec(numero));
        }  catch (Exception e) {
            System.out.println("Erro ao ler entrada do usuário: " + e.getMessage());
        }
    }
}
