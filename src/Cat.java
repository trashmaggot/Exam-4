public class Cat {
    private final String name;
    private int age;
    private int moodLevel;
    private int satietyLevel;
    private int healthLevel;
    private transient int averageLevel;
    private transient Strategy strategy;

    private void calculateAverageLevel() {
        averageLevel = (age + satietyLevel + healthLevel + moodLevel) / 4;
    }

    public Cat(String name, int age, int satietyLevel, int healthLevel, int moodLevel) {
        this.name = name;
        this.age = age;
        this.satietyLevel = satietyLevel;
        this.healthLevel = healthLevel;
        this.moodLevel = moodLevel;
        calculateAverageLevel();
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getSatietyLevel() {
        return satietyLevel;
    }

    public int getHealthLevel() {
        return healthLevel;
    }

    public int getAverageLevel() {
        return averageLevel;
    }

    public int getMoodLevel() {
        return moodLevel;
    }

    public void setAge(int age) {
        this.age = age;
        calculateAverageLevel();
    }

    public void setMoodLevel(int moodLevel) {
        this.moodLevel = Math.max(moodLevel, 0);
        ;
        calculateAverageLevel();
    }

    public void setSatietyLevel(int satietyLevel) {
        this.satietyLevel = Math.max(satietyLevel, 0);
        ;
        calculateAverageLevel();
    }

    public void setHealthLevel(int healthLevel) {
        this.healthLevel = Math.max(healthLevel, 0);
        calculateAverageLevel();
    }

    public void executeStrategy(Strategy strategy) {
        this.strategy = strategy;
        if (age <= 5) strategy.makeAction(this, 7, 3);
        else if (age <= 10) strategy.makeAction(this, 5, 5);
        else strategy.makeAction(this, 4, 6);
    }
}
