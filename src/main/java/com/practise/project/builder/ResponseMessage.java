package com.practise.project.builder;

import java.io.Serializable;
import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseMessage implements Serializable{
	private static final long serialVersionUID = 201045184942402918L;
    private Integer id;
    private String type;
    private String messageKey;
    private String defaultMessage;
    private Integer httpStatusCode;
    private String customStatusCode;

    public HttpStatus getHttpStatus() {
        HttpStatus hs = null;
        if (this.httpStatusCode != null) {
            hs = HttpStatus.resolve(this.httpStatusCode);
        }

        if (hs == null) {
            throw new RuntimeException("HttpStatus could not found for httpStatusCode: " + this.httpStatusCode);
        } else {
            return hs;
        }
    } 
}
