public class FeedStrategy implements Strategy{
    @Override
    public void makeAction(Cat cat, int bonus, int penalty) {
        if (cat.isHasFeed()) return;
        cat.setSatietyLevel(cat.getSatietyLevel() + bonus);
        cat.setMoodLevel(cat.getMoodLevel() + bonus);
        cat.setHasFeed(true);
    }
}
