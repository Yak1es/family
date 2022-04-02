package com.example.Controller;


import com.example.Entity.Record.IncomeRecord;
import com.example.Entity.Record.SpendRecord;
import com.example.Service.Record.AddRecordServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@RestController
public class AddController {
    @Autowired
    AddRecordServiceImp addRecordServiceImp;

    /*添加收入*/
    @GetMapping("/Income")
    public String hello() throws ParseException {
//        IncomeRecord f = new IncomeRecord();
//        IncomeRecord m = new IncomeRecord();
//        IncomeRecord s = new IncomeRecord();
//        setW(f, m, s, 2);
//        List<IncomeRecord> list = new ArrayList<>();
//        /*工资*/
////        for (int i = 1; i <= 31; i++) {
////            if (i < 10) {
////                f.setIdate("2020-12-0" + i);
////                m.setIdate("2020-12-0" + i);
////                s.setIdate("2020-12-0" + i);
////            } else {
////                f.setIdate("2020-12-" + i);
////                m.setIdate("2020-12-" + i);
////                s.setIdate("2020-12-" + i);
////            }
////            list.add(f);
////            list.add(m);
////            list.add(s);
////            f = getIncomeRecord();
////            m = getIncomeRecord();
////            s = getIncomeRecord();
////            setG(f, m, s);
////
////        }
//        /*外快*/
//        for (int i = 1; i <= 30; i = i + 4) {
//            if (i < 10) {
//                f.setIdate("2020-11-0" + i);
//                m.setIdate("2020-11-0" + i);
//                s.setIdate("2020-11-0" + i);
//            } else {
//                f.setIdate("2020-11-" + i);
//                m.setIdate("2020-11-" + i);
//                s.setIdate("2020-11-" + i);
//            }
//            list.add(f);
//            list.add(m);
//            list.add(s);
//            f = getIncomeRecord();
//            m = getIncomeRecord();
//            s = getIncomeRecord();
//            setW(f, m, s, i / 2);
//
//        }
////        addRecordServiceImp.AddIncome(list);
        SpendRecord f = new SpendRecord();
        SpendRecord m = new SpendRecord();
        SpendRecord s = new SpendRecord();
        List<SpendRecord> list = new ArrayList<>();
        /*先添加 固定的 保险和话费*/
        for (int j = 1; j <= 12; j++) {
            for (int i = 1; i <= getDaysOfMonth(j); i++) {
                /*j是月份*/
//                if (j < 10) {
//                    if (i < 10) {
////                        f.setSdate("2020-0" + j + "-0" + i);
////                        s.setSdate("2020-0" + j + "-0" + i);
//                        m.setSdate("2020-0" + j + "-0" + i);
//                    } else {
//                        /*i是几月*/
////                        f.setSdate("2020-0" + j + "-0" + i);
////                        s.setSdate("2020-0" + j + "-0" + i);
//                        m.setSdate("2020-0" + j + "-0" + i);
//                    }
//                } else {
//                    if (i < 10) {
////                        f.setSdate("2020-" + j + "-0" + i);
////                        s.setSdate("2020-" + j + "-0" + i);
//                        m.setSdate("2020-" + j + "-0" + i);
//                    } else {
////                        f.setSdate("2020-" + j + "-0" + i);
////                        s.setSdate("2020-" + j + "-0" + i);
//                        m.setSdate("2020-" + j + "-0" + i);
//                    }
//                }
//            /*养老保险*/
//            SetB(f, m);
                f.setSdate("2020-" + j + "-0" + i);
                m.setSdate("2020-" + j + "-0" + i);
                s.setSdate("2020-" + j + "-0" + i);
                /*吃饭*/
//                if (i % 7 != 0) {
//                    SetS(f, s);
//                    list.add(f);
//                    list.add(s);
//                }
//                f = getSpendRecord();
//                s = getSpendRecord();
                /*买菜 i % 4 ==0 4天买一次菜*/
                /*i % 10 ==0 15天买一次日用品*/

                /*1个月买一次调料*/
                if (j == 6) {
//                    double v = 10 + Math.random() * (20 - 10 + 1);
//                    SetQ(f, s, v);
                    SetY(f, m, s);
                    list.add(f);
                    list.add(m);
                    list.add(s);
                    break;
                }
                f = getSpendRecord();
                s = getSpendRecord();
                m = getSpendRecord();
            }

        }


//        addRecordServiceImp.AddSpend(list);

        return "你好";
    }

    private void setG(IncomeRecord f, IncomeRecord m, IncomeRecord s) {
        f.setFk_familyid("Family1").setMoney(300).setIncome("工资").setMoneynote("日常工资");
        m.setFk_familyid("Family2").setMoney(100).setIncome("工资").setMoneynote("日常工资");
        s.setFk_familyid("Family3").setMoney(200).setIncome("工资").setMoneynote("日常工资");
    }

