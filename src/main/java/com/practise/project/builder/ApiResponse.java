package com.practise.project.builder;

import java.io.Serializable;
import lombok.NoArgsConstructor;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiResponse implements Serializable{
    private static final long serialVersionUID = 2203986815774042259L;
    private String status;
    private String message;
    private String statusCode;
    private transient Object data;
    private ResponseMetadata meta;
    private List<FieldError> errors;

}
