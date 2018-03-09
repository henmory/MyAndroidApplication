package com.henmory.mvptest.netconnection;

/**
 * author: henmory
 * time:  11/23/16
 * function:
 * description:
 */

public class ServerConfig {

    //url
    public static final String SERVER_IP = "http://118.126.10.86:29090/";//"http://182.92.165.152:29091/";// TODO: 11/23/16 测试端口
    public static final String SERVER_API = "api/";
    public final static String INIT_REQUEST_OF_SERVICE_VERIFICATION_CODE = "VerifyCode/Init";
    public final static String GET_VERIFICATION_CODE = "VerifyCode/Send";
    public final static String GET_IMAGE_VERIFICATION_CODE = "VerifyCode/GphCode";
    public final static String VERIFY_VERIFICATION_CODE = "VerifyCode/VfyCode";
    public final static String REGISTER = "Regist";
    public final static String LOGIN = "Token?v=1";
    public final static String CHECKUSER = "VerifyCode/CheckUser";
    public final static String RESET = "Pwd/Reset";
    public final static String MODIFY = "Pwd/Modify";
    public final static String LOGOUT = "Token/Logout";
    public final static String PAY = "Pay";
    public final static String ALIPAYNOTIFY = "AlipayNotify";
    public final static String MULTDEVICEINFO = "Location/MultiRealLocs";
    public final static String REALTIMELOC = "Location/RealtimeLoc";
    public final static String LIST = "Device/List";
    public final static String FAMILYNUMLIST = "FamNum";
    public final static String SETNICK = "Device/SetNick";
    public final static String GETLOCATIONMODE = "Device/LocMode";
    public final static String HISTORYLOC = "Location/HIstoryLoc";
    public final static String SETLOCATIONMODE = "Device/SetLocMode";
    public final static String DELETEDEVICE = "Device/UnBind";




    //token
    public static final String TOKEN_FLAG = " CAuth ";
    public static final String KEY_TOKEN = "Authorization";

    //return json key from server
    public static final String KEY_STATUS_CODE = "State";
    public static final String KEY_DATA = "Data";
    public static final String KEY_DESCRIPTION = "Desc";


    //author defined error codes and descriptions by himself, except that from server
    public final static String KEY_ERROR_CODE = "State";
    public final static String KEY_ERROR_DESCRIPTION = "errorDescripition";
    public final static int ERROR_CODE_START = 100;

    public final static String PARSE_DATA_FAILED = "parse json data failed";
    public final static int PARSE_DATA_FAILED_ERROR_CODE = ERROR_CODE_START + 1;

    public final static String USER_CANCLE_NET_REQUEST = "user cancels net request";
    public final static int USER_CANCLE_NET_REQUEST_ERROR_CODE = ERROR_CODE_START + 2;

    public final static String NET_BUSY = "net is busy, please try later";
    public final static int NET_BUSY_ERROR_CODE = ERROR_CODE_START + 3;

    public final static String OKHTTTP_FAILED = "okhttp failed";
    public final static int OKHTTP_ERROR_CODE = ERROR_CODE_START + 4;


}
