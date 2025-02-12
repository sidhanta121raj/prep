//package com.poppulo.lottery.exception;
//
//import java.util.Collections;
//
//import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import jakarta.validation.ConstraintViolationException;
//
//@RestController
//@RequestMapping("/test")
//public class TestController {
//
//    @GetMapping("/notfound")
//    public void throwNotFoundException() {
//        throw new NotFoundException("Resource not found");
//    }
//
//    @GetMapping("/badrequest")
//    public void throwBadRequestException() {
//        throw new BadRequestException("Bad request");
//    }
//
//    @GetMapping("/validation")
//    public void throwValidationException() throws MethodArgumentNotValidException {
//        throw new MethodArgumentNotValidException(null, null);
//    }
//
//    @GetMapping("/constraintviolation")
//    public void throwConstraintViolationException() {
//        throw new ConstraintViolationException(Collections.emptySet());
//    }
//}
