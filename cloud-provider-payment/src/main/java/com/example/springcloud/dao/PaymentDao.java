package com.example.springcloud.dao;

import com.example.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PaymentDao {
    int save(Payment payment);

    Payment getPaymentById(@Param(value = "id") Long id);

    List<Payment> findAll();

    int update(Payment payment);

    int delete(@Param(value = "id") Long id);
}
