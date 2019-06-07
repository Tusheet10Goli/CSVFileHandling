package com.example.csvfilehandling;

class Food {
    private String food;
    private String price;
    private String calories;
    private String cuisine;

    public Food (String food, String price, String calories, String cuisine) {
        this.food = food;
        this.price = price;
        this.calories = calories;
        this.cuisine = cuisine;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCalories() {
        return calories;
    }

    public void setCalories(String calories) {
        this.calories = calories;
    }

    @Override
    public String toString() {
        String a = "Food: " + food + "\tPrice: " + price + "\tCalories: " + calories
                + "\tCuisine: " + cuisine + "\n";
        return a;
    }
}
