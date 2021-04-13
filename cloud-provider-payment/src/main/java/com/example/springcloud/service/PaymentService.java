package com.example.springcloud.service;

import com.example.springcloud.entities.Payment;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;

public interface PaymentService {
    int save(Payment payment);

    Payment getPaymentById(@Param(value = "id") Long id);

    PageInfo<Payment> findByHelper(int page, int size);

    int update(Payment payment);

    int delete(Long id);
}