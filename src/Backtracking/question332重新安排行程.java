package Backtracking;

//给你一份航线列表 tickets ，其中 tickets[i] = [fromi, toi] 表示飞机出发和降落的机场地点。请你对该行程进行重新规划排序。
//所有这些机票都属于一个从 JFK（肯尼迪国际机场）出发的先生，所以该行程必须从 JFK 开始。如果存在多种有效的行程，请你按字典排序返回最小的行程组合。
//
//例如，行程 ["JFK", "LGA"] 与 ["JFK", "LGB"] 相比就更小，排序更靠前。
//假定所有机票至少存在一种合理的行程。且所有的机票 必须都用一次 且 只能用一次。
//
//
//示例 1：
//
//输入：tickets = [["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]
//输出：["JFK","MUC","LHR","SFO","SJC"]
//示例 2：
//
//输入：tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
//输出：["JFK","ATL","JFK","SFO","ATL","SFO"]
//解释：另一种有效的行程是 ["JFK","SFO","ATL","JFK","ATL","SFO"] ，但是它字典排序更大更靠后。
//
//提示：
//
//1 <= tickets.length <= 300
//tickets[i].length == 2
//fromi.length == 3
//toi.length == 3
//fromi 和 toi 由大写英文字母组成
//fromi != toi

import java.util.*;

public class question332重新安排行程 {
    static Map<String, List<String>> graph = new HashMap<>(); // 存储图的邻接表
    static List<String> res = new ArrayList<>(); // 存储结果路径
    public static List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> path:tickets) {
            String start = path.get(0);
            String end = path.get(1);
            if(!graph.containsKey(start)){
                graph.put(start,new ArrayList<>());
            }
            graph.get(start).add(end);
        }

        // 按照字典序排序
        for (List<String> destinations : graph.values()) {
            Collections.sort(destinations);
        }

        dfs("JFK"); // 从 JFK 机场开始深度优先搜索
        Collections.reverse(res); // 将结果路径反转

        return res;
    }

    private static void dfs(String start) {
        List<String> destinations = graph.get(start); // 获取目的地列表
        while (destinations != null && destinations.size() > 0) {
            String end = destinations.remove(0); // 获取当前目的地并将其从列表中移除
            dfs(end); // 递归搜索下一个机场
        }
        res.add(start); // 将当前机场加入到结果路径中
    }

    public static void main(String[] args) {
        List<List<String>> tickets = new ArrayList<>();
        List<String> route1 = Arrays.asList("JFK","SFO");
        List<String> route2 = Arrays.asList("JFK","ATL");
        List<String> route3 = Arrays.asList("SFO","ATL");
        List<String> route4 = Arrays.asList("ATL","JFK");
        List<String> route5 = Arrays.asList("ATL","SFO");

        tickets.add(route1);
        tickets.add(route2);
        tickets.add(route3);
        tickets.add(route4);
        tickets.add(route5);

        findItinerary(tickets);
    }
}
