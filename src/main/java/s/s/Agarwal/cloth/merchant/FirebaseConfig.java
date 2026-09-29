package s.s.Agarwal.cloth.merchant;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.context.annotation.Configuration;
import jakarta.annotation.PostConstruct;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Configuration
public class FirebaseConfig {

    @PostConstruct
    public void initializeFirebase() throws IOException {

        if (FirebaseApp.getApps().isEmpty()) {

            String firebaseCredentials = System.getenv("FIREBASE_CREDENTIALS");

            if (firebaseCredentials == null || firebaseCredentials.isBlank()) {
                throw new IllegalStateException(
                        "FIREBASE_CREDENTIALS environment variable is not set"
                );
            }

            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(
                            GoogleCredentials.fromStream(
                                    new ByteArrayInputStream(
                                            firebaseCredentials.getBytes(StandardCharsets.UTF_8)
                                    )
                            )
                    )
                    .build();

            FirebaseApp.initializeApp(options);

            System.out.println("====================================");
            System.out.println("FIREBASE CONNECTED SUCCESSFULLY");
            System.out.println("====================================");
        }
    }
}