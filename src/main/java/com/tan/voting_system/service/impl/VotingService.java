package com.tan.voting_system.service.impl;

import com.tan.voting_system.pojo.VotingOptions;
import com.tan.voting_system.pojo.VotingThemes;

import java.text.ParseException;
import java.util.List;

/**
 * @author TanShan
 * @date 2022/12/29 16:38
 */
public interface VotingService {
    //插入主题
    public int createTopic(String theme,String end_time) throws ParseException;
    //根据主题查询
    public VotingThemes fondTheme(String theme);
    //插入选项
    public int createOptions(int themeId,String[] optionName);

    public List<VotingThemes> getConductVoting();

    //获取历史投票列表
    public List<VotingThemes> getHistoricalVote();

    public boolean isVote(int userId,int themeId);

    public VotingThemes fondThemeById(int themeId);

    public List<VotingOptions> getOptions(int themeId);

    public boolean vote(int optionsId);

    public boolean addData(int userId,int themeId);
}
