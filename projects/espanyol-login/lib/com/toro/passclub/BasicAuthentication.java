package com.toro.passclub;

import io.jans.as.server.service.AuthenticationService;
import io.jans.service.cdi.util.CdiUtil;
import io.jans.service.custom.script.CustomScriptManager;
import io.jans.as.common.model.common.User;
import io.jans.as.common.service.common.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BasicAuthentication {

    private static final Logger scriptLogger = LoggerFactory.getLogger(CustomScriptManager.class);
    private static AuthenticationService authenticationService = CdiUtil.bean(AuthenticationService.class);
    private static UserService userService = CdiUtil.bean(UserService.class);

    public static boolean authenticate(String username, String password) {

        User user = userService.getUserByAttribute("uid", username);
        if (user == null) {
            scriptLogger.info("Passclub BasicAuthentication. User not found for username: " + username + "creating it...");
            user = new User();
            user.setAttribute("uid", username);
            user.setAttribute("userPassword", password);
            user = userService.addUser(user, true);
            scriptLogger.info("Passclub BasicAuthentication. User added with username: " + username);
        }
        
        boolean isAuthenticated = authenticationService.authenticate(username, password);
        scriptLogger.info("Passclub BasicAuthentication. is authenticated: " + isAuthenticated);
        
        return isAuthenticated;
    }


}
