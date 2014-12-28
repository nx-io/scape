package me.scape.ti.controller;

import me.scape.ti.security.utils.ContextUtil;

public abstract class BaseController {

    public int getMerchantUserId() {
        return ContextUtil.getUserId();
    }
}
