package ru.javawebinar.topjava.repository.inmemory;

import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.repository.MealCrud;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class MealCrudMap implements MealCrud {
    AtomicInteger identification = new AtomicInteger();
    Map<Integer, Meal> map = new ConcurrentHashMap<>();

    @Override
    public Meal create(Meal m) {
        return map.computeIfAbsent(identification.addAndGet(1), integer -> m);
    }

    @Override
    public void update(int id, Meal m) {
        map.computeIfPresent(id, (integer, meal) -> m);
    }

    @Override
    public void delete(int id) {
        if (map.remove(id) == null) {
            throw new RuntimeException(id + " not found");
        }
    }

    @Override
    public Meal get(int id) {
        if (map.containsKey(id)) {
            return map.get(id);
        }
        throw new RuntimeException(id + " not found");
    }

    @Override
    public List<Meal> getAll() {
        return new ArrayList<>(map.values());
    }
}
