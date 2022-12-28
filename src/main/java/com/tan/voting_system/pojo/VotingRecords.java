package com.tan.voting_system.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 投票主题和选项中间实体类
 * @author TanShan
 * @date 2022/12/27 21:20
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VotingRecords {
    private int id;
    private int user_id;
    private int voting_option_id;
}
