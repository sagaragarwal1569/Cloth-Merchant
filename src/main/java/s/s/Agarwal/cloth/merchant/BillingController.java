package s.s.Agarwal.cloth.merchant;

import org.springframework.web.bind.annotation.*;

@RestController
public class BillingController {

    private final FirestoreService firestoreService;

    public BillingController(FirestoreService firestoreService) {
        this.firestoreService = firestoreService;
    }

    @PostMapping("/calculate")
    public BillResponse calculateBill(@RequestBody BillRequest request) {

        // ============================================
        // CALCULATE TOTAL
        // ============================================

        double total = 0;

        for (BillRequest.Item item : request.items) {
            total = total + (item.quantity * item.price);
        }

        // ============================================
        // DISCOUNT
        // ============================================

        double discount;

        if (total >= 10000) {
            discount = total * 0.10;
        }
        else if (total >= 5000) {
            discount = total * 0.05;
        }
        else if (total >= 3000) {
            discount = total * 0.03;
        }
        else {
            discount = 0;
        }

        // ============================================
        // TAXABLE AMOUNT
        // ============================================

        double taxableAmount = total - discount;

        // ============================================
        // GST
        // ============================================

        double cgst = taxableAmount * 0.025;

        double sgst = taxableAmount * 0.025;

        double gst = cgst + sgst;

        // ============================================
        // AMOUNT INCLUDING GST
        // ============================================

        double finalAmount = taxableAmount + gst;

        // ============================================
        // SAVE BILL TO FIREBASE
        // ============================================

        firestoreService.saveBill(
                request.invoiceNumber,
                request.date,
                request.customerName,
                finalAmount
        );

        // ============================================
        // RETURN BILL DATA
        // ============================================

        return new BillResponse(
                request.customerName,
                total,
                discount,
                taxableAmount,
                cgst,
                sgst,
                gst,
                finalAmount
        );
    }
}