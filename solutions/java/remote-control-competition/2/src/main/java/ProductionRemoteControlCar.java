class ProductionRemoteControlCar implements RemoteControlCar, Comparable<ProductionRemoteControlCar> {

    private int distance;
    private final int SPEED = 10;
    private int numberOfVictories;

    public ProductionRemoteControlCar() {
        this.distance = 0;
    }

    public void drive() {
        distance += SPEED;
    }

    public int getDistanceTravelled() {
        return distance;
    }

    public int getNumberOfVictories() {
        return numberOfVictories;
    }
    
    public void setNumberOfVictories(int numberOfVictories) {
        this.numberOfVictories = numberOfVictories;
    }

    public int compareTo(ProductionRemoteControlCar that) {
        return this.getNumberOfVictories() - that.getNumberOfVictories();
    }
}
