public boolean isPalindrome(String str) {
    String clean = str.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
    int left = 0;
    int right = clean.length() - 1;
    
    while (left < right) {
        if (clean.charAt(left) != clean.charAt(right)) {
            return false;
        }
        left++;
        right--;
    }
    return true;
}

public long factorial(int n) {
    if (n < 0) throw new IllegalArgumentException("Negative numbers not allowed");
    if (n <= 1) return 1;
    return n * factorial(n - 1);
}

public <T> ArrayList<T> arrayToList(T[] array) {
    return new ArrayList<>(Arrays.asList(array));
}

public <T extends Comparable<T>> T findMax(T[] array) {
    if (array == null || array.length == 0) {
        throw new IllegalArgumentException("Array cannot be empty or null");
    }
    
    T max = array[0];
    for (T element : array) {
        if (element.compareTo(max) > 0) {
            max = element;
        }
    }
    return max;
}

public boolean isPrime(int number) {
    if (number <= 1) return false;
    for (int i = 2; i <= Math.sqrt(number); i++) {
        if (number % i == 0) return false;
    }
    return true;
}

public String reverseString(String str) {
    return new StringBuilder(str).reverse().toString();
}

public double power(double base, int exponent) {
    if (exponent == 0) return 1;
    if (exponent < 0) {
        return 1 / power(base, -exponent);
    }
    double result = 1;
    for (int i = 0; i < exponent; i++) {
        result *= base;
    }
    return result;
}

public int gcd(int a, int b) {
    while (b != 0) {
        int temp = b;
        b = a % b;
        a = temp;
    }
    return a;
}

public boolean isLeapYear(int year) {
    return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
}

public double calculateAverage(double[] numbers) {
    if (numbers == null || numbers.length == 0) {
        throw new IllegalArgumentException("Array cannot be empty or null");
    }
    
    double sum = 0;
    for (double num : numbers) {
        sum += num;
    }
    return sum / numbers.length;
}