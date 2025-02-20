package com.tma.demo.common;

public class EndPointConstant {
    public static final String BASE_API = "/api/v1";

    public static final String POSTS = BASE_API + "/post";
    public static final String USERS = BASE_API + "/user";
    public static final String COMMENTS = BASE_API + "/comment";
    public static final String LIKE_COMMENTS = COMMENTS + "/favourite";
    public static final String AUTH = BASE_API + "/auth";
    public static final String SETTING = BASE_API + "/setting";
    public static final String FAVOURITE = BASE_API + "/favourite";
    public static final String BOARDING_HOUSE = BASE_API + "/boarding-house";
    public static final String ROOM = BASE_API + "/room";
    public static final String ID = "/{id}";
    public static final String VIEW_LIST = "/view-list";
    public static final String STATUS = "/status";
    public static final String PEOPLE = "/people";
    public static final String DETAIL = "/detail";
    public static final String PAYMENT = "/payment";
    //
    public static final String COMMENT_ID = "/{commentId}";
    public static final String LIKE_COMMENT_ID = "/{likeCommentId}";
    public static final String ROOM_USER_ID = "/{roomUserId}";
    public static final String ROOM_ID = "/{roomId}";
    // Auth Endpoints
    public static final String AUTH_LOGIN = "/login";
    public static final String AUTH_REGISTER = "/register";
    public static final String AUTH_VERIFY_OTP = "/verify-otp";
    public static final String AUTH_FORGOT_PASSWORD = "/forgot-password";
    public static final String AUTH_SET_PASSWORD = "/set-password";
    public static final String AUTH_REFRESH_TOKEN = "/refresh-token";
    // User Endpoints
    public static final String USER_AVATAR = "/avatar";
    public static final String USER_PASSWORD = "/password";
    public static final String USER_COVER_PICTURE = "/cover-picture";
    // Post Endpoints
    public static final String GET_POST_NEWS = "/news";
    public static final String REPORT_POST = "/report";
    // Comment Post Endpoints
    public static final String HIDDEN_LIST_COMMENT_POST = "/hidden";
    public static final String SHARE = "/share";
    //    boarding house
    public static final String UPDATE_SETTING = "/update-setting";
    //    room
    public static final String RESET_ROOM = "/reset-room";

}
