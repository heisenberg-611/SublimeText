//Task 02: Container with Most Water
class Task2{

    //Complete this method so that it gives the Expected Output
    public static void mostWater( Integer[] height ){

        //TO DO
        int startIdx = 0;
        int endIdx = height.length - 1;
        int maximumCapacity = 0;

        while (startIdx < endIdx) {
            int containerWidth = endIdx - startIdx;
            int containerHeight = determineSmallerElevation(height[startIdx], height[endIdx]);

            int currentCapacity = containerWidth * containerHeight;
            if (currentCapacity > maximumCapacity) {
                maximumCapacity = currentCapacity;
            }

            if (height[startIdx] < height[endIdx]) {
                startIdx++;
            } else if (height[startIdx] > height[endIdx]) {
                endIdx--;
            } else {
                startIdx++;
                endIdx--;
            }
        }
        System.out.println(maximumCapacity);
    }
    private static int determineSmallerElevation(int a, int b) {
        if(a <= b){
            return a;
        } else {
            return b;
        }
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
