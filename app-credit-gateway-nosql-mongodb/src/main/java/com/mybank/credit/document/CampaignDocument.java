package com.mybank.credit.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document("campaign")
@NoArgsConstructor
@AllArgsConstructor
public class CampaignDocument {
    @Id
    private String _id;

    @Field(value = "TypeDocument")
    private String typeDocument;

    @Field(value = "DocumentNumber")
    private String documentNumber;

    @Field(value = "IsRisk")
    private boolean risk;

    @Field(value = "Tea")
    private Double tea;
}
