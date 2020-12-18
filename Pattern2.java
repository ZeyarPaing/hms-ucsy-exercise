public class Pattern2 {
    public static void main(String[] args) {
        int lines = 5;
        for (int i = lines; i >= 0; --i) {

            for (int j = 0; j < i; ++j) {
                System.out.print("   ");
            }

            for (int k = 0; k < lines - i; ++k) {
                System.out.print(" * ");
            }

            System.out.println();
        }
    }
}
