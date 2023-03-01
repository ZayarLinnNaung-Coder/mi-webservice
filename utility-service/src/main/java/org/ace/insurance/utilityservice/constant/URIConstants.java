package org.ace.insurance.utilityservice.constant;

public class URIConstants {
    public static final String CALLTORESTCALLERIPADDRESS = "http://10.2.104.21:8084/restcaller";// "http://10.2.104.21:8084/restcallerUAT";http://37.111.50.42:8084/restcallerUAT
    public static final String CALLTORESTCALLER_LOCALIPADDRESS = "http://localhost:8080/restcaller";
    public static final String LOCALSERVER = "http://localhost:8899/rcuat";
    public static final String APPVERION = "/appVersion";
    public static final String REGISTER = "/register";// http://192.168.11.210:8080/ggiwsp/ws/register
    public static final String LOGIN = "/login"; // http://192.168.11.210:8080/ggiwsp/ws/login
    public static final String ACTIVATE = "/activate"; // http://192.168.11.210:8080/ggiwsp/ws/activate
    public static final String CHANGE_PASSWORD = "/changePassword"; // http://192.168.11.210:8080/ggiwsp/ws/changePassword
    public static final String FORGET_PASSWORD = "/forgetPassword"; // http://192.168.11.210:8080/ggiwsp/ws/forgetPassword
    public static final String CHECK_ACTIVATED_CODE = "/checkActivatedCode";
    public static final String RESET_PASSWORD = "/resetPassword"; // http://192.168.11.210:8080/ggiwsp/ws/resetPassword
    public static final String MOBILE_USER_LIST = "/mobileUserList"; // http://192.168.11.210:8080/ggiwsp/ws/mobileUserList
    public static final String INSERT_TRAVELPROPOSAL = "/insertTravelProposal"; // http://192.168.11.210:8080/ggiwsp/ws/insertTravelProposal
    public static final String POLICY_LIST_BY_USER = "/getPolicyListByMobileUser"; // http://192.168.11.210:8080/ggiwsp/ws/getPolicyListByMobileUser
    public static final String GET_SECURITYQUESTION_LIST = "/getSecurityQuestionList";// http://192.168.11.210:8080/ggiwsp/ws/getSecurityQuestionList
    public static final String GET_BRANCH_LIST = "/getBranchList";// http://192.168.11.210:8080/ggiwsp/ws/getBranchList
    public static final String PRODUCT_FAQ_LIST = "/getProductFAQList";// http://192.168.11.210:8080/ggiwsp/ws/getProductFAQList
    public static final String GET_PRODUCT_SPECIFICATION_BY_PRODUCT_ID = "/getProductSpecificationByProductId";// http://192.168.11.210:8080/ggiwsp/ws/getProductSpecificationByProductId
    public static final String PRODUCT_SPECIFICATION_LIST = "/getProductSpecificationList";// http://192.168.11.210:8080/ggiwsp/ws/getProductSpecificationList
    public static final String GET_ANDROID_LATEST_VERSION = "/getAndroidLatestVersion";// http://192.168.11.210:8080/ggiwsp/ws/getAndroidLatestVersion
    public static final String GET_IOS_LATEST_VERSION = "/getIOSLatestVersion";// http://192.168.11.210:8080/ggiwsp/ws/getIOSLatestVersion
    public static final String GET_NOTIFICATION_LIST = "/getNotificationList";// http://192.168.11.210:8080/ggiwsp/ws/getNotificationList
    public static final String GET_NOTIFICATION_BY_ID = "/getNotificationById";// http://192.168.11.210:8080/ggiwsp/ws/getNotificationById
    public static final String GET_NOTIFICATION_BY_DATE = "/getNotificationByDate";// http://192.168.11.210:8080/ggiwsp/ws/getNotificationByDate
    public static final String OK$_PAYMENT = "/paymentStatus";// http://192.168.11.210:8080/ggiwsp/ws/paymentStatus
    public static final String GET_PAYMENT_STATUS = "/status/refNo/{refNo}/desno/{destination}";// http://192.168.11.210:8080/ggiwsp/ws/status/refNo/{refNo}/desno/{destination}
    public static final String GET_PAYMENT_STATUS_BY_REFNO = "/statusById";// http://192.168.11.210:8080/ggiwsp/ws/statusById
    public static final String TWOC2P_PAYMENT = "/TwoC2pPayment";// http://192.168.11.210:8080/ggiwsp/ws/TwoC2pPayment
    public static final String IOS_PAYMENT_CONSTANTS = "/getIOS2C2PInfo";// http://192.168.11.210:8080/ggiwsp/ws/getIOS2C2PInfo
    public static final String ANDORID_PAYMENT_CONSTANTS = "/getAndorid2C2PInfo";// http://192.168.11.210:8080/ggiwsp/ws/getAndorid2C2PInfo
    public static final String OK$_PAYMENT_CONSTANTS = "/getOK$PaymentInfo";// http://192.168.11.210:8080/ggiwsp/ws/getOK$PaymentInfo
    public static final String UPDATE = "/editMobileUserProfile";// http://192.168.11.210:8080/ggiwsp/ws/editMobileUserProfile
    public static final String GET_TOWNSHIP_LIST = "/getTownshipList";// http://192.168.11.210:8080/ggiwsp/ws/getTownshipList
    public static final String GET_TOWNSHIP_LIST_BY_ID = "/getTownshipListByProvinence";
    public static final String GET_DISTRICT_LIST_BY_ID = "/getDistrictListByProvinence";
    public static final String GET_PROVINCE_LIST = "/getProvinceList";// http://192.168.11.210:8080/ggiwsp/ws/getProvinceList
    public static final String GET_COUNTRY_LIST = "/getCountryList";// http://192.168.11.210:8080/ggiwsp/ws/getCountryList
    public static final String INSERT_FILE = "/insertFile";
    public static final String INSERT_PA_PROPOSAL = "/insertPAProposal";
    public static final String PA_POLICY_LIST_BY_USER = "/getPAPolicyListByMobileUser";
    public static final String PA_POLICY_LIST_BY_REFNO = "/getPAProposalbyReferenceNo";
    public static final String PA_POLICY_LETTER = "/getPAPolicyCertificatePDF";
    public static final String HEALTH_POLICY_LETTER = "/getHealthPolicyCertificatePDF";
    public static final String TRAVEL_POLICY_LETTER = "/getTravelPolicyCertificatePDF";
    public static final String GET_OCCUPATION_LIST = "/getOccupationList";// http://localhost:8080/ggiwsp/ws/getOccupationList

