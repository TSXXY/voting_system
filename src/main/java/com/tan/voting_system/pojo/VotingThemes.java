package com.tan.voting_system.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private String start_time;
    private String end_time;
}
