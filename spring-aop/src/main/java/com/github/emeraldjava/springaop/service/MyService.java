package com.github.emeraldjava.springaop.service;

import org.springframework.stereotype.Component;

@Component
public class MyService implements IBillNoArgs, IBillArgs, IBillArgsException {

    public void createBill() {
        System.out.println("Bill created");
    }

    public void createBill(Long id) {
        System.out.println("Bill created "+id);
    }

    public void createBillEx(Long id) throws Exception {
        System.out.println("createBillEx "+id);
    }
}
