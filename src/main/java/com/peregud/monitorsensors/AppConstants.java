package com.peregud.monitorsensors;

public class AppConstants {
    public static final String PARAM_ID = "id";
    public static final String PARAM_NAME = "name";
    public static final String PARAM_MODEL = "model";
    public static final String PARAM_TYPE = "type";
    public static final String PARAM_RANGE_FROM = "rangeFrom";
    public static final String PARAM_RANGE_TO = "rangeTo";
    public static final String PARAM_UNIT = "unit";
    public static final String PARAM_LOCATION = "location";
    public static final String PARAM_DESCRIPTION = "description";
    public static final String PARAM_USERNAME = "username";
    public static final String PARAM_PASSWORD = "password";
    public static final String PARAM_ROLE = "role";
    public static final String PARAM_SEARCH = "search";
    public static final String PARAM_DELETE_SENSOR = "deleteSensor";
    public static final String PARAM_PAGE_NUMBER = "pageNo";

    public static final String ATTR_USER = "user";
    public static final String ATTR_ADMIN = "admin";
    public static final String ATTR_LIST_SENSORS = "listSensors";
    public static final String ATTR_SENSOR = "sensor";
    public static final String ATTR_LIST_TYPES = "listTypes";
    public static final String ATTR_LIST_UNITS = "listUnits";
    public static final String ATTR_LAST_PAGE = "lastPageNo";

    public static final String PAGE_START = "/";
    public static final String PAGE_SENSORS_LIST = "/user/sensors-list";
    public static final String PAGE_SENSORS_SEARCH = "/user/sensors-search";
    public static final String PAGE_SENSORS_SEARCH_RESULT = "/user/sensors-search-result";
    public static final String PAGE_SENSORS_ADD = "/admin/sensor-add";
    public static final String PAGE_SENSORS_INSERT = "/admin/insert-sensor";
    public static final String PAGE_SENSORS_EDIT = "/admin/edit-sensor";
    public static final String PAGE_SENSORS_UPDATE = "/admin/update-sensor";
    public static final String PAGE_SENSORS_DELETE = "/admin/delete-sensors";
    public static final String PAGE_LOGIN = "/login";
    public static final String PAGE_LOGOUT = "/logout";
    public static final String PAGE_SIGN_UP = "/sign-up-page";
    public static final String PAGE_SUCCESS = "/user/success";
    public static final String PAGE_ACCESS_DENIED = "/access-denied";
    public static final String PAGE_LOGIN_FAILED = "/login-failed";
    public static final String PAGE_USER_SIGN_UP = "/sign-up-new";
    public static final String PAGE_USERS_ACCESS = "/user/*";
    public static final String PAGE_ADMIN_ACCESS = "/admin/*";

    public static final String VIEW_LOGIN = "login";
    public static final String VIEW_SENSORS_LIST = "sensors-list";
    public static final String VIEW_SENSOR_FORM = "sensor-form";
    public static final String VIEW_SENSOR_SEARCH = "sensor-search";
    public static final String VIEW_SENSOR_SEARCH_RESULT = "sensors-searched-list";
    public static final String VIEW_SIGN_UP = "sign-up";
    public static final String VIEW_SUCCESS = "success";
    public static final String VIEW_ACCESS_DENIED = "access-denied";
    public static final String VIEW_LOGIN_FAILED = "login-failed";

    public static final String REDIRECT_SENSORS_LIST = "redirect:/user/sensors-list";

    public static final Integer PAGE_SIZE = 4;
    public static final String PAGE_NUMBER_DEFAULT = "0";
}
