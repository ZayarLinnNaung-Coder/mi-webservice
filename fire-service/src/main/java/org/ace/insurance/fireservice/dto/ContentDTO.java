package org.ace.insurance.fireservice.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.ace.insurance.fireservice.model.CargoType;
import org.ace.insurance.productservice.model.Currency;
import org.ace.insurance.productservice.model.PaymentType;

@Data
@NoArgsConstructor
public class ContentDTO {

    String id;
    String name;

    public ContentDTO(CargoType cargoType){
        this.id = cargoType.getId();
        this.name = cargoType.getName();
    }

    public ContentDTO(PaymentType paymentType){
        this.id = paymentType.getId();
        this.name = paymentType.getName();
    }

    public ContentDTO(Currency currency){
        this.id = currency.getId();
        this.name = currency.getCurrencyCode();
    }
}
