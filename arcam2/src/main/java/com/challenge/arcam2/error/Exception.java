package com.challenge.arcam2.error;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class Exception extends RuntimeException{
    private static final long serialVersionUID = 1L;
    private ErrorModel error;

    public Exception(ErrorModel error){
        super();
        this.error = error;
    }
}
