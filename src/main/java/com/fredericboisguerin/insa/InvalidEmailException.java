package com.fredericboisguerin.insa;

public class InvalidEmailException extends Exception {
    public InvalidEmailException(String emailException){
        super(emailException);
    }
}
