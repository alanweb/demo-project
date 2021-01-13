package org.smart4j.charter.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smart4j.charter.bean.ResponseBo;
import org.smart4j.framework.annotation.Controller;
import org.smart4j.framework.annotation.GetMapping;
import org.smart4j.framework.annotation.PostMapping;
import org.smart4j.framework.bean.Data;
import org.smart4j.framework.bean.Param;
import org.smart4j.framework.bean.View;
import org.smart4j.plugin.security.SecurityHelper;
import org.smart4j.plugin.security.exception.AuthcException;

@Controller
public class SystemController {
    private static final Logger LOGGER = LoggerFactory.getLogger(SystemController.class);

    @GetMapping
    public View main() {
        return new View("index.jsp");
    }

    @GetMapping("index")
    public View index() {
        return new View("index.jsp");
    }

    @GetMapping("login")
    public View login() {
        return new View("login.jsp");
    }

    @PostMapping("login")
    public Data login(Param param) {
        String username = param.getString("username");
        String password = param.getString("password");
        try {
            SecurityHelper.login(username, password);
        } catch (AuthcException e) {
            LOGGER.error("login failure", e);
            return new Data(ResponseBo.error());
        }
        return new Data(ResponseBo.ok());
    }

    @GetMapping("logout")
    public View logout() {
        SecurityHelper.logout();
        return new View("login.jsp");
    }
}
