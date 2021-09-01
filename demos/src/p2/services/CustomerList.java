package p2.services;
import p2.bean.Customer;
/*
 * @Description CustomerList为Customer对象的管理模块，内部用数组管理一组Customer对象，并提供相应的添加、修改、删除或便利方法，供CustomerView使用
 * @author Cloris
 * @version
 * @date 2021年8月29日
 * */

public class CustomerList {
    private Customer[] customers; //
    private int total = 0; // 记录已保存客户的数量

    public CustomerList(int totalCustomer) {
        customers = new Customer[totalCustomer];
    }

    public boolean addCustomer(Customer customer) {
        if (total >= customers.length){
            return false;
        }
//        customers[total] = customer;
//        total++;
        customers[total++] = customer;
        return true;
    }

    public boolean replaceCustomer(int index, Customer cust){
        if (index < 0 || index >= total){
            customers[index] = cust;
            return false;
        }
        customers[index] = cust;
        return true;
    }

    public boolean deleteCustomer(int index) {
        if (index < 0 || index >= total) {
            return false;
        }
        for (int i=index; i<total -1; i++){
            customers[i] = customers[i+1];
        }
//        customers[total-1] = null;
//        total--;
        customers[--total] = null;
        return true;
    }

    public Customer[] getAllCustomers() {
        // return customers 不能直接这么写因为customers中有很多位置是空的
        Customer[] custs = new Customer[total];
        for (int i=0; i<total; i++){
            custs[i] = customers[i];
        }
        return custs;
    }

    public Customer getCustomer(int index){
        if (index < 0 || index >= total){
            return null;
        }
        return customers[index];
    }

    public int getTotal(){
        return total;
    }
}
