//package com.mmkpdevelopers.ecommerce.config;
//
//import com.mmkpdevelopers.ecommerce.entity.Customer;
//import com.mmkpdevelopers.ecommerce.entity.Restaurant;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
//import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
//import org.springframework.http.HttpMethod;
//
//@Configuration
//public class MyDataRestConfig implements RepositoryRestConfigurer {
//
//    @Override
//    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
//        HttpMethod[] theUnsupportedActions ={HttpMethod.PUT, HttpMethod.POST, HttpMethod.DELETE};
//
//        // disable HTTP methods for Customer: PUT, POST and DELETE
//
//        config.getExposureConfiguration()
//                .forDomainType(Customer.class)
//                .withItemExposure((metadata, httpMethods) -> httpMethods.disable(theUnsupportedActions))
//                .withCollectionExposure((metadata, httpMethods) -> httpMethods.disable(theUnsupportedActions));
//
//        config.getExposureConfiguration()
//                .forDomainType(Restaurant.class)
//                .withItemExposure((metadata, httpMethods) -> httpMethods.disable(theUnsupportedActions))
//                .withCollectionExposure((metadata, httpMethods) -> httpMethods.disable(theUnsupportedActions));
//
//    }
//}
