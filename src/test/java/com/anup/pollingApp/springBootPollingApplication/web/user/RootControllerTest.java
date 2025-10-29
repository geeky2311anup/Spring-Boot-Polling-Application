package com.anup.pollingApp.springBootPollingApplication.web.user;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static com.anup.pollingApp.springBootPollingApplication.RestaurantTestData.RESTAURANTS;
import static com.anup.pollingApp.springBootPollingApplication.RestaurantTestData.RESTAURANT_4;
import static com.anup.pollingApp.springBootPollingApplication.RestaurantTestData.assertMatch;
import static com.anup.pollingApp.springBootPollingApplication.TestUtil.contentJsonArray;
import static com.anup.pollingApp.springBootPollingApplication.TestUtil.mockAuthorize;
import static com.anup.pollingApp.springBootPollingApplication.TestUtil.userAuth;
import static com.anup.pollingApp.springBootPollingApplication.UserTestData.USER_1;
import static com.anup.pollingApp.springBootPollingApplication.UserTestData.USER_2;

import java.util.Comparator;

import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import com.anup.pollingApp.springBootPollingApplication.model.Restaurant;
import com.anup.pollingApp.springBootPollingApplication.web.AbstractControllerTest;

/**
 * Created by Anup Kumar Singh - 2025
 */

class RootControllerTest extends AbstractControllerTest {

    private static final String REST_URL = RootController.REST_URL + "/";

    @Test
    void getRestaurantsWithDishes() throws Exception {
        mockMvc.perform(get(REST_URL + "dishes")
                .with(userAuth(USER_1))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());

        mockAuthorize(USER_1);
        RESTAURANTS.sort(Comparator.comparing(Restaurant::getTitle));
        assertMatch(restaurantService.getRestaurantsWithDishes(), RESTAURANTS);
    }

    @Test
    void findByTitle() throws Exception {
        mockMvc.perform(get(REST_URL + "searchByTitle?title=ku")
                .with(userAuth(USER_2))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(contentJsonArray(RESTAURANT_4));

        mockAuthorize(USER_2);
        assertMatch(restaurantService.findByTitle("ku"), RESTAURANT_4);
    }
}
