package com.tan.voting_system.dao.impl;

import com.tan.voting_system.dao.VotingDao;
import com.tan.voting_system.pojo.VotingOptions;
import com.tan.voting_system.pojo.VotingRecords;
import com.tan.voting_system.pojo.VotingThemes;
import com.tan.voting_system.utils.BaseDao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author TanShan
 * @date 2022/12/29 14:30
 */
public class VotingDaoImpl extends BaseDao implements VotingDao {
    @Override
    public int createTopic(String theme, String end_time) throws ParseException {
        SimpleDateFormat sdf =  new SimpleDateFormat( "yyyy-MM-dd" );
        Date parse = sdf.parse(end_time);
        String sql = "insert into voting_themes(theme, start_time, end_time) values (?,now(),?)";
        return  update(sql,theme,parse);
    }

    @Override
    public VotingThemes fondTheme(String theme) {
        String sql = "select * from voting_themes where theme = ?";
        return queryForOne(VotingThemes.class,sql,theme);
    }

    @Override
    public int createOptions(int themeId, String optionName) {
        String sql = "insert into voting_options(voting_theme_id, option_name) values (?,?)";
        return update(sql,themeId,optionName);
    }

    @Override
    public List<VotingThemes> getConductVoting() {
        String sql = "select * from voting_themes where not end_time < now()";
        return queryForList(VotingThemes.class,sql);
    }

    @Override
    public List<VotingThemes> getHistoricalVote() {
        String sql = "select * from voting_themes where not end_time > now()";
        return queryForList(VotingThemes.class,sql);
    }

    @Override
    public boolean isVote(int userId, int themeId) {
        String sql = "select * from voting_records where user_id = ? and voting_theme_id = ?";
        VotingRecords votingRecords = queryForOne(VotingRecords.class, sql, userId, themeId);
        return votingRecords != null;
    }

    @Override
    public VotingThemes fondThemeById(int themeId) {
        String sql = "select * from voting_themes where id = ?";
        return queryForOne(VotingThemes.class, sql, themeId);
    }

    @Override
    public List<VotingOptions> getOptions(int themeId) {
        String sql = "select * from voting_options where voting_theme_id = ?";
        return queryForList(VotingOptions.class,sql,themeId);
    }

    @Override
    public boolean vote(int optionsId) {
        String sql = "update voting_options set vote_number= vote_number+1 where id = ?";
        return update(sql,optionsId)>0;
    }

    @Override
    public boolean addData(int userId, int themeId) {
        String sql = "insert into voting_records(user_id, voting_theme_id) values (?,?)";
        return update(sql,userId,themeId)>0;
    }
}
