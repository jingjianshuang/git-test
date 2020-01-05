package com.itheima.dao;

import com.itheima.domain.Customer;

import java.util.List;

public interface CustomerDao {

    /**
     * 查询客户列表
     *
     * @param customer
     * @return
     */
    public List<Customer> selectCustomerList(Customer customer);

    /**
     * 查询客户总数
     *
     * @param customer
     * @return
     */
    public Integer selectCustomerListCount(Customer customer);

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
