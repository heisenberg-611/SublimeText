//Assignment Task 01: Container with Most Water
class AssgnTask1{

    //Complete this method so that it gives the Expected Output
    //YOU ONLY HAVE TO SUBMIT THIS METHOD, NO OTHER DRIVER CODE
    public static void mostWater(Integer[] height) {

        int l = height.length;
        int m = 0;
        for (int i = 0; i < l; i++) {
            for (int j = i + 1; j < l; j++) {
                int a = Math.min(height[i], height[j]) * (j - i);
                m = Math.max(a, m);
            }
        }
        System.out.println(m);
    }

    //DO NOT CHANGE ANY DRIVER CODE BELOW THIS LINE
    public static void main(String[] args){
        Integer[] array = {1,8,6,2,5,4,8,3,7};
        System.out.println("Given Array: ");
        Arr.print(array);
        System.out.println("\nExpected Output:");
        System.out.print("49");
        System.out.print("\nYour Output:\n");
        mostWater( array );
    }
}
