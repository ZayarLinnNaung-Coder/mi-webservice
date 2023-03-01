package org.ace.insurance.fireserviceapi.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ace.insurance.fireservice.dto.BuildingClassCriteriaDTO;
import org.ace.insurance.fireservice.dto.ContentDTO;
import org.ace.insurance.fireservice.dto.PAE001;
import org.ace.insurance.fireservice.dto.RouteDTO;
import org.ace.insurance.fireservice.factory.FireCalculatorFactory;
import org.ace.insurance.fireservice.model.*;
import org.ace.insurance.utilityservice.constant.Constants;
import org.ace.insurance.utilityservice.constant.StatusType;
import org.ace.insurance.utilityservice.constant.URIConstants;
import org.ace.insurance.utilityservice.enumeration.ResponseStatus;
import org.ace.insurance.utilityservice.exception.SystemException;
import org.hibernate.service.spi.ServiceException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/fire")
@AllArgsConstructor
@Slf4j
public class FireController {

    @PostMapping(value = URIConstants.FLOOR_LIST)
    private String getFloorList() {
        List<ContentDTO> floorDTOList = new ArrayList<>();
        List<Floor> floorList = floorService.findAllFloor();
        if (floorList != null && !floorList.isEmpty()) {
            floorDTOList = FireCalculatorFactory.convertFloorDTOList(floorList);
        }
        return responseManager.getResponseString(floorDTOList);
    }

    @PostMapping(value = URIConstants.ROOF_LIST)
    private String getRoofList() {
        List<ContentDTO> roofDTOList = new ArrayList<>();
        List<Roof> roofList = roofService.findAllRoof();
        if (roofList != null && !roofList.isEmpty()) {
            roofDTOList = FireCalculatorFactory.convertRoofDTOList(roofList);
        }
        return responseManager.getResponseString(roofDTOList);
    }

    @PostMapping(value = URIConstants.WALL_LIST)
    private @ResponseBody
    String getWallList() {
        List<ContentDTO> wallDTOList = new ArrayList<>();
        List<Wall> wallList = wallService.findAllWall();
        if (wallList != null && !wallList.isEmpty()) {
            wallDTOList = FireCalculatorFactory.convertWallDTOList(wallList);
        }
        return responseManager.getResponseString(wallDTOList);
    }


    @CrossOrigin
    @PostMapping(value = URIConstants.BUILDING_CLASS_LIST)
    private String getBuildingClassList() {
        List<ContentDTO> bclassDTOList = new ArrayList<>();
        List<BuildingClass> bclassList = bClassService.findAllBuildingClass();
        if (bclassList != null && !bclassList.isEmpty()) {
            bclassDTOList = FireCalculatorFactory.convertBuildingClassDTOList(bclassList);
        }
        return responseManager.getResponseString(bclassDTOList);
    }

    @CrossOrigin
    @PostMapping(value = URIConstants.BUILDING_CLASS_LIST_BY_ROOFWALLFLOOR)
    private String getBuildingClassListByRoofWallFloor(@RequestBody BuildingClassCriteriaDTO criteria) {
        ContentDTO buildingClassDTO = new ContentDTO();
        BuildingClass buildingClass = bClassService.findBuildingClassByRoofWallFloor(criteria.getRoofId(), criteria.getWallId(), criteria.getFloorId());
        if (buildingClass != null) {
            buildingClassDTO = FireCalculatorFactory.convertBuildingClassDTO(buildingClass);
        }
        return responseManager.getResponseString(buildingClassDTO);
    }

    @CrossOrigin
    @PostMapping(value = URIConstants.GET_PAERATE_BY_CLASS_AGE)
    private String getPAERate(@RequestBody PAE001 pae001) {
        double paeRate = paeRateService.findPAERateByClassAndAge(pae001.getBuildingClassId(), pae001.getAge());
        return responseManager.getResponseString(paeRate);
    }

    @CrossOrigin
    @PostMapping(value = URIConstants.ROUTE_LIST)
    private String getRouteList() {
        List<ContentDTO> routeDTOList = new ArrayList<>();
        List<Route> routeList = routeService.findAllRoute();
        if (routeList != null && !routeList.isEmpty()) {
            routeDTOList = FireCalculatorFactory.convertRouteDTOList(routeList);
        }
        return responseManager.getResponseString(routeDTOList);
    }

    @CrossOrigin
    @PostMapping(value = URIConstants.ROUTE_BY_INSURANCETYPE_LIST)
    private String getRouteListByInsuranceType(@RequestBody RouteDTO routeDTO) {
        List<RouteDTO> routeDTOList = new ArrayList<>();
        List<Route> routeList = routeService.findRouteByInsuranceType(routeDTO.getInsuranceType());
        if (routeList != null && !routeList.isEmpty()) {
            routeDTOList = FireCalculatorFactory.convertRouteWithInsuranceTypeDTOList(routeList);
        }
        return responseManager.getResponseString(routeDTOList);
    }

    @CrossOrigin
    @PostMapping(value = URIConstants.GET_OCCUPATION_LIST)
    public String getOccupationList(@RequestHeader String key) throws ServiceException {
        String response;
        try {
            if (key.equals(Constants.getApikey())) {
                List<Occupation> occupationList = occupationService.findAllOccupation();
                response = responseManager.getResponseString(occupationList);
            } else {
                response = responseManager.getResponseString(ResponseStatus.INVALID_REQUEST_PARAM.getLabel());
            }
        } catch (SystemException e) {
            e.printStackTrace();
            response = responseManager.getResponseString(StatusType.SQL_Exception);
            throw new ServiceException(StatusType.SQL_Exception);
        }
        return response;
    }

    @CrossOrigin
    @PostMapping(value = URIConstants.BUILDING_OCCUPATION_LIST)
    private String getBuildingOccupationList() {
        String response;
        List<ContentDTO> bOccuDTOList = new ArrayList<>();
        List<BuildingOccupation> bOccuList = buildingOccupationService.findAllBuildingOccupation();
        if (bOccuList != null && !bOccuList.isEmpty()) {
            bOccuDTOList = FireCalculatorFactory.convertBuildingOccupationDTOList(bOccuList);
        }
        response = responseManager.getResponseString(bOccuDTOList);
        return response;
    }
}
