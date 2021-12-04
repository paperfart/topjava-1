package ru.javawebinar.topjava.web.meal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.javawebinar.topjava.model.Meal;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

@Controller
public class JspMealController {
    @Autowired
    MealRestController controller;

    @GetMapping("/meals")
    public String getMeals(Model model) {
        model.addAttribute("meals", controller.getAll());
        return "meals";
    }

    @GetMapping("/meals/delete")
    public String delMeal(@RequestParam String id) {
        controller.delete(Integer.parseInt(id));
        return "redirect:/meals";
    }

    @GetMapping("/meals/create")
    public String createMeal(HttpServletRequest request) {
        final Meal meal = new Meal(LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES), "", 1000);
        request.setAttribute("meal", meal);
        return "mealForm";
    }

    @GetMapping("/meals/update")
    public String updateMeal(HttpServletRequest request, Model model) {
        Meal meal = controller.get(getId(request));
        model.addAttribute("meal", meal);
        return "mealForm";
    }

    @PostMapping("/meals/create")
    public String saveMeal(HttpServletRequest request) {
        Meal meal = new Meal(
                LocalDateTime.parse(request.getParameter("dateTime")),
                request.getParameter("description"),
                Integer.parseInt(request.getParameter("calories")));
        if (StringUtils.hasLength(request.getParameter("id"))) {
            controller.update(meal, getId(request));
        } else {
            controller.create(meal);
        }
        return "redirect:/meals";
    }

    private int getId(HttpServletRequest request) {
        String paramId = Objects.requireNonNull(request.getParameter("id"));
        return Integer.parseInt(paramId);
    }
}
