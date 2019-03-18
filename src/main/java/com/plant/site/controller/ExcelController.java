package com.plant.site.controller;

import com.plant.site.model.SysUser;
import com.plant.site.model.SysUserExcelModel;
import com.plant.site.service.ISysUserService;
import com.plant.site.util.ExcelUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @description: TODO
 * @author: yumingbin@zto.cn
 * @date: 2019/1/11 12:31
 * @version:1.0
 **/
@Slf4j
@RestController
@RequestMapping("/excel")
public class ExcelController {

    @Autowired
    private ISysUserService sysUserService;

    @RequestMapping(value = "/writeExcel")
    public void writeExcel(HttpServletResponse response) throws IOException {
        List<SysUser> list = sysUserService.selectAll();
        List<SysUserExcelModel> sysUserExcelModels = new ArrayList<>();
        list.forEach(user -> {
            SysUserExcelModel sysUserExcelModel = new SysUserExcelModel();

            BeanUtils.copyProperties(user, sysUserExcelModel);
            sysUserExcelModels.add(sysUserExcelModel);
        });
        String fileName = "单个sheet的 文件";
        String sheetName = "第一个 sheet";
        //单个sheet
        ExcelUtil.writeExcel(response, sysUserExcelModels, fileName, sheetName, new SysUserExcelModel());
    }

    @GetMapping(value = "writeExcelWithSheets")
    public void writeExcelWithSheets(HttpServletResponse response) throws IOException {
        List<SysUser> list = sysUserService.selectAll();
//        List<SysUserExcelModel> sysUserExcelModels = new ArrayList<>();
        List<SysUserExcelModel> sysUserExcelModels = getList();
        Long startTime = System.currentTimeMillis();

        if (!CollectionUtils.isEmpty(sysUserExcelModels)) {
            list.forEach(user -> {
                SysUserExcelModel sysUserExcelModel = new SysUserExcelModel();

                BeanUtils.copyProperties(user, sysUserExcelModel);
                sysUserExcelModels.add(sysUserExcelModel);
            });
        }


        String fileName = "多个sheet的 文件";
        String sheetName1 = "第一个 sheet";
        String sheetName2 = "第二个 sheet";
        String sheetName3 = "第三个 sheet";

        List<String> sheetList = new ArrayList<>();
        sheetList.add(sheetName1);
        sheetList.add(sheetName2);
        sheetList.add(sheetName3);


        ExcelUtil.writeExcelWithSheets(response, sysUserExcelModels, fileName, sheetName1, new SysUserExcelModel())
                .write(sysUserExcelModels, sheetName2, new SysUserExcelModel())
                .write(sysUserExcelModels, sheetName3, new SysUserExcelModel())
                .finish();
        Long endTime = System.currentTimeMillis();
        log.info("导出数据共{}条,用时间{}秒", sysUserExcelModels.size(), (endTime - startTime) / 1000);

    }

    @PostMapping(value = "readExcel")
    public List<SysUserExcelModel> readExcel(@RequestParam("file") MultipartFile excel) {
        Object objects = ExcelUtil.readExcel(excel, new SysUserExcelModel());


        return (List<SysUserExcelModel>) objects;
    }


    private List<SysUserExcelModel> getList() {

        List list = new ArrayList();
        for (int i = 0; i < 1000000; i++) {
            SysUserExcelModel model = new SysUserExcelModel();

            model.setPassword(i + "");
            model.setUserId(i);
            model.setUserName("name" + i);

            list.add(model);
        }
        return list;
    }


}
