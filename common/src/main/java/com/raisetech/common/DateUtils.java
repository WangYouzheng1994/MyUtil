package com.raisetech.common;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;
import java.util.TimeZone;

/**
 * 日期工具类，提供常用的日期处理功能。
 * 基于JDK8新日期API实现，提供高性能的日期处理方法。
 *
 * @author 王有政
 */
public class DateUtils {
    
    /**
     * 默认日期格式：yyyy-MM-dd
     */
    public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";
    
    /**
     * 默认日期时间格式：yyyy-MM-dd HH:mm:ss
     */
    public static final String DEFAULT_DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    
    /**
     * 默认时间格式：HH:mm:ss
     */
    public static final String DEFAULT_TIME_FORMAT = "HH:mm:ss";
    
    /**
     * 默认时区：Asia/Shanghai
     */
    public static final TimeZone DEFAULT_TIME_ZONE = TimeZone.getTimeZone("Asia/Shanghai");
    
    /**
     * 默认日期格式化器：yyyy-MM-dd
     */
    public static final DateTimeFormatter DEFAULT_DATE_FORMATTER = DateTimeFormatter.ofPattern(DEFAULT_DATE_FORMAT);
    
    /**
     * 默认日期时间格式化器：yyyy-MM-dd HH:mm:ss
     */
    public static final DateTimeFormatter DEFAULT_DATETIME_FORMATTER = DateTimeFormatter.ofPattern(DEFAULT_DATETIME_FORMAT);
    
    /**
     * 默认时间格式化器：HH:mm:ss
     */
    public static final DateTimeFormatter DEFAULT_TIME_FORMATTER = DateTimeFormatter.ofPattern(DEFAULT_TIME_FORMAT);
    
    /**
     * 私有构造方法，防止实例化
     */
    private DateUtils() {
        // 私有构造方法，防止实例化
    }
    
    /**
     * 获取当前日期，格式为yyyy-MM-dd
     *
     * @return 当前日期字符串
     */
    public static String getCurrentDate() {
        return LocalDate.now().format(DEFAULT_DATE_FORMATTER);
    }
    
    /**
     * 获取当前日期时间，格式为yyyy-MM-dd HH:mm:ss
     *
     * @return 当前日期时间字符串
     */
    public static String getCurrentDateTime() {
        return LocalDateTime.now().format(DEFAULT_DATETIME_FORMATTER);
    }
    
    /**
     * 获取当前时间，格式为HH:mm:ss
     *
     * @return 当前时间字符串
     */
    public static String getCurrentTime() {
        return LocalTime.now().format(DEFAULT_TIME_FORMATTER);
    }
    
    /**
     * 将LocalDate格式化为字符串
     *
     * @param date   日期对象
     * @param format 日期格式
     * @return 格式化后的日期字符串
     */
    public static String format(LocalDate date, String format) {
        if (date == null) {
            return null;
        }
        
        if (format == null || format.isEmpty()) {
            return date.format(DEFAULT_DATE_FORMATTER);
        }
        
        return date.format(DateTimeFormatter.ofPattern(format));
    }
    
    /**
     * 将LocalDate格式化为字符串，使用默认格式yyyy-MM-dd
     *
     * @param date 日期对象
     * @return 格式化后的日期字符串
     */
    public static String format(LocalDate date) {
        return format(date, DEFAULT_DATE_FORMAT);
    }
    
    /**
     * 将LocalDateTime格式化为字符串
     *
     * @param dateTime 日期时间对象
     * @param format   日期时间格式
     * @return 格式化后的日期时间字符串
     */
    public static String format(LocalDateTime dateTime, String format) {
        if (dateTime == null) {
            return null;
        }
        
        if (format == null || format.isEmpty()) {
            return dateTime.format(DEFAULT_DATETIME_FORMATTER);
        }
        
        return dateTime.format(DateTimeFormatter.ofPattern(format));
    }
    
