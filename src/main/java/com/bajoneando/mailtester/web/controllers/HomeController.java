package com.bajoneando.mailtester.web.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.subethamail.wiser.Wiser;
import org.subethamail.wiser.WiserMessage;

/**
 *
 * @author lrmonterosa
 */

@Controller
public class HomeController {
    
    @RequestMapping("/")
    public String home(ModelAndView modelAndView) {
        List<WiserMessage> wiserMessages = wiser.getMessages();
        modelAndView.addObject("wiserMessages", wiserMessages);
        return "/home";
    }
    
    @RequestMapping(value="/messages", method=RequestMethod.GET, headers="Accept=application/json")
    @ResponseBody
    public List<WiserMessage> list() {
        return wiser.getMessages();
    }
    
    @Autowired private Wiser wiser;
    
}
