package org.mg.blog.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 基本响应信息
 *
 * @since 2020-05-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Result<T> implements Serializable {
    private String respDateTime = System.currentTimeMillis() + "";
    private Status status = Status.SUCCESS;
    private T result;
}
