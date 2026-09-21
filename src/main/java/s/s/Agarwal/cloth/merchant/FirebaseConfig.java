package s.s.Agarwal.cloth.merchant;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.context.annotation.Configuration;

import jakarta.annotation.PostConstruct;
import java.io.IOException;

@Configuration
public class FirebaseConfig {

    @PostConstruct
    public void initializeFirebase() throws IOException {

        if (FirebaseApp.getApps().isEmpty()) {

            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(
                            GoogleCredentials.getApplicationDefault()
                    )
                    .build();

            FirebaseApp.initializeApp(options);

            System.out.println("====================================");
            System.out.println("FIREBASE CONNECTED SUCCESSFULLY");
            System.out.println("====================================");
        }
    }
}