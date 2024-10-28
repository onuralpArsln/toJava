public class LogarithmicTimeExample {
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target)
                return mid;
            if (arr[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return -1; // Target not found
    }

    public static void main(String[] args) {
        int[] arr = { 10, 20, 30, 40, 50 };
        int target = 30;
        int index = binarySearch(arr, target);
        System.out.println("Index of target: " + index);
    }
}

// Logarithmic Time - 𝑂(log 𝑛)

// genelde böl parçala algoları buradadır

// mesela binary search için 20 elementle 40 element arasındaki fark fazladan 1
// işlem olabilir
// bu durumda lineardan yavaş bir zaman artışı olur
