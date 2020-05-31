package org.launchcode.muriel_mays.models;

import java.util.Objects;

public class RecipeField {

        private int id;
        private static int nextId = 1;
        private String value;

        public RecipeField() {
            id = nextId;
            nextId++;
        }

        public RecipeField(String value) {
            this();
            this.value = value;
        }

        @Override
        public String toString() {
            return value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof RecipeField)) return false;
            RecipeField jobField = (RecipeField) o;
            return id == jobField.id;
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }

        // Getters and setters.
        public int getId() {
            return id;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }