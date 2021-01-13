package org.smart4j.charter.model;

import lombok.Data;

@Data
public class Customer {
    private Long id;
    private String name;
    private String telephone;
    private String email;
    private String contact;
    private String photo;
    private String remark;

}
