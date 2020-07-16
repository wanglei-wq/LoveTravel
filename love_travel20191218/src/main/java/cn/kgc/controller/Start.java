package cn.kgc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Administrator on 2019/12/12.
 */
@Controller
@RequestMapping("/")
public class Start {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model){
        return "html/wl";
    }
}

