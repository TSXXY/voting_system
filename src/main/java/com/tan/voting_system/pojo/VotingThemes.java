package com.tan.voting_system.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 投票主题
 * @author TanShan
 * @date 2022/12/27 21:22
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VotingThemes {
    private int id;
    private String theme;
    private Date start_time;
    private Date end_time;
}
