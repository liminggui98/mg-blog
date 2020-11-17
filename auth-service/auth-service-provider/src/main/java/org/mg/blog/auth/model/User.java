package org.mg.blog.auth.model;

import lombok.Data;

@Data
public class User {
    private String userName;

    private String pass;

    private Boolean rememberMe;
}
