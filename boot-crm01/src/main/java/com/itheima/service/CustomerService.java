package com.itheima.service;

import com.itheima.common.utils.Page;
import com.itheima.domain.Customer;

public interface CustomerService {


    public Page<Customer> findCustomerList(Integer page,Integer rows,String custName, String custSource,String custIndustry,String custLevel);

    /**
     * 添加用户
     *
     * @param customer
     * @return
     */
    public int createCustomer(Customer customer);

    /**
     * 根据id获取用户信息
     *
     * @param id
     * @return
     */
    public Customer getCustomerById(Integer id);

    /**
     * 更新用户
     *
     * @param customer
     * @return
     */
    public int updateCustomer(Customer customer);

    /**
     * 根据id删除用户
     *
     * @param id
     * @return
     */
    public int deleteCustomer(Integer id);

}
