package com.controller.design.requestentity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Event implements Serializable {

    private String person_id;
    private String person_fname;
    private String person_lname;
    private String person_email;
    private String person_mobile_number;
    private String person_mobile_model;


}
