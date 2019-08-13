package com.zhang.mybatis.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.zhang.mybatis.entity.Node;

import java.util.List;
import java.util.Map;

/**
 * @ClassName TreeRecursion
 * @Author zhangjiwei
 * @Date 2019/8/12 20:57
 * @Description
 */
public class TreeRecursion {
    public static void main(String[] args) {
        Map<String, Node> nodes = Maps.newHashMap();
        //模拟数据库存储树结构
        nodes.put("1", new Node("1", "root", 1, "0"));
        nodes.put("2", new Node("2", "a", 1, "1"));
        nodes.put("3", new Node("3", "b", 1, "1"));
        nodes.put("4", new Node("4", "c", 1, "1"));
        nodes.put("5", new Node("5", "d", 1, "2"));
        nodes.put("6", new Node("6", "e", 1, "2"));
        nodes.put("7", new Node("7", "f", 1, "3"));
        nodes.put("8", new Node("8", "g", 1, "7"));
        System.out.println(JSONObject.toJSONString(getNodeJson("0", nodes), SerializerFeature.PrettyFormat));
    }

    private static JSONArray getNodeJson(String nodeId, Map<String, Node> nodes) {
        // 当前层级node对象
        // 当前层级当前节点下的所有子节点(实战中不要慢慢去查，一次加载到集合中慢慢处理)
        List<Node> childList = getChildNodes(nodeId,nodes);
        JSONArray childTree = new JSONArray();
        for(Node node : childList){
            JSONObject o = new JSONObject();
            o.put("name",node.getName());
            o.put("type",node.getType());
            JSONArray childs = getNodeJson(node.getId(),nodes);
            if(!childs.isEmpty()){
                o.put("children",childs);
            }
            childTree.add(o);
        }
        return childTree;
    }

    private static List<Node> getChildNodes(String nodeId, Map<String, Node> nodes) {
        List<Node> list = Lists.newArrayList();
        for (String key : nodes.keySet()) {
            if (nodes.get(key).getParentId().equals(nodeId)) {
                list.add(nodes.get(key));
            }
        }
        return list;
    }
}
