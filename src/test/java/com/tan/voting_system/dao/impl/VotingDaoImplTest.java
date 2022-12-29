package com.tan.voting_system.dao.impl;

import com.tan.voting_system.dao.VotingDao;
import com.tan.voting_system.pojo.VotingThemes;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author TanShan
 * @date 2022/12/29 14:38
 */
class VotingDaoImplTest {

    VotingDao votingDao = new VotingDaoImpl();
    @Test
    void createTopic() throws ParseException {
        votingDao.createTopic("sadsadsda", "2022-12-07");
    }

    @Test
    void testCreateTopic() {
    }

    @Test
    void fondTheme() {
        VotingThemes theme = votingDao.fondTheme("母亲和老婆掉水里你先救谁");
        System.out.println(theme);
    }

    @Test
    void createOptions() {
        System.out.println(votingDao.createOptions(3, "dsadadadad"));
    }

    @Test
    void getConductVoting() {
        List<VotingThemes> conductVoting = votingDao.getConductVoting();
        System.out.println("conductVoting = " + conductVoting);
    }

    @Test
    void isVote() {
        System.out.println("votingDao.isVote(1,1) = " + votingDao.isVote(1, 1));
    }

    @Test
    void fondThemeById() {
        System.out.println("votingDao.fondThemeById(1) = " + votingDao.fondThemeById(1));
    }

    @Test
    void getOptions() {
        System.out.println("votingDao.getOptions(1) = " + votingDao.getOptions(1));
    }
}