package com.genpact.onlineshopingapp;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.assertEquals;
import com.genpact.onlineshopingapp.repository.AdminRepositoryImpl;

public class AdminRepositoryImplTest {
    private static AdminRepositoryImpl adminRepositoryImpl = null;

    @BeforeAll
    static void init(){
        //code
    }

    @AfterAll
    static void destroy(){
        //code
    }

    @Test
    void testGetAllCustomer(){
        //count total customers and compare with the last id.
    }

    @Test
    void testGetAllShopkeeper(){
        //count total customers and compare with the last id.
    }

    @Test
    void testGetHistoryOfCustomer1(){
        //test on an non existing customer compare with null.
    }

    @Test
    void testGetHistoryOfCustomer2(){
        //test on an existing customer by comparing theit cid.
    }

    @Test
    void testGetHistoryOfShopkeeper1(){
        //test on an non existing shopkeeper compare with null.
    }

    @Test
    void testGetHistoryOfShopkeeper2(){
        //test on an existing shopkeeper compare with sid.
    }

    @Test
    void testAddPaymentMethod1(){
        //add a new test payment method.
    }

    @Test
    void testAddPaymentMethod2(){
        //add a new test payment method, with -0.1 discount.
    }

    @Test
    void testAddPaymentMethod3(){
        //add a new test payment method, with 100.1 discount.
    }
	
    @Test
    void changeDiscountOfPayment1(){
        //add a new test payment method.
    }

    @Test
    void changeDiscountOfPayment2(){
        //add a new test payment method, with -0.1 discount.
    }

    @Test
    void changeDiscountOfPayment3(){
        //add a new test payment method, with 100.1 discount.
    }
}
