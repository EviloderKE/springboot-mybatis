package com.springbootmybatis.Excel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSON;
import com.springbootmybatis.qo.UserExcel;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
public class UserExcelListener extends AnalysisEventListener<UserExcel> {

    /**
     * 批处理阈值
     */
    private static final int BATCH_COUNT = 2;

    List<UserExcel> list = new ArrayList<>(BATCH_COUNT);

    @Override
    public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
        log.info("解析到一条头数据:{}", JSON.toJSONString(headMap));
    }

    @Override
    public void invoke(UserExcel userExcel, AnalysisContext analysisContext) {
        log.info("解析到一条数据:{}", JSON.toJSONString(userExcel));
        list.add(userExcel);
        if (list.size() >= BATCH_COUNT) {
            saveData();
            list.clear();
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        saveData();
        log.info("所有数据解析完成！");
    }

    private void saveData(){
        log.info("{}条数据，开始存储数据库！", list.size());
        log.info("存储数据库成功！");
    }
}
