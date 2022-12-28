package com.tan.voting_system.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 选项实体类
 * @author TanShan
 * @date 2022/12/27 21:18
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VotingOptions {
    private int id;
    private int voting_theme_id;
    private String option_name;
}
