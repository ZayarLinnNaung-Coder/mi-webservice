package org.ace.insurance.productservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ace.insurance.productservice.model.MainCategory;
import org.ace.insurance.productservice.model.NameText;
import org.ace.insurance.productservice.model.SubCategory;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MC001 {

    private String id;
    private String productId;
    private int order;
    private int version;
    private List<NT001> textList;
    private List<SC001> subCategoryList;

    public MC001(MainCategory m) {
        id = m.getId();
        order = m.getOrder();
        version = m.getVersion();
        productId = m.getProduct().getId();
        textList = new ArrayList<>();
        for (NameText text : m.getTextList()) {
            NT001 nameText001 = new NT001(text);
            textList.add(nameText001);
        }
        subCategoryList = new ArrayList<>();
        for (SubCategory subCategory : m.getSubCategoryList()) {
            SC001 subCategory001 = new SC001(subCategory);
            subCategoryList.add(subCategory001);
        }
    }

}
