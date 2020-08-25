package com.s9abriel.springcloud.controller;


import com.s9abriel.springcloud.entities.CommonResult;
import com.s9abriel.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import com.s9abriel.springcloud.service.PaymentService;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("*********插入结果:" + result);
        if (result > 0) {
            return new CommonResult(200, "插入数据库，端口为"+serverPort, result);
        }else {
            return new CommonResult(444, "插入数据库失败", null);
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id")Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("*********插入结果:" + payment);
        if (payment != null) {
            return new CommonResult(200, "查询成功,端口号"+serverPort, payment);
        }else {
            return new CommonResult(444, "查询"+id+"查询失败，请核对id", null);
        }
    }
}
