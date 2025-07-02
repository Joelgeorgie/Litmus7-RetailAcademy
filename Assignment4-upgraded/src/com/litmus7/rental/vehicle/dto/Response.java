package com.litmus7.rental.vehicle.dto;

/**
 * The {@code Response<T>} class is a generic response wrapper used by the controller
 * to encapsulate results, status codes, messages, and arbitrary data.
 *
 * <p>This promotes uniform handling of successful and error responses.</p>
 *
 * @param <T> the type of the data included in the response
 * 
 * <p><strong>Author:</strong> Joel Georgie</p>
 */
public class Response<T> {

    private int statusCode;
    private String errorMessage;
    private T data;

    /**
     * Gets the status code of the response.
     *
     * @return status code (e.g., 200, 400)
     */
    public int getStatusCode() {
        return statusCode;
    }

    /**
     * Sets the status code of the response.
     *
     * @param statusCode the HTTP-like status code to set
     */
    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    /**
     * Gets the error message, if any.
     *
     * @return error message string
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * Sets the error message in case of failure.
     *
     * @param errorMessage the message describing the error
     */
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    /**
     * Gets the data included in the response.
     *
     * @return the response data
     */
    public T getData() {
        return data;
    }

    /**
     * Sets the data for the response.
     *
     * @param data the data to include
     */
    public void setData(T data) {
        this.data = data;
    }
}
