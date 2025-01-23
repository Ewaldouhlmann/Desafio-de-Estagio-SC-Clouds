from math import sqrt

def listar_primos(number: int) -> list[int]:
    """
        Função que encontra todos os números primos entre 1 e o número especificado (N).
    
        Args:
            number (int): O número até o qual os primos serão encontrados. Deve ser um número inteiro positivo.

        Returns:
            list[int]: Uma lista contendo todos os números primos entre 1 e o número especificado (inclusive).
        
        Exemplo:
            >>> encontrar_primos_entre_1_e_n(10)
            [2, 3, 5, 7]
    """
    # Validações iniciais do número
    try:
        validate_input(number)
    except (TypeError, ValueError) as e:
        return e
    
    # Inicializa a lista de primos vazia
    primos = []

    # Percorremos todos os números de 2 até o número especificado e retornamos os valores primos
    for i in range(2, number + 1):
        if is_prime(i):
            primos.append(i)
    return primos


def listar_primos_rec(number: int, primos: list[int]=[], current: int=2)-> list[int]:
    """
        Função recursiva que encontra todos os números primos entre 1 e o número especificado (N).

        Args:
            number (int): O número até o qual os primos serão encontrados.
            current (int): O número atual sendo verificado, sendo 2 o primeiro número a ser verificado.
            primos (list[int]): A lista de números primos encontrados até o momento, inicialmente vazia.
        
        Returns:
            list[int]: A lista de números primos encontrados até o número especificado.
    """
    # Validação inicial, com o valor padrão para o número atual
    if current == 2:
        try:
            validate_input(number)
        except (ValueError, TypeError) as e:
            return e
    
    # Se chegar a um valor maior que o número passado, retornamos a lista de valores primos encontrados
    if current > number:
        return primos
    
    # Se o valor atual for primo, adicionamos a lista de primos
    if is_prime(current):
        primos.append(current)

    # Chamada recursiva para o próximo número
    return listar_primos_rec(number, primos, current + 1)


def is_prime(number):
    """
        Verifica se um número é primo

        Args:
            number (int): O número a ser verificado.

        Returns:
            Bool: True se o número é primo, False caso contrário
    """
    if number == 2:
        return True
    # Verifica se o número é par, para ajudar na otimizar da verificação, já que números pares maiores que 2 não são primos (são divisiveis por 2)
    if number <= 1 or number % 2 == 0:
        return False
    
    # Percorre os números ímpares de forma decrescente, entre a raiz quadrada do número e 2, para verificar se o número é divisível por algum deles.
    for i in range(int(sqrt(number)),2,-2):
        if number % i == 0:
            return False
    return True

def validate_input(number: int):
    """
        Valida o número passado como entrada, garantindo que seja um número inteiro positivo.
        Retorna um erro caso a entrada seja inválida.
    """
    if not isinstance(number, int):
        raise TypeError("O número deve ser um número inteiro.")
    if number < 1:
        raise ValueError("O número deve ser um número inteiro positivo.")
    
if __name__ == "__main__":
    # Valores inválidos
    print(listar_primos(0)) 
    print(listar_primos('a'))

    # Realizando testes
    print(listar_primos(1)) 
    print(listar_primos_rec(1))
    print(listar_primos_rec(100))
    print(listar_primos(100))
        
    