package org.launchcode.muriel_mays.models;

import java.util.Objects;

public class Recipe {

    private int id;
    private static int nextId = 1;

    private Name name;
    private Category category;
    private Servings servings;
    private PrepTime prepTime;
    private Ingredients ingredients;
    private Step1 step1;
    private Step2 step2;
    private Step3 step3;
    private Step4 step4;
    private Step5 step5;
    private Step6 step6;
    private Step7 step7;
    private Step8 step8;
    private Step9 step9;
    private OriginalCreator originalCreator;

    // Initialize a unique ID.
    public Recipe() {
        id = nextId;
        nextId++;
    }

    // Initialize the id and value fields.
    public Recipe(Name aName, Category aCategory, Servings aServings, PrepTime aPrepTime, Ingredients anIngredients, Step1 aStep1, Step2 aStep2, Step3 aStep3, Step4 aStep4, Step5 aStep5, Step6 aStep6, Step7 aStep7, Step8 aStep8, Step9 aStep9, OriginalCreator anOriginalCreator) {
        this();
        name = aName;
        category = aCategory;
        servings = aServings;
        prepTime = aPrepTime;
        ingredients = anIngredients;
        step1 = aStep1;
        step2 = aStep2;
        step3 = aStep3;
        step4 = aStep4;
        step5 = aStep5;
        step6 = aStep6;
        step7 = aStep7;
        step8 = aStep8;
        step9 = aStep9;
        originalCreator = anOriginalCreator;
    }

    // Custom toString method.
//    @Override
//    public String toString() {
//        String output = "";
//        if (name.getValue().equals("") || name.getValue() == null) {
//            name.setValue("Data not available");
//        }
//        if (category.getValue().equals("") || category.getValue() == null) {
//            category.setValue("Data not available");
//        }
//        if (servings.getValue().equals("") || servings.getValue() == null) {
//            servings.setValue("Data not available");
//        }
//        if (prepTime.getValue().equals("") || prepTime.getValue() == null) {
//            prepTime.setValue("Data not available");
//        }
//        if (ingredients.getValue().equals("") || ingredients.getValue() == null) {
//            ingredients.setValue("Data not available");
//        }
//        if (originalCreator.getValue().equals("") || originalCreator.getValue() == null) {
//            originalCreator.setValue("Data not available");
//        }

//        output = String.forat(
//               "\nID: %1d\n" +
//                "Name: %2s\n" +
//                "Category: %3s\n" +
//                "Servings: %4s\n" +
//                "Prep Time: %5s\n" +
//                "Ingredients: %6s\n" +
//                "Step 1: %7s\n" +
//                "Step 2: %8s\n" +
//                "Step 3: %9s\n" +
//                "Step 4: %10s\n" +
//                "Step 5: %11s\n" +
//                "Step 6: %12s\n" +
//                "Step 7: %13s\n" +
//                "Step 8: %14s\n" +
//                "Step 9: %15s\n" +
//                "Original Creator: %16x\n", name, category, servings, prepTime, ingredients, step1, step2, step3, step4, step5, step6, step7, step8, step9, originalCreator);
//        return output;
//}

    // Custom equals and hashCode methods. Two Job objects are "equal" when their id fields match.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Recipe)) return false;
        Recipe recipe = (Recipe) o;
        return id == recipe.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


    // Getters and setters.

    public int getId() {
        return id;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Servings getServings() {
        return servings;
    }

    public void setServings(Servings servings) {
        this.servings = servings;
    }

    public PrepTime getPrepTime() {
        return prepTime;
    }

    public void setPrepTime(PrepTime prepTime) {
        this.prepTime = prepTime;
    }

    public Ingredients getIngredients() {
        return ingredients;
    }

    public void setIngredients(Ingredients ingredients) {
        this.ingredients = ingredients;
    }

    public Step1 getStep1() {
        return step1;
    }

    public void setStep1(Step1 step1) {
        this.step1 = step1;
    }

    public Step2 getStep2() {
        return step2;
    }

    public void setStep2(Step2 step2) {
        this.step2 = step2;
    }

    public Step3 getStep3() {
        return step3;
    }

    public void setStep3(Step3 step3) {
        this.step3 = step3;
    }

    public Step4 getStep4() {
        return step4;
    }

    public void setStep4(Step4 step4) {
        this.step4 = step4;
    }

    public Step5 getStep5() {
        return step5;
    }

    public void setStep5(Step5 step5) {
        this.step5 = step5;
    }

    public Step6 getStep6() {
        return step6;
    }

    public void setStep6(Step6 step6) {
        this.step6 = step6;
    }

    public Step7 getStep7() {
        return step7;
    }

    public void setStep7(Step7 step7) {
        this.step7 = step7;
    }

    public Step8 getStep8() {
        return step8;
    }

    public void setStep8(Step8 step8) {
        this.step8 = step8;
    }

    public Step9 getStep9() {
        return step9;
    }

    public void setStep9(Step9 step9) {
        this.step9 = step9;
    }

    public OriginalCreator getOriginalCreator() {
        return originalCreator;
    }

    public void setOriginalCreator(OriginalCreator originalCreator) {
        this.originalCreator = originalCreator;
    }
}

