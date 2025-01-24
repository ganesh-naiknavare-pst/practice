def is_palindrome(string: str) -> bool:
    clean = ''.join(char.lower() for char in string if char.isalnum())
    return clean == clean[::-1]

def factorial(n: int) -> int:
    if n < 0:
        raise ValueError("Negative numbers not allowed")
    if n <= 1:
        return 1
    return n * factorial(n - 1)

def array_to_list(array: tuple) -> list:
    return list(array)

def find_max(array: list) -> any:
    if not array:
        raise ValueError("Array cannot be empty or None")
    return max(array)

def is_prime(number: int) -> bool:
    if number <= 1:
        return False
    return all(number % i != 0 for i in range(2, int(number ** 0.5) + 1))

def reverse_string(string: str) -> str:
    return string[::-1]

def power(base: float, exponent: int) -> float:
    if exponent == 0:
        return 1
    if exponent < 0:
        return 1 / power(base, -exponent)
    result = 1
    for _ in range(exponent):
        result *= base
    return result

def gcd(a: int, b: int) -> int:
    while b:
        a, b = b, a % b
    return a

def is_leap_year(year: int) -> bool:
    return year % 4 == 0 and (year % 100 != 0 or year % 400 == 0)

def calculate_average(numbers: list) -> float:
    if not numbers:
        raise ValueError("Array cannot be empty or None")
    return sum(numbers) / len(numbers)
