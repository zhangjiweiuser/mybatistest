package com.zhang.mybatis.util;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

/**
 * @ClassName StartEndDate
 * @Author zhangjiwei
 * @Date 2019/8/26 14:09
 * @Description
 */
public class StartEndDate {
    public static void main(String[] args) {
        LocalDate startDate = LocalDate.of(2019, 12, 20);
        LocalDate startDate1 = LocalDate.of(2019, 12, 29);
        LocalDate endDate = LocalDate.of(2020, 6, 15);
/*        System.out.println(startDate.getDayOfWeek().getValue());
        System.out.println(startDate.getDayOfMonth());
        System.out.println(startDate.getMonthValue());
        System.out.println(startDate.getDayOfYear());*/
        LocalDate fistDay = LocalDate.of(2019, 1, 1);
        System.out.println(fistDay.getDayOfWeek().getValue());
        int num = 1;
        LocalDate firstWeekStart = fistDay.minusDays(2);
        System.out.println(firstWeekStart.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        LocalDate firstWeekEnd = firstWeekStart.plusDays(6);
        List<Map<String, Object>> list = Lists.newArrayList();
        Map<String, Object> map = Maps.newHashMap();
        map.put("year", firstWeekEnd.getYear());
        map.put("week", num);
        map.put("start", firstWeekStart);
        map.put("end", firstWeekEnd);
        list.add(map);
        while (firstWeekEnd.isBefore(LocalDate.of(2020, 1, 1).minusDays(1))) {
            map = Maps.newHashMap();
            firstWeekStart = firstWeekEnd.plusDays(1);
            firstWeekEnd = firstWeekStart.plusDays(6);
            map.put("year", firstWeekStart.getYear());
            map.put("week", ++num);
            map.put("start", firstWeekStart);
            map.put("end", firstWeekEnd);
            list.add(map);
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        for (Map<String, Object> m : list) {
            System.out.println(m.get("year") + "==" + m.get("week") + "==" + ((LocalDate) m.get("start")).format(formatter) + "===" + ((LocalDate) m.get("end")).format(formatter))
            ;
        }
    }
}
