package org.ace.insurance.productservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ace.insurance.productservice.model.NameText;
import org.ace.insurance.utilityservice.enumeration.Language;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NT001 {

    private String id;
    private String content;
    private String name;
    private Language language;
    private int version;

    public NT001(NameText nameText) {
        id = nameText.getId();
        content = nameText.getContent();
        name = nameText.getName();
        language = nameText.getLanguage();
        version = nameText.getVersion();
    }
}
