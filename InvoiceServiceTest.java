package com.cabinvoice;

import org.junit.Assert;
import org.junit.Test;

public class InvoiceServiceTest {

    //Calculating total Fare
    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare() {
        InvoiceGenerator cabInvoiceGenerator = new InvoiceGenerator();
        double distance = 2.0;
        int time = 5;
        double fare = cabInvoiceGenerator.calculateFare(distance, time);
        Assert.assertEquals(25, fare, 0.0);
    }

    //Calculating Minimum Fare
    @Test
    public void givenDistanceAndTime_ShouldReturnMinFare() {
        InvoiceGenerator cabInvoiceGenerator = new InvoiceGenerator();
        double distance = 0.0;
        int time = 1;
        double fare = cabInvoiceGenerator.calculateFare(distance, time);
        Assert.assertEquals(5, fare, 0.0);
    }

    //Taking multiple rides and calculating  total fare
    @Test
    public void givenMultipleRides_ShouldReturnInvoiceSummary() {
        InvoiceGenerator cabInvoiceGenerator = new InvoiceGenerator();
        Ride[] rides = { new Ride(2.0,5),
                new Ride(2.0,8),
                new Ride(0.2,1),
                new Ride(3.0,6)
        };
        InvoiceSummary invoiceSummary = cabInvoiceGenerator.calculateFare(rides);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(4,94);
        Assert.assertEquals(invoiceSummary,expectedInvoiceSummary);
    }
}
