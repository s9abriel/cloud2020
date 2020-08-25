package com.s9abriel.springcloud.service.impl;

import com.s9abriel.springcloud.entities.Payment;
import com.s9abriel.springcloud.dao.PaymentDao;

import com.s9abriel.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
