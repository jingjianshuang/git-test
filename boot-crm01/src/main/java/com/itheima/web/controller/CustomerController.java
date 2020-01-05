package com.itheima.web.controller;

import com.itheima.common.utils.Page;
import com.itheima.domain.BaseDict;
import com.itheima.domain.Customer;
import com.itheima.domain.User;
import com.itheima.service.BaseDictService;
import com.itheima.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    private BaseDictService baseDictService;
    @Autowired
    private CustomerService customerService;

    @Value("${customer.from.type}")
    private String FROM_TYPE;
    @Value("${customer.industry.type}")
    private String INDUSTRY_TYPE;
    @Value("${customer.level.type}")
    private String LEVEL_TYPE;
    /**
     * 客户列表
     */
    @RequestMapping("/customer/list.action")
    public String list(@RequestParam(defaultValue="1")Integer page,
                       @RequestParam(defaultValue="10")Integer rows,
                       String custName,
                       String custSource,
                       String custIndustry,
                       String custLevel,
                       Model model){

        Page<Customer> customers = customerService.findCustomerList(page, rows, custName, custSource, custIndustry, custLevel);
        model.addAttribute("page",customers);

        //查询客户来源
        List<BaseDict> fromType = baseDictService.selectBaseDictByTypeCode(FROM_TYPE);
        //查询客户所属行业
        List<BaseDict> industryType = baseDictService.selectBaseDictByTypeCode(INDUSTRY_TYPE);
        //查询客户级别
        List<BaseDict> levelType = baseDictService.selectBaseDictByTypeCode(LEVEL_TYPE);

        model.addAttribute("fromType", fromType);
        model.addAttribute("industryType", industryType);
        model.addAttribute("levelType", levelType);
        model.addAttribute("custName", custName);
        model.addAttribute("custSource", custSource);
        model.addAttribute("custIndustry", custIndustry);
        model.addAttribute("custLevel", custLevel);

        return "customer";
    }



    /**
     * 创建用户
     */
    @RequestMapping("/customer/create.action")
    @ResponseBody
    public String customerCreate(Customer customer, HttpSession session){

        User user = (User) session.getAttribute("USER_SESSION");
        customer.getCust_create_id(user.getUser_id());
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        customer.setCust_createtime(timestamp);

        int rows = customerService.createCustomer(customer);
        if (rows>0){
            return "OK";
        }else {
            return "FLASE";
        }

    }

    /**
     * 根据用户id查询用户
     * @param id
     * @return
     */
    @RequestMapping("/customer/getCustomerById.action")
    @ResponseBody
    public Customer getCustomerById(Integer id){
        Customer customer = customerService.getCustomerById(id);
        return customer;
    }

    /**
     * 更新用户
     * @param customer
     * @return
     */
    @RequestMapping("/customer/update.action")
    @ResponseBody
    public String getCustomerById(Customer customer){

        int rows = customerService.updateCustomer(customer);
        if(rows>0){
            return "OK";
        }else {
            return "FLASE";
        }
    }

    /**
     * 删除用户
     * @param id
     * @return
     */
    @RequestMapping("/customer/delete.action")
    @ResponseBody
    public String CustomerDelete(Integer id){

        int rows = customerService.deleteCustomer(id);
        if (rows>0){
            return "OK";
        }else {
            return "FLASE";
        }
    }
}
