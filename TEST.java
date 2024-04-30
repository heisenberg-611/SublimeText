public class TEST{
    public static void main(String[] args) {
        String S = "abababa";
        String S1 = "aba";
        String S2 = "a";
        modifyStrings(S, S1, S2);
    }

    public static void modifyStrings(String S, String S1, String S2) {
        String modifiedString = S.replace(S1, S2);
        System.out.println("Modified String S: " + modifiedString);
    }
}
