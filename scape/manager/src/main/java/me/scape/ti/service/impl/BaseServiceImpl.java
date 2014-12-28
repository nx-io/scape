package me.scape.ti.service.impl;

import me.scape.ti.security.utils.ContextUtil;

public abstract class BaseServiceImpl {

    public int getMerchantUserId() {
        return ContextUtil.getUserId();
    }
}
