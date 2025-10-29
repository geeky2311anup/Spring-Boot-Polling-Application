package com.anup.pollingApp.springBootPollingApplication;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.anup.pollingApp.springBootPollingApplication.web.admin.DishAdminController;
import com.anup.pollingApp.springBootPollingApplication.web.admin.RestaurantAdminController;
import com.anup.pollingApp.springBootPollingApplication.web.user.VoteController;

/**
 * Created by Anup Kumar Singh - 2025
 */

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ControllerContextTest {

    @Autowired
    private RestaurantAdminController raController;

    @Autowired
    private DishAdminController daController;

    @Autowired
    private VoteController voteController;

    @Test
    public void contextLoadsRestaurants() throws Exception {
        assertThat(raController).isNotNull();
    }

    @Test
    public void contextLoadsDishes() throws Exception{
        assertThat(daController).isNotNull();
    }

    @Test
    public void contextLoadsVotes() throws Exception {
        assertThat(voteController).isNotNull();
    }
}
