public class QuadraticTimeExample {
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j + 1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = { 64, 34, 25, 12, 22, 11, 90 };
        bubbleSort(arr);

        System.out.println("Sorted array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}

// Quadratic Time - O(n^2)
// iç içe looplar genelde buna sebep olur

// bubble sort iç içe iki lopp döner
// 10 eleman sıralarken önce 9 kere 8 kere 7 kere azalar sürekli döner
// en son 1 döngü olana kadar devam eder
// 1 den n e kadar olan sayıların toplamı ise n(n-1)/2 olarak bilinir.
// bu denklem n^2 elmanı yüzünden quadratic time olarak geçer
// quadratic matematikte en büyük güçteki elamanı n^2 olan denklemlerdir
// comes from the Latin word "quadratus," which means "square."
// iç içe 3 loop olsa cubic time o(n^3)
