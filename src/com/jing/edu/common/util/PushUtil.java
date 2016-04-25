package com.jing.edu.common.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.jing.edu.model.GoeasyAccount;
import com.jing.edu.model.GoeasyApp;
import com.jing.edu.model.params.PushConstants;
import com.uwantsoft.goeasy.client.goeasyclient.GoEasy;

/**
 * 推送消息工具类
 * 
 * @author jing
 *
 */
public class PushUtil {

	public static String goeasyFile = "com/jing/resources/test/goeasy.xml";

	// 存放goeasy的配置内容
	private static HashMap<String, GoeasyApp> goeasyMap = null;

	// goeasy服务
	private static GoEasy eduGoeasy = null;

	private static void initPushConfig() {
		SAXReader reader = new SAXReader();
		InputStream iStream = null;
		try {
			goeasyMap = new HashMap<>();
			iStream = PushUtil.class.getClassLoader().getResourceAsStream(goeasyFile);
			Document doc = reader.read(iStream);
			Element root = doc.getRootElement();
			Iterator<Element> apps = root.elementIterator("application");
			Element app = null;
			while (apps.hasNext()) {
				app = apps.next();
				GoeasyApp goeasyApp = new GoeasyApp();
				goeasyApp.setApplicationName(app.attributeValue("name"));
				goeasyApp.setCreateTime(app.attributeValue("create_time"));
				;
				// account
				List<Element> accountList = app.elements("account");
				int size = accountList.size();
				List<GoeasyAccount> accounts = new ArrayList<>();
				for (int i = 0; i < size; i++) {
					GoeasyAccount account = new GoeasyAccount();
					account.setSuperKey(accountList.get(i).attributeValue("superkey"));
					account.setSubscribeKey(accountList.get(i).attributeValue("subscribekey"));
					accounts.add(account);
				}
				goeasyApp.setAccounts(accounts);
				goeasyMap.put(goeasyApp.getApplicationName(), goeasyApp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				iStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static HashMap<String, GoeasyApp> getGoeasyMap() {
		if (null == goeasyMap) {
			// 初始化map
			initPushConfig();
		}
		return goeasyMap;
	}

	public static GoEasy getGoeasyServer() {
		if (null == eduGoeasy) {
			String eduSuperKey = getGoeasyMap().get(PushConstants.GOEASY_APP_EDU).getAccounts().get(0).getSuperKey();
			eduGoeasy = new GoEasy(eduSuperKey);
		}
		return eduGoeasy;
	}
}
