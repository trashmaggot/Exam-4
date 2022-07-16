import java.util.Random;

public class PlayStrategy implements Strategy {
    @Override
    public void makeAction(Cat cat, int bonus, int penalty) {
        if (cat.isHasPlayed()) return;

        cat.setHasPlayed(true);

        Random r = new Random();
        if (r.nextInt(10) < 1) {
            System.out.println("Вы случайно травмировали кота во время игры");
            cat.setHealthLevel(cat.getHealthLevel() - penalty);
            cat.setMoodLevel(cat.getMoodLevel() - penalty);
            return;
        }

        cat.setHealthLevel(cat.getHealthLevel() + bonus);
        cat.setMoodLevel(cat.getMoodLevel() + bonus);

        cat.setSatietyLevel(cat.getSatietyLevel() - penalty);
    }
}
