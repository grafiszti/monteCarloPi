package monteCarlo.bfCode;

import monteCarlo.Calculable;

import java.util.Random;

public class Calculator implements Calculable {
    public static double CIRCLE_ORIGIN_X = 0.5f;
    public static double CIRCLE_ORIGIN_Y = 0.5f;
    public static double CIRCLE_RADIUS = 0.5;

    @Override
    public double calculate(int n) {
        Circle circle = new Circle(new Point(CIRCLE_ORIGIN_X, CIRCLE_ORIGIN_Y),
                CIRCLE_RADIUS);
        int insideCirclePoints = checkPoints(n, circle);
        return calculatePi(insideCirclePoints, n);
    }

    public static int checkPoints(int pointsNumber, Circle circle) {
        int insideCircle = 0;
        for (int i = 0; i < pointsNumber; i++) {
            if (isInCircle(getRandomPoint(), circle)) {
                insideCircle++;
            }
        }
        return insideCircle;
    }

    public static Point getRandomPoint() {
        return new Point(new Random().nextDouble(), new Random().nextDouble());
    }

    public static boolean isInCircle(Point point, Circle circle) {
        return lengthBetweenPoints(circle.origin.x, circle.origin.y,
                point.x, point.y) < circle.radius;
    }

    public static double lengthBetweenPoints(double x1, double y1, double x2, double y2) {
        return Math.sqrt((Math.pow(x2 - x1, 2)) + (Math.pow(y2 - y1, 2)));
    }

    public static double calculatePi(int pointsInsideCircle, int allPoints) {
        return (4 * (double) pointsInsideCircle) / allPoints;
    }
}