    public static final String GET_SURVEYQUESTION_LIST = "/getSurveyQuestionList";
    public static final String GET_PRODUCT_PROCESS_LIST = "/getProductProcessList";

    /** Medical **/
    public static final String INSERT_MEDICAL_PROPOSAL = "/insertMedicalProposal";
    public static final String MEDICAL_POLICY_LIST_BY_USER = "/getMedicalPolicyListByMobileUser";
    public static final String MEDICAL_POLICY_LIST_BY_REFNO = "/getMedicalProposalbyReferenceNo";

    /** For ThirdParty **/
    public static final String INSERT_TOWNSHIP = "/insertTownship";
    public static final String GET_THIRDPARTY_PREMIUM_RECEIPT = "/getPremiumReceipt";
    public static final String POST_THIRDPARTY_PREMIUM_RECEIPT = "/premiumReceipt";
    public static final String POST_CONFIRM_PAYMENT_BY_2C2P = "/submitPaymentConfirm";// http://localhost:8080/miwsp/ws/submitPaymentConfirm
    public static final String DELETE_THIRDPARTY_PREMIUM_RECEIPT = "/premiumReceipt";
    public static final String GET_THIRDPARTY_PREMIUM_RECEIPT_BY_VEHICLENO = "/getPremiumReceiptByVehicleNo";
    public static final String GET_THIRDPARTY_PREMIUM_RECEIPT_FINDALL = "/getPremiumReceipts";
    public static final String POST_THIRDPARTY_PREMIUM_EXCEL_PATH = "/postPremiumExcelPath";
    public static final String POST_THIRDPARTY_PREMIUM_RECEIPT_CHECK = "/premiumCheck";
    public static final String POST_THIRDPARTY_PREMIUM_CALCULATE = "/premiumCalculate";
    public static final String GET_PRINT_THIRDPARTY_PREMIUM_RECEIPT = "/printReceipt";
    public static final String GET_RECORDS_HISTORY = "/recordsHistory";
    public static final String GET_DRIVER_TYPE = "/getDriverType";
    public static final String GET_MOTORCYCLE_TYPE = "/getMotorCycleType";
    public static final String GET_THIRDPARTY_PREMIUM_BUYERS = "/getPremiumList";
    public static final String GET_MI_THIRDPARTY_PREMIUM_BUYERS = "/getMIPremiumList";
    public static final String POST_RTA_DATA_lIST = "/rtaRecordDataUploadList";
    public static final String POST_RTA_lIST = "/rtaRecordUploadList";
    /** For Calculator Website **/
    public static final String FLOOR_LIST = "/getFloorList";// http://192.168.11.210:8080/ggiwsp/ws/getFloorList
    public static final String WALL_LIST = "/getWallList";// http://192.168.11.210:8080/ggiwsp/ws/getWallList
    public static final String ROOF_LIST = "/getRoofList";// http://192.168.11.210:8080/ggiwsp/ws/getRoofList
    public static final String BUILDING_CLASS_LIST = "/getBuildingClassList";// http://192.168.11.210:8080/ggiwsp/ws/getBuildingClassList
    public static final String BUILDING_CLASS_LIST_BY_ROOFWALLFLOOR = "/getBuildingClassListByRoofWallFloor";// http://192.168.11.210:8080/ggiwsp/ws/getBuildingClassListByRoofWallFloor
    public static final String BUILDING_OCCUPATION_LIST = "/getBuildingOccupationList";// http://192.168.11.210:8080/fnigwsp/ws/getBuildingOccupationList
    public static final String CATGO_TYPE_LIST = "/getCargoTypeList";// http://192.168.11.210:8080/ggiwsp/ws/getCargoTypeList
    public static final String ROUTE_LIST = "/getRouteList";// http://192.168.11.210:8080/ggiwsp/ws/getRouteList
    public static final String CURRENCY_LIST = "/getCurrencyList";// http://192.168.11.210:8080/ggiwsp/ws/getCurrencyList
    public static final String PAYMENT_TYPE_LIST = "/getPaymentTypeList";// http://192.168.11.210:8080/ggiwsp/ws/getPaymentTypeList
    public static final String GET_PREMIUM = "/getPremium";// http://192.168.11.210:8080/fnigwsp/ws/getPremium
    public static final String GET_ALLRELATIONSHIP = "/getAllRelationShip";
    public static final String GET_PAERATE_BY_CLASS_AGE = "/getPAERate";// http://192.168.11.210:8080/fnigwsp/ws/getPAERate
    public static final String ROUTE_BY_INSURANCETYPE_LIST = "/getRouteListByInsuranceType";
    public static final String GET_ACTIVATE_CODE_BY_MOBILE_NUMBER = "/getActivateCodeByMobileNumber";
    public static final String POST_NEARBY_BRANCH = "/findAllNearByBranchesList";

