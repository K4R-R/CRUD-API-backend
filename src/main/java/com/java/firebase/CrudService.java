package com.java.firebase;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class CrudService {

    public String createCrud(Crud crud) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("users").document(crud.getDocumentId()).set(crud);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    public Crud getCrud(String documentId) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFirestore.collection("users").document(documentId);
        ApiFuture<DocumentSnapshot> future = documentReference.get();
        DocumentSnapshot document = future.get();
        Crud crud;
        if(document.exists()) {
            crud = document.toObject(Crud.class);
            return crud;
        }
        return null;
    }

    public List<Crud> getAllCruds() throws ExecutionException, InterruptedException {
    Firestore dbFirestore = FirestoreClient.getFirestore();
    CollectionReference users = dbFirestore.collection("users");
    ApiFuture<QuerySnapshot> querySnapshot = users.get();
    
    List<Crud> userList = new ArrayList<>();
    for (DocumentSnapshot document : querySnapshot.get().getDocuments()) {
        Crud user = document.toObject(Crud.class);
        userList.add(user);
    }
    return userList;
}

    public String updateCrud(Crud crud) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("users").document(crud.getDocumentId()).set(crud);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    public String deleteCrud(String documentId) {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> writeResult = dbFirestore.collection("users").document(documentId).delete();
        return "Successfully Deleted " + documentId;
    }

}
