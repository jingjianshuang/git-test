package com.itheima.web.controller;

import com.itheima.domain.User;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 用户登录
     */
    @RequestMapping("/login.action")
    public String login(String usercode, String password, HttpSession session, Model model){

        User user = userService.findUser(usercode, password);
        if (user != null){
           session.setAttribute("USER_SESSION",user);
           return "redirect:/customer/list.action";
        }
        model.addAttribute("msg","用户名或密码输入错误！");
        return "login";
    }

    /**
     * 退出登录
     * @param session
     * @return
     */
    @RequestMapping("/logout.action")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:login.action";
    }

    /**
     * 模拟其他类中跳转到客户管理页面
     */
    @RequestMapping("/toCustomer.action")
    public String toCustomer(){
        return "customer";
    }
    /**
     * 向用户登录页面跳转
     */
    @RequestMapping(value="/login.action",method=RequestMethod.GET)
    public String login(){
        return "login";
    }
}
