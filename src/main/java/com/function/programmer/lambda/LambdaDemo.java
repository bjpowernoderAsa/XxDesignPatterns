package com.function.programmer.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 文件说明：
 *
 * @author XuBin
 * @createDT 2021/12/2 15:16
 */
public class LambdaDemo {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("Java","PHP","C++");
        System.out.println("//------------------------------------jdk 8----------------------------------");
        //jdk 8
        list.forEach(s -> System.out.println(s));
        System.out.println("//------------------------------------jdk 8 lambda----------------------------");
        //jdk 8 lambda
        list.stream().forEach(s -> System.out.println(s));

        //-------------------------------------常用操作-----------------------------------
        System.out.println("//-------------------------------------常用操作-----------------------------------");
        list.stream().collect(Collectors.joining(","));//Java,PHP,C++
        //1.map/flatMap
        //map的作用就是把 inputStream 的每一个元素，映射成 outputStream 的另外一个元素 flatmap则代表一对多
        //将list中每个字符都变成大写
        list.stream().map(String::toUpperCase).collect(Collectors.toList());//JAVA,PHP,C++

        //2.filter 过滤  筛选出来长度大于4的集合
        list.stream().filter(x -> x.length() > 4).collect(Collectors.toList());

        //3.forEach forEach 和常规 for 循环的差异不涉及到性能，它们仅仅是函数式风格与传统 Java 风格的差别。
        list.stream().filter(x -> x.length() > 4).forEach(x -> System.out.println("1 : " + x));

        //4.peek 对每个元素操作并返回一个新的stream  然后之后操作都在这个新的stream上操作
        list.stream()
                .filter(x->x.length()>4)
                .peek(x->System.out.println(x))
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        //5.findFirst 用来判断空指针 因为集合为string 把list第一个元素拿出来用map output转换为int，集合为null则返回-1
        list.stream().findFirst().map(String::length).orElse(-1);
        //打印集合中第一个元素，如果集合为空则打印false
        list.stream().findFirst().orElse("false");

        //判断字符串是否为空字符串
        String str="xxx";
        int s= Optional.ofNullable(str).map(String::length).orElse(-1);

        //reduce 主要作用是把 Stream 元素组合起来  reduce（初始位，BinaryOperator操作） 所谓初始位 结果=初始位+BinaryOperator得到的值
        //合并所有元素  结果x=""+ JavaPHPC++
        String x=list.stream().reduce("",String::concat);

        // 求最小值，minValue = -3.0  从10.0到-3.0 获取最小
        double minValue = Stream.of(-1.5, 1.0, -3.0, -2.0).reduce(10.0, Double::min);
        // 求和，sumValue = 10, 有起始值 0+ 10=10
        int sumValue = Stream.of(1, 2, 3, 4).reduce(0, Integer::sum);
        // 求和，sumValue = 10, 无起始值  由于没有初始值 所以得到的是option 所以用get()
        sumValue = Stream.of(1, 2, 3, 4).reduce(Integer::sum).get();


        //limit/skip limit返回前n个元素 skip则扔掉前n个元素  结果为scala
        list.stream().skip(1).limit(1).collect(Collectors.toList());

        //sorted  排序 结果:JavaPHPC++
        list= list.stream().sorted(String::compareTo).collect(Collectors.toList());

        //match
        //allMatch：Stream 中全部元素符合传入的 predicate，返回 true  结果true
        boolean s1=list.stream().allMatch(a -> a.length()>2);

        //anyMatch：Stream 中只要有一个元素符合传入的 predicate，返回 true 结果true
        boolean s2=list.stream().allMatch(b -> b.equals("scala"));
        //noneMatch：Stream 中没有一个元素符合传入的 predicate，返回 true   结果true
        boolean s3=list.stream().allMatch(c -> c.equals("xxxx"));

    }







}
