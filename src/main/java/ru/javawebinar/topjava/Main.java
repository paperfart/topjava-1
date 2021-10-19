package ru.javawebinar.topjava;

import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.repository.inmemory.MealCrudMap;

import java.time.LocalDateTime;

/**
 * @see <a href="http://topjava.herokuapp.com">Demo application</a>
 * @see <a href="https://github.com/JavaOPs/topjava">Initial project</a>
 */
public class Main {
    private final static MealCrudMap MEAL_CRUD_MAP = new MealCrudMap();
    static Meal lunch = new Meal(LocalDateTime.now(), "Lunch", 300);
    static Meal updated = new Meal(lunch.getDateTime(), lunch.getDescription(), 600);

    public static void main(String[] args) {

        MEAL_CRUD_MAP.create(lunch);
        MEAL_CRUD_MAP.create(lunch);
        MEAL_CRUD_MAP.create(lunch);
        MEAL_CRUD_MAP.create(lunch);
        System.out.println(MEAL_CRUD_MAP.get(1));
        MEAL_CRUD_MAP.update(1, updated);
        System.out.println(MEAL_CRUD_MAP.get(1));
        MEAL_CRUD_MAP.delete(1);
        MEAL_CRUD_MAP.getAll().forEach(System.out::println);
        System.out.println(MEAL_CRUD_MAP.get(1));

    }
}
