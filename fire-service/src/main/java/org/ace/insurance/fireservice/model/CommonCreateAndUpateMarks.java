package org.ace.insurance.fireservice.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class CommonCreateAndUpateMarks {

    private String createdUserId;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    private String updatedUserId;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedDate;
}
