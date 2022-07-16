public class PlayStrategy implements Strategy {
    @Override
    public void makeAction(Cat cat, int bonus, int penalty) {
        cat.setHealthLevel(cat.getHealthLevel() + bonus);
        cat.setMoodLevel(cat.getMoodLevel() + bonus);

        cat.setSatietyLevel(cat.getSatietyLevel() - penalty);
    }
}
