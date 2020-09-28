package org.mg.blog.resp;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 功能描述
 *
 * @since 2020-05-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class UpdateByIdResp {
    private int count;
    private String desc;
}