    public static final String TPL_CLOUD_TO_CORE = "/tplCloudToCore";
    public static final String TPL_MD_CLOUD_TO_CORE = "/medicalCloudToCore";
    public static final String TPL_PA_CLOUD_TO_CORE = "/paCloudToCore";
    public static final String TPL_TVL_CLOUD_TO_CORE = "/travelCloudToCore";
    public static final String ONLINE_BILLER_CLOUD_TO_CORE = "/onlineBillerCloudToCore";
    public static final String SPECIAL_FOREIGN_CLOUD_TO_CORE = "/specialForeignTravelCloudToCore";
    public static final String OUTBOUND_TRAVEL_CLOUD_TO_CORE = "/outboundTravelCloudToCore";
    public static final String OUTBOUND_TRAVEL_CORE_TO_CLOUD = "/outboundTravelCoreToCloud";



    public static final String ONLINEBILLERCORETOCLOUD = "/onlineBillerCoreToCloud";
    public static final String POST_ONLINE_BILLER_BY_INVOICE_NO = "/onlineBillerByInvoiceNo";
    public static final String POST_ONLINE_BILLER_BY_DATE = "/onlineBillerByDate";
    public static final String POST_ONLINE_BILLER_BUYER = "/buyOnlineBiller";

    public static final String UPDATE_BY_APP_VERSION = "/upDateByAppVersion";

    public static final String GET_OUTBOUND_PREMIUM = "/getOutboundPremium";
    public static final String OUTBOUND_SPECIAL_TRAVEL="/buyOutboundSpecailTravel";

    public static final String GET_OUTBOUND_SPECIAL_TRAVEL = "/getOutboundSpecailTravel";
    public static final String GET_OUTBOUND_SPECIAL_TRAVELLER_RECEIPT = "/getOutboundSpecialTravellerPrintReceipt";

    public static final String SPECIAL_FOREIGN_TRAVEL = "/buySpecailForeignTravel";
    public static final String GET_SPECIAL_FOREIGN_TRAVEL = "/getSpecailForeignTravel";
    public static final String GET_MOBILE_COUNTRY_LIST = "/getMobileCountryList";
    public static final String GET_OUTBOUND_MOBILE_COUNTRY_LIST = "/getOutboundMobileCountryList";
    public static final String GET_SPECIAL_FOREIGN_TRAVELLER_RECEIPT = "/getSpecialForeignTravellerPrintReceipt";
    public static final String IBT_CORE_TO_CLOUD = "/inboundTravelCoreToCloud";

    public static final String POST_OUTBOUND_AGENT_CHECK = "/checkOutboundAgent";

    /** ThirdParty Driver License **/
    public static final String THIRDPARTY_DRIVER = "/buyThirdPartyDriver";
    public static final String GET_TYPE_OF_DRIVER = "/getTypeOfDriver";
    public static final String GET_THIRD_PARTY_DRIVER = "/getThirdPartyDriver";
    public static final String GET_THIRD_PARTY_DRIVER_PREMIUM = "/getThirdPartyDriverPremium";
    public static final String GET_THIRD_PARTY_DRIVER_RECEIPT = "/getThirdPartyDriverReceipt";
}

