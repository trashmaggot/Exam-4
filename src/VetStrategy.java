import java.util.Random;

public class VetStrategy implements Strategy {
    @Override
    public void makeAction(Cat cat, int bonus, int penalty) {
        if (cat.isHasVet()) return;

        cat.setHasVet(true);

        Random r = new Random();
        if (r.nextInt(10) < 1) {
            System.out.println("Ветеринар допустил ошибку и травмировал кота");
            cat.setHealthLevel(cat.getHealthLevel() - penalty);
            cat.setMoodLevel(cat.getMoodLevel() - penalty);
            return;
        }

        cat.setHealthLevel(cat.getHealthLevel() + bonus);

        cat.setSatietyLevel(cat.getSatietyLevel() - penalty);
        cat.setMoodLevel(cat.getMoodLevel() - penalty);
    }
}
