<?php

// 1. Check if a string is a palindrome
function isPalindrome(string $str): bool {
    $clean = preg_replace("/[^a-zA-Z0-9]/", "", strtolower($str));
    return $clean === strrev($clean);
}

// 2. Find the factorial of a number
function factorial(int $n): int {
    if ($n < 0) {
        throw new InvalidArgumentException("Negative numbers not allowed");
    }
    if ($n <= 1) {
        return 1;
    }
    return $n * factorial($n - 1);
}

// 3. Convert array to list (In PHP arrays are already list-like)
function arrayToList(array $array): array {
    return array_values($array);
}

// 4. Find the maximum element in an array
function findMax(array $array) {
    if (empty($array)) {
        throw new InvalidArgumentException("Array cannot be empty");
    }
    return max($array);
}

// 5. Check if a number is prime
function isPrime(int $number): bool {
    if ($number <= 1) {
        return false;
    }
    for ($i = 2; $i <= sqrt($number); $i++) {
        if ($number % $i === 0) {
            return false;
        }
    }
    return true;
}

// 6. Reverse a string
function reverseString(string $str): string {
    return strrev($str);
}

// 7. Calculate the power of a number
function power(float $base, int $exponent): float {
    if ($exponent === 0) {
        return 1;
    }
    if ($exponent < 0) {
        return 1 / power($base, -$exponent);
    }
    $result = 1;
    for ($i = 0; $i < $exponent; $i++) {
        $result *= $base;
    }
    return $result;
}

// 8. Find GCD (Greatest Common Divisor)
function gcd(int $a, int $b): int {
    while ($b !== 0) {
        $temp = $b;
        $b = $a % $b;
        $a = $temp;
    }
    return $a;
}

// 9. Check if year is leap year
function isLeapYear(int $year): bool {
    return $year % 4 === 0 && ($year % 100 !== 0 || $year % 400 === 0);
}

// 10. Calculate average of array
function calculateAverage(array $numbers): float {
    if (empty($numbers)) {
        throw new InvalidArgumentException("Array cannot be empty");
    }
    return array_sum($numbers) / count($numbers);
}

// Example usage:
try {
    // Test palindrome
    var_dump(isPalindrome("A man, a plan, a canal: Panama")); // bool(true)
    
    // Test factorial
    var_dump(factorial(5)); // int(120)
    
    // Test array to list
    var_dump(arrayToList(['a' => 1, 'b' => 2, 'c' => 3])); // array(1, 2, 3)
    
    // Test find max
    var_dump(findMax([1, 5, 3, 9, 2])); // int(9)
    
    // Test prime
    var_dump(isPrime(17)); // bool(true)
    
    // Test reverse string
    var_dump(reverseString("hello")); // string(5) "olleh"
    
    // Test power
    var_dump(power(2, 3)); // float(8)
    
    // Test GCD
    var_dump(gcd(48, 18)); // int(6)
    
    // Test leap year
    var_dump(isLeapYear(2024)); // bool(true)
    
    // Test average
    var_dump(calculateAverage([1, 2, 3, 4, 5])); // float(3)
    
} catch (Exception $e) {
    echo "Error: " . $e->getMessage();
}