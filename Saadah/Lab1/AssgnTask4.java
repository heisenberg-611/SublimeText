//Assignment Task 04: Game Arena
class AssgnTask4{

    //Complete this method so that it gives the Expected Output
    //YOU ONLY HAVE TO SUBMIT THIS METHOD, NO OTHER DRIVER CODES
    public static void playGame( Integer[][] arena ){

        int r = arena.length;
        int c = arena[0].length;
        int p = 0;
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(arena[i][j] % 50 == 0 && arena[i][j] != 0){
                    int u = i-1;
                    int d = i+1;
                    int l = j-1;
                    int z = j+1;

                    if(i > 0 && arena[u][j] == 2){
                        p += 2;
                    }
                    if(i < r - 1 && arena[d][j] == 2){
                        p += 2;
                    }
                    if(j > 0 && arena[i][l] == 2){
                        p += 2;
                    }
                    if(j < c - 1 && arena[i][z] == 2){
                        p += 2;
                    }
                }
            }
        }
        System.out.print("Points Gained: " + p + ". ");
        if (p >= 10){
            System.out.println("Your team has survived the game.");
        }
        else {
            System.out.println("Your team is out.");
        }
    }

    //DO NOT CHANGE ANY DRIVER CODES BELOW THIS LINE
    public static void main(String[] args){
        Integer[][] arena = {
                {0,2,2,0},
                {50,1,2,0},
                {2,2,2,0},
                {1,100,2,0}
        };
        System.out.println("Given Arena: ");
        Arr.print2D(arena);

        System.out.println("\nExpected Output:");
        System.out.print("Points Gained: 6. Your team is out.\n");

        System.out.print("\nYour Output:\n");
        playGame( arena );

        System.out.print("\n======================\n");

        Integer[][] arena1 = {
                {0,2,2,0,2},
                {1,50,2,1,100},
                {2,2,2,0,2},
                {0,200,2,0,0}
        };
        System.out.println("\nGiven Arena: ");
        Arr.print2D(arena1);

        System.out.println("\nExpected Output:");
        System.out.print("Points Gained: 14. Your team has survived the game.\n");

        System.out.print("\nYour Output:\n");
        playGame( arena1 );
    }
}
//                    int[][] directions = {
//                            {-1, 0},  // Top
//                            {1, 0},   // Down
//                            {0, -1},  // Left
//                            {0, 1}    // Right
//                    };
//                    for (int[] dir : directions) {
//                        int newRow = i + dir[0];
//                        int newCol = j + dir[1];
//
//                        if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < arena[newRow].length) {
//                            if (arena[newRow][newCol] == 2) {
//                                count2++;
//                            }
//                        }
//                    }