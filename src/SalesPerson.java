public class SalesPerson extends  ComissionEmployee implements IWorker{

	 private static int lastAssignedId = 0;
     private int id;
	    
    public SalesPerson(int age, String firstName, String lastName,
                       String email, Address address,int comission,double priceOfDeal, int numberOfDeals) {
        super(age, firstName, lastName, email, address,comission,priceOfDeal,numberOfDeals);
        this.lastAssignedId++;
        this.id = lastAssignedId;
    }
    public int getId() {
        return this.id;
    }

    public void Work() {

    }
}
