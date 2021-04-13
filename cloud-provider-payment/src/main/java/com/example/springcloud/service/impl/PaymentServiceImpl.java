package com.example.springcloud.service.impl;

import com.example.springcloud.dao.PaymentDao;
import com.example.springcloud.entities.Payment;
import com.example.springcloud.service.PaymentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service(value = "paymentService")
public class PaymentServiceImpl implements PaymentService {
    private final PaymentDao paymentDao;

    public PaymentServiceImpl(PaymentDao paymentDao) {
        this.paymentDao = paymentDao;
    }

    @Override
    public int save(Payment payment) {
        payment.setId(UUID.randomUUID().toString().codePoints().count());
        return paymentDao.save(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }

    @Override
    public PageInfo<Payment> findByHelper(int page, int size) {
        PageHelper.startPage(page, size);
        List<Payment> paymentList = paymentDao.findAll();
        return new PageInfo<>(paymentList);
    }

    @Override
    public int update(Payment payment) {
        return paymentDao.update(payment);
    }

    @Override
    public int delete(Long id) {
        return paymentDao.delete(id);
    }
}
