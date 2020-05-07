public class Secretary extends SalaryEmployee implements IWorker {
	 private static int lastAssignedId = 0;
	 private int id;
    public Secretary(int age, String firstName, String lastName,
                   String email, Address address,double salary) {
        super(age, firstName, lastName, email, address, salary);
        this.lastAssignedId++;
        this.id = lastAssignedId;
    }
    public int getId() {
        return this.id;
    }

    public void Work() {

    }
}
