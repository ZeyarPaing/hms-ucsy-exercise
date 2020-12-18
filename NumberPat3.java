public class NumberPat3 {
    public static void main(String[] args) {
        int lines = 5;
        for (int i = 1; i <= lines; ++i) {
            for (int j = 1; j <= i; ++j) {
                System.out.print(j + "  ");
            }
            System.out.println();
        }
    }
}
