package com.ponto.inteligenteapi.entrypoints.dtos.responses;

import java.util.ArrayList;
import java.util.List;

/**
 * Response
 *
 * @author : Edson Costa
 * @since : 04/04/2021
 **/
public class Response<T> {

    private T data;
    private List<String> errors;

    public Response() {
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public List<String> getErrors() {
        if (this.errors == null) {
            this.errors = new ArrayList<String>();
        }
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
}
