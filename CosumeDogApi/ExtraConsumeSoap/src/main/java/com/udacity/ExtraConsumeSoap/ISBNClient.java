package com.udacity.ExtraConsumeSoap;

import com.daehosting.webservices.isbn.IsValidISBN10;
import com.daehosting.webservices.isbn.IsValidISBN10Response;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class ISBNClient extends WebServiceGatewaySupport {

    public IsValidISBN10Response validate(String isbn) {
        //publicly accessible SOAP service
        String uri = "http://webservices.daehosting.com/services/isbnservice.wso";

        //set the request
        IsValidISBN10 isbnRequest = new IsValidISBN10();
        isbnRequest.setSISBN(isbn);

        //obtain and return the response
        IsValidISBN10Response response =
                (IsValidISBN10Response) getWebServiceTemplate().marshalSendAndReceive(uri, isbnRequest);

        return response;
    }
}
