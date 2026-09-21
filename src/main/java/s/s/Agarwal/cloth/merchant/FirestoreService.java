package s.s.Agarwal.cloth.merchant;

import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class FirestoreService {

    public void saveBill(
            String invoiceNumber,
            String date,
            String customerName,
            double grandTotal) {

        try {

            Firestore db = FirestoreClient.getFirestore();

            Map<String, Object> bill = new HashMap<>();

            bill.put("invoiceNumber", invoiceNumber);
            bill.put("date", date);
            bill.put("customerName", customerName);
            bill.put("grandTotal", grandTotal);

            db.collection("bills").add(bill);

            System.out.println("====================================");
            System.out.println("BILL SAVED TO FIREBASE");
            System.out.println("Invoice: " + invoiceNumber);
            System.out.println("Customer: " + customerName);
            System.out.println("Grand Total: " + grandTotal);
            System.out.println("====================================");

        } catch (Exception e) {

            System.out.println("====================================");
            System.out.println("FIREBASE SAVE FAILED");
            System.out.println(e.getMessage());
            System.out.println("====================================");

            e.printStackTrace();
        }
    }
}