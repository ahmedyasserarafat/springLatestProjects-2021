package com.acme.orders.api.integrations.impl;

import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;

import com.acme.orders.api.integrations.CatalogueClient;
import com.acme.orders.api.integrations.lib.catalogue.ECommerce;
import com.acme.orders.api.integrations.lib.catalogue.ECommerceErrorFault_Exception;
import com.acme.orders.api.integrations.lib.catalogue.ECommerceWsService;
import com.acme.orders.api.integrations.lib.catalogue.Product;
import com.acme.orders.api.integrations.lib.catalogue.RetrieveProductRequestMessage;
import com.acme.orders.api.integrations.lib.catalogue.RetrieveProductResponseMessage;
import com.acme.orders.api.services.exceptions.GeneralServiceException;

public class CatalogueClientImpl implements CatalogueClient {

    private ECommerce port;

    public CatalogueClientImpl(String wsdl) {

        try {
            //URL wsdlUrl = new URL(wsdl);

           // ECommerceWsService service = new ECommerceWsService(wsdlUrl);

            //port = service.getECommercePort();
        } catch (Exception e) {

            throw new GeneralServiceException(e);
        }
    }

    @Override
    public Product findProductById(String id) {

        try {
            RetrieveProductRequestMessage retrieveProductRequestMessage = new RetrieveProductRequestMessage();
            retrieveProductRequestMessage.setId(Long.valueOf(id));

            RetrieveProductResponseMessage response = port.retrieveProduct(retrieveProductRequestMessage);

            return response.getProduct();
        } catch (Exception e) {

			/*
			 * String code = e.getFaultInfo().getFault().getCode();
			 * 
			 * switch (code) {
			 * 
			 * case "resource.not.found": throw new
			 * ResourceNotFoundException(Product.class.getSimpleName(), id); }
			 * 
			 * throw new GeneralServiceException(e);
			 */
        	Product dd= new Product();
        	dd.setTitle("Test");
        	dd.setPrice(new BigDecimal(4352));
        	dd.setCurrency("BHD");
        	return dd;
        }
    }
}
