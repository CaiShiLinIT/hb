package com.hb.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hb.pojo.Datas;
import com.hb.pojo.Geocodes;
import com.hb.pojo.JsonRootBean;
import com.hb.pojo.LuxianBean;
import com.hb.pojo.Paths;
import com.hb.util.HttpClientService;
import com.hb.util.ObjectMapperUtil;


@Service
public class MapServiceImpl implements MapService {
	@Autowired
	private HttpClientService httpClientService;
	private String url="https://restapi.amap.com/v3/geocode/geo";
	private String lujiurl="https://restapi.amap.com/v4/direction/bicycling";
	@Override
	public String siliFind(String city,String address) {
		Map<String, String> params=new HashMap<>();
		params.put("key", "a1feadf3156ae023a417f49f07e1ae93");
		params.put("city", city);
		params.put("address", address);
		System.err.println(url);
		String status = httpClientService.doGet(url, params);
		JsonRootBean dili = ObjectMapperUtil.toObject(status, JsonRootBean.class);
		List<Geocodes> geocodes = dili.getGeocodes();
		String location = geocodes.get(0).getLocation();
		System.err.println(status);
		return location;
	}
	//116.480656,39.989677	方恒国际中心A座
	//116.508685,39.823105  北京珠宝首饰研修学院
	@Override
	public String lujiFind(String city, String address) {
		String location = siliFind(city,address);
		Map<String, String> params=new HashMap<>();
		params.put("key", "a1feadf3156ae023a417f49f07e1ae93");
		params.put("origin", "116.508685,39.823105");//起点
		params.put("destination", location);
		String status = httpClientService.doGet(lujiurl, params);
		LuxianBean luxian = ObjectMapperUtil.toObject(status, LuxianBean.class);
		Datas data = luxian.getData();
		List<Paths> path = data.getPaths();
		Integer changdu = path.get(0).getDistance();
		Integer shijian = path.get(0).getDuration()/60;
		System.out.println("****************************************");
		System.out.println(status);
		System.err.println();
		System.err.println(changdu);
		System.err.println(shijian);
		System.out.println("****************************************");
		return changdu+"米"+shijian+"分";
	}
	
}
