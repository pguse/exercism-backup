public class GameMaster {

    public String describe(Character c) {
        return String.format("You're a level %d %s with %d hit points.", c.getLevel(), c.getCharacterClass(), c.getHitPoints());
    }

    public String describe(Destination d) {
        return String.format("You've arrived at %s, which has %d inhabitants.", d.getName(), d.getInhabitants());
    }

    public String describe(TravelMethod t) {
        String method = "";
        switch (t) {
            case TravelMethod.WALKING:
                method = "by walking";
                break;
            case TravelMethod.HORSEBACK:
                method = "on horseback";
        }
        return String.format("You're traveling to your destination %s.", method);
    }

    public String describe(Character c, Destination d, TravelMethod t){
        return String.format("%s %s %s", describe(c), describe(t), describe(d));
    }

    public String describe(Character c, Destination d) {
        return String.format("%s %s %s", describe(c), describe(TravelMethod.WALKING), describe(d));
    }
}
