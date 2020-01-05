package com.ysyang.sbmarket.controller;

import com.ysyang.sbmarket.Domain.Customer;
import org.springframework.web.bind.annotation.*;
import com.ysyang.sbmarket.Domain.Branch;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BranchCotroller {

    @GetMapping("/branches")
    public List<Branch> getUsers() {
        List<Branch> listBr = new ArrayList<>();

        return listBr;
    }

    @PostMapping("/branches")
    public Branch createBranch(@RequestBody Branch branch) {
        Branch br = new Branch();

        return br;
    }

    @GetMapping("/branch/{branchId}")
    public Branch getUser(@PathVariable Long branchId) {
        Branch br = new Branch();

        return br;
    }

    @GetMapping("/{branchId}/customers")
    public List<Customer> getUserCustomers(@PathVariable Long branchId){
        List<Customer> listCt = new ArrayList<>();

        return listCt;
    }

    @DeleteMapping("/branch/{branchId}")
    public void deleteUser(@PathVariable Long branchId){

    }

}
