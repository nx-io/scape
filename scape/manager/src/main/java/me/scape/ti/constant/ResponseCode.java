package me.scape.ti.constant;

public enum ResponseCode {
    BAD_REQUEST(400),

    FORBIDDEN(403),

    SERVER_ERROR(500),

    INVALID_PARAMETER(10000),

    FILE_UPLOAD_ERROR(11000);

    private int value;

    private ResponseCode(final int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
