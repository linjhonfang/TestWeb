package com.testweb.testJson;

import com.tudou.utils.json.JsonTool;

import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class JsonTest {
	
	public static void main2(String args[]) throws JsonGenerationException, JsonMappingException, IOException{
		Test test = mockTest();
		ObjectMapper mapper = new ObjectMapper();
		
		String str = mapper.writeValueAsString(test); 
		System.out.println("str="+str);
	}
	
	public static  Test mockTest(){
		Test test = new Test();
		test.id="123123123";
		test.value = null;
		return test;
	}
	
	public static void main1(String[] args) {
		
		String result="";
				if(StringUtils.isNotBlank(result)){
			Map<String, Object> resultMap=JsonTool.readValue(result, Map.class);
			
			List<Map> list = JsonTool.readValue2List(resultMap.get("data").toString(), Map.class);
			
			for(Map map : list){
				System.out.println(map.get("id"));
			}
		}
		
	}
	
	public static void main(String[] args) {
		String str = "{\"widget_info\":[{\"channelId\":\"5590364\",\"widgetId\":\"125086\",\"videoId\":\"391519947\"},{\"channelId\":\"331686196\",\"widgetId\":\"125106\",\"videoId\":\"383684136\"},{\"channelId\":\"366174539\",\"widgetId\":\"125487\",\"videoId\":\"392009968\"},{\"channelId\":\"361121177\",\"widgetId\":\"125546\",\"videoId\":\"376094768\"},{\"channelId\":\"833397967\",\"widgetId\":\"125563\",\"videoId\":\"391967706\"},{\"channelId\":\"18619072\",\"widgetId\":\"125565\",\"videoId\":\"392110424\"},{\"channelId\":\"813374342\",\"widgetId\":\"125625\",\"videoId\":\"392134995\"},{\"channelId\":\"359834923\",\"widgetId\":\"125635\",\"videoId\":\"392139306\"},{\"channelId\":\"78073747\",\"widgetId\":\"125647\",\"videoId\":\"391905380\"},{\"channelId\":\"90485402\",\"widgetId\":\"125651\",\"videoId\":\"390298598\"},{\"channelId\":\"42229022\",\"widgetId\":\"125656\",\"videoId\":\"392158410\"},{\"channelId\":\"321176492\",\"widgetId\":\"125668\",\"videoId\":\"392161855\"},{\"channelId\":\"792314372\",\"widgetId\":\"125670\",\"videoId\":\"392166837\"},{\"channelId\":\"194146\",\"widgetId\":\"125671\",\"videoId\":\"390985095\"},{\"channelId\":\"404150979\",\"widgetId\":\"125684\",\"videoId\":\"392194393\"},{\"channelId\":\"90485402\",\"widgetId\":\"125711\",\"videoId\":\"392203629\"},{\"channelId\":\"18619072\",\"widgetId\":\"125747\",\"videoId\":\"393192093\"},{\"channelId\":\"429511344\",\"widgetId\":\"125751\",\"videoId\":\"392233693\"},{\"channelId\":\"194146\",\"widgetId\":\"125752\",\"videoId\":\"391867892\"},{\"channelId\":\"321176492\",\"widgetId\":\"125755\",\"videoId\":\"389935252\"},{\"channelId\":\"478180815\",\"widgetId\":\"125774\",\"videoId\":\"391974155\"},{\"channelId\":\"813374342\",\"widgetId\":\"125797\",\"videoId\":\"393371366\"},{\"channelId\":\"329897314\",\"widgetId\":\"125800\",\"videoId\":\"381653882\"},{\"channelId\":\"478180815\",\"widgetId\":\"125807\",\"videoId\":\"392271710\"},{\"channelId\":\"455266321\",\"widgetId\":\"125809\",\"videoId\":\"392276883\"},{\"channelId\":\"820446123\",\"widgetId\":\"125813\",\"videoId\":\"392184847\"},{\"channelId\":\"133493789\",\"widgetId\":\"125817\",\"videoId\":\"392241165\"},{\"channelId\":\"368267803\",\"widgetId\":\"125819\",\"videoId\":\"392291553\"},{\"channelId\":\"478180815\",\"widgetId\":\"125838\",\"videoId\":\"391965104\"},{\"channelId\":\"75281247\",\"widgetId\":\"125885\",\"videoId\":\"392355708\"},{\"channelId\":\"355971427\",\"widgetId\":\"125890\",\"videoId\":\"391245134\"},{\"channelId\":\"35876095\",\"widgetId\":\"125913\",\"videoId\":\"391925946\"},{\"channelId\":\"431877785\",\"widgetId\":\"125962\",\"videoId\":\"392500592\"},{\"channelId\":\"78073747\",\"widgetId\":\"125963\",\"videoId\":\"392407275\"},{\"channelId\":\"431877785\",\"widgetId\":\"125968\",\"videoId\":\"392514263\"},{\"channelId\":\"129960264\",\"widgetId\":\"125969\",\"videoId\":\"393291229\"},{\"channelId\":\"93404847\",\"widgetId\":\"125971\",\"videoId\":\"392519467\"},{\"channelId\":\"302130089\",\"widgetId\":\"125972\",\"videoId\":\"392507820\"},{\"channelId\":\"431877785\",\"widgetId\":\"125975\",\"videoId\":\"392266497\"},{\"channelId\":\"320564332\",\"widgetId\":\"125990\",\"videoId\":\"392826700\"},{\"channelId\":\"361121177\",\"widgetId\":\"125995\",\"videoId\":\"379544376\"},{\"channelId\":\"429511344\",\"widgetId\":\"126000\",\"videoId\":\"392553993\"},{\"channelId\":\"9472345\",\"widgetId\":\"126017\",\"videoId\":\"392585810\"},{\"channelId\":\"368267803\",\"widgetId\":\"126020\",\"videoId\":\"392600818\"},{\"channelId\":\"9472345\",\"widgetId\":\"126036\",\"videoId\":\"392603023\"},{\"channelId\":\"9472345\",\"widgetId\":\"126040\",\"videoId\":\"392635584\"},{\"channelId\":\"804201193\",\"widgetId\":\"126130\",\"videoId\":\"348753926\"},{\"channelId\":\"429511344\",\"widgetId\":\"126135\",\"videoId\":\"392816449\"},{\"channelId\":\"354374278\",\"widgetId\":\"126139\",\"videoId\":\"393053470\"},{\"channelId\":\"431877785\",\"widgetId\":\"126140\",\"videoId\":\"392829819\"},{\"channelId\":\"431877785\",\"widgetId\":\"126142\",\"videoId\":\"392834140\"},{\"channelId\":\"75281247\",\"widgetId\":\"126219\",\"videoId\":\"392766214\"},{\"channelId\":\"361121177\",\"widgetId\":\"126238\",\"videoId\":\"384383196\"},{\"channelId\":\"443384310\",\"widgetId\":\"126246\",\"videoId\":\"393046117\"},{\"channelId\":\"780336690\",\"widgetId\":\"126259\",\"videoId\":\"392783092\"},{\"channelId\":\"127545591\",\"widgetId\":\"126269\",\"videoId\":\"392088624\"},{\"channelId\":\"132997651\",\"widgetId\":\"126274\",\"videoId\":\"391685157\"},{\"channelId\":\"144725772\",\"widgetId\":\"126279\",\"videoId\":\"393099155\"},{\"channelId\":\"455366760\",\"widgetId\":\"126341\",\"videoId\":\"391933029\"},{\"channelId\":\"9472345\",\"widgetId\":\"126356\",\"videoId\":\"393163830\"},{\"channelId\":\"31860482\",\"widgetId\":\"126386\",\"videoId\":\"393236055\"},{\"channelId\":\"429511344\",\"widgetId\":\"126387\",\"videoId\":\"393247536\"},{\"channelId\":\"9472345\",\"widgetId\":\"126410\",\"videoId\":\"393209942\"},{\"channelId\":\"31860482\",\"widgetId\":\"126413\",\"videoId\":\"393265319\"},{\"channelId\":\"75281247\",\"widgetId\":\"126447\",\"videoId\":\"393228593\"},{\"channelId\":\"320564332\",\"widgetId\":\"126455\",\"videoId\":\"393344910\"},{\"channelId\":\"109102698\",\"widgetId\":\"126495\",\"videoId\":\"391988768\"}]}";
		Map<String,Object> map = JsonTool.readValue2Map(str, String.class, Object.class);
		List<Map<String,String>> data = (List<Map<String,String>>)map.get("widget_info");
		for(Map<String,String> map1 : data){
			//System.out.println(map1.get("channelId"));
			//System.out.println(map1.get("widgetId"));
			System.out.println(map1.get("videoId"));
		}
	}
}
class Test{
	public String id;
	public Double value;
}