import java.text.DateFormat;
import java.time.LocalDate;
import java.util.Arrays;

public class Customer implements Service{
    private String name;
    private String lastname;
    private String country;
    private LocalDate dateOfBirth;
    private String email;
    public Customer() {
    }

    public Customer(String name, String lastname, String country, LocalDate dateOfBirth, String email) {
        if(name.length() >= 2) {
            this.name = name;
        }else {
            System.out.println("The name cannot be less than 2!");
        }
        if(lastname.length() >= 2){
            this.lastname = lastname;
        }else {
            System.out.println("The lastname cannot be less than 2!");
        }
        if(country.length() > 2){
            this.country = country;
        }else {
            System.out.println("The country name cannot be less than 3!");
        }
        this.dateOfBirth = dateOfBirth;
        if(email.contains("@")){
            this.email = email;
        }else {
            System.out.println("email must contain @!");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int clientAge() {
        int age =  LocalDate.now().getYear() - dateOfBirth.getYear();
        return age;
    }

    @Override
    public Customer[] similarCountry(String country,Customer[] customers) {
        int counter = 0;
        for (Customer customer: customers) {
            if(customer.getCountry().equals(country)){
                counter++;
            }
        }
        Customer[] customers1 = new Customer[counter];
        int index = 0;
        for (Customer customer:customers) {
            if (customer.getCountry().equals(country)) {
                customers1[index++] = customer;
            }
        }
        return customers1;
    }

    @Override
    public Customer[] sortCountries(Customer[] customers) {
        Customer safe;
        for (int i = 0; i < customers.length; i++) {
            for (int j = 1; j < customers.length; j++) {
                if(customers[i].getCountry().compareTo(customers[j].getCountry())>0){
                    safe=customers[j-1];
                    customers[j-1]=customers[j];
                    customers[j]=safe;
                }
            }
        }
        return customers;
    }

    @Override
    public Customer[] showAllCustomers(Customer[] customers) {
        return customers;
    }

    @Override
    public String toString() {
        return "\nCustomer:" +
                "\nname = " + name +
                "\nlastname = " + lastname +
                "\nAge = "+ clientAge()+
                "\ncountry = " + country +
                "\ndateOfBirth = " + dateOfBirth +
                "\nemail = " + email+"\n";
    }
}
