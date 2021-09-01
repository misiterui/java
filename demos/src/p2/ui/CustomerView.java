package p2.ui;

import p2.bean.Customer;
import p2.services.CustomerList;
import p2.utils.CMUtility;

/*
 * @Description CustomerView为主模块，负责菜单的显示和处理用户操作
 * @author Cloris
 * @version
 * @date 2021年8月29日
 * */
public class CustomerView {

    private CustomerList customerList = new CustomerList(10);

    public CustomerView() {
        Customer customer = new Customer("Alaa", "male", 33, "778xxxxxxx", "alaa@sfu.ca");
        customerList.addCustomer(customer);
    }

    public void enterMainMenu(){
        boolean isFlag = true;
        while (isFlag) {
            System.out.println("\n---------客户信息管理软件---------");
            System.out.println("            1. 添加客户");
            System.out.println("            2. 修改客户");
            System.out.println("            3. 删除客户");
            System.out.println("            4. 客户列表");
            System.out.println("            5. 退  出");
            System.out.print("请选择（1-5）：");
            char menu = CMUtility.readMeanSelection();
            switch (menu) {
                case '1':
                    addNewCustomer();
                    break;
                case '2':
                    modifyCustomer();
                    break;
                case '3':
                    deleteCustomer();
                    break;
                case '4':
                    listAllCustomer();
                    break;
                case '5':
                    System.out.print("确认是否退出(Y/N): ");
                    char isExit = CMUtility.readConfirmSelection();
                    if (isExit == 'Y') {
                        isFlag = false;
                    }
                    break;

            }
        }
    }
    private void addNewCustomer(){
        System.out.println("--------- Add a customer ---------");
        System.out.print("Name: ");
        String name = CMUtility.readString(20);
        System.out.print("Gender: ");
        String gender = CMUtility.readString(10);
        System.out.print("Age: ");
        int age = CMUtility.readInt();
        System.out.print("Phone: ");
        String phone = CMUtility.readString(13);
        System.out.print("Email: ");
        String email = CMUtility.readString(30);

        // encapsulate the info above to a customer
        Customer customer = new Customer(name, gender, age, phone, email);
        boolean isSuccess = customerList.addCustomer(customer);
        if (isSuccess){
            System.out.println("--- Successfully add a customer ---");
        } else {
            System.out.println("--- Failed add a customer due to customer list full ---");
        }
    }
    private void modifyCustomer(){
        System.out.println("------- Modify a customer -------");
        Customer customer;
        int index;
        for(;;){
            System.out.print("Please enter the customer id you would like to modify (-1 to exit): ");
            int number = CMUtility.readInt();

            if(number == -1){
                return;
            }
            customer = customerList.getCustomer(number-1);
            if (customer == null) {
                System.out.println("Customer not found");
            } else {
                index = number-1;
                break;
            }
        }
        // modify the customer info
        System.out.print("Name(" + customer.getName() + "): ");
        String name = CMUtility.readString(20, customer.getName());
        System.out.print("Gender(" + customer.getGender() + "): ");
        String gender = CMUtility.readString(10, customer.getGender());
        System.out.print("Age(" + customer.getAge() + "): ");
        int age = CMUtility.readInt(customer.getAge());
        System.out.print("Phone(" + customer.getPhone() + "): ");
        String phone = CMUtility.readString(13, customer.getPhone());
        System.out.print("Email(" + customer.getEmail() + "): ");
        String email = CMUtility.readString(20, customer.getEmail());

        Customer newCustomer = new Customer(name, gender, age, phone, email);
        boolean isReplaced = customerList.replaceCustomer(index, newCustomer);
        if (isReplaced){
            System.out.println("--- Successfully modify the customer: " + newCustomer.getName() + "---");
        } else {
            System.out.println("--- Failed to modify the customer: " + newCustomer.getName() + "---");
        }
    }
    private void deleteCustomer(){
        System.out.println("------- Delete a customer -------");
        int index;
        for (;;){
            System.out.print("Please select a customer id (-1 to exit): ");
            int number = CMUtility.readInt();

            if (number == -1) {
                return;
            }

            Customer customer = customerList.getCustomer(number - 1);
            if (customer == null) {
                System.out.println("The customer does not exist!");
            } else {
                index = number - 1;
                break;
            }
        }

        // find the customer;
        System.out.print("Are you sure to delete the customer(Y/N): ");
        char isDelete = CMUtility.readConfirmSelection();
        if (isDelete == 'Y'){
            customerList.deleteCustomer(index);
        }
    }
    private void listAllCustomer(){
        System.out.println("------------- customer list ---------------");
        int total = customerList.getTotal();
        if (total == 0){
            System.out.println("no records!");
        } else {
            System.out.println("id\tname\tgender\tage\t\tphone\t\temail");
            Customer[] customers = customerList.getAllCustomers();
            for (int i=0; i<customers.length; i++){
                System.out.println((i+1) + "\t" + customers[i].getName()
                                         + "\t" + customers[i].getGender()
                                         + "\t" + customers[i].getAge()
                                         + "\t" + customers[i].getPhone()
                                         + "\t\t" + customers[i].getEmail());
            }
        }
        System.out.println("-------------------------end of customer list--------------------------");
    }

    public static void main(String[] args) {
        CustomerView customerView = new CustomerView();
        customerView.enterMainMenu();
    }
}
