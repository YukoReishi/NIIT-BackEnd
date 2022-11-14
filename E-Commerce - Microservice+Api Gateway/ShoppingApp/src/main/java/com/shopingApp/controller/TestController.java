package com.shopingApp.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shopingApp.model.ResponseToken;
import com.shopingApp.model.User;
import com.shopingApp.model.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class TestController {

    @Autowired
    private RestTemplate restTemplate;
    String username;

    ResponseToken responseToken = new ResponseToken();
    String jwt;
    private static final String REGISTRATION_URL = "http://localhost:9002/customer/register";
    private static final String AUTHENTICATION_URL = "http://localhost:9002/customer/authenticate";
    private static final String HELLO_URL = "http://localhost:9002/customer/getcustomer";

    private static final String ADD_CUSTOMER_DETAIL = "http://localhost:9002/customer/addDetails";

    private static final String MOBILE_URL = "http://localhost:9004/mobile/getall";
    private static final String ORDER_URL_PLACEORDER = "http://localhost:9005/Order/place-order/";
    private static final String ORDER_URL_GETBYUSERNAME = "http://localhost:9005/Order/";


    @PostMapping("/customer-register")
    public ResponseEntity customerRegistration(@RequestBody User user) throws JsonProcessingException {
        String response = null;
        String registrationBody = getBody(user);
        HttpHeaders registrationHeaders = getHeaders();
        HttpEntity<String> registrationEntity = new HttpEntity<String>(registrationBody, registrationHeaders);
        try{
            ResponseEntity<String> registrationResponse = restTemplate.exchange(REGISTRATION_URL, HttpMethod.POST,registrationEntity, String.class);

            if (registrationResponse.getStatusCode().equals(HttpStatus.OK)) {
                response="Customer Registered Successfully!";
            }
        }catch (Exception e){
            return ResponseEntity.ok(e.getMessage());
        }
        return ResponseEntity.ok(response);
    }


    @RequestMapping(value="/customer-login",method = RequestMethod.POST)
    public String authenticateCustomer(@RequestBody User user) throws JsonProcessingException {
        username = user.getUsername();
        String authenticationBody = getBody(user);
        // create headers specifying that it is JSON request
        HttpHeaders authenticationHeaders = getHeaders();
        HttpEntity<String> authenticationEntity = new HttpEntity<String>(authenticationBody, authenticationHeaders);

        // Authenticate User and get JWT
        ResponseEntity<String> authenticationResponse = restTemplate.exchange(AUTHENTICATION_URL,HttpMethod.POST,authenticationEntity,String.class);
        responseToken.setToken(authenticationResponse.getBody());
        // if the authentication is successful
        try{
            if (authenticationResponse.getStatusCode().equals(HttpStatus.OK)) {
                jwt=authenticationResponse.getBody();
            }
        }catch (Exception e){
            return e.getMessage();
        }
        return jwt;
    }


    @PostMapping("/addDetails")
    public ResponseEntity addDetails(@RequestBody UserDTO userDTO) throws JsonProcessingException {
        String response = null;
        String detailBody = getBody(userDTO);
        System.out.println(detailBody);
        String token = "Bearer " + responseToken.getToken();
        HttpHeaders detailHeaders = getHeaders();
        detailHeaders.set("Authorization", token);
        HttpEntity<String> addDetailEntity = new HttpEntity<String>(detailBody, detailHeaders);
        try{
            ResponseEntity<String> detailResponse = restTemplate.exchange(ADD_CUSTOMER_DETAIL, HttpMethod.POST,addDetailEntity, String.class);
            System.out.println("in try");
            if (detailResponse.getStatusCode().equals(HttpStatus.OK)) {
                response= detailResponse.getBody();
                System.out.println("in if "+response);
            }
        }catch (Exception e){
            System.out.println("in exception");
            return ResponseEntity.ok(e.getMessage());
        }

        return ResponseEntity.ok(response);

    }


    @GetMapping("/getDetails")
    public String getDetails(){
        String response = null;
        String token = "Bearer " + responseToken.getToken();
        HttpHeaders headers = getHeaders();
        headers.set("Authorization", token);
        HttpEntity<String> jwtEntity = new HttpEntity<String>(headers);
        // Use Token to get Response
        ResponseEntity<String> detailResponse = restTemplate.exchange(HELLO_URL, HttpMethod.GET, jwtEntity,
                String.class);
        if (detailResponse.getStatusCode().equals(HttpStatus.OK)) {
            response = String.valueOf(detailResponse.getBody());
        }
        return response;
    }


    @GetMapping("/view-mobile")
    public ResponseEntity viewMobiles(){
        String token = "Bearer " + responseToken.getToken();
        HttpHeaders headers = getHeaders();
        headers.set("Authorization", token);
        HttpEntity<String> jwtEntity = new HttpEntity<String>(headers);
        return ResponseEntity.ok(restTemplate.exchange(MOBILE_URL,HttpMethod.GET,jwtEntity, String.class).getBody());
    }

    @GetMapping("/place-order/{productId}/{qty}")
    public ResponseEntity placeOrder(@PathVariable Long productId,@PathVariable int qty){
        String token = "Bearer " + responseToken.getToken();
        HttpHeaders headers = getHeaders();
        headers.set("Authorization", token);
        HttpEntity<String> jwtEntity = new HttpEntity<String>(headers);
        return ResponseEntity.ok(restTemplate.exchange(ORDER_URL_PLACEORDER+username+"/"+productId+"/"+qty,HttpMethod.GET,jwtEntity, String.class).getBody());
    }


    @GetMapping("/findOrders")
    public ResponseEntity findOrder(){
        return ResponseEntity.ok(restTemplate.getForObject(ORDER_URL_GETBYUSERNAME+username, String.class));
    }




//    @RequestMapping(value = "/getResponse", method = RequestMethod.GET)
//    public String getResponse() throws JsonProcessingException {
//
//        String response = null;
//        // create user registration object
//        RegistrationUser registrationUser = getRegistrationUser();
//        // convert the user registration object to JSON
//        String registrationBody = getBody(registrationUser);
//        // create headers specifying that it is JSON request
//        HttpHeaders registrationHeaders = getHeaders();
//        HttpEntity<String> registrationEntity = new HttpEntity<String>(registrationBody, registrationHeaders);
//
//        try {
//            // Register User
//            ResponseEntity<String> registrationResponse = restTemplate.exchange(REGISTRATION_URL, HttpMethod.POST,
//                    registrationEntity, String.class);
//            // if the registration is successful
//            if (registrationResponse.getStatusCode().equals(HttpStatus.OK)) {
//
//                // create user authentication object
//                User authenticationUser = getAuthenticationUser();
//                // convert the user authentication object to JSON
//                String authenticationBody = getBody(authenticationUser);
//                // create headers specifying that it is JSON request
//                HttpHeaders authenticationHeaders = getHeaders();
//                HttpEntity<String> authenticationEntity = new HttpEntity<String>(authenticationBody,
//                        authenticationHeaders);
//
//                // Authenticate User and get JWT
//                ResponseEntity<ResponseToken> authenticationResponse = restTemplate.exchange(AUTHENTICATION_URL,
//                        HttpMethod.POST, authenticationEntity, ResponseToken.class);
//
//                // if the authentication is successful
//                if (authenticationResponse.getStatusCode().equals(HttpStatus.OK)) {
//                    String token = "Bearer " + authenticationResponse.getBody().getToken();
//                    HttpHeaders headers = getHeaders();
//                    headers.set("Authorization", token);
//                    HttpEntity<String> jwtEntity = new HttpEntity<String>(headers);
//                    // Use Token to get Response
//                    ResponseEntity<String> helloResponse = restTemplate.exchange(HELLO_URL, HttpMethod.GET, jwtEntity,
//                            String.class);
//                    if (helloResponse.getStatusCode().equals(HttpStatus.OK)) {
//                        response = helloResponse.getBody();
//                    }
//                }
//            }
//        } catch (Exception ex) {
//            System.out.println(ex);
//        }
//        return response;
//    }

//    private RegistrationUser getRegistrationUser() {
//        RegistrationUser user = new RegistrationUser();
//        user.setUsername("javainuse");
//        user.setPassword("javainuse");
//        user.setRole("ROLE_USER");
//        return user;
//    }
//
//    private User getAuthenticationUser() {
//        User user = new User();
//        user.setUsername("javainuse");
//        user.setPassword("javainuse");
//        return user;
//    }

    private HttpHeaders getHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        return headers;
    }

    private String getBody(final User user) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(user);
    }

    private String getBody(final UserDTO userDTO) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(userDTO);
    }
}
