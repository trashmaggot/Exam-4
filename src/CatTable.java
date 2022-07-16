import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class CatTable {
    private final ArrayList<Cat> cats = new ArrayList<>();

    public void printTable(Comparator<Cat> comparator) {
        cats.sort(comparator);
        cats.forEach(cat -> {
            if (cat.isHasPlayed())
                System.out.println("You played with " + cat.getName() + " " + cat.getAge() + " years old");
            if (cat.isHasFeed()) System.out.println("You feed " + cat.getName() + " " + cat.getAge() + " years old");
            if (cat.isHasVet())
                System.out.println("You took to Vet " + cat.getName() + " " + cat.getAge() + " years old");
        });
        System.out.println("---+----------+-----------+-----------+----------+----------+----------+");
        System.out.println(" # |   имя    |  возраст  | здоровье  |настроение|  сытость |ср уровень|");
        for (int i = 0; i < cats.size(); i++) {
            Cat cat = cats.get(i);
            System.out.printf(" %2s| %8s |    %3s    |    %3s    |    %3s   |    %3s   |    %3s   |\n", i + 1, cat.getName(), cat.getAge(), cat.getHealthLevel(), cat.getMoodLevel(), cat.getSatietyLevel(), cat.getAverageLevel());
        }
        System.out.println("---+----------+-----------+-----------+----------+----------+----------+");
        System.out.println();
    }

    public void addCat(String name, int age) {
        Random r = new Random();
        cats.add(new Cat(name, age, r.nextInt(81) + 20,
                r.nextInt(81) + 20, r.nextInt(81) + 20));
    }

    public Cat getCat(int index) {
        return cats.get(index - 1);
    }

    public int getSize() {
        return cats.size();
    }

    public void nextDay() {
        Random r = new Random();
        cats.forEach(k -> {
            k.setSatietyLevel(r.nextInt(5) - 5 + k.getSatietyLevel());
            k.setMoodLevel(r.nextInt(7) - 3 + k.getMoodLevel());
            k.setHealthLevel(r.nextInt(7) - 3 + k.getHealthLevel());
            k.setHasFeed(false);
            k.setHasVet(false);
            k.setHasPlayed(false);
        });
    }

    public void holdFuneral() {
        cats.removeIf(Cat::isDead);
    }
}
