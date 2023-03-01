package org.ace.insurance.productservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ace.insurance.utilityservice.embeddable.UserRecorder;

import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PhotoImage implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "IMAGEPATH")
    private String filepath;
    @Lob
    private byte[] image;
    private String name;

    @Column(name = "ORDERNUMBER")
    private int order;

    @OneToOne(mappedBy = "image")
    private MainCategory mainCategory;

    @OneToOne(mappedBy = "image")
    private SubCategory subCategory;

    @Embedded
    private UserRecorder recorder;

    @Version
    private int version;

    public PhotoImage(String name, String filepath, byte[] image) {
        this.name = name;
        this.image = image;
        this.filepath = filepath;
    }

}
