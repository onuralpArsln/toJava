public class ExponentialTimeExample {
    public static int fibonacci(int n) {
        if (n <= 1)
            return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        int n = 7;
        System.out.println("Fibonacci of " + 7 + " is " + fibonacci(7));
    }
}

// fibonacci 0,1,1,2,3,5,8,13,21
// Exponential Time -O(2^n)
// her turnda 2 yeni tur çağrılıyor recursive olarak
// bu durumda 2 üzeri n oluyor dallanıp budaklanan bir ağaç gibi
// Eğer bir fonksiyon kendini her çağırdığında 3 kere tekrar çağırıyorsa, bu
// durumda time complexity O(3^n)olur.
