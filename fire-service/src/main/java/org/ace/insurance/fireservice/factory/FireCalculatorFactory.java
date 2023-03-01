package org.ace.insurance.fireservice.factory;

import org.ace.insurance.fireservice.dto.ClassValueDTO;
import org.ace.insurance.fireservice.dto.ContentDTO;
import org.ace.insurance.fireservice.dto.RouteDTO;
import org.ace.insurance.fireservice.model.*;
import org.ace.insurance.fireservice.model.ClassValue;
import org.ace.insurance.productservice.model.Currency;
import org.ace.insurance.productservice.model.PaymentType;

import java.util.ArrayList;
import java.util.List;

public class FireCalculatorFactory {
    /** Floor **/
    public static ContentDTO convertFloorDTO(Floor floor) {
        ContentDTO dto = new ContentDTO();
        dto.setId(floor.getId());
        dto.setName(floor.getName());
        return dto;
    }

    public static List<ContentDTO> convertFloorDTOList(List<Floor> floorList) {
        List<ContentDTO> result = new ArrayList<>();
        for (Floor f : floorList) {
            result.add(convertFloorDTO(f));
        }
        return result;
    }

    /** Wall **/
    public static ContentDTO convertWallDTO(Wall wall) {
        ContentDTO dto = new ContentDTO();
        dto.setId(wall.getId());
        dto.setName(wall.getName());
        return dto;
    }

    public static List<ContentDTO> convertWallDTOList(List<Wall> wallList) {
        List<ContentDTO> result = new ArrayList<>();
        for (Wall f : wallList) {
            result.add(convertWallDTO(f));
        }
        return result;
    }

    /** Roof **/
    public static ContentDTO convertRoofDTO(Roof roof) {
        ContentDTO dto = new ContentDTO();
        dto.setId(roof.getId());
        dto.setName(roof.getName());
        return dto;
    }

    public static List<ContentDTO> convertRoofDTOList(List<Roof> roofList) {
        List<ContentDTO> result = new ArrayList<>();
        for (Roof f : roofList) {
            result.add(convertRoofDTO(f));
        }
        return result;
    }

    /** BuildingClass **/
    public static ContentDTO convertBuildingClassDTO(BuildingClass bclass) {
        ContentDTO dto = new ContentDTO();
        dto.setId(bclass.getId());
        dto.setName(bclass.getName());
        return dto;
    }

    public static List<ContentDTO> convertBuildingClassDTOList(List<BuildingClass> bclassList) {
        List<ContentDTO> result = new ArrayList<>();
        for (BuildingClass f : bclassList) {
            result.add(convertBuildingClassDTO(f));
        }
        return result;
    }

    /** BuildingOccupation **/
    public static ContentDTO convertBuildingOccupationDTO(BuildingOccupation bocc) {
        ContentDTO dto = new ContentDTO();
        dto.setId(bocc.getId());
        if (bocc.getBuildingOccupationType() == null) {
            dto.setName(bocc.getName());
        } else {
            dto.setName(bocc.getBuildingOccupationType().concat(" " + bocc.getName()));
        }

        return dto;
    }

    public static List<ContentDTO> convertBuildingOccupationDTOList(List<BuildingOccupation> boccList) {
        List<ContentDTO> result = new ArrayList<>();
        for (BuildingOccupation f : boccList) {
            result.add(convertBuildingOccupationDTO(f));
        }
        return result;
    }

    /** Class Value **/
    public static ClassValueDTO convertClassValueDTO(ClassValue ClassValueDTO) {
        return new ClassValueDTO(ClassValueDTO);
    }

    public static List<ClassValueDTO> convertClassValueDTOList(List<ClassValue> classValueList) {
        List<ClassValueDTO> result = new ArrayList<>();
        for (ClassValue f : classValueList) {
            result.add(convertClassValueDTO(f));
        }
        return result;
    }

    /** CargoType **/
    public static ContentDTO convertCargoTypeDTO(CargoType cargoType) {
        ContentDTO dto = new ContentDTO();
        dto.setId(cargoType.getId());
        dto.setName(cargoType.getName());
        return dto;
    }

    public static List<ContentDTO> convertCargoTypeDTOList(List<CargoType> cargoTypeList) {
        List<ContentDTO> result = new ArrayList<>();
        for (CargoType f : cargoTypeList) {
            result.add(convertCargoTypeDTO(f));
        }
        return result;
    }

    /** Route **/
    public static ContentDTO convertRouteeDTO(Route route) {
        ContentDTO dto = new ContentDTO();
        dto.setId(route.getId());
        dto.setName(route.getName());
        return dto;
    }

    public static List<ContentDTO> convertRouteDTOList(List<Route> cargoTypeList) {
        List<ContentDTO> result = new ArrayList<>();
        for (Route f : cargoTypeList) {
            result.add(convertRouteeDTO(f));
        }
        return result;
    }

    /** Currency **/
    public static ContentDTO convertCurrencyDTO(Currency cur) {
        ContentDTO dto = new ContentDTO();
        dto.setId(cur.getId());
        dto.setName(cur.getCurrencyCode());
        return dto;
    }

    public static List<ContentDTO> convertCurrencyList(List<Currency> curList) {
        List<ContentDTO> result = new ArrayList<>();
        for (Currency f : curList) {
            result.add(convertCurrencyDTO(f));
        }
        return result;
    }

    /** PaymentType **/
    public static ContentDTO convertPaymentTypeDTO(PaymentType payType) {
        ContentDTO dto = new ContentDTO();
        dto.setId(payType.getId());
        dto.setName(payType.getName());
        return dto;
    }

    public static List<ContentDTO> convertPaymentTypeList(List<PaymentType> payTypeList) {
        List<ContentDTO> result = new ArrayList<>();
        for (PaymentType f : payTypeList) {
            if(f.getName().contains("-")) {
                f.setName(f.getName().replace("-", "_"));
            }
            result.add(convertPaymentTypeDTO(f));
        }
        return result;
    }

    public static List<RouteDTO> convertRouteWithInsuranceTypeDTOList(List<Route> cargoTypeList) {
        List<RouteDTO> result = new ArrayList<>();
        for (Route f : cargoTypeList) {
            result.add(convertRouteWithInsuranceTypeDTO(f));
        }
        return result;
    }

    /** Route **/
    public static RouteDTO convertRouteWithInsuranceTypeDTO(Route route) {
        RouteDTO dto = new RouteDTO();
        dto.setId(route.getId());
        dto.setName(route.getName());
        dto.setInsuranceType(route.getInsuranceType().name());
        return dto;
    }
}
