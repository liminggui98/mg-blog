package org.mg.blog.user.vo.resp;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 功能描述
 *
 * @since 2020-05-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class AddUserResp implements Serializable {
    private String desc;
    private int updateCount;
}
