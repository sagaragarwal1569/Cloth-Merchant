package s.s.Agarwal.cloth.merchant;

public class BillResponse {

    public String customerName;

    public double total;

    public double discount;

    public double taxableAmount;

    public double cgst;

    public double sgst;

    public double gst;

    public double finalAmount;


    public BillResponse(

            String customerName,

            double total,

            double discount,

            double taxableAmount,

            double cgst,

            double sgst,

            double gst,

            double finalAmount

    ) {

        this.customerName =
                customerName;

        this.total =
                total;

        this.discount =
                discount;

        this.taxableAmount =
                taxableAmount;

        this.cgst =
                cgst;

        this.sgst =
                sgst;

        this.gst =
                gst;

        this.finalAmount =
                finalAmount;

    }

}