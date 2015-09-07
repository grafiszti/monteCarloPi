import monteCarlo.Calculable;
import monteCarlo.bfCode.Calculator;
import monteCarlo.s.C;

import java.util.Date;

public class Main {
    public static final int N = 1000000;

    public static void main(String args[]) {
        execute(new Calculator(), N);

        Date startDate = new Date();
        double pi = new C().c(N);
        Date endDate = new Date();
        printResult(pi, endDate.getTime() - startDate.getTime());
    }

    private static void execute(Calculable calculator, int n) {
        Date startDate = new Date();
        double pi = calculator.calculate(n);
        Date endDate = new Date();
        printResult(pi, endDate.getTime() - startDate.getTime());
    }

    private static void printResult(double pi, long milis) {
        System.out.println("Pi ~ " + pi + " in: " + (double) milis / 1000 + " seconds.");
    }
}