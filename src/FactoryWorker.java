public class FactoryWorker extends HourlyEmployee implements IWorker {
	
	 private static int lastAssignedId = 0;
	 private int id;
	
    public FactoryWorker(int age, String firstName, String lastName,
                       String email, Address address,double pricePerHour,int hoursPerMonth) {
        super(age, firstName, lastName, email, address,pricePerHour,hoursPerMonth);
        
       this.lastAssignedId++;
        this.id = lastAssignedId;
    }

    public int getId() {
        return this.id;
    }
    public void Work() {

    }
}
