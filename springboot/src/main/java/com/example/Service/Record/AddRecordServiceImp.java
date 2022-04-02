package com.example.Service.Record;

import com.example.Dao.Record.AddRecord;
import com.example.Entity.Record.IncomeRecord;
import com.example.Entity.Record.SpendRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AddRecordServiceImp implements AddRecordService {
    @Autowired
    AddRecord addRecord;

    @Override
    public Boolean AddIncome(IncomeRecord incomeRecord) {
        return addRecord.AddIncome(incomeRecord);
    }

    @Override
    public Boolean AddSpend(SpendRecord spendRecords) {
        return addRecord.AddSpend(spendRecords);
    }


}
