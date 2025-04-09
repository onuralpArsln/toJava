public class BS {

    public static int performSearch(int[] input, int find) {
        int leftPoint = 0;
        int rightPoint = input.length - 1;

        int midPoint = (rightPoint + leftPoint) / 2;

        while (rightPoint > leftPoint) {

            if (find == input[midPoint]) {
                return midPoint;
            }

            else if (find > input[midPoint]) {
                leftPoint = midPoint;
                midPoint = (rightPoint + leftPoint) / 2;

            } else {
                rightPoint = midPoint;
                midPoint = (rightPoint + leftPoint) / 2;

            }
        }
        System.out.println("Sayı bulunmadı");
        return -1; // bulamama durumu

    }

    public static void main(String[] args) {
        int[] arr = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14 };

        int indx = performSearch(arr, 7);
        System.out.println(indx);

    }

}