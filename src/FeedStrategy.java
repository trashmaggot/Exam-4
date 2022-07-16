import java.util.Random;

public class FeedStrategy implements Strategy{
    @Override
    public void makeAction(Cat cat, int bonus, int penalty) {
        if (cat.isHasFeed()) return;

        cat.setHasFeed(true);

        Random r = new Random();
        if (r.nextInt(10) < 1) {
            System.out.println("Коту не повезло с едой, он отравился");
            cat.setHealthLevel(cat.getHealthLevel() - penalty);
            cat.setMoodLevel(cat.getMoodLevel() - penalty);
            return;
        }

        cat.setSatietyLevel(cat.getSatietyLevel() + bonus);
        cat.setMoodLevel(cat.getMoodLevel() + bonus);
    }
}
