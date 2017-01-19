package com.testweb.test1_8.testStream;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by xingxuechao@alibaba-inc.com
 * on:17/1/11 下午3:58
 */
public class TestStream {

    public static void main(String args[]){
        List<String> resultGroupList = new ArrayList<String>(3);//缩小初始化代价
        List<GroupId> groupIdList = GroupId.allGroups();
        String dataId = "";
        if(groupIdList!=null){
            List<String> resultList = groupIdList.stream().filter(groupId -> dataId.equals(groupId.getDataId())).map(GroupId::getGroupId).collect(Collectors.toList());
            resultGroupList.addAll(resultList);
        }

    }

}
class GroupId{
    String dataId;
    String groupId;

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public static List<GroupId> allGroups(){
        return new ArrayList<GroupId>();
    }
}