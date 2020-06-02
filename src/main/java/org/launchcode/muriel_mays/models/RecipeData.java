package org.launchcode.muriel_mays.models;

import org.launchcode.muriel_mays.NameSorter;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class RecipeData {

    private static final String DATA_FILE = "recipes.csv";
    private static boolean isDataLoaded = false;

    private static ArrayList<Recipe> allRecipes;
    private static ArrayList<Name> allNames = new ArrayList<>();
    private static ArrayList<Category> allCategories = new ArrayList<>();
    private static ArrayList<Servings> allServings = new ArrayList<>();
    private static ArrayList<PrepTime> allPrepTimes = new ArrayList<>();
    private static ArrayList<Ingredients> allIngredients = new ArrayList<>();
    private static ArrayList<Step1> allStep1s = new ArrayList<>();
    private static ArrayList<Step2> allStep2s = new ArrayList<>();
    private static ArrayList<Step3> allStep3s = new ArrayList<>();
    private static ArrayList<Step4> allStep4s = new ArrayList<>();
    private static ArrayList<Step5> allStep5s = new ArrayList<>();
    private static ArrayList<Step6> allStep6s = new ArrayList<>();
    private static ArrayList<Step7> allStep7s = new ArrayList<>();
    private static ArrayList<Step8> allStep8s = new ArrayList<>();
    private static ArrayList<Step9> allStep9s = new ArrayList<>();
    private static ArrayList<OriginalCreator> allOriginalCreators = new ArrayList<>();

    /**
     * Fetch list of all job objects from loaded data,
     * without duplicates, then return a copy.
     */

    public static ArrayList<Recipe> findAll() {

        // load data, if not already loaded
        loadData();

        // Bonus mission; normal version returns allJobs
        return new ArrayList<>(allRecipes);
    }

    /**
     * Returns the results of searching the Jobs data by field and search term.
     *
     * For example, searching for employer "Enterprise" will include results
     * with "Enterprise Holdings, Inc".
     *
     * @param column Job field that should be searched.
     * @param value Value of the field to search for.
     * @return List of all jobs matching the criteria.
     */
    public static ArrayList<Recipe> findByColumnAndValue(String column, String value) {

        // load data, if not already loaded
        loadData();

        ArrayList<Recipe> recipes = new ArrayList<>();

        if (value.toLowerCase().equals("all")){
            return findAll();
        }

        if (column.equals("all")){
            recipes = findByValue(value);
            return recipes;
        }
        for (Recipe recipe : allRecipes) {

            String aValue = getFieldValue(recipe, column);

            if (aValue != null && aValue.toLowerCase().contains(value.toLowerCase())) {
                recipes.add(recipe);
            }
        }

        return recipes;
    }
    public static String getFieldValue(Recipe recipe, String fieldName){
        String theValue;
        if (fieldName.equals("name")){
            theValue = recipe.getName().toString();
        } else if (fieldName.equals("category")){
            theValue = recipe.getCategory().toString();
        } else if (fieldName.equals("servings")){
            theValue = recipe.getServings().toString();
        } else if (fieldName.equals("prep time")){
            theValue = recipe.getPrepTime().toString();
        } else if (fieldName.equals("ingredients")){
            theValue = recipe.getIngredients().toString();
        } else if (fieldName.equals("step 1")){
            theValue = recipe.getStep1().toString();
        } else if (fieldName.equals("step 2")){
            theValue = recipe.getStep2().toString();
        } else if (fieldName.equals("step 3")){
            theValue = recipe.getStep3().toString();
        } else if (fieldName.equals("step 4")){
            theValue = recipe.getStep4().toString();
        } else if (fieldName.equals("step 5")){
            theValue = recipe.getStep5().toString();
        } else if (fieldName.equals("step 6")){
            theValue = recipe.getStep6().toString();
        } else if (fieldName.equals("step 7")){
            theValue = recipe.getStep7().toString();
        } else if (fieldName.equals("step 8")){
            theValue = recipe.getStep8().toString();
        } else if (fieldName.equals("step 9")){
            theValue = recipe.getStep9().toString();
        } else {
            theValue = recipe.getOriginalCreator().toString();
        }

        return theValue;
    }
    /**
     * Search all Job fields for the given term.
     *
     * @param value The search term to look for.
     * @return      List of all jobs with at least one field containing the value.
     */
    public static ArrayList<Recipe> findByValue(String value) {

        // load data, if not already loaded
        loadData();

        ArrayList<Recipe> recipes = new ArrayList<>();

        for (Recipe recipe : allRecipes) {

            if (recipe.getName().toString().toLowerCase().contains(value.toLowerCase())) {
                recipes.add(recipe);
            } else if (recipe.getCategory().toString().toLowerCase().contains(value.toLowerCase())) {
                recipes.add(recipe);
            } else if (recipe.getServings().toString().toLowerCase().contains(value.toLowerCase())) {
                recipes.add(recipe);
            } else if (recipe.getPrepTime().toString().toLowerCase().contains(value.toLowerCase())) {
                recipes.add(recipe);
            } else if (recipe.getIngredients().toString().toLowerCase().contains(value.toLowerCase())) {
                recipes.add(recipe);
            } else if (recipe.getStep1().toString().toLowerCase().contains(value.toLowerCase())){
                recipes.add(recipe);
            }  else if (recipe.getStep3().toString().toLowerCase().contains(value.toLowerCase())){
                recipes.add(recipe);
            } else if (recipe.getStep3().toString().toLowerCase().contains(value.toLowerCase())){
                recipes.add(recipe);
            } else if (recipe.getStep4().toString().toLowerCase().contains(value.toLowerCase())){
                recipes.add(recipe);
            } else if (recipe.getStep5().toString().toLowerCase().contains(value.toLowerCase())){
                recipes.add(recipe);
            } else if (recipe.getStep6().toString().toLowerCase().contains(value.toLowerCase())){
                recipes.add(recipe);
            } else if (recipe.getStep7().toString().toLowerCase().contains(value.toLowerCase())){
                recipes.add(recipe);
            } else if (recipe.getStep8().toString().toLowerCase().contains(value.toLowerCase())){
                recipes.add(recipe);
            } else if (recipe.getStep9().toString().toLowerCase().contains(value.toLowerCase())){
                recipes.add(recipe);
            } else if (recipe.getOriginalCreator().toString().toLowerCase().contains(value.toLowerCase())) {
                recipes.add(recipe);
            }

        }

        return recipes;
    }

    private static Object findExistingObject(ArrayList list, String value){
        for (Object item : list){
            if (item.toString().toLowerCase().equals(value.toLowerCase())){
                return item;
            }
        }
        return null;
    }

    /**
     * Read in data from a CSV file and store it in an ArrayList of Job objects.
     */
    private static void loadData() {

        // Only load data once
        if (isDataLoaded) {
            return;
        }

        try {

            // Open the CSV file and set up pull out column header info and records
            Resource resource = new ClassPathResource(DATA_FILE);
            InputStream is = resource.getInputStream();
            Reader reader = new InputStreamReader(is);
            CSVParser parser = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(reader);
            List<CSVRecord> records = parser.getRecords();
            Integer numberOfColumns = records.get(0).size();
            String[] headers = parser.getHeaderMap().keySet().toArray(new String[numberOfColumns]);

            allRecipes = new ArrayList<>();

            // Put the records into a more friendly format
            for (CSVRecord record : records) {

                String aName = record.get(0);
                String aCategory = record.get(1);
                String aServings = record.get(2);
                String aPrepTime = record.get(3);
                String anIngredients = record.get(4);
                String aStep1 = record.get(5);
                String aStep2 = record.get(6);
                String aStep3 = record.get(7);
                String aStep4 = record.get(8);
                String aStep5 = record.get(9);
                String aStep6 = record.get(10);
                String aStep7 = record.get(11);
                String aStep8 = record.get(12);
                String aStep9 = record.get(13);
                String anOriginalCreator = record.get(14);

                Name newName = (Name) findExistingObject(allNames, aName);
                Category newCategory = (Category) findExistingObject(allCategories, aCategory);
                Servings newServings = (Servings) findExistingObject(allServings, aServings);
                PrepTime newPrepTime = (PrepTime) findExistingObject(allPrepTimes, aPrepTime);
                Ingredients newIngredients = (Ingredients) findExistingObject(allIngredients, anIngredients);
                Step1 newStep1 = (Step1) findExistingObject(allStep1s, aStep1);
                Step2 newStep2 = (Step2) findExistingObject(allStep2s, aStep2);
                Step3 newStep3 = (Step3) findExistingObject(allStep3s, aStep3);
                Step4 newStep4 = (Step4) findExistingObject(allStep4s, aStep4);
                Step5 newStep5 = (Step5) findExistingObject(allStep5s, aStep5);
                Step6 newStep6 = (Step6) findExistingObject(allStep6s, aStep6);
                Step7 newStep7 = (Step7) findExistingObject(allStep7s, aStep7);
                Step8 newStep8 = (Step8) findExistingObject(allStep8s, aStep8);
                Step9 newStep9 = (Step9) findExistingObject(allStep9s, aStep9);
                OriginalCreator newOriginalCreator = (OriginalCreator) findExistingObject(allOriginalCreators, anOriginalCreator);

                if (newName == null){
                    newName = new Name(aName);
                    allNames.add(newName);
                }
                if (newCategory == null){
                    newCategory = new Category(aCategory);
                    allCategories.add(newCategory);
                }
                if (newServings == null){
                    newServings = new Servings(aServings);
                    allServings.add(newServings);
                }

                if (newPrepTime == null){
                    newPrepTime = new PrepTime(aPrepTime);
                    allPrepTimes.add(newPrepTime);
                }

                if (newIngredients == null){
                    newIngredients = new Ingredients(anIngredients);
                    allIngredients.add(newIngredients);
                }

                if (newStep1 == null){
                    newStep1 = new Step1(aStep1);
                    allStep1s.add(newStep1);
                }
                if (newStep2 == null){
                    newStep2 = new Step2(aStep2);
                    allStep2s.add(newStep2);
                }
                if (newStep3 == null){
                    newStep3 = new Step3(aStep3);
                    allStep3s.add(newStep3);
                }
                if (newStep4 == null){
                    newStep4 = new Step4(aStep4);
                    allStep4s.add(newStep4);
                }
                if (newStep5 == null){
                    newStep5 = new Step5(aStep5);
                    allStep5s.add(newStep5);
                }
                if (newStep6 == null){
                    newStep6 = new Step6(aStep6);
                    allStep6s.add(newStep6);
                }
                if (newStep7 == null){
                    newStep7 = new Step7(aStep7);
                    allStep7s.add(newStep7);
                }
                if (newStep8 == null){
                    newStep8 = new Step8(aStep8);
                    allStep8s.add(newStep8);
                }
                if (newStep9 == null){
                    newStep9 = new Step9(aStep9);
                    allStep9s.add(newStep9);
                }
                if (newOriginalCreator == null){
                    newOriginalCreator = new OriginalCreator(anOriginalCreator);
                    allOriginalCreators.add(newOriginalCreator);
                }
                Recipe newRecipe = new Recipe(newName, newCategory, newServings, newPrepTime, newIngredients, newStep1, newStep2, newStep3, newStep4, newStep5, newStep6, newStep7, newStep8, newStep9, newOriginalCreator);

                allRecipes.add(newRecipe);
            }
            // flag the data as loaded, so we don't do it twice
            isDataLoaded = true;

        } catch (IOException e) {
            System.out.println("Failed to load recipe data");
            e.printStackTrace();
        }
    }

    public static ArrayList<Name> getAllNames() {
        loadData();
        allNames.sort(new NameSorter());
        return allNames;
    }
    public static ArrayList<Category> getAllCategories() {
        loadData();
        allCategories.sort(new NameSorter());
        return allCategories;
    }
    public static ArrayList<Servings> getAllServings() {
        loadData();
        allServings.sort(new NameSorter());
        return allServings;
    }

    public static ArrayList<PrepTime> getAllPrepTimes() {
        loadData();
        allPrepTimes.sort(new NameSorter());
        return allPrepTimes;
    }

    public static ArrayList<Ingredients> getAllIngredients() {
        loadData();
        allIngredients.sort(new NameSorter());
        return allIngredients;
    }

    public static ArrayList<Step1> getStep1s() {
        loadData();
        allStep1s.sort(new NameSorter());
        return allStep1s;
    }
    public static ArrayList<Step2> getAllStep2s() {
        loadData();
        allStep2s.sort(new NameSorter());
        return allStep2s;
    }
    public static ArrayList<Step3> getAllStep3s() {
        loadData();
        allStep3s.sort(new NameSorter());
        return allStep3s;
    }
    public static ArrayList<Step4> getAllStep4s() {
        loadData();
        allStep4s.sort(new NameSorter());
        return allStep4s;
    }
    public static ArrayList<Step5> getAllStep5s() {
        loadData();
        allStep5s.sort(new NameSorter());
        return allStep5s;
    }
    public static ArrayList<Step6> getAllStep6s() {
        loadData();
        allStep6s.sort(new NameSorter());
        return allStep6s;
    }
    public static ArrayList<Step7> getAllStep7s() {
        loadData();
        allStep7s.sort(new NameSorter());
        return allStep7s;
    }
    public static ArrayList<Step8> getAllStep8s() {
        loadData();
        allStep8s.sort(new NameSorter());
        return allStep8s;
    }
    public static ArrayList<Step9> getAllStep9s() {
        loadData();
        allStep9s.sort(new NameSorter());
        return allStep9s;
    }
    public static ArrayList<OriginalCreator> getAllOriginalCreators() {
        loadData();
        allOriginalCreators.sort(new NameSorter());
        return allOriginalCreators;
    }

}

