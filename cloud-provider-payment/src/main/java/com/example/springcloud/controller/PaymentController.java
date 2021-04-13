package com.example.springcloud.controller;

import com.example.springcloud.entities.CommentResult;
import com.example.springcloud.entities.Payment;
import com.example.springcloud.service.PaymentService;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @GetMapping(value = "/payment/list?page={page}&size={size}")
    public CommentResult<PageInfo<Payment>> findByHelper(@RequestParam(defaultValue = "1") @PathVariable("page") int page,
                                          @RequestParam(defaultValue = "10") @PathVariable("size") int size) {
        PageInfo<Payment> pageInfo = paymentService.findByHelper(page, size);
        if (pageInfo != null) {
            return new CommentResult<>(200, "查询数据成功", pageInfo);
        } else {
            return new CommentResult<>(444, "查询数据失败", null);
        }
    }

    @PostMapping(value = "/payment/create")
    public CommentResult<Integer> create(Payment payment) {
        int result = paymentService.save(payment);
        log.info("插入结果：" + result);
        if (result > 0) {
            return new CommentResult<>(200, "添加数据成功", result);
        } else {
            return new CommentResult<>(444, "添加数据失败", null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommentResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("查询结果：" + payment);
        if (payment != null) {
            return new CommentResult<>(200, "查询数据成功", payment);
        } else {
            return new CommentResult<>(444, "没有对应结果，查询数据失败", null);
        }
    }

    @PutMapping(value = "/payment/update")
    public CommentResult<Integer> update(Payment payment) {
        int result = paymentService.update(payment);
        log.info("修改结果：" + result);
        if (result > 0) {
            return new CommentResult<>(200, "修改数据成功", result);
        } else {
            return new CommentResult<>(444, "修改数据失败", null);
        }
    }

    @DeleteMapping(value = "/payment/delete/{id}")
    public CommentResult<Integer> delete(@PathVariable("id") Long id) {
        int result = paymentService.delete(id);
        log.info("删除结果：" + result);
        if (result > 0) {
            return new CommentResult<>(200, "删除数据成功", result);
        } else {
            return new CommentResult<>(444, "删除数据失败", null);
        }
    }
}
