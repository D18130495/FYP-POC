package com.yushun.poc.controller.gmail;

import com.yushun.poc.utils.GmailUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
@RestController
@RequestMapping("/email")
public class GmailController {

    @Autowired
    private GmailUtils gmailUtils;

    @GetMapping("/send")
    public String sendEmail() {
        gmailUtils.sendEmail();
        return "Ok";
    }
}