    /**
     * 将LocalDateTime格式化为字符串，使用默认格式yyyy-MM-dd HH:mm:ss
     *
     * @param dateTime 日期时间对象
     * @return 格式化后的日期时间字符串
     */
    public static String format(LocalDateTime dateTime) {
        return format(dateTime, DEFAULT_DATETIME_FORMAT);
    }
    
    /**
     * 将LocalTime格式化为字符串
     *
     * @param time   时间对象
     * @param format 时间格式
     * @return 格式化后的时间字符串
     */
    public static String format(LocalTime time, String format) {
        if (time == null) {
            return null;
        }
        
        if (format == null || format.isEmpty()) {
            return time.format(DEFAULT_TIME_FORMATTER);
        }
        
        return time.format(DateTimeFormatter.ofPattern(format));
    }
    
    /**
     * 将LocalTime格式化为字符串，使用默认格式HH:mm:ss
     *
     * @param time 时间对象
     * @return 格式化后的时间字符串
     */
    public static String format(LocalTime time) {
        return format(time, DEFAULT_TIME_FORMAT);
    }
    
    /**
     * 将Date格式化为字符串
     *
     * @param date   日期对象
     * @param format 日期格式
     * @return 格式化后的日期字符串
     */
    public static String format(Date date, String format) {
        if (date == null) {
            return null;
        }
        
        LocalDateTime dateTime = toLocalDateTime(date);
        return format(dateTime, format);
    }
    
    /**
     * 将Date格式化为字符串，使用默认格式yyyy-MM-dd HH:mm:ss
     *
     * @param date 日期对象
     * @return 格式化后的日期字符串
     */
    public static String format(Date date) {
        return format(date, DEFAULT_DATETIME_FORMAT);
    }
    
    /**
     * 将字符串解析为LocalDate
     *
     * @param dateStr 日期字符串
     * @param format  日期格式
     * @return LocalDate对象
     */
    public static LocalDate parseLocalDate(String dateStr, String format) {
        if (dateStr == null || dateStr.isEmpty()) {
            return null;
        }
        
        if (format == null || format.isEmpty()) {
            return LocalDate.parse(dateStr, DEFAULT_DATE_FORMATTER);
        }
        
        return LocalDate.parse(dateStr, DateTimeFormatter.ofPattern(format));
    }
    
    /**
     * 将字符串解析为LocalDate，使用默认格式yyyy-MM-dd
     *
     * @param dateStr 日期字符串
     * @return LocalDate对象
     */
    public static LocalDate parseLocalDate(String dateStr) {
        return parseLocalDate(dateStr, DEFAULT_DATE_FORMAT);
    }
    
    /**
     * 将字符串解析为LocalDateTime
     *
     * @param dateTimeStr 日期时间字符串
     * @param format      日期时间格式
     * @return LocalDateTime对象
     */
    public static LocalDateTime parseLocalDateTime(String dateTimeStr, String format) {
        if (dateTimeStr == null || dateTimeStr.isEmpty()) {
            return null;
        }
        
        if (format == null || format.isEmpty()) {
            return LocalDateTime.parse(dateTimeStr, DEFAULT_DATETIME_FORMATTER);
        }
        
        return LocalDateTime.parse(dateTimeStr, DateTimeFormatter.ofPattern(format));
    }
    
    /**
     * 将字符串解析为LocalDateTime，使用默认格式yyyy-MM-dd HH:mm:ss
     *
     * @param dateTimeStr 日期时间字符串
     * @return LocalDateTime对象
     */
    public static LocalDateTime parseLocalDateTime(String dateTimeStr) {
        return parseLocalDateTime(dateTimeStr, DEFAULT_DATETIME_FORMAT);
    }
    
    /**
     * 将字符串解析为LocalTime
     *
     * @param timeStr 时间字符串
     * @param format  时间格式
     * @return LocalTime对象
     */
    public static LocalTime parseLocalTime(String timeStr, String format) {
        if (timeStr == null || timeStr.isEmpty()) {
            return null;
        }
        
        if (format == null || format.isEmpty()) {
            return LocalTime.parse(timeStr, DEFAULT_TIME_FORMATTER);
        }
        
        return LocalTime.parse(timeStr, DateTimeFormatter.ofPattern(format));
    }
    
