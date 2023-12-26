package com.android.android.Controller.REST;

import com.android.android.Controller.DTO.ReportDTO;
import com.android.android.Service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping({"api/report"})
public class ReportController {

    private final OrderService orderService;

    public ReportController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/getReport/{dateFrom}/{dateTo}")
    public ReportDTO getReport(@PathVariable("dateFrom") Long dateFrom,
                               @PathVariable("dateTo") Long dateTo){
        return orderService.getReportOrders(dateFrom, dateTo);
    }
}
