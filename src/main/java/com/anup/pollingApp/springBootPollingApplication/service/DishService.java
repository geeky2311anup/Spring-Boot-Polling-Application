package com.anup.pollingApp.springBootPollingApplication.service;

import java.util.List;

import org.springframework.security.access.annotation.Secured;

import com.anup.pollingApp.springBootPollingApplication.model.Dish;
import com.anup.pollingApp.springBootPollingApplication.util.exceptions.NotFoundException;

/**
 * Created by Anup Kumar Singh - 2025
 */

public interface DishService {
    @Secured({"ROLE_ADMIN"})
    List<Dish> getAll();

    @Secured({"ROLE_ADMIN"})
    Dish retrieve(int id) throws NotFoundException;

    @Secured({"ROLE_ADMIN"})
    void delete(int id) throws NotFoundException;

    @Secured({"ROLE_ADMIN"})
    Dish create(Dish dish);

    @Secured({"ROLE_ADMIN"})
    void update(Dish dish, int id) throws NotFoundException;
}
