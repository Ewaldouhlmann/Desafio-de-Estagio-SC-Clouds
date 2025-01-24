public class Fibonacci {

    /**
     * Calcula o número na posição especificada da série de Fibonacci de forma iterativa.
     *
     * @param number A posição na série de Fibonacci (deve ser um inteiro não negativo).
     * @return O número correspondente na posição especificada da série de Fibonacci.
     * @throws IllegalArgumentException Se a entrada for um número negativo.
     */
    public static int fibonacciIterative(int number) {
        validateFibonacciInput(number);

        if (number == 0) {
            return 0;
        } else if (number == 1) {
            return 1;
        } else {
            int prev = 0, curr = 1;
            for (int i = 2; i <= number; i++) {
                int next = prev + curr;
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
    public static int fibonacciRecursive(int number) {
        validateFibonacciInput(number);

        if (number == 0) {
            return 0;
        } else if (number == 1) {
            return 1;
        } else {
            return fibonacciRecursive(number - 1) + fibonacciRecursive(number - 2);
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
        try {
            // Testes com entradas inválidas
            System.out.println(fibonacciIterative(-1)); // Deve lançar exceção
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println(fibonacciRecursive(-1)); // Deve lançar exceção
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // Testes com entradas válidas
        System.out.println(fibonacciIterative(0));  // 0
        System.out.println(fibonacciRecursive(1)); // 1
        System.out.println(fibonacciIterative(5)); // 5
        System.out.println(fibonacciRecursive(5)); // 5
        System.out.println(fibonacciIterative(10)); // 55
        System.out.println(fibonacciRecursive(10)); // 55
    }
}