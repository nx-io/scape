package me.scape.ti.exception;

import java.util.ArrayList;
import java.util.List;

import me.scape.ti.constant.ResponseCode;

public class CPException extends Exception {

    private static final long serialVersionUID = -3843875618738029785L;

    private List<String> errorMessages;

    private ResponseCode code;

    public CPException() {
    }

    public final List<String> getErrorMessages() {
        return errorMessages;
    }

    public final void setErrorMessages(final List<String> errorMessages) {
        this.errorMessages = errorMessages;
    }

    public final void setCode(final ResponseCode code) {
        this.code = code;
    }

    public final ResponseCode getCode() {
        return code;
    }

    public final void addErrorMessage(final String message) {
        if (null == errorMessages) {
            errorMessages = new ArrayList<String>();
        }
        errorMessages.add(message);
    }
}
