package com.bajoneando.mailtester.web.controllers;

import java.util.Date;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.subethamail.wiser.Wiser;
import org.subethamail.wiser.WiserMessage;

/**
 *
 * @author lrmonterosa
 */

@Controller
public class HomeController {
    
    @RequestMapping("/")
    public String home(ModelMap modelMap) {
        List<WiserMessage> wiserMessages = wiser.getMessages();
        modelMap.addAttribute("wiserMessages", wiserMessages);
        return "/home";
    }
    
    @RequestMapping(value="/messages", method=RequestMethod.GET, headers="Accept=application/json")
    @ResponseBody
    public List<WiserMessage> list() {
        return wiser.getMessages();
    }
    
    @RequestMapping(value="/addDummyMail", method= RequestMethod.POST, headers="Accept=application/json")
    public void addDummyMail() {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("admin@bajoneando.com");
        mailMessage.setTo("someone@somewhere.com");
        mailMessage.setText("Adding a new dummy message '" + new Date() + "'");
        try {
            mailSender.send(mailMessage);
        } catch (MailException e) {
            log.error(e.getMessage(),e);
        }
    }
    
    @Autowired private Wiser wiser;
    
    @Autowired private MailSender mailSender;
    
    private static final Log log = LogFactory.getLog(HomeController.class);
    
}