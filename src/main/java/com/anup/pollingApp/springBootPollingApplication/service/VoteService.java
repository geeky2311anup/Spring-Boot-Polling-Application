package com.anup.pollingApp.springBootPollingApplication.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.security.access.annotation.Secured;

import com.anup.pollingApp.springBootPollingApplication.model.Vote;
import com.anup.pollingApp.springBootPollingApplication.to.VoteTo;

/**
 * Created by Anup Kumar Singh - 2025
 */

public interface VoteService {

    Optional<Vote> getTodayUserVote(int userId, LocalDate date);

    @Secured({"ROLE_USER"})
    VoteTo create(int userId, int restaurantId);

    @Secured({"ROLE_USER"})
    VoteTo createOrUpdate(int userId, int restaurantId);

    @Secured({"ROLE_USER"})
    List<Vote> getVotesBetween(int userId, LocalDate startDate, LocalDate endDate);
}
