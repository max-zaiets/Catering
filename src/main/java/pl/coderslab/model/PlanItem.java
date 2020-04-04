package pl.coderslab.model;

public class PlanItem {
    String day_name;
    String meal_name;
    String recipe_name;
    String recipe_description;
    int recipe_id;

    public PlanItem() {
    }


    public String getDay_name() {
        return day_name;
    }

    public void setDay_name(String day_name) {
        this.day_name = day_name;
    }

    public String getMeal_name() {
        return meal_name;
    }

    public void setMeal_name(String meal_name) {
        this.meal_name = meal_name;
    }

    public String getRecipe_name() {
        return recipe_name;
    }

    public void setRecipe_name(String recipe_name) {
        this.recipe_name = recipe_name;
    }

    public String getRecipe_description() {
        return recipe_description;
    }

    public void setRecipe_description(String recipe_description) {
        this.recipe_description = recipe_description;
    }

    public int getRecipe_id() {
        return recipe_id;
    }

    public void setRecipe_id(int recipe_id) {
        this.recipe_id = recipe_id;
    }

    public PlanItem(String day_name, String meal_name, String recipe_name, String recipe_description) {
        this.day_name = day_name;
        this.meal_name = meal_name;
        this.recipe_name = recipe_name;
        this.recipe_description = recipe_description;
    }

    @Override
    public String toString() {
        return "PlanItem{" +
                "day_name='" + day_name + '\'' +
                ", meal_name='" + meal_name + '\'' +
                ", recipe_name='" + recipe_name + '\'' +
                ", recipe_description='" + recipe_description + '\'' +
                '}';
    }
}
