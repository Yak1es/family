package com.example.Controller;

import com.example.Entity.Record.IncomeRecord;
import com.example.Entity.Record.SpendRecord;
import com.example.Service.Record.AddRecordServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/AddData")
public class AddDataController {
    @Autowired
    AddRecordServiceImp addRecordServiceImp;

    @PostMapping("/AddSpend")
    public Boolean AddSpend(@RequestBody SpendRecord spendRecord) {
        return addRecordServiceImp.AddSpend(spendRecord);

    }

    @PostMapping("/AddIncome")
    public Boolean AddIncome(@RequestBody IncomeRecord incomeRecord) {
       
        return addRecordServiceImp.AddIncome(incomeRecord);

    }

}
