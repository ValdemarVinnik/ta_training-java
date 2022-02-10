package com.epam.training.student_Uladzimir_Vinnik.collections.taxi_park.action.exception;

public class DataSubmissionException extends RuntimeException {
    public DataSubmissionException() {
    }

    public DataSubmissionException(String message) {
        super(message);
    }

    public DataSubmissionException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataSubmissionException(Throwable cause) {
        super(cause);
    }

    public DataSubmissionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
