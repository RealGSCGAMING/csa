package DataLab.DataLab_Code;

public class Cereal {
    private String name;
    private boolean type;
    private int calories;
    private int protein;
    private int fat;
    private int sodium;
    private double fiber;
    private double carbs;
    private int sugar;
    private int potassium;
    private int vitamins;
    private int shelf;
    private double weight;
    private double cups;
    private double rating;

    public static void main(String[] args) {
        Cereal c = new Cereal("Corn Flakes", false, 100, 1, 2, 100, 0, 7.0, 5, 200, 10, 1, 1.5, 0.5, 75.0);
        System.out.println(c);
    }

    public Cereal(String name, boolean type, int calories, int protein, int fat, int sodium, double fiber, double carbs, int sugar, int potassium, int vitamins, int shelf, double weight, double cups, double rating) {
        this.name = name;
        this.type = type;
        this.calories = calories;
        this.protein = protein;
        this.fat = fat;
        this.sodium = sodium;
        this.fiber = fiber;
        this.carbs = carbs;
        this.sugar = sugar;
        this.potassium = potassium;
        this.vitamins = vitamins;
        this.shelf = shelf;
        this.weight = weight;
        this.cups = cups;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getType() {
        return type;
    }

    public void setType(boolean type) {
        this.type = type;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public int getProtein() {
        return protein;
    }

    public void setProtein(int protein) {
        this.protein = protein;
    }

    public int getFat() {
        return fat;
    }

    public void setFat(int fat) {
        this.fat = fat;
    }

    public int getSodium() {
        return sodium;
    }

    public void setSodium(int sodium) {
        this.sodium = sodium;
    }

    public double getFiber() {
        return fiber;
    }

    public void setFiber(double fiber) {
        this.fiber = fiber;
    }

    public double getCarbs() {
        return carbs;
    }

    public void setCarbs(double carbs) {
        this.carbs = carbs;
    }

    public int getSugar() {
        return sugar;
    }

    public void setSugar(int sugar) {
        this.sugar = sugar;
    }

    public int getPotassium() {
        return potassium;
    }

    public void setPotassium(int potassium) {
        this.potassium = potassium;
    }

    public int getVitamins() {
        return vitamins;
    }

    public void setVitamins(int vitamins) {
        this.vitamins = vitamins;
    }

    public int getShelf() {
        return shelf;
    }

    public void setShelf(int shelf) {
        this.shelf = shelf;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getCups() {
        return cups;
    }

    public void setCups(double cups) {
        this.cups = cups;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String toString() {
        String s = name + "\nNutrition Facts:\nCalories" + calories + "\nProtein: " + protein + "\nFat: " + fat + "\nSodium: " + sodium + "\nFiber: " + fiber + "\nCarbohydrates: " + carbs + "\nSugar: " + sugar + "\nPotassium: " + potassium + "\nVitamins: " + vitamins + "\n---\nShelf: " + shelf + "\nWeight: " + weight + "\nCups: " + cups + "\nRating: " + rating + "\nServed " + (type ? "hot" : "cold");
        return s;
    }
}