    /**
     * 将字符串解析为LocalTime，使用默认格式HH:mm:ss
     *
     * @param timeStr 时间字符串
     * @return LocalTime对象
     */
    public static LocalTime parseLocalTime(String timeStr) {
        return parseLocalTime(timeStr, DEFAULT_TIME_FORMAT);
    }
    
    /**
     * 将字符串解析为Date
     *
     * @param dateStr 日期字符串
     * @param format  日期格式
     * @return Date对象
     */
    public static Date parseDate(String dateStr, String format) {
        if (dateStr == null || dateStr.isEmpty()) {
            return null;
        }
        
        LocalDateTime dateTime;
        if (format == null || format.isEmpty()) {
            if (dateStr.length() == DEFAULT_DATE_FORMAT.length()) {
                LocalDate date = LocalDate.parse(dateStr, DEFAULT_DATE_FORMATTER);
                dateTime = date.atStartOfDay();
            } else {
                dateTime = LocalDateTime.parse(dateStr, DEFAULT_DATETIME_FORMATTER);
            }
        } else {
            if (format.equals(DEFAULT_DATE_FORMAT)) {
                LocalDate date = LocalDate.parse(dateStr, DateTimeFormatter.ofPattern(format));
                dateTime = date.atStartOfDay();
            } else {
                dateTime = LocalDateTime.parse(dateStr, DateTimeFormatter.ofPattern(format));
            }
        }
        
        return toDate(dateTime);
    }
    
    /**
     * 将字符串解析为Date，使用默认格式yyyy-MM-dd HH:mm:ss
     *
     * @param dateStr 日期字符串
     * @return Date对象
     */
    public static Date parseDate(String dateStr) {
        return parseDate(dateStr, DEFAULT_DATETIME_FORMAT);
    }
    
    /**
     * 比较两个LocalDate的大小
     *
     * @param date1 第一个日期
     * @param date2 第二个日期
     * @return 如果date1在date2之前，返回-1；如果相等，返回0；如果date1在date2之后，返回1
     */
    public static int compare(LocalDate date1, LocalDate date2) {
        if (date1 == null || date2 == null) {
            throw new IllegalArgumentException("日期不能为空");
        }
        
        return date1.compareTo(date2);
    }
    
    /**
     * 比较两个LocalDateTime的大小
     *
     * @param dateTime1 第一个日期时间
     * @param dateTime2 第二个日期时间
     * @return 如果dateTime1在dateTime2之前，返回-1；如果相等，返回0；如果dateTime1在dateTime2之后，返回1
     */
    public static int compare(LocalDateTime dateTime1, LocalDateTime dateTime2) {
        if (dateTime1 == null || dateTime2 == null) {
            throw new IllegalArgumentException("日期时间不能为空");
        }
        
        return dateTime1.compareTo(dateTime2);
    }
    
    /**
     * 比较两个Date的大小
     *
     * @param date1 第一个日期
     * @param date2 第二个日期
     * @return 如果date1在date2之前，返回-1；如果相等，返回0；如果date1在date2之后，返回1
     */
    public static int compare(Date date1, Date date2) {
        if (date1 == null || date2 == null) {
            throw new IllegalArgumentException("日期不能为空");
        }
        
        return date1.compareTo(date2);
    }
    
    /**
     * 判断date1是否在date2之前
     *
     * @param date1 第一个日期
     * @param date2 第二个日期
     * @return 如果date1在date2之前，返回true；否则返回false
     */
    public static boolean isBefore(LocalDate date1, LocalDate date2) {
        if (date1 == null || date2 == null) {
            return false;
        }
        
        return date1.isBefore(date2);
    }
    
