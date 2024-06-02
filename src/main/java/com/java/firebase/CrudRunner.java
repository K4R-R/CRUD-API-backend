package com.java.firebase;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileInputStream;
import java.io.IOException;

@SpringBootApplication
public class CrudRunner {
    public static void main(String[] args) throws IOException {
        ClassLoader classLoader = CrudRunner.class.getClassLoader();

        FileInputStream serviceAccount =
                new FileInputStream("src/main/resources/serviceAccountKey.json");

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("https://userapi-4d607-default-rtdb.firebaseio.com")
                .build();

        FirebaseApp.initializeApp(options);



        SpringApplication.run(CrudRunner.class, args);
    }
}