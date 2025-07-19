//DO NOT TOUCH THIS CODE
class Arr{

    // HELPER METHOD TO PRINT LINEAR ARRAY
    public static void print(Object[] arr) {
        if( arr!=null ){
            System.out.print("[ ");
            for (Object o : arr) {
                System.out.print(o + " ");
            }
            System.out.println("]");
        } else {
            System.out.println(arr);
        }
    }

    // HELPER METHOD TO FIND THE MAXIMUM ELEMENT LENGTH
    public static int findMaxWidth(Object[][] arr2D) {
        int maxWidth = 0;
        for (Object[] arr : arr2D) {
            for (Object elem : arr) {
                maxWidth = Math.max(maxWidth, elem.toString().length());
            }
        }
        return maxWidth;
    }

}
