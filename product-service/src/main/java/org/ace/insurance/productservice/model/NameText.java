package org.ace.insurance.productservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ace.insurance.utilityservice.embeddable.UserRecorder;
import org.ace.insurance.utilityservice.enumeration.Language;

import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "NAMETEXT")
public class NameText implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "NAME_TEXT")
    private String name;

    @Column(name = "CONTENT_TEXT")
    private String content;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "MAINCATEGORYID", referencedColumnName = "ID")
    private MainCategory mainCategory;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "SUBCATEGORYID", referencedColumnName = "ID")
    private SubCategory subCategory;

    @Enumerated(EnumType.STRING)
    private Language language;

    @Embedded
    private UserRecorder recorder;

    @Version
    private int version;

}
