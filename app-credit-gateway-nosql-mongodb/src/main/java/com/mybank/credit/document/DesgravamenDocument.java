package com.mybank.credit.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document("desgravamen")
@NoArgsConstructor
@AllArgsConstructor
public class DesgravamenDocument {
    @Id
    private String _id;

    @Field(value = "MinTerm")
    private Double minTerm;

    @Field(value = "MaxTerm")
    private Double maxTerm;

    @Field(value = "Rate")
    private Double rate;
}