    private void setW(IncomeRecord f, IncomeRecord m, IncomeRecord s, int i) {
        f.setFk_familyid("Family1").setMoney(i * 27).setIncome("外快").setMoneynote("兼职");
        m.setFk_familyid("Family2").setMoney(i * 15).setIncome("外快").setMoneynote("兼职");
        s.setFk_familyid("Family3").setMoney(i * 30).setIncome("外快").setMoneynote("兼职");
    }

    private IncomeRecord getIncomeRecord() {
        return new IncomeRecord();
    }

    /*添加支出*/
    @GetMapping("/Spend")
    public String Spend() {
        SpendRecord f = new SpendRecord();
        SpendRecord m = new SpendRecord();
        SpendRecord s = new SpendRecord();
        List<SpendRecord> list = new ArrayList<>();
        /*先添加 固定的 保险和话费*/
//        for (int i = 1; i <= 12; i++) {
//            if (i < 10) {
//                f.setSdate("2020-0" + i + "-01");
//                m.setSdate("2020-0" + i + "-01");
//                s.setSdate("2020-0" + i + "-01");
//            } else {
//                f.setSdate("2020-" + i + "-01");
//                m.setSdate("2020-" + i + "-01");
//                s.setSdate("2020-" + i + "-01");
//            }
////            /*养老保险*/
////            SetB(f, m);
//            /*话费*/
//            SetH(f, m, s);
//            list.add(f);
//            list.add(m);
//            list.add(s);
//            f = getSpendRecord();
//            m = getSpendRecord();
//            s = getSpendRecord();
//        }

        for (int i = 1; i <= 12; i = i++) {
            if (i < 10) {
                f.setSdate("2020-01-0" + i);
                s.setSdate("2020-01-0" + i);
            } else {
                f.setSdate("2020-01-" + i);
                s.setSdate("2020-01-" + i);
            }
            SetS(f, s);
            list.add(f);
            list.add(s);
            f = getSpendRecord();
            s = getSpendRecord();
        }

//        addRecordServiceImp.AddSpend(list);
        return "1";
    }

    /*保险*/
    private void SetB(SpendRecord f, SpendRecord m) {
        f.setFk_familyid("Family1").setMoney(1500).setSpend("保险").setMoneynote("养老保险");
        m.setFk_familyid("Family2").setMoney(800).setSpend("保险").setMoneynote("养老保险");
    }

    /*话费*/
    private void SetH(SpendRecord f, SpendRecord m, SpendRecord s) {
        f.setFk_familyid("Family1").setMoney(100).setSpend("话费").setMoneynote("每个月的手机话费");
        m.setFk_familyid("Family2").setMoney(50).setSpend("话费").setMoneynote("每个月的手机话费");
        s.setFk_familyid("Family3").setMoney(50).setSpend("话费").setMoneynote("每个月的手机话费");
    }

    /*工作时候在外吃饭*/
    private void SetS(SpendRecord f, SpendRecord s) {
        f.setFk_familyid("Family1").setMoney(20).setSpend("食品").setMoneynote("上班时候中午在外就餐");
        s.setFk_familyid("Family3").setMoney(25).setSpend("食品").setMoneynote("上班时候中午在外就餐");
    }

    private void SetC(SpendRecord m, SpendRecord m2) {
        m.setFk_familyid("Family2").setMoney(20).setSpend("日用品").setMoneynote("纸巾");
        m2.setFk_familyid("Family2").setMoney(40).setSpend("日用品").setMoneynote("洗衣液");

    }

    private void SetT(SpendRecord f) {
        f.setFk_familyid("Family2").setMoney(15).setSpend("食品").setMoneynote("酱油,醋");
//        s.setFk_familyid("Family3").setMoney(25).setSpend("食品").setMoneynote("上班时候中午在外就餐");
    }

    /*水电气油*/
//    private void SetQ(SpendRecord m, SpendRecord m2, double j) {
//        m.setFk_familyid("Family1").setMoney(12 * j).setSpend("娱乐").setMoneynote("父亲和母亲一起看电影");
//        m2.setFk_familyid("Family3").setMoney(20 * j).setSpend("娱乐").setMoneynote("今天和朋友一起去唱歌,吃夜宵了");
//    }

    /*半年买一次*/
    private void SetY(SpendRecord m, SpendRecord m2, SpendRecord m3) {
        m.setFk_familyid("Family1").setMoney(340).setSpend("购物").setMoneynote("今天买了一件羽绒服");
        m2.setFk_familyid("Family2").setMoney(250).setSpend("购物").setMoneynote("今天买了一双靴子");
        m3.setFk_familyid("Family3").setMoney(250).setSpend("购物").setMoneynote("今天买了一双鞋子");
    }

    private SpendRecord getSpendRecord() {
        return new SpendRecord();
    }

    /*获取每月的天数*/
    public int getDaysOfMonth(int j) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        calendar.setTime(sdf.parse("2020-0" + j));
        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

    }
}
