package pl.coderslab.model;

public class RecipePlan {

    private int id;

    private int planId;

    private String mealName;
    private String mealNumber;
    private int recipeId;
    private int day;
    public RecipePlan() {
    }

    public RecipePlan(int planId, String mealName, String mealNumber, int recipeId, int day) {
        this.planId = planId;
        this.mealName = mealName;
        this.mealNumber = mealNumber;
        this.recipeId = recipeId;
        this.day = day;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPlanId() {
        return planId;
    }

    public void setPlanId(int planId) {
        this.planId = planId;
    }

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public String  getMealNumber() {
        return mealNumber;
    }

    public void setMealNumber(String mealNumber) {
        this.mealNumber = mealNumber;
    }

    public int getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }
}
