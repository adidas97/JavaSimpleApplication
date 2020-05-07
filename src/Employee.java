public abstract class Employee  {

    private int age;
    private String firstName;
    private String lastName;
    protected double salary;
    private String email;
    private Address address;

    public Employee(int age, String firstName, String lastName,
                     String email, Address address) {
          
          this.age = age;
          this.firstName = firstName;
          this.lastName = lastName;
          this.email = email;
          this.address = address;
    }
    
    public int getAge() {
        return age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
   
    public String getEmail() {
        return email;
    }

    public double getSalary() {
        return salary;
    }

    public Address getAddress() {
        return address;
    }
}
