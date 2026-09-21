package s.s.Agarwal.cloth.merchant;

import java.util.List;

public class BillRequest {

    public String customerName;
    public String invoiceNumber;
    public String date;
    public List<Item> items;

    public static class Item {

        public int id;
        public String name;
        public int quantity;
        public double price;
    }
}