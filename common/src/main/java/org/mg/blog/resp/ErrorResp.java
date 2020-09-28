
package org.mg.blog.resp;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ErrorResp {
    private String errorDesc;
}
