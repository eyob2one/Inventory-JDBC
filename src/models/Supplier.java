package models;

public class Supplier {
    private int supplier_id;
    private String company_name;
    private String transaction_number;
    private int id;

    public Supplier(int supplier_id, String company_name, String transaction_number, int id){
        this.supplier_id = supplier_id;
        this.company_name = company_name;
        this.transaction_number = transaction_number;
        this.id = id;
    }

    public int getSupplier_id() {
        return supplier_id;
    }

    public void setSupplier_id(int supplier_id) {
        this.supplier_id = supplier_id;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
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
