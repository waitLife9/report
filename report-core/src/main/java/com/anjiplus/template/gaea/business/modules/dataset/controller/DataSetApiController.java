package com.anjiplus.template.gaea.business.modules.dataset.controller;

import com.anji.plus.gaea.bean.ResponseBean;
import com.anjiplus.template.gaea.business.modules.dashboard.controller.dto.ChartDto;
import com.anjiplus.template.gaea.business.modules.dataset.controller.dto.DataSetDto;
import com.anjiplus.template.gaea.business.modules.dataset.controller.dto.OriginalDataDto;
import com.anjiplus.template.gaea.business.modules.dataset.service.DataSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

/**
 * @author WongBin
 * @date 2023/7/20
 */
@RestController
@RequestMapping(value = "/dws")
public class DataSetApiController {
    @Autowired
    private DataSetService dataSetService;

    @Value("${report.stat.days.limit:31}")
    private int daysLimit;

    @PostMapping("/getData")
    //@Permission(code = "view", name = "查看大屏")
    public ResponseBean getData(@RequestBody ChartDto dto) {
        if(Objects.nonNull(dto.getContextData()) && Objects.nonNull(dto.getContextData().get("startTime"))
                && Objects.nonNull(dto.getContextData().get("endTime"))) {
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyyMMdd-HH");
            LocalDate date1 = LocalDate.parse(dto.getContextData().get("startTime") + "", fmt);
            LocalDate date2 = LocalDate.parse(dto.getContextData().get("endTime") + "", fmt);
            long s = ChronoUnit.DAYS.between(date1, date2);
            if (s > daysLimit) {
                return ResponseBean.builder().message("时间范围输入无效").build();
            }
        }
        DataSetDto setDto = new DataSetDto();
        setDto.setSetCode(dto.getSetCode());
        setDto.setContextData(dto.getContextData());
        OriginalDataDto result = this.dataSetService.getData(setDto);
        return ResponseBean.builder().data(result).build();
    }

}
