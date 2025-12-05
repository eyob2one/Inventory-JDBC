package models;

public class Customer {
    private int customer_id;
    private String first_name;
    private String last_name;
    private String transaction_number;
    private int id;

    public Customer(int customer_id, String first_name, String last_name, String transaction_number, int id){
        this.customer_id = customer_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.transaction_number = transaction_number;
        this.id = id;
    }


    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getTransaction_number() {
        return transaction_number;
    }

    public void setTransaction_number(String transaction_number) {
        this.transaction_number = transaction_number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
