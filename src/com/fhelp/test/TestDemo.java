package com.fhelp.test;

import java.io.IOException;
import java.util.UUID;

import org.junit.Test;

import com.fhelp.base.BaseBean;
import com.fhelp.base.User;
import com.google.gson.Gson;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class TestDemo {
	private static String src = "zhangyongjian";

	@Test
	public void huhxBase64() {
		try {
			BASE64Encoder encoder = new BASE64Encoder();
			String encode = encoder.encode(src.getBytes());
			System.out.println("encode: " + encode);

			BASE64Decoder decoder = new BASE64Decoder();
			String decode = new String(decoder.decodeBuffer(encode));
			System.out.println("decode: " + decode);
			System.out.println("hashCode: " + UUID.randomUUID().toString());
			System.out.println("你好你好好".matches("^[\\u4e00-\\u9fa5_a-zA-Z0-9-]{4,16}$"));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void explainJson() {
		String str = "[{'taskId:8userId:2type:2state:0remunertype:2remuneration:123.0timelimit:111taskName:secendTasktaskDesc:this is a testloc:康定commentList:nullupCount:0collecCount:0clickCount:0taskPhoto:nullstartTime:2019-02-14':{'userId':2,'username':'account','password':'passowrd','autograph':'这个人是个猪，没写任何东西','registertime':'Feb 18, 2019 10:57:08 AM','isRealName':0,'credit':100,'follow':null,'fans':null,'balance':0.0,'integral':0.0,'release':null,'accept':null,'colection':null,'finish':null,'offtenTask':null,'nikename':'help_a6ba48062','photo':null,'sex':0,'location':null}}]";
		Gson gson = new Gson();
		str = "{\"code\":200,\"msg\":\"登录成功！\",\"data\":{\"userId\":2,\"username\":\"account\",\"password\":\"passowrd\",\"autograph\":\"这个人是个猪，没写任何东西\",\"registertime\":\"Feb 18, 2019 10:57:08 AM\",\"isRealName\":0,\"credit\":100,\"follow\":null,\"fans\":null,\"balance\":0.0,\"integral\":0.0,\"release\":null,\"accept\":null,\"colection\":null,\"finish\":null,\"offtenTask\":null,\"nikename\":\"help_a6ba48062\",\"photo\":null,\"sex\":0,\"location\":null}}";
//		List<Map<Task,User>> list = gson.fromJson(str,List.class);
//		for(Map<Task, User> map:list) {
//			Set<Task> keySet = map.keySet();
//			Iterator<Task> it = keySet.iterator();
//			if(it.hasNext()) {
//				Task task = it.next();
//				System.out.println(it.next().getTaskId());
//				User user = map.get(task);
//				System.out.println(task.toString()+"------"+user.toString());
//			}
//		}
		BaseBean base = gson.fromJson(str, BaseBean.class);
		System.out.println(base.getCode()+">>>"+base.getMsg());
		Object user = base.getData();
		System.out.println(user);
	}
}
