package org.ace.insurance.productservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ace.insurance.productservice.model.NameText;
import org.ace.insurance.productservice.model.SubCategory;

import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class SC001 {

    private String id;
    private int order;
    private int version;
    private List<NT001> textList;


    public SC001(SubCategory subCategory) {
        id = subCategory.getId();
        order = subCategory.getOrder();
        version = subCategory.getVersion();
        textList = new ArrayList<>();
        for (NameText nameText : subCategory.getTextList()) {
            NT001 nameText001 = new NT001(nameText);
            textList.add(nameText001);
        }
    }
}
