package com.controller.design.responseentity;


import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Response<T>  implements Serializable {
    private String status;
    private T messageBody;
}
