public class CarsAssemble {

    public double productionRatePerHour(int speed) {
        double success_rate;
        if (speed == 10) {
            success_rate = 0.77;
        } else if (speed == 9) {
            success_rate = 0.80;
        } else if (speed >= 5) {
            success_rate = 0.90;
        } else {
            success_rate = 1.00;
        }
        return 221 * speed * success_rate;
    }

    public int workingItemsPerMinute(int speed) {
        return (int) (productionRatePerHour(speed) / 60);
    }
}
