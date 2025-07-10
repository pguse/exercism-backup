class NeedForSpeed {
    
    private int distance;
    private int speed;
    private int battery;
    private int batteryDrain;

    public NeedForSpeed(int speed, int batteryDrain){
        this.distance = 0;
        this.battery = 100;
        this.speed = speed;
        this.batteryDrain = batteryDrain;
    }

    public boolean batteryDrained() {
        return (battery < batteryDrain);    
    }

    public int distanceDriven() {
        return distance;
    }

    public void drive() {
        if (!batteryDrained()){
            distance += speed;
            battery -= batteryDrain;
        }
    }

    public static NeedForSpeed nitro() {
        return new NeedForSpeed(50, 4);
    }
}

class RaceTrack {
    private int distance;

    public RaceTrack(int distance) {
        this.distance = distance;
    }

    public boolean tryFinishTrack(NeedForSpeed car) {
        while (car.distanceDriven() <= distance && !car.batteryDrained()){
            car.drive();
        }

        return (car.distanceDriven() >= distance);
    }
}
