package org.ace.insurance.utilityservice.embeddable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Embeddable
@Data
@NoArgsConstructor
public class UserRecorder {
	private String createdUserId;
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;
	private String updatedUserId;
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedDate;

}
