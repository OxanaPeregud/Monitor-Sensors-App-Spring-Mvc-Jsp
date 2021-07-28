package com.peregud.monitorsensors.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.peregud.monitorsensors.AppConstants.PAGE_START;
import static com.peregud.monitorsensors.AppConstants.VIEW_LOGIN;

@Controller
public class AppController {

    @RequestMapping(value = {PAGE_START})
    public String staticResource() {
        return VIEW_LOGIN;
    }
}
