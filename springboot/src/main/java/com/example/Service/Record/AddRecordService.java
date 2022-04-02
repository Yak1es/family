package com.example.Service.Record;

import com.example.Entity.Record.IncomeRecord;
import com.example.Entity.Record.SpendRecord;

import java.util.List;

public interface AddRecordService {
    /*添加收入*/
    Boolean AddIncome(IncomeRecord incomeRecord);

    /*添加支出*/
    Boolean AddSpend(SpendRecord spendRecords);
}
