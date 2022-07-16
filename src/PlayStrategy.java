public class PlayStrategy implements Strategy {
    @Override
    public void makeAction(Cat cat, int bonus, int penalty) {
        if (cat.isHasPlayed()) return;
        cat.setHealthLevel(cat.getHealthLevel() + bonus);
        cat.setMoodLevel(cat.getMoodLevel() + bonus);

        cat.setSatietyLevel(cat.getSatietyLevel() - penalty);
        cat.setHasPlayed(true);
    }
}
