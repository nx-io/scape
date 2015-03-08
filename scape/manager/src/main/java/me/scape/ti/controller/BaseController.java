package me.scape.ti.controller;

import java.beans.PropertyEditor;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import me.scape.ti.security.utils.ContextUtil;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

public abstract class BaseController {

    @InitBinder
    protected final void initBinder(final HttpServletRequest request, final ServletRequestDataBinder binder)
            throws Exception {
        PropertyEditor editor = new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true);
        binder.registerCustomEditor(Date.class, editor);
    }

    public int getMerchantUserId() {
        return ContextUtil.getUserId();
    }
}
