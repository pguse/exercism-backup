
class BirdWatcher {
    private final int[] birdsPerDay;

    public BirdWatcher(int[] birdsPerDay) {
        this.birdsPerDay = birdsPerDay.clone();
    }

    public int[] getLastWeek() {
        int[] birdsLastWeek = new int[]{0,2,5,3,7,8,4};
        return birdsLastWeek;
    }

    public int getToday() {
        return birdsPerDay[birdsPerDay.length-1];
    }

    public void incrementTodaysCount() {
        birdsPerDay[birdsPerDay.length-1] += 1;
    }

    public boolean hasDayWithoutBirds() {
        boolean withOutBirds = false;
        for(int numBirds: birdsPerDay) {
            if (numBirds == 0) {
                withOutBirds = true;
                break;
            }
        }
        return withOutBirds;
    }

    public int getCountForFirstDays(int numberOfDays) {
        int count = 0;
        if (numberOfDays > 7) {
            numberOfDays = 7;
        }
        for (int i = 0; i < numberOfDays; i++) {
            count += birdsPerDay[i];
        }
        return count;
    }

    public int getBusyDays() {
        int numBusyDays = 0;
        for (int numBirds: birdsPerDay) {
            if (numBirds >= 5) {
                numBusyDays += 1;
            }
        }
        return numBusyDays;
    }
}
