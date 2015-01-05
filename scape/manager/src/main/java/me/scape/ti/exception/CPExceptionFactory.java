package me.scape.ti.exception;

import java.util.Arrays;
import java.util.List;

import me.scape.ti.constant.ResponseCode;

import org.apache.log4j.Logger;

public final class CPExceptionFactory {

    public static final Logger LOGGER = Logger.getLogger(CPExceptionFactory.class);

    private CPExceptionFactory() {
    }

    public static <T extends CPException> T getException(final Class<T> exceptionClass, final ResponseCode code,
            final String... messages) {
        T t = null;
        if (null != messages) {
            List<String> messageList = Arrays.asList(messages);
            t = getException(exceptionClass, code, messageList);

        }
        return t;
    }

    public static <T extends CPException> T getException(final Class<T> exceptionClass, final ResponseCode code,
            final List<String> messages) {
        T t = null;
        try {
            t = exceptionClass.newInstance();
            for (String message : messages) {
                t.addErrorMessage(message);
            }
            t.setCode(code);
        } catch (InstantiationException e) {
            LOGGER.debug(e.getMessage(), e);
        } catch (IllegalAccessException e) {
            LOGGER.debug(e.getMessage(), e);
        }
        return t;
    }
}
