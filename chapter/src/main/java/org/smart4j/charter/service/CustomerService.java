package org.smart4j.charter.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smart4j.framework.annotation.Transaction;
import org.smart4j.framework.bean.FileParam;
import org.smart4j.framework.helper.DatabaseHelper;
import org.smart4j.charter.model.Customer;
import org.smart4j.framework.annotation.Service;
import org.smart4j.framework.helper.UploadHelper;

import java.util.List;
import java.util.Map;

@Service
public class CustomerService {
    private static final Logger LOGGER = LoggerFactory.getLogger(Customer.class);

    /**
     * 获取客户列表
     *
     * @param keyword
     * @return
     */
    public List<Customer> getCustomerList(String... keyword) {
        String sql = "select * from t_customer";
        return DatabaseHelper.queryEntityList(Customer.class, sql);
    }

    /**
     * 获取客户信息
     *
     * @param id
     * @return
     */
    public Customer getCustomer(long id) {
        String sql = "select * from t_customer where id = ?";
        return DatabaseHelper.queryEntity(Customer.class, sql, id);
    }

    /**
     * 创建客户信息
     *
     * @param params
     * @param photo
     * @return
     */
    public boolean createCustomer(Map<String, Object> params, FileParam photo) {
        params.put("photo", photo.getFileName());
        boolean flag = DatabaseHelper.insertEntity(Customer.class, params);
        if (flag)
            UploadHelper.uploadFile("/tmp/upload/", photo);
        return flag;
    }

    /**
     * 修改客户信息
     *
     * @param id
     * @param params
     * @return
     */
    public boolean updateCustomer(long id, Map<String, Object> params) {
        return DatabaseHelper.updateEntity(id, Customer.class, params);
    }

    /**
     * 删除客户信息
     *
     * @param id
     * @return
     */
    @Transaction
    public boolean deleteCustomer(long id) {
        boolean flag = DatabaseHelper.deleteEntity(id, Customer.class);
        throw new RuntimeException("xxx");
    }

}