    /**
     * 判断date1是否在date2之后
     *
     * @param date1 第一个日期
     * @param date2 第二个日期
     * @return 如果date1在date2之后，返回true；否则返回false
     */
    public static boolean isAfter(LocalDate date1, LocalDate date2) {
        if (date1 == null || date2 == null) {
            return false;
        }
        
        return date1.isAfter(date2);
    }
    
    /**
     * 判断两个日期是否相等
     *
     * @param date1 第一个日期
     * @param date2 第二个日期
     * @return 如果两个日期相等，返回true；否则返回false
     */
    public static boolean isEqual(LocalDate date1, LocalDate date2) {
        if (date1 == null || date2 == null) {
            return false;
        }
        
        return date1.isEqual(date2);
    }
    
    /**
     * 为LocalDate添加指定的年数
     *
     * @param date  原始日期
     * @param years 要添加的年数
     * @return 添加后的日期
     */
    public static LocalDate plusYears(LocalDate date, long years) {
        if (date == null) {
            return null;
        }
        
        return date.plusYears(years);
    }
    
    /**
     * 为LocalDate添加指定的月数
     *
     * @param date   原始日期
     * @param months 要添加的月数
     * @return 添加后的日期
     */
    public static LocalDate plusMonths(LocalDate date, long months) {
        if (date == null) {
            return null;
        }
        
        return date.plusMonths(months);
    }
    
    /**
     * 为LocalDate添加指定的天数
     *
     * @param date 原始日期
     * @param days 要添加的天数
     * @return 添加后的日期
     */
    public static LocalDate plusDays(LocalDate date, long days) {
        if (date == null) {
            return null;
        }
        
        return date.plusDays(days);
    }
    
    /**
     * 为LocalDateTime添加指定的年数
     *
     * @param dateTime 原始日期时间
     * @param years    要添加的年数
     * @return 添加后的日期时间
     */
    public static LocalDateTime plusYears(LocalDateTime dateTime, long years) {
        if (dateTime == null) {
            return null;
        }
        
        return dateTime.plusYears(years);
    }
    
    /**
     * 为LocalDateTime添加指定的月数
     *
     * @param dateTime 原始日期时间
     * @param months   要添加的月数
     * @return 添加后的日期时间
     */
    public static LocalDateTime plusMonths(LocalDateTime dateTime, long months) {
        if (dateTime == null) {
            return null;
        }
        
        return dateTime.plusMonths(months);
    }
    
    /**
     * 为LocalDateTime添加指定的天数
     *
     * @param dateTime 原始日期时间
     * @param days     要添加的天数
     * @return 添加后的日期时间
     */
    public static LocalDateTime plusDays(LocalDateTime dateTime, long days) {
        if (dateTime == null) {
            return null;
        }
        
        return dateTime.plusDays(days);
    }
    
    /**
     * 为LocalDateTime添加指定的小时数
     *
     * @param dateTime 原始日期时间
     * @param hours    要添加的小时数
     * @return 添加后的日期时间
     */
    public static LocalDateTime plusHours(LocalDateTime dateTime, long hours) {
        if (dateTime == null) {
            return null;
        }
        
        return dateTime.plusHours(hours);
    }
    
    /**
     * 为LocalDateTime添加指定的分钟数
     *
     * @param dateTime 原始日期时间
     * @param minutes  要添加的分钟数
     * @return 添加后的日期时间
     */
    public static LocalDateTime plusMinutes(LocalDateTime dateTime, long minutes) {
        if (dateTime == null) {
            return null;
        }
        
        return dateTime.plusMinutes(minutes);
    }
    
    /**
     * 为LocalDateTime添加指定的秒数
     *
     * @param dateTime 原始日期时间
     * @param seconds  要添加的秒数
     * @return 添加后的日期时间
     */
    public static LocalDateTime plusSeconds(LocalDateTime dateTime, long seconds) {
        if (dateTime == null) {
            return null;
        }
        
        return dateTime.plusSeconds(seconds);
    }
    
