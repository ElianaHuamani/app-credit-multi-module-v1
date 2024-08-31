package com.mybank.credit.mapper;

import com.mybank.credit.document.DesgravamenDocument;
import com.mybank.credit.usecases.model.bd.DesgravamenBDResponse;

public interface DesgravamenMongoAdapterMapper {
    DesgravamenBDResponse to(DesgravamenDocument desgravamenDocument);
}
