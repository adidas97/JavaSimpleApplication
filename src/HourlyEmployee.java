public class HourlyEmployee extends Employee implements IPayrollCalculator {

    private double pricePerHour;
    private int hoursPerMonth;

    public HourlyEmployee(int age, String firstName, String lastName,
                          String email, Address address,
                          double pricePerHour,int hoursPerMonth) {

        super(age, firstName, lastName, email, address);
        this.pricePerHour = pricePerHour;
        this.hoursPerMonth = hoursPerMonth;
        this.salary = CalculateSalary();
    }

    public double CalculateSalary() {
        return pricePerHour*hoursPerMonth;
    }

}
