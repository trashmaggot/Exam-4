public class FeedStrategy implements Strategy{
    @Override
    public void makeAction(Cat cat, int bonus, int penalty) {
        cat.setSatietyLevel(cat.getSatietyLevel() + bonus);
        cat.setMoodLevel(cat.getMoodLevel() + bonus);
    }
}
