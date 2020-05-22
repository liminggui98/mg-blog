package org.mg.blog.common.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 基本响应信息
 *
 * @since 2020-05-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Result<T> implements Serializable {
    private Date respDateTime;
    private Status status;
    private T result;
}
