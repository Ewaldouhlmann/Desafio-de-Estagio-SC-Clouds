import java.util.Scanner;
import java.util.HashMap;

public class Fibonacci {

    // Mapa para armazenar os resultados já calculados
    private static HashMap<Integer, Long> memo = new HashMap<>();

    /**
     * Calcula o número na posição especificada da série de Fibonacci de forma iterativa.
     *
     * @param number A posição na série de Fibonacci (deve ser um inteiro não negativo).
     * @return O número correspondente na posição especificada da série de Fibonacci.
     * @throws IllegalArgumentException Se a entrada for um número negativo.
     */
    public static long fibonacciIterative(int number) {
        validateFibonacciInput(number);
        // Caso Base (numero = 0 ou numero = 1)
        if (number == 0) {
            return 0;
        } else if (number == 1) {
            return 1;
        } else {
            // Caso n > 1

            // Para lidar com valores grandes
            long prev = 0, curr = 1;

            // Iteração para calcular o número na posição especificada
            for (int i = 2; i <= number; i++) {
                long next = prev + curr;
                prev = curr;
                curr = next;
            }
            return curr;
        }
    }

    /**
     * Calcula o número na posição especificada da série de Fibonacci de forma recursiva.
     *
     * @param number A posição na série de Fibonacci (deve ser um inteiro não negativo).
     * @return O número correspondente na posição especificada da série de Fibonacci.
     * @throws IllegalArgumentException Se a entrada for um número negativo.
     */
    public static long fibonacciRecursive(int number) {
        validateFibonacciInput(number);

        // Se já foi calculado, retorna o resultado armazenado
        if (memo.containsKey(number)) {
            return memo.get(number);
        }

        // Caso base, n = 0 ou n = 1
        if (number == 0) {
            return 0;
        } else if (number == 1) {
            return 1;
        } else {
            // Caso n > 1, realiza chamadas recursivas até achar o resultado
            long result = fibonacciRecursive(number - 1) + fibonacciRecursive(number - 2);
            // Armazena o resultado calculado no mapa de memorização
            memo.put(number, result);
            return result;
        }
    }

    /**
     * Valida se a entrada é um inteiro não negativo.
     *
     * @param number O número a ser validado.
     * @throws IllegalArgumentException Se o número não for um inteiro não negativo.
     */
    private static void validateFibonacciInput(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("A entrada deve ser um número inteiro não negativo.");
        }
    }

    public static void main(String[] args) {
        // Testes com entradas inválidas
        try {
            System.out.println(fibonacciIterative(-1)); 
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println(fibonacciRecursive(-1)); 
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // Testes com entradas válidas
        System.out.println(fibonacciIterative(0)); 
        System.out.println(fibonacciRecursive(1)); 
        System.out.println(fibonacciIterative(5));
        System.out.println(fibonacciRecursive(5)); 
        System.out.println(fibonacciIterative(10));
        System.out.println(fibonacciRecursive(10)); 

        // Teste para calcular os números de Fibonacci, recebendo um número de entrada do usuário e tratando
        // exceções de argumentos inválidos
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Digite um número inteiro para calcular o valor de Fibonacci correspondente: ");

            int userNumber = scanner.nextInt();
            try {
                System.out.println(fibonacciIterative(userNumber));
                System.out.println(fibonacciRecursive(userNumber));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }


    }
}