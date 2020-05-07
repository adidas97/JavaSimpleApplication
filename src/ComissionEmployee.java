public class ComissionEmployee extends Employee implements IPayrollCalculator {

    private int comission;
    private double priceOfDeal;
    private int numberOfDeals;

    public ComissionEmployee(int age, String firstName, String lastName,
                             String email, Address address,int comission, double priceOfDeal,int numberOfDeals) {
        super(age, firstName, lastName, email, address);
        this.comission = comission;
        this.numberOfDeals = numberOfDeals;
        this.priceOfDeal = priceOfDeal;
        this.salary = CalculateSalary();
    }
    public double CalculateSalary() {

    	  double convertedPrice = comission/100.0;
          return (numberOfDeals*priceOfDeal)*convertedPrice;
    }
}
