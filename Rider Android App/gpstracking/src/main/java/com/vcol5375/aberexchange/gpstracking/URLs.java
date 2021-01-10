package com.vcol5375.aberexchange.gpstracking;

public class URLs {

    private static final String ROOT_URL = "http://192.168.0.16/Aber/Api.php?apicall=";

    public static final String URL_LOGIN= ROOT_URL + "login";
    public static final String URL_ORDERS= ROOT_URL + "getorders";
    public static final String URL_NEW_ORDERS= ROOT_URL + "getallorders";
    public static final String URL_LOCATION_UPDATE= ROOT_URL + "updatelocation";
    public static final String URL_COMPLETE_ORDER= ROOT_URL + "updateorder";

}
