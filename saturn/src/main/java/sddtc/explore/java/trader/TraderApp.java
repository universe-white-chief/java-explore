package sddtc.explore.java.trader;

import javax.swing.text.html.Option;
import java.util.*;
import java.util.stream.Collectors;

/**
 *
 *
 * Created by hchang on 2017/1/24.
 */
public class TraderApp {
    Trader raoul = new Trader("Raoul", "Cambridge");
    Trader mario = new Trader("Mario", "Milan");
    Trader alan = new Trader("Alan", "Cambridge");
    Trader brian = new Trader("Brian", "Cambridge");

    List<Transaction> transactions = Arrays.asList(
            new Transaction(brian, 2011, 300),
            new Transaction(raoul, 2012, 1000),
            new Transaction(raoul, 2011, 400),
            new Transaction(mario, 2012, 710),
            new Transaction(mario, 2012, 700),
            new Transaction(alan, 2012, 950)
    );

    /**
     * 找出2011年的所有交易并按照交易额排序(从低到高)
     * @return
     */
    public List<Transaction> first() {
        List<Transaction> tr2011 = transactions.stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(Collectors.toList());
        return tr2011;
    }

    /**
     * 交易员都在哪些不同的城市工作过
     * @return
     */
    public Set<String> second() {
        Set<String> cities = transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .collect(Collectors.toSet());

        return cities;
    }

    /**
     * 查找所有来自剑桥的交易员,按照姓名排序
     * @return
     */
    public List<Trader> third() {
        List<Trader> traders = transactions.stream()
                .map(Transaction::getTrader)
                .filter(trader -> trader.getCity().equals("Cambridge"))
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .collect(Collectors.toList());

        return traders;
    }

    /**
     * 返回所有交易员的姓名字符串,按字母顺序排序
     * @return
     */
    public String fourth() {
        String names = transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .reduce("", (n1, n2) -> n1+n2);

        return names;
    }

    /**
     * 有没有交易员是在米兰工作的
     * @return
     */
    public boolean fifth() {
        boolean milanBased = transactions.stream().anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan"));
        return milanBased;
    }

    /**
     * 打印生活在剑桥的交易员的交易额
     */
    public void sixth() {
        transactions.stream()
                .filter(transaction -> "Cambridge".equals(transaction.getTrader().getCity()))
                .map(Transaction::getValue)
                .forEach(System.out::println);

    }

    /**
     * 所有交易中,最高的交易额是多少
     * @return
     */
    public int seventh() {
        Optional<Integer> highestValue = transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::max);

        return highestValue.get();

    }

    /**
     * 找到交易额最小的交易
     * @return
     */
    public Transaction eighth() {
        Optional<Transaction> smallestTransaction = transactions.stream()
                .reduce((t1, t2) -> t1.getValue()<t2.getValue()?t1:t2);

        return smallestTransaction.get();
    }

}
