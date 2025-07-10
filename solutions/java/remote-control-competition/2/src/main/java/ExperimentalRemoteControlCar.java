public class ExperimentalRemoteControlCar implements RemoteControlCar {
    
    private int distance;
    private final int SPEED = 20;

    public ExperimentalRemoteControlCar() {
        this.distance = 0;
    }

    public void drive() {
        distance += SPEED;
    }

    public int getDistanceTravelled() {
        return distance;
    }

}
