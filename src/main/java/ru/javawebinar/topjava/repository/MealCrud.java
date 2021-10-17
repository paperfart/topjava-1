package ru.javawebinar.topjava.repository;

import ru.javawebinar.topjava.model.Meal;

public interface MealCrud {
    public Meal create(Meal meal);

    public void update(int id, Meal meal);

    public void delete(int id);

}
