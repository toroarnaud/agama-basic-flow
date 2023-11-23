package com.toro.passclub;

import io.jans.as.server.service.AuthenticationService;
import io.jans.service.cdi.util.CdiUtil;
import io.jans.service.custom.script.CustomScriptManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BasicAuthentication {

    private static final Logger scriptLogger = LoggerFactory.getLogger(CustomScriptManager.java.class);
    private static AuthenticationService authenticationService = CdiUtil.bean(AuthenticationService.class);

    public static boolean authenticate(String username, String password) {
        System.out.println("Looooooooooooooooooogs!");
        scriptLogger.info("Passclub BasicAuthentication. authenticating with user: " + username);
        return authenticationService.authenticate("idm", password);

    }

    public static void testNoArg() {
        System.out.println("Looooooooooooooooooogs!");
        scriptLogger.info("Passclub BasicAuthentication. Called with no arguments");

    }


}
