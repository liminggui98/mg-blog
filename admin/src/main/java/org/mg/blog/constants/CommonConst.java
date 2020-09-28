
package org.mg.blog.constants;

/**
 * 常量类
 *
 * @since 2020-09-25
 */
public class CommonConst {

    /**
     * 安全密码(UUID生成)，作为盐值用于用户密码的加密
     */
    public static final String ZYD_SECURITY_KEY = "929123f8f17944e8b0a531045453e1f1";

    /**
     * 程序默认的错误状态码
     */
    public static final int DEFAULT_ERROR_CODE = 500;

    /**
     * 程序默认的成功状态码
     */
    public static final int DEFAULT_SUCCESS_CODE = 200;

    /**
     * page 字段
     */
    public static final String PAGE_FIELD = "PAGE";

    /**
     * 表 option 字段
     */
    public static final String TABLE_OPTION_FIELD = "tableOption";

    /**
     * url 字段
     */
    public static final String URL_FIELD = "url";

    /**
     * 列字段
     */
    public static final String COLS_FIELD = "cols";

    /**
     * 隐藏构造器
     */
    private CommonConst() {
    }

}
