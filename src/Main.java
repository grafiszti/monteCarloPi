import monteCarlo.s.C;

public class Main {
    public static final int N = 100000;
    public static void main(String args[]) {
        printResult(new monteCarlo.bfCode.Calculator().calculate(N));
        printResult(new C().c(N));
    }

    private static void printResult(double pi) {
        System.out.println("Pi ~ " + pi);
    }
}