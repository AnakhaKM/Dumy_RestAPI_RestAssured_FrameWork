package com.automation.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.cucumber.java.en_pirate.Gangway;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateRecordPojo {
    String name;
    double salary;
    int age;
}
