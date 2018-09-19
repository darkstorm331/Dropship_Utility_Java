/*******************************************************************************
 * Copyright 2009-2016 Amazon Services. All Rights Reserved.
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 *
 * You may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at: http://aws.amazon.com/apache2.0
 * This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR 
 * CONDITIONS OF ANY KIND, either express or implied. See the License for the 
 * specific language governing permissions and limitations under the License.
 *******************************************************************************
 * Marketplace Web Service Products
 * API Version: 2011-10-01
 * Library Version: 2016-06-01
 * Generated: Mon Jun 13 10:07:47 PDT 2016
 */
package com.amazonservices.mws.products.samples;

import java.util.*;
import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigDecimal;

import com.amazonservices.mws.client.*;
import com.amazonservices.mws.products.*;
import com.amazonservices.mws.products.model.*;


/** Sample call for GetMyFeesEstimate. */
public class GetMyFeesEstimateSample {

    /**
     * Call the service, log response and exceptions.
     *
     * @param client
     * @param request
     *
     * @return The response.
     */
    public static GetMyFeesEstimateResponse invokeGetMyFeesEstimate(
            MarketplaceWebServiceProducts client, 
            GetMyFeesEstimateRequest request) {
        try {
            // Call the service.
            GetMyFeesEstimateResponse response = client.getMyFeesEstimate(request);
            ResponseHeaderMetadata rhmd = response.getResponseHeaderMetadata();
            // We recommend logging every the request id and timestamp of every call.
            System.out.println("Response:");
            System.out.println("RequestId: "+rhmd.getRequestId());
            System.out.println("Timestamp: "+rhmd.getTimestamp());
            String responseXml = response.toXML();
            System.out.println(responseXml);
            return response;
        } catch (MarketplaceWebServiceProductsException ex) {
            // Exception properties are important for diagnostics.
            System.out.println("Service Exception:");
            ResponseHeaderMetadata rhmd = ex.getResponseHeaderMetadata();
            if(rhmd != null) {
                System.out.println("RequestId: "+rhmd.getRequestId());
                System.out.println("Timestamp: "+rhmd.getTimestamp());
            }
            System.out.println("Message: "+ex.getMessage());
            System.out.println("StatusCode: "+ex.getStatusCode());
            System.out.println("ErrorCode: "+ex.getErrorCode());
            System.out.println("ErrorType: "+ex.getErrorType());
            throw ex;
        }
    }

    /**
     *  Command line entry point.
     */
    public static void main(String[] args) {

        // Get a client connection.
        // Make sure you've set the variables in MarketplaceWebServiceProductsSampleConfig.
        MarketplaceWebServiceProductsClient client = MarketplaceWebServiceProductsSampleConfig.getClient();

        // Create a request.
        GetMyFeesEstimateRequest request = new GetMyFeesEstimateRequest();
        String sellerId = "A3HVTA4MNUBNX3";
        request.setSellerId(sellerId);
        String mwsAuthToken = "AKIAIMDEW7A52MUKBJDA";
        request.setMWSAuthToken(mwsAuthToken);
        FeesEstimateRequestList feesEstimateRequestList = new FeesEstimateRequestList();
        FeesEstimateRequest testASIN = new FeesEstimateRequest();
        testASIN.setIdType("ASIN");
        testASIN.setIdValue("B01NAF2JLG");
        testASIN.setIdentifier("testASIN");
        testASIN.setMarketplaceId("A1F83G8C2ARO7P");
        PriceToEstimateFees price = new PriceToEstimateFees();
        MoneyType mt = new MoneyType();
        MoneyType shipping = new MoneyType();
        mt.setAmount(new BigDecimal(59.49));
        mt.setCurrencyCode("GBP");
        shipping.setAmount(new BigDecimal(5));
        shipping.setCurrencyCode("GBP");
        price.setListingPrice(mt);
        price.setShipping(shipping);
        testASIN.setPriceToEstimateFees(price);;
        feesEstimateRequestList.withFeesEstimateRequest(testASIN);
        request.setFeesEstimateRequestList(feesEstimateRequestList);

        // Make the call.
        GetMyFeesEstimateSample.invokeGetMyFeesEstimate(client, request);

    }

}
