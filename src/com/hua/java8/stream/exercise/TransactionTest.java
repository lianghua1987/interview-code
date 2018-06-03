package com.hua.java8.stream.exercise;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TransactionTest {

    List<Transaction> transactions = null;

    @Before
    public void before() {
        Trader raoul = new Trader("raoul", "Cambridge");
        Trader mario = new Trader("mario", "Milan");
        Trader alan = new Trader("alan", "Cambridge");
        Trader brian = new Trader("brian", "Cambridge");

        transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950));
    }

    /*
     * 1. 2011所有交易，按交易额排序
     * 2. 交易员都在哪些不同城市工作过
     * 3. 来自剑桥交易员，按姓名排序
     * 4. 返回所有交易员的姓名字符串，按字母排序
     * 5. 有没有交易员在米兰工作
     * 6. 在剑桥交易员的的所有交易额
     * 7. 找出最高交易额
     * 8. 找出最小交易
     * */

    //1. 2011所有交易，按交易额排序
    @Test
    public void test1() {
        transactions.stream()
                .filter(e -> e.getYear() == 2011)
                .sorted((e1, e2) -> e1.getValue() - e2.getValue())
                .forEach(System.out::println);
    }

    // 2. 交易员都在哪些不同城市工作过
    @Test
    public void test2() {
        transactions.stream()
                .map(t -> t.getTrader().getCity())
                .distinct()
                .forEach(System.out::println);

        System.out.println("---------------------------------------------");
        transactions.stream()
                .map(t -> t.getTrader().getCity())
                .collect(Collectors.toSet())
                .forEach(System.out::println);
    }

    //3. 来自剑桥交易员，按姓名排序
    @Test
    public void test3() {
        transactions.stream()
                .filter(t -> t.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getTrader)
                .sorted((t1, t2) -> t1.getName().compareTo(t2.getName()))
                .distinct()
                .forEach(System.out::println);
    }

    //4. 返回所有交易员的姓名字符串，按字母排序
    @Test
    public void test4() {
        transactions.stream()
                .map(t -> t.getTrader().getName())
                .sorted()
                .distinct()
                .forEach(System.out::println);

        System.out.println("---------------------------------------------");

        System.out.println(transactions.stream()
                .map(t -> t.getTrader().getName())
                .sorted()
                .distinct()
                .collect(Collectors.joining(",")));

        System.out.println("---------------------------------------------");

        System.out.println(transactions.stream()
                .map(t -> t.getTrader().getName())
                .sorted()
                .distinct()
                .reduce("", String::concat));
    }

    //5. 有没有交易员在米兰工作
    @Test
    public void test5() {
        System.out.println(transactions.stream().anyMatch(t -> t.getTrader().getCity().equals("Milan")));
    }

    //6. 在剑桥交易员的的所有交易额
    @Test
    public void test6() {
        System.out.println(transactions.stream()
                .filter(t -> t.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .reduce(Integer::sum).get());
    }

    //7. 找出最高交易额
    @Test
    public void test7() {
        System.out.println(transactions.stream().map(Transaction::getValue).max(Integer::compareTo).get());
    }


    //7. 找出最小交易额
    @Test
    public void test8() {
        System.out.println(transactions.stream().min((t1, t2) -> t1.getValue() - t2.getValue()).get());
    }

}
