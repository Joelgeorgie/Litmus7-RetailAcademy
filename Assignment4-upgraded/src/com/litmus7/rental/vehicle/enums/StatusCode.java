package com.litmus7.rental.vehicle.enums;

/**
 * The {@code StatusCode} enum represents standardized status codes
 * used in controller responses to indicate success, client errors,
 * or server failures.
 * <p>
 * These are similar to HTTP status codes and help maintain consistency
 * in API-style responses.
 * </p>
 * 
 * <p><strong>Author:</strong> Joel Georgie</p>
 */
public enum StatusCode {

    /**
     * Indicates a successful operation.
     */
    SUCCESS(200),

    /**
     * Indicates a resource was created successfully.
     */
    CREATED(201),

    /**
     * Indicates the client sent an invalid request.
     */
    BAD_REQUEST(400),

    /**
     * Indicates the requested resource was not found.
     */
    NOT_FOUND(404),

    /**
     * Indicates an internal server error occurred.
     */
    SERVER_ERROR(500);

    private final int code;

    /**
     * Constructs a StatusCode with the given code.
     *
     * @param code the numeric status code
     */
    StatusCode(int code) {
        this.code = code;
    }

    /**
     * Returns the numeric code associated with this status.
     *
     * @return the integer status code
     */
    public int getCode() {
        return code;
    }
}
