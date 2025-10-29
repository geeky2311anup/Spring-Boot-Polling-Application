package com.anup.pollingApp.springBootPollingApplication.web.json;

import static com.anup.pollingApp.springBootPollingApplication.RestaurantTestData.RESTAURANTS;
import static com.anup.pollingApp.springBootPollingApplication.RestaurantTestData.RESTAURANT_2;
import static com.anup.pollingApp.springBootPollingApplication.RestaurantTestData.assertMatch;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.anup.pollingApp.springBootPollingApplication.model.Restaurant;

/**
 * Created by Anup Kumar Singh - 2025
 */

public class JsonUtilTest {

    @Test
    public void testReadWriteValue() throws Exception {
        String json = JsonUtil.writeValue(RESTAURANT_2);
        System.out.println(json);
        Restaurant restaurant = JsonUtil.readValue(json, Restaurant.class);
        assertMatch(restaurant, RESTAURANT_2);
    }

    @Test
    public void testReadWriteValues() throws Exception {
        String json = JsonUtil.writeValue(RESTAURANTS);
        System.out.println(json);
        List<Restaurant> restaurants = JsonUtil.readValues(json, Restaurant.class);
        assertMatch(restaurants, RESTAURANTS);
    }
}