    /**
     * 从LocalDate减去指定的年数
     *
     * @param date  原始日期
     * @param years 要减去的年数
     * @return 减去后的日期
     */
    public static LocalDate minusYears(LocalDate date, long years) {
        if (date == null) {
            return null;
        }
        
        return date.minusYears(years);
    }
    
    /**
     * 从LocalDate减去指定的月数
     *
     * @param date   原始日期
     * @param months 要减去的月数
     * @return 减去后的日期
     */
    public static LocalDate minusMonths(LocalDate date, long months) {
        if (date == null) {
            return null;
        }
        
        return date.minusMonths(months);
    }
    
    /**
     * 从LocalDate减去指定的天数
     *
     * @param date 原始日期
     * @param days 要减去的天数
     * @return 减去后的日期
     */
    public static LocalDate minusDays(LocalDate date, long days) {
        if (date == null) {
            return null;
        }
        
        return date.minusDays(days);
    }
    
    /**
     * 将Date转换为LocalDate
     *
     * @param date Date对象
     * @return LocalDate对象
     */
    public static LocalDate toLocalDate(Date date) {
        if (date == null) {
            return null;
        }
        
        Instant instant = date.toInstant();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        return localDateTime.toLocalDate();
    }
    
    /**
     * 将Date转换为LocalDateTime
     *
     * @param date Date对象
     * @return LocalDateTime对象
     */
    public static LocalDateTime toLocalDateTime(Date date) {
        if (date == null) {
            return null;
        }
        
        Instant instant = date.toInstant();
        return LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
    }
    
    /**
     * 将LocalDate转换为Date
     *
     * @param date LocalDate对象
     * @return Date对象
     */
    public static Date toDate(LocalDate date) {
        if (date == null) {
            return null;
        }
        
        LocalDateTime dateTime = date.atStartOfDay();
        return toDate(dateTime);
    }
    
    /**
     * 将LocalDateTime转换为Date
     *
     * @param dateTime LocalDateTime对象
     * @return Date对象
     */
    public static Date toDate(LocalDateTime dateTime) {
        if (dateTime == null) {
            return null;
        }
        
        Instant instant = dateTime.atZone(ZoneId.systemDefault()).toInstant();
        return Date.from(instant);
    }
    
    /**
     * 计算两个LocalDate之间的天数差
     *
     * @param startDate 开始日期
     * @param endDate   结束日期
     * @return 天数差
     */
    public static long daysBetween(LocalDate startDate, LocalDate endDate) {
        if (startDate == null || endDate == null) {
            return 0;
        }
        
        return ChronoUnit.DAYS.between(startDate, endDate);
    }
    
    /**
     * 计算两个LocalDateTime之间的天数差
     *
     * @param startDateTime 开始日期时间
     * @param endDateTime   结束日期时间
     * @return 天数差
     */
    public static long daysBetween(LocalDateTime startDateTime, LocalDateTime endDateTime) {
        if (startDateTime == null || endDateTime == null) {
            return 0;
        }
        
        return ChronoUnit.DAYS.between(startDateTime, endDateTime);
    }
    
    /**
     * 计算两个Date之间的天数差
     *
     * @param startDate 开始日期
     * @param endDate   结束日期
     * @return 天数差
     */
    public static long daysBetween(Date startDate, Date endDate) {
        if (startDate == null || endDate == null) {
            return 0;
        }
        
        LocalDate startLocalDate = toLocalDate(startDate);
        LocalDate endLocalDate = toLocalDate(endDate);
        return daysBetween(startLocalDate, endLocalDate);
    }
    
    /**
     * 计算两个LocalDateTime之间的小时差
     *
     * @param startDateTime 开始日期时间
     * @param endDateTime   结束日期时间
     * @return 小时差
     */
    public static long hoursBetween(LocalDateTime startDateTime, LocalDateTime endDateTime) {
        if (startDateTime == null || endDateTime == null) {
            return 0;
        }
        
        return ChronoUnit.HOURS.between(startDateTime, endDateTime);
    }
    
