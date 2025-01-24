// 1. Check if a string is a palindrome
const isPalindrome = (str) => {
    const clean = str.toLowerCase().replace(/[^a-zA-Z0-9]/g, '');
    return clean === clean.split('').reverse().join('');
};

// 2. Find the factorial of a number
const factorial = (n) => {
    if (n < 0) {
        throw new Error("Negative numbers not allowed");
    }
    if (n <= 1) return 1;
    return n * factorial(n - 1);
};

// 3. Convert array-like object to array
const arrayToList = (arrayLike) => {
    return Array.from(arrayLike);
};

// 4. Find the maximum element in an array
const findMax = (array) => {
    if (!array || array.length === 0) {
        throw new Error("Array cannot be empty or null");
    }
    return Math.max(...array);
};

// 5. Check if a number is prime
const isPrime = (number) => {
    if (number <= 1) return false;
    for (let i = 2; i <= Math.sqrt(number); i++) {
        if (number % i === 0) return false;
    }
    return true;
};

// 6. Reverse a string
const reverseString = (str) => {
    return str.split('').reverse().join('');
};

// 7. Calculate the power of a number
const power = (base, exponent) => {
    if (exponent === 0) return 1;
    if (exponent < 0) {
        return 1 / power(base, -exponent);
    }
    let result = 1;
    for (let i = 0; i < exponent; i++) {
        result *= base;
    }
    return result;
};

// 8. Find GCD (Greatest Common Divisor)
const gcd = (a, b) => {
    while (b !== 0) {
        let temp = b;
        b = a % b;
        a = temp;
    }
    return a;
};

// 9. Check if year is leap year
const isLeapYear = (year) => {
    return year % 4 === 0 && (year % 100 !== 0 || year % 400 === 0);
};

// 10. Calculate average of array
const calculateAverage = (numbers) => {
    if (!numbers || numbers.length === 0) {
        throw new Error("Array cannot be empty or null");
    }
    return numbers.reduce((sum, num) => sum + num, 0) / numbers.length;
};

// Example usage with error handling
try {
    // Test palindrome
    console.log(isPalindrome("A man, a plan, a canal: Panama")); // true

    // Test factorial
    console.log(factorial(5)); // 120

    // Test array to list
    console.log(arrayToList("123")); // ['1', '2', '3']

    // Test find max
    console.log(findMax([1, 5, 3, 9, 2])); // 9

    // Test prime
    console.log(isPrime(17)); // true

    // Test reverse string
    console.log(reverseString("hello")); // "olleh"

    // Test power
    console.log(power(2, 3)); // 8

    // Test GCD
    console.log(gcd(48, 18)); // 6

    // Test leap year
    console.log(isLeapYear(2024)); // true

    // Test average
    console.log(calculateAverage([1, 2, 3, 4,