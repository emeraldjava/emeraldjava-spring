package com.github.emeraldjava.springaop;

import com.github.emeraldjava.springaop.service.MyService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringAopApplicationTests {

    @Autowired
    MyService myService;

    @Test
    void createBill() {
        myService.createBill();
    }

    @Test
    void createBillArg() {
        myService.createBill(2l);
    }

    @Test
    void createBillArgEx() throws Exception {
        myService.createBillEx(4l);
    }

    @Test
    void createBillArgExCatch() throws Exception {
        try {
            myService.createBillEx(5l);
        } catch(Throwable e) {
            e.printStackTrace();
        }
    }

}
