def fibonacci(number: int) -> int:
    """
    Essa função calcula o número na posição especificada da série de Fibonacci de forma não recursiva.

    Args:
        number (int): A posição na série de Fibonacci (deve ser um inteiro não negativo).
    
    Returns:
        int: O número correspondente na posição especificada da série de Fibonacci.
    
    Raises:
        TypeError: Se a entrada não for um número inteiro.
        ValueError: Se a entrada for um número negativo.
    """
    try:
        validate_fibonacci_input(number)
        
        # Caso Base, quando o número for 0 ou 1 o valor de fibonacci será o próprio número
        if number == 0:
            return 0
        elif number == 1:
            return 1
        else:
            # Caso n > 1, o valor de fibonacci será a soma dos dois valores anteriores
            prev, curr = 0, 1
            for i in range(2, number + 1):
                prev, curr = curr, prev + curr
            return curr
    except (TypeError, ValueError) as e:
        return e


def fibonacci_rec(number: int) -> int:
    """
    Essa função calcula o número na posição especificada da série de Fibonacci de forma recursiva.

    Args:
        number (int): A posição na série de Fibonacci (deve ser um inteiro não negativo).
    
    Returns:
        int: O número correspondente na posição especificada da série de Fibonacci.
    
    Raises:
        TypeError: Se a entrada não for um número inteiro.
        ValueError: Se a entrada for um número negativo.
    """
    try:
        validate_fibonacci_input(number)
        # Caso Base
        if number == 0:
            return 0
        elif number == 1:
            return 1
        # Chamada recursiva da função
        else:
            return fibonacci_rec(number - 1) + fibonacci_rec(number - 2)
    except (TypeError, ValueError) as e:
        return e

def validate_fibonacci_input(number: int) -> bool:
    """
    Função auxiliar para validar se o número é um inteiro não negativo, para ser usado nas funções de Fibonacci.

    Args:
        number (int): O número a ser validado.
    
    Returns:
        bool: Verdadeiro se o número for um inteiro não negativo, falso caso contrário.

    Raises:
        TypeError: Se a entrada não for um número inteiro.
        ValueError: Se a entrada for um número negativo.
    """
    # Validando se é do tipo inteiro
    if not isinstance(number, int):
        raise TypeError("A entrada deve ser um número inteiro.")
    
    # Validando se é não negativo
    if number < 0:
        raise ValueError("A entrada deve ser um número não negativo.")

if __name__ == "__main__":
    # Testando a função
    print(fibonacci('a')) 
    print(fibonacci(-1))
    print(fibonacci(0))
    print(fibonacci_rec(1))
    print(fibonacci_rec(5))
    print(fibonacci(5)) 
    print(fibonacci(10))
    print(fibonacci_rec(10))
