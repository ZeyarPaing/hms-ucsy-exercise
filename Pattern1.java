public class Pattern1 {
    public static void main(String[] args) {
        int lines = 5;

        for (int i = 0; i < lines; ++i) {
            for (int j = i; j < lines; ++j) {
                System.out.print(" ");
            }
            for (int k = 0; k <= i; ++k) {
                System.out.print(" *");
            }
            System.out.println();
        }
    }
}
