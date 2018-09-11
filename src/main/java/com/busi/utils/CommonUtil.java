package com.busi.utils;

import com.ttf.common.exception.BusinessException;
import org.apache.commons.lang.StringUtils;

import java.math.BigDecimal;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 通用工具
 * @author xxf
 */
public class CommonUtil {
    /**
     * String 转int
     * @param param   转换参数
     * @param message 参数名称（抛异常使用）
     * @return
     */
    public static int toInt(String param,String message){
        try {
            param=new BigDecimal(param).toPlainString();
            return Integer.parseInt(param);
        } catch (NumberFormatException e) {
//            DebugLogger.debug("请输入正确的"+message+":"+param);
            throw new BusinessException("请输入正确的"+message);
        } catch (NullPointerException e) {
            throw new BusinessException("缺少"+message);
        } catch (Exception e){
//            DebugLogger.debug("请输入正确的"+message+":"+param);
            throw new BusinessException("请输入正确的"+message);
        }
    }
    /**
     * 检测是否是数字
     * @param str 数字字符串
     * @return
     */
    public static boolean isNumeric(String str) {
        // 该正则表达式可以匹配所有的数字 包括负数
        Pattern pattern = Pattern.compile("-?[0-9]+\\.?[0-9]*");
        String bigStr;
        try {
            bigStr = new BigDecimal(str).toString();
        } catch (Exception e) {
            return false;//异常 说明包含非数字。
        }
        Matcher isNum = pattern.matcher(bigStr); // matcher是全匹配
        if (!isNum.matches()) {
            return false;
        }
        return true;
    }

    /**
     * 页数计算
     * @param allCount
     * @param pageSize
     * @return
     */
    public static String getAllPage(int allCount,int pageSize){
        int pageCount = allCount/pageSize;
        if(allCount%pageSize>0){
            pageCount++;
        }
        return String.valueOf(pageCount);
    }
    /**
     * 两个时间之间相差距离多少分钟
     * @param one 时间参数 1：
     * @param two 时间参数 2：
     * @return 相差天数
     */
    public static long getDistanceHours(Date one, Date two) {
        long days=0;
        try {
            long time1 = one.getTime();
            long time2 = two.getTime();
            long diff ;
            if(time1<time2) {
                diff = time2 - time1;
            } else {
                diff = time1 - time2;
            }
            days = diff / (1000 * 60);
        } catch (Exception e) {
            return 0;
        }
        return days;
    }

