package com.jt.pojo;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class AxiosUser {
    private Integer id;
    private String name;
}
