import java.util.Scanner;
import java.util.HashMap;
import java.math.BigInteger;

public class Fibonacci {

    // Mapa para armazenar os resultados já calculados com Long como chave e BigInteger como valor
    private static HashMap<Long, BigInteger> memo = new HashMap<>();

    /**
     * Calcula o número na posição especificada da série de Fibonacci de forma iterativa.
     *
     * @param number A posição na série de Fibonacci (deve ser um inteiro não negativo).
     * @return O número correspondente na posição especificada da série de Fibonacci.
     * @throws IllegalArgumentException Se a entrada for um número negativo.
     */
    public static BigInteger fibonacciIterative(long number) {
        // Validando a entrada do número
        validateFibonacciInput(number);

        // Caso Base (numero = 0 ou numero = 1)
        if (number == 0) {
            return BigInteger.ZERO;
        } else if (number == 1) {
            return BigInteger.ONE;
        } else {
            // Caso n > 1, declarando variaveis prev e curr como BigInteger para lidar com valores muito grandes
            BigInteger prev = BigInteger.ZERO, curr = BigInteger.ONE;

            // Iterando cada valor até chegar ao 
            for (long i = 2; i <= number; i++) {
                BigInteger next = prev.add(curr);
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
    public static BigInteger fibonacciRecursive(long number) {
        validateFibonacciInput(number);

        // Se já foi calculado, retorna o resultado armazenado
        if (memo.containsKey(number)) {
            return memo.get(number);
        }

        // Caso base, n = 0 ou n = 1
        if (number == 0) {
            return BigInteger.ZERO;
        } else if (number == 1) {
            return BigInteger.ONE;
        } else {
            // Caso n > 1, realiza chamadas recursivas até achar o resultado
            BigInteger result = fibonacciRecursive(number - 1).add(fibonacciRecursive(number - 2));
            
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
    private static void validateFibonacciInput(long number) {
        if (number < 0) {
            throw new IllegalArgumentException("A entrada deve ser um número inteiro não negativo.");
        }
    }

    public static void main(String[] args) {
        // Teste para calcular os números de Fibonacci, recebendo um número de entrada do usuário e tratando
        // exceções de argumentos inválidos
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Digite um número inteiro para calcular o valor de Fibonacci correspondente: ");

            long userNumber = scanner.nextLong();
            try {
                System.out.println("Fibonacci Iterativa: " + fibonacciIterative(userNumber));
                System.out.println("Fibonacci Recursiva: " + fibonacciRecursive(userNumber));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}