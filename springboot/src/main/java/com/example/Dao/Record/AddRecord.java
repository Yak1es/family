package com.example.Dao.Record;

import com.example.Entity.Record.IncomeRecord;
import com.example.Entity.Record.SpendRecord;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AddRecord {
    /*添加收入记录*/
    Boolean AddIncome(IncomeRecord incomeRecord);

    /*添加支出记录*/
    Boolean AddSpend(SpendRecord spendRecords);
}
