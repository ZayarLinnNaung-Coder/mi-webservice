package org.ace.insurance.fireservice.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.ace.insurance.fireservice.model.ClassValue;

@Data
@NoArgsConstructor
public class ClassValueDTO {

    String id;
    String floorId;
    String roofId;
    String wallId;
    String buildingClassId;

    public ClassValueDTO(ClassValue classVal) {
        this.id = classVal.getId();
        this.floorId = classVal.getFloor().getId();
        this.roofId = classVal.getRoof().getId();
        this.wallId = classVal.getWall().getId();
        this.buildingClassId = classVal.getBuildingClass().getId();
    }

}