    /**
     * 检测不为空但不是数字
     * @param str
     * @return
     */
    public static Boolean isNotEmptyButNotNumeric(String str){
        if(StringUtils.isNotEmpty(str) && !isNumeric(str)){
            return true;
        }
        return false;
    }
    /**
     * 检测不为空但不是纯数字
     * @param str
     * @return
     */
    public static Boolean isNotEmptyButNotInt(String str){
        if(StringUtils.isNotEmpty(str) && !StringUtils.isNumeric(str)){
            return true;
        }
        return false;
    }
    /**
     * 获取start_no
     * @param
     * @return
     */
    public static Integer getStartNo(String page_no,String page_size){
        int no = CommonUtil.toInt(page_no,"页码");
        int size=CommonUtil.toInt(page_size,"分页大小");
        if(no<=0){
//            DebugLogger.debug("请输入正确的页码数"+page_no);
            throw new BusinessException("请输入正确的页码数");
        }
        if(size<=0){
//            DebugLogger.debug("请输入正确的页长"+page_size);
            throw new BusinessException("请输入正确的页长");
        }
        return (no-1)*(size);
    }

//
//    private static Map<Class, MethodAccess> methodMap = new HashMap<Class, MethodAccess>();
//    private static Map<String, Integer> methodIndexMap = new HashMap<String, Integer>();
//    private static Map<Class, List<String>> fieldMap = new HashMap<Class, List<String>>();
//    /**
//     *
//     * @param desc 转换后的类
//     * @param orgi 要装换的类
//     */
//    public static void copyProperties(Object desc, Object orgi) {
//        MethodAccess descMethodAccess = methodMap.get(desc.getClass());
//        if (descMethodAccess == null) {
//            descMethodAccess = cache(desc);
//        }
//        MethodAccess orgiMethodAccess = methodMap.get(orgi.getClass());
//        if (orgiMethodAccess == null) {
//            orgiMethodAccess = cache(orgi);
//        }
//
//        List<String> fieldList = fieldMap.get(orgi.getClass());
//        for (String field : fieldList) {
//            String getKey = orgi.getClass().getName() + "." + "get" + field;
//            String setkey = desc.getClass().getName() + "." + "set" + field;
//            Integer setIndex = methodIndexMap.get(setkey);
//            if (setIndex != null) {
//                int getIndex = methodIndexMap.get(getKey);
//                // 参数一需要反射的对象
//                // 参数二class.getDeclaredMethods 对应方法的index
//                // 参数对三象集合
//                descMethodAccess.invoke(desc, setIndex.intValue(),
//                        orgiMethodAccess.invoke(orgi, getIndex));
//            }
//        }
//    }
//    // 单例模式
//    private static MethodAccess cache(Object orgi) {
//        synchronized (orgi.getClass()) {
//            MethodAccess methodAccess = MethodAccess.get(orgi.getClass());
//            Field[] fields = orgi.getClass().getDeclaredFields();
//            List<String> fieldList = new ArrayList<String>(fields.length);
//            for (Field field : fields) {
//                if (Modifier.isPrivate(field.getModifiers())
//                        && !Modifier.isStatic(field.getModifiers())) { // 是否是私有的，是否是静态的
//                    // 非公共私有变量
//                    String fieldName = StringUtils.capitalize(field.getName()); // 获取属性名称
//                    int getIndex = methodAccess.getIndex("get" + fieldName); // 获取get方法的下标
//                    int setIndex = methodAccess.getIndex("set" + fieldName); // 获取set方法的下标
//                    methodIndexMap.put(orgi.getClass().getName() + "." + "get"
//                            + fieldName, getIndex); // 将类名get方法名，方法下标注册到map中
//                    methodIndexMap.put(orgi.getClass().getName() + "." + "set"
//                            + fieldName, setIndex); // 将类名set方法名，方法下标注册到map中
//                    fieldList.add(fieldName); // 将属性名称放入集合里
//                }
//            }
//            fieldMap.put(orgi.getClass(), fieldList); // 将类名，属性名称注册到map中
//            methodMap.put(orgi.getClass(), methodAccess);
//            return methodAccess;
//        }
//    }

    //
    private static double EARTH_RADIUS = 6378.137;
    private static double rad(double d) {
        return d * Math.PI / 180.0;
    }
    /**
     * 通过经纬度获取距离(单位：米)
     * @param lat1
     * @param lng1
     * @param lat2
     * @param lng2
     * @return
     */
    public static double getDistance(double lat1, double lng1, double lat2,
                                     double lng2) {
        double radLat1 = rad(lat1);
        double radLat2 = rad(lat2);
        double a = radLat1 - radLat2;
        double b = rad(lng1) - rad(lng2);
        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2)
                + Math.cos(radLat1) * Math.cos(radLat2)
                * Math.pow(Math.sin(b / 2), 2)));
        s = s * EARTH_RADIUS;
        s = Math.round(s * 10000d) / 10000d;
        s = s*1000;
        return s;
    }



    public static String getDebugMsg(String name,String params){
        String a="@RequestParam(required = false)String";
        String[] split = params.split(",");
        StringBuffer str=new StringBuffer("\""+name);
        for (String s : split) {

            String r = s.trim().replace(a, "").trim();
            String param="\","+r+"=\"+"+r;
            if(str.toString().endsWith(name)){
                str.append(",参数为："+param.substring(2));
            }else{
                str.append("+"+param);
            }
        }

        return str.toString();
    }
    public static void main(String[] args) {
        String str = getDebugMsg("调用我的比赛列表接口",
                "@RequestParam(required = false)String user_id,\n" +
                        "            @RequestParam(required = false)String page_no,\n" +
                        "            @RequestParam(required = false)String page_size");
        System.out.println(str);
//
//        String sign = getSign("operation_type=save_clan_match_order&version_id=1.0&user_id=170922051&token=45a2e292-e9a3-4cf1-9428-5c0c8411eef6&order_id=170916183220&team_type=1");
//        System.out.println(sign);
    }


}
