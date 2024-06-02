package com.java.firebase;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
public class CrudController {

    public CrudService crudService;

    public CrudController(CrudService crudService) {
        this.crudService=crudService;
    }

    @PostMapping("/create")
    public String createCrud(@RequestBody Crud crud) throws InterruptedException, ExecutionException {
        return crudService.createCrud(crud);
    }

    @GetMapping("/get")
    public Crud getCrud(@RequestParam String documentId) throws InterruptedException, ExecutionException {
        return crudService.getCrud(documentId);
    }

    @PutMapping("/update")
    public String updateCrud(@RequestBody Crud crud) throws InterruptedException, ExecutionException {
        return crudService.updateCrud(crud);
    }

    @DeleteMapping("/delete")
    public String deleteCrud(@RequestParam String documentId) throws InterruptedException, ExecutionException {
        return crudService.deleteCrud(documentId);
    }

    @GetMapping("/")
    public List<Crud> getAllUsers() throws ExecutionException, InterruptedException {
        return crudService.getAllCruds();
    }


}
