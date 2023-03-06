package org.ace.insurance.utilityservice.embeddable;

import java.io.Serializable;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ace.insurance.utilityservice.enumeration.NcbYear;

@Data
@NoArgsConstructor
@Embeddable
public class NcbRate implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Enumerated(EnumType.STRING)
	private NcbYear ncbYear;
	private float ncbPercentage;

}
