public class Test {
    public static int max(int[] array, int l, int maximum) {
        if (l < 0) {
            return maximum;
        }
        if (array[l] > maximum) {
            maximum = array[l];
        }
        return max(array, l - 1, maximum);
    }

    public static void main(String[] args) {
        int[] array = {22, 33, 44, 55, 66, 78, 89};
        int l = array.length - 1;
        int maximum = array[0];
        int max1 = max(array, l, maximum);
        System.out.println("Max number is " + max1);
    }
}