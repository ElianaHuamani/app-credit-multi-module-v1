package com.mybank.credit.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;

@Data
@Document("holiday")
@NoArgsConstructor
@AllArgsConstructor
public class HolidayDocument {
    @Id
    private String _id;

    @Field(value = "HolidayDate")
    private LocalDate holidayDate;

    @Field(value = "Name")
    private String name;
}
