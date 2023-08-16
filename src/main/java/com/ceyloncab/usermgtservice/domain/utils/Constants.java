package com.ceyloncab.usermgtservice.domain.utils;

import lombok.Getter;

public class Constants {
    public static final String UNHANDLED_ERROR_CODE = "UMS3000";
    @Getter
    public enum ResponseData {
        CREATE_SUCCESS("UMS1000", "Success","201"),
        QUERY_SUCCESS("UMS1001", "Query Success","200"),
        VERIFY_SUCCESS("UMS1002", "Verified","200"),
        PASSWORD_NOT_MATCHED("UMS2001", "Password not matched","400"),
        COMMON_FAIL("UMS2000", "Failed","400"),
        DRIVER_NOT_FOUND("UMS2002", "Driver not found","400"),
        CUSTOMER_NOT_FOUND("UMS2003", "Customer not found","400"),
        INTERNAL_SERVER_ERROR("UMS3001", "Internal Server Error","500");

        private String code;
        private String message;
        private String responseCode;

        ResponseData(String code, String message, String responseCode) {
            this.code = code;
            this.message = message;
            this.responseCode= responseCode;
        }
    }
}
