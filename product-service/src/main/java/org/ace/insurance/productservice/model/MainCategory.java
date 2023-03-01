package org.ace.insurance.productservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ace.insurance.utilityservice.embeddable.UserRecorder;

import java.io.Serializable;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "MAINCATEGORY")
@NamedQueries(value = { @NamedQuery(name = "MainCategory.findAll", query = "SELECT m FROM MainCategory m"),
        @NamedQuery(name = "MainCategory.findById", query = "SELECT mc FROM MainCategory mc WHERE mc.id = :id") })
public class MainCategory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @OneToOne
    @JoinColumn(name = "PRODUCTID", referencedColumnName = "ID")
    private Product product;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "mainCategory", orphanRemoval = true)
    private List<NameText> textList;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "IMAGEID")
    private PhotoImage image;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "mainCategory", orphanRemoval = true)
    private List<SubCategory> subCategoryList;

    @Column(name = "ORDERNUMBER")
    private int order;

    @Embedded
    private UserRecorder recorder;

    @Version
    private int version;
}