    /**
     * 计算两个LocalDateTime之间的分钟差
     *
     * @param startDateTime 开始日期时间
     * @param endDateTime   结束日期时间
     * @return 分钟差
     */
    public static long minutesBetween(LocalDateTime startDateTime, LocalDateTime endDateTime) {
        if (startDateTime == null || endDateTime == null) {
            return 0;
        }
        
        return ChronoUnit.MINUTES.between(startDateTime, endDateTime);
    }
    
    /**
     * 计算两个LocalDateTime之间的秒差
     *
     * @param startDateTime 开始日期时间
     * @param endDateTime   结束日期时间
     * @return 秒差
     */
    public static long secondsBetween(LocalDateTime startDateTime, LocalDateTime endDateTime) {
        if (startDateTime == null || endDateTime == null) {
            return 0;
        }
        
        return ChronoUnit.SECONDS.between(startDateTime, endDateTime);
    }
    
    /**
     * 获取指定日期所在月份的第一天
     *
     * @param date 日期
     * @return 该月第一天
     */
    public static LocalDate firstDayOfMonth(LocalDate date) {
        if (date == null) {
            return null;
        }
        
        return date.with(TemporalAdjusters.firstDayOfMonth());
    }
    
    /**
     * 获取指定日期所在月份的最后一天
     *
     * @param date 日期
     * @return 该月最后一天
     */
    public static LocalDate lastDayOfMonth(LocalDate date) {
        if (date == null) {
            return null;
        }
        
        return date.with(TemporalAdjusters.lastDayOfMonth());
    }
    
    /**
     * 获取指定日期所在周的第一天（周一）
     *
     * @param date 日期
     * @return 该周第一天
     */
    public static LocalDate firstDayOfWeek(LocalDate date) {
        if (date == null) {
            return null;
        }
        
        return date.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
    }
    
    /**
     * 获取指定日期所在周的最后一天（周日）
     *
     * @param date 日期
     * @return 该周最后一天
     */
    public static LocalDate lastDayOfWeek(LocalDate date) {
        if (date == null) {
            return null;
        }
        
        return date.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));
    }
    
    /**
     * 判断指定日期是否是周末
     *
     * @param date 日期
     * @return 如果是周末，返回true；否则返回false
     */
    public static boolean isWeekend(LocalDate date) {
        if (date == null) {
            return false;
        }
        
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        if (dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY) {
            return true;
        }
        
        return false;
    }
    
    /**
     * 判断指定日期是否是工作日
     *
     * @param date 日期
     * @return 如果是工作日，返回true；否则返回false
     */
    public static boolean isWeekday(LocalDate date) {
        if (date == null) {
            return false;
        }
        
        return !isWeekend(date);
    }
    
    /**
     * 获取指定日期的星期几
     *
     * @param date 日期
     * @return 星期几（1-7，1表示周一，7表示周日）
     */
    public static int getDayOfWeek(LocalDate date) {
        if (date == null) {
            return 0;
        }
        
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        int day = dayOfWeek.getValue();
        if (day == 7) {
            return 7;
        }
        
        return day;
    }
    
    /**
     * 获取指定日期所在月份的天数
     *
     * @param date 日期
     * @return 该月天数
     */
    public static int getDaysInMonth(LocalDate date) {
        if (date == null) {
            return 0;
        }
        
        return date.lengthOfMonth();
    }
    
    /**
     * 判断指定年份是否是闰年
     *
     * @param year 年份
     * @return 如果是闰年，返回true；否则返回false
     */
    public static boolean isLeapYear(int year) {
        LocalDate date = LocalDate.of(year, 1, 1);
        return date.isLeapYear();
    }
    
    /**
     * 判断指定日期所在年份是否是闰年
     *
     * @param date 日期
     * @return 如果是闰年，返回true；否则返回false
     */
    public static boolean isLeapYear(LocalDate date) {
        if (date == null) {
            return false;
        }
        
        return date.isLeapYear();
    }
}