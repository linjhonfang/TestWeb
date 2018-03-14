package com.testweb.testGson;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xingxuechao@alibaba-inc.com
 * on:17/6/28 下午7:54
 */
public class GsonGenericsTest {

    public static void main(String args[]) {
        Tree tree = new Tree();
        List<Node> nodeList = new ArrayList<>();
        nodeList.add(new SubNode("list1", null));
        nodeList.add(new SubNode("list2", null));
        tree.node = new SubNode("xxc", nodeList);

        Gson gson = new GsonBuilder().registerTypeAdapter(SubNode.class, new SubNodeJsonDeserializer()).create();


        String gsonStr = gson.toJson(tree);
        System.out.println("gsonStr:" + gsonStr);
        //new TypeToken<Tree<>(){}.getType();
        Tree tree1 = gson.fromJson(gsonStr, Tree.class);
        System.out.println("gsonObj:" + tree1.toString());


        String NodeStr = gson.toJson(tree.node);
        System.out.println("NodeStr:" + NodeStr);

        //new TypeToken<SubNode<List<SubNode>>(){}.getType();
        Node node1 = gson.fromJson(NodeStr, SubNode.class);
        System.out.println("node1:" + node1.toString());

        String fastStr = JSON.toJSONString(tree);
        System.out.println("fastStr:" + fastStr);
        Tree tree2 = JSON.parseObject(fastStr, Tree.class);
        System.out.println("fastObj:" + tree2.toString());


    }

}
    class SubNodeJsonDeserializer implements JsonDeserializer<SubNode> {
        @Override
        public SubNode deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            SubNode subNode1 = null;
            if (json.isJsonObject()) {
                JsonObject jsonObject = json.getAsJsonObject();


                JsonArray array = new JsonArray();
                array.add(jsonObject);
                JsonArray subArray = null;
                //while(array!=null && array.size()>0) {

                //for (int i = 0; i < array.size(); i++) {
                //    JsonObject element = (JsonObject) array.get(i);
                    JsonObject element = json.getAsJsonObject();
                    String idStr = element.get("id").getAsString();
                    String fatherIdStr = element.get("fatherId").getAsString();
                    subArray = element.getAsJsonArray("nodelist");
                    List<Node> subNodes = new ArrayList<Node>();
                    if (subArray != null) {
                        for (int j = 0; j < subArray.size(); j++) {
                            subNodes.add(context.deserialize(subArray.get(j), SubNode.class));
                        }
                    }
                    subNode1 = new SubNode(idStr, fatherIdStr, subNodes);
                //}
                //}
//                    if ("video".equals(type)) {
//                        item = context.deserialize(element.getAsJsonObject("data"), Video.class);
//                    } else if ("link".equals(type)) {
//                        item = context.deserialize(element.getAsJsonObject("data"), Link.class);
//                    }
//                    if (item != null) {
//                        list.add(item);
//                    }
//                }
//                videoList.results = list;
            }


            return subNode1;
        }
    }


class Node {
    String fatherId;
    List<Node> nodelist;
    public Node(String fatherId, List<Node> nodelist){
        this.fatherId = fatherId;
        this.nodelist = nodelist;
    }
    public Node(){}
    public String toString(){
        return "fatherId:"+fatherId+",nodelist:"+nodelist;
    }
}

class SubNode extends Node {
    String id;
    public SubNode(String id, List<Node> nodeList){
        super(id+"father", nodeList);
        this.id = id;
    }
    public SubNode(String id, String fatherId, List<Node> nodeList){
        super(fatherId, nodeList);
        this.id = id;
    }
    public SubNode(){
        super();
    }

    public String toString(){
        return "id:"+id+",fatherId:"+fatherId+",nodelist:"+nodelist;
    }
}

class Tree {
    SubNode node;

    public String toString(){
        return node.toString();
    }
}

