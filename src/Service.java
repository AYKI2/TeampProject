public interface Service {
    int clientAge();
    Customer[] similarCountry(String country,Customer[] customers);
    Customer[] sortCountries(Customer[] customers);
    Customer[] showAllCustomers(Customer[] customers);
}
