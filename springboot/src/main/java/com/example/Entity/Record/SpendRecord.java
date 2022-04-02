package com.example.Entity.Record;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Repository;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Repository
@Accessors(chain = true)
public class SpendRecord {
    private String id;
    private String sdate;
    private Integer money;
    private String spend;
    private String moneynote;
    private String fk_familyid;
}
