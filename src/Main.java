import java.util.Comparator;
import java.util.Scanner;

public class Main {

    static Scanner in = new Scanner(System.in);
    static CatTable cats = new CatTable();

    public static int getNumberInBounds(int l, int r) {
        System.out.println("Введите число: ");
        int num;
        try {
            num = Integer.parseInt(in.nextLine());
            if (num > r || num < l) throw new Exception();
        } catch (Exception e) {
            System.out.println("Неккоректный ввод");
            num = getNumberInBounds(l, r);
        }
        return num;
    }

    public static String getNonEmptyString() {
        String str;
        try {
            str = in.nextLine();
            if (str.isEmpty()) throw new Exception();
        } catch (Exception e) {
            System.out.println("Неккоректный ввод");
            str = getNonEmptyString();
        }
        return str;
    }

    public static void print() {
        System.out.println("Введите в каком виде вы хотите увидеть таблицу");
        System.out.println("1 Отсортированной по имени");
        System.out.println("2 Отсортированной по возрасту");
        System.out.println("3 Отсортированной по здоровью");
        System.out.println("4 Отсортированной по настроению");
        System.out.println("5 Отсортированной по сытости");
        System.out.println("6 Отсортированной по среднему");

        int n = getNumberInBounds(1, 6);

        switch (n) {
            case 1 -> cats.printTable(Comparator.comparing(Cat::getName));
            case 2 -> cats.printTable(Comparator.comparing(Cat::getAge).reversed());
            case 3 -> cats.printTable(Comparator.comparing(Cat::getHealthLevel).reversed());
            case 4 -> cats.printTable(Comparator.comparing(Cat::getMoodLevel).reversed());
            case 5 -> cats.printTable(Comparator.comparing(Cat::getSatietyLevel).reversed());
            case 6 -> cats.printTable(Comparator.comparing(Cat::getAverageLevel).reversed());
        }
        System.out.println();
    }

    public static void add() {
        System.out.println("Введите имя кота");
        String name = getNonEmptyString();
        System.out.println("Введите возраст");
        int age = getNumberInBounds(1, Integer.MAX_VALUE);
        cats.addCat(name, age);
    }

    public static void chooseAction() {
        System.out.println("Выберите действие с котом");
        System.out.println("1 покормить");
        System.out.println("2 поиграть");
        System.out.println("3 к ветеринару");
        System.out.println("4 завести нового питомца");
        System.out.println("5 пропустить день");

        int n = getNumberInBounds(1, 5);
        if (n < 4 && cats.getSize() == 0) {
            System.out.println("Это действие недоступно, так как котов еще нет");
            return;
        }

        switch (n) {
            case 1 -> {
                Cat cat = cats.getCat(getNumberInBounds(1, cats.getSize()));
                cat.executeStrategy(new FeedStrategy());
            }
            case 2 -> {
                Cat cat = cats.getCat(getNumberInBounds(1, cats.getSize()));
                cat.executeStrategy(new PlayStrategy());
            }
            case 3 -> {
                Cat cat = cats.getCat(getNumberInBounds(1, cats.getSize()));
                cat.executeStrategy(new VetStrategy());
            }
            case 4 -> add();
            case 5 -> cats.nextDay();
        }
    }

    public static void run() {
        print();
        chooseAction();
        cats.holdFuneral();
        run();
    }

    public static void main(String[] args) {
        run();
    }
}
