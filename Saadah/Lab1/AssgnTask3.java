//Assignment Task 03: Matrix Compression
class AssgnTask3{

    //Complete this method so that it gives the Expected Output
    //YOU ONLY HAVE TO SUBMIT THIS METHOD, NO OTHER DRIVER CODES
    public static Integer[][] compressMatrix( Integer[][] matrix ){

        int r = matrix.length / 2;
        int c = matrix[0].length / 2;
        Integer[][] comArr = new Integer[r][c];
        for (int i = 0; i < matrix.length; i += 2) {
            int Ridx = i / 2;
            for (int j = 0; j < matrix[i].length; j += 2) {
                int Cidx = j / 2;
                comArr[Ridx][Cidx] = matrix[i][j] + matrix[i+1][j] + matrix[i+1][j+1] + matrix[i][j+1];
            }
        }
        return comArr;
    }

    //DO NOT CHANGE ANY DRIVER CODES BELOW THIS LINE
    public static void main(String[] args){
        Integer[][] matrix = {
                { 1 , 2 , 3 , 4 },
                { 5 , 6 , 7 , 8 },
                { 1 , 3 , 5 , 2 },
                {-2 , 0 , 6 ,-3 }
        };
//        Integer[][] matrix = {
//                { 1 , 2 , 3 , 4 , 5, 9},
//                { 5 , 6 , 7 , 8 , 9 , 1},
//                { 1 , 3 , 5 , 2 , 10 , 4},
//                {-2 , 0 , 6 ,-3 , 11, 9},
//                {-2 , 0 , 6 ,-3 , 12, 3},
//                {-2 , 0 , 6 ,-3 , 13, 2}
//        };
        System.out.println("Given Matrix: ");
        Arr.print2D(matrix);

        System.out.println("\nExpected Output:");
        System.out.print("| 14 | 22 |\n| 2  | 10 |\n");

        System.out.print("\nYour Output:\n");
        Integer[][] returnedArray = compressMatrix( matrix );
        Arr.print2D( returnedArray );
    }
}