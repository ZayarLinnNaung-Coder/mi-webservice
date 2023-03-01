package org.ace.insurance.productservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ace.insurance.utilityservice.embeddable.UserRecorder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubCategory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "subCategory", orphanRemoval = true)
    private List<NameText> textList;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "IMAGEID")
    private PhotoImage image;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "MAINCATEGORYID", referencedColumnName = "ID")
    private MainCategory mainCategory;

    @Column(name = "ORDERNUMBER")
    private int order;

    @Embedded
    private UserRecorder recorder;

    @Version
    private int version;

    public List<NameText> getTextList() {
        if (textList == null) {
            textList = new ArrayList<NameText>();
        }
        return textList;
    }

    public void addNameAndText(NameText nameAndText) {
        if (this.textList == null) {
            textList = new ArrayList<NameText>();
        }
        this.textList.add(nameAndText);
        nameAndText.setSubCategory(this);
    }

}
