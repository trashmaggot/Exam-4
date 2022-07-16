import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class CatTable {
    private ArrayList<Cat> cats = new ArrayList<>();

    public void printTable(Comparator<Cat> comparator) {
        cats.sort(comparator);
        System.out.println("---+----------+-----------+-----------+----------+----------+----------+");
        System.out.println(" # |   имя    |  возраст  | здоровье  |настроение|  сытость |ср уровень|");
        for (int i = 0; i < cats.size(); i++) {
            Cat cat = cats.get(i);
            System.out.printf(" 2%s| 8%s |   3%s    |   3%s    |   3%s    |   3%s    |   3%s    |",
                    i, cat.getName(),cat.getAge(), cat.getHealthLevel(), cat.getMoodLevel(), cat.getSatietyLevel(), cat.getAverageLevel());
        }
        System.out.println("---+----------+-----------+-----------+----------+----------+----------+");
    }


    public void addCat(String name, int age) {  //TODO
        Random r = new Random();
        printTable(Comparator.comparing(Cat::getAverageLevel));
    }

    public Cat getCat(int index) {
        return cats.get(index);
    }
}
