public class VetStrategy implements Strategy {
    @Override
    public void makeAction(Cat cat, int bonus, int penalty) {
        cat.setHealthLevel(cat.getHealthLevel() + bonus);

        cat.setSatietyLevel(cat.getSatietyLevel() - penalty);
        cat.setMoodLevel(cat.getMoodLevel() - penalty);
    }
}
