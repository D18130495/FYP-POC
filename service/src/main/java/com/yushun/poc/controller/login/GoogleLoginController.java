package com.yushun.poc.controller.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>
 * google login controller
 * </p>
 *
 * @author yushun zeng
 * @since 2022-9-25
 */

@CrossOrigin
@Controller
@RequestMapping("/")
public class GoogleLoginController {
    @GetMapping("index")
    public String index() {
        return "index";
    }

    @GetMapping("level1")
    public String level1() {
        return "views/level1/level1";
    }

    @GetMapping("level2")
    public String level2() {
        return "views/level2/level2";
    }
}
