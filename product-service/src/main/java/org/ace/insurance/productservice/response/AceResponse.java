package org.ace.insurance.productservice.response;

import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AceResponse {
    private int code;
    private HttpStatus status;
    private String message;
    private Object data;
}
