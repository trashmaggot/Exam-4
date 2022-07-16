public class VetStrategy implements Strategy {
    @Override
    public void makeAction(Cat cat, int bonus, int penalty) {
        if (cat.isHasVet()) return;
        cat.setHealthLevel(cat.getHealthLevel() + bonus);

        cat.setSatietyLevel(cat.getSatietyLevel() - penalty);
        cat.setMoodLevel(cat.getMoodLevel() - penalty);
        cat.setHasVet(true);
    }
}
