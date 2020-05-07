public class SalaryEmployee extends Employee {

    public SalaryEmployee(int age, String firstName, String lastName,
                          String email, Address address, double salary) {
        super(age, firstName, lastName, email, address);
        this.salary = salary;
    }
}
