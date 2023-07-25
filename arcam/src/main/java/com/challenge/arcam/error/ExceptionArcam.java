package com.challenge.arcam.error;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class ExceptionArcam extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private ErrorModel error;

    public ExceptionArcam(ErrorModel error) {
        super();
        this.error = error;
    }
}
