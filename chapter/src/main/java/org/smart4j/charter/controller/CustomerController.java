package org.smart4j.charter.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.smart4j.charter.bean.ResponseBo;
import org.smart4j.charter.model.Customer;
import org.smart4j.charter.service.CustomerService;
import org.smart4j.framework.annotation.*;
import org.smart4j.framework.bean.Data;
import org.smart4j.framework.bean.Param;
import org.smart4j.framework.bean.View;
import org.smart4j.framework.helper.ServletHelper;

import java.util.List;
@RequestMapping("customer")
@Controller
public class CustomerController {
    @Inject
    private CustomerService customerService;
    @RequiresPermissions("customer:create")
    @GetMapping("create")
    public View customerCreate() {
        ServletHelper.setRequestAttribute("user","zhangsan");
        return new View("customer_create.jsp");
    }
    @RequiresPermissions("customer:create")
    @PostMapping("create")
    public Data customerCreate(Param param) {
        boolean flag = customerService.createCustomer(param.getFieldMap(),param.getFile("photo"));
        return new Data(flag ? ResponseBo.ok() : ResponseBo.error());
    }
    @GetMapping("detail")
    @RequiresPermissions("customer:detail")
    public View customerDetail(Param param) {
        long id = param.getLong("id");
        Customer customer = customerService.getCustomer(id);
        View view = new View("customer_edit.jsp");
        view.addModel("customer", customer);
        return view;
    }
    @PostMapping("edit")
    @RequiresPermissions("customer:edit")
    public Data customerEdit(Param param) {
        long id = param.getLong("id");
        Data data = new Data(ResponseBo.error("修改错误"));
        return data;
    }
    @GetMapping
    @RequiresPermissions("customer:list")
    public View customer(Param param) {
        String name = param.getString("name");
        List<Customer> customerList = customerService.getCustomerList(name);
        View view = new View("customer.jsp");
        view.addModel("customerList", customerList);
        return view;
    }
    @PostMapping("delete")
    @RequiresPermissions("customer:delete")
    public Data customerDelete(Param param) {
        long id = param.getLong("id");
        boolean flag = customerService.deleteCustomer(id);
        Data data = new Data(flag ? ResponseBo.ok() : ResponseBo.error());
        return data;
    }
}
