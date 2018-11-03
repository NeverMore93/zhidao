package com.yuan.zhidao.enums;

public enum Authority {
    GENERAL("general"),
    ADMIN("admin");
    private final String authority;
    private Authority(final String authority) {
        this.authority = authority;
    }

    public String toString() {
        return authority;
    }

}
