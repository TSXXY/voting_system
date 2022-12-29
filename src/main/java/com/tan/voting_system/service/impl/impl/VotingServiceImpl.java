package com.tan.voting_system.service.impl.impl;

import com.tan.voting_system.dao.VotingDao;
import com.tan.voting_system.dao.impl.VotingDaoImpl;
import com.tan.voting_system.pojo.VotingOptions;
import com.tan.voting_system.pojo.VotingThemes;
import com.tan.voting_system.service.impl.VotingService;

import java.text.ParseException;
import java.util.List;

/**
 * @author TanShan
 * @date 2022/12/29 16:39
 */
public class VotingServiceImpl implements VotingService {

    VotingDao votingDao = new VotingDaoImpl();
    @Override
    public int createTopic(String theme, String end_time) throws ParseException {
        return votingDao.createTopic(theme,end_time);
    }

    @Override
    public VotingThemes fondTheme(String theme) {
        return votingDao.fondTheme(theme);
    }

    @Override
    public int createOptions(int themeId, String[] optionName) {
        int flag = 0;
        for (String s : optionName) {
          flag +=  votingDao.createOptions(themeId,s);
        }
        return flag;
    }

    @Override
    public List<VotingThemes> getConductVoting() {
       return votingDao.getConductVoting();
    }

    @Override
    public List<VotingThemes> getHistoricalVote() {
        return votingDao.getHistoricalVote();
    }

    @Override
    public boolean isVote(int userId, int themeId) {
        return votingDao.isVote(userId,themeId);
    }

    @Override
    public VotingThemes fondThemeById(int themeId) {
        return votingDao.fondThemeById(themeId);
    }

    @Override
    public List<VotingOptions> getOptions(int themeId) {
        return votingDao.getOptions(themeId);
    }

    @Override
    public boolean vote(int optionsId) {
        return votingDao.vote(optionsId);
    }

    @Override
    public boolean addData(int userId, int themeId) {
        return votingDao.addData(userId,themeId);
    }
}
