package com.anup.pollingApp.springBootPollingApplication.web.user;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static com.anup.pollingApp.springBootPollingApplication.RestaurantTestData.RESTAURANT_5;
import static com.anup.pollingApp.springBootPollingApplication.RestaurantTestData.RES_ID;
import static com.anup.pollingApp.springBootPollingApplication.TestUtil.contentJson;
import static com.anup.pollingApp.springBootPollingApplication.TestUtil.mockAuthorize;
import static com.anup.pollingApp.springBootPollingApplication.TestUtil.userAuth;
import static com.anup.pollingApp.springBootPollingApplication.UserTestData.USER_1;
import static com.anup.pollingApp.springBootPollingApplication.UserTestData.USER_2;
import static com.anup.pollingApp.springBootPollingApplication.VoteTestData.VOTE_HISTORY_USER_1;
import static com.anup.pollingApp.springBootPollingApplication.VoteTestData.assertMatch;

import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import com.anup.pollingApp.springBootPollingApplication.web.AbstractControllerTest;

/**
 * Created by Anup Kumar Singh - 2025
 */

class VoteControllerTest extends AbstractControllerTest {

	private static final String REST_URL = VoteController.REST_URL + "/";

	@Test
	void testGetUnAuthorized() throws Exception {
		mockMvc.perform(get(REST_URL + "history")
				.contentType(MediaType.APPLICATION_JSON))
		        .andDo(print())
				.andExpect(status().isUnauthorized());
	}

	@Test
	void vote() throws Exception {
		mockMvc.perform(post(REST_URL + (RES_ID + 4))
				.with(userAuth(USER_2))
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated())
				.andDo(print())
				.andExpect(contentJson(RESTAURANT_5));
	}

	@Test
	void getVotesBetween() throws Exception {
		mockMvc.perform(get(REST_URL + "history")
				.with(userAuth(USER_1))
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andDo(print());

		mockAuthorize(USER_1);
		assertMatch(voteService.getVotesBetween(1017, null, null), VOTE_HISTORY_USER_1);
	}
}
