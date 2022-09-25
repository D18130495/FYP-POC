package com.yushun.poc.controller.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @GetMapping("welcome")
    public String test() {
        return "welcome";
    }
}
