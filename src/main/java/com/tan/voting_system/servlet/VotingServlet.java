package com.tan.voting_system.servlet;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.tan.voting_system.pojo.VotingOptions;
import com.tan.voting_system.pojo.VotingThemes;
import com.tan.voting_system.service.impl.VotingService;
import com.tan.voting_system.service.impl.impl.VotingServiceImpl;
import com.tan.voting_system.utils.BaseServlet;
import com.tan.voting_system.utils.WebUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author TanShan
 * @date 2022/12/29 14:09
 */
@WebServlet("/voting")
public class VotingServlet extends BaseServlet {
    VotingService votingService = new VotingServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    public void createVote(HttpServletRequest request,HttpServletResponse response) throws ParseException, ServletException, IOException {
        String theme = request.getParameter("theme");
        String[] optionNames = request.getParameterMap().get("option_name");
        String endTime = request.getParameter("end_time");
        int topic = votingService.createTopic(theme, endTime);
        if (topic > 0 ){
            VotingThemes votingThemes = votingService.fondTheme(theme);
            if (votingThemes!=null) {
                votingService.createOptions(votingThemes.getId(),optionNames);
            }
        }
        request.getRequestDispatcher("home.jsp").forward(request,response);

    }

    public void getConductVoting(HttpServletRequest request,HttpServletResponse response) throws IOException {
        List<VotingThemes> conductVoting = votingService.getConductVoting();
        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        stringObjectHashMap.put("code",0);
        stringObjectHashMap.put("msg","ok");
        stringObjectHashMap.put("count",conductVoting.size());
        stringObjectHashMap.put("data",conductVoting);
        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writeValueAsString(stringObjectHashMap);
        response.getWriter().write(s);
    }


    public void getHistoricalVote(HttpServletRequest request,HttpServletResponse response) throws IOException {
        List<VotingThemes> conductVoting = votingService.getHistoricalVote();
        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        stringObjectHashMap.put("code",0);
        stringObjectHashMap.put("msg","ok");
        stringObjectHashMap.put("count",conductVoting.size());
        stringObjectHashMap.put("data",conductVoting);
        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writeValueAsString(stringObjectHashMap);
        response.getWriter().write(s);
    }

    public void goToVote(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        int userid = Integer.parseInt(request.getParameter("userid"));
        int themeid = Integer.parseInt(request.getParameter("themeid"));
        int num = 0;
        boolean vote = votingService.isVote(userid, themeid);
        request.setAttribute("isVote",vote);
        VotingThemes votingThemes = votingService.fondThemeById(themeid);
        request.setAttribute("votingThemes",votingThemes);
        List<VotingOptions> options = votingService.getOptions(themeid);
        for (VotingOptions option : options) {
           num+= option.getVote_number();
        }
        request.setAttribute("num",num);
        request.setAttribute("options",options);
        request.getRequestDispatcher("vote.jsp").forward(request,response);


    }

    public void vote(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        int optionsid = Integer.parseInt(request.getParameter("optionid"));
        int userid = Integer.parseInt(request.getParameter("userid"));
        int themeId = Integer.parseInt(request.getParameter("themeId"));
        boolean vote1 = votingService.isVote(userid,themeId);
        if (!vote1){
            boolean vote = votingService.vote(optionsid);
            if (vote){
                boolean b = votingService.addData(userid, themeId);
                if (b){
                    request.getRequestDispatcher("home.jsp").forward(request,response);
                }
            }
            else {
                request.getRequestDispatcher("home.jsp").forward(request,response);
            }
        }



    }
}
