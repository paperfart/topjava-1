package ru.javawebinar.topjava.repository.inmemory;

import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.repository.MealCrud;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class MealCrudMap implements MealCrud {
    AtomicInteger id = new AtomicInteger();
    Map<Integer, Meal> map = new ConcurrentHashMap<>();

    @Override
    public Meal create(Meal m) {
        return map.computeIfAbsent(id.addAndGet(1), integer -> m);
    }

    @Override
    public void update(int id, Meal m) {
        map.computeIfPresent(id, (integer, meal) -> m);
    }

    @Override
    public void delete(int id) {
        map.remove(id);
    }
}
