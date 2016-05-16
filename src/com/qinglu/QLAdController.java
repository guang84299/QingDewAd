package com.qinglu;

import org.androidpn.client.ServiceManager;


import com.qinglu.ad.QLAdManager;
import com.qinglu.ad.QLAdView;
import com.qinglu.ad.QLOffersManager;
import com.qinglu.ad.QLSpotManager;
import com.qinglu.ad.impl.qinglu.QLAdManagerQingLu;
import com.qinglu.ad.impl.qinglu.QLSpotManagerQingLu;
import com.qinglu.ad.tools.QLNetTools;

import android.content.Context;

public class QLAdController {
	private static QLAdController controller;
	private static QLAdManager manager;
	private static QLSpotManager spotManager;
	private static QLOffersManager offersManager;
	private static int CurrPlatform = 0;
	private static boolean testModel;
	private static int notifiIcon;
	private Context con;
	public static boolean isInit = false;
	
	private QLAdController()
	{
		isInit = true;
	}
	
	public static QLAdController getInstance()
	{
		if(controller == null)
		{
			controller = new QLAdController();					
		}			
		return controller;
	}
	
	public void init(Context context,int notificationIcon,boolean isTestModel)
	{
		this.con = context;		
		testModel = isTestModel;
		
		notifiIcon = notificationIcon;
		QLNetTools.requestAdPlatfrom(context);		
	}
	
	public void init()
	{
		CurrPlatform = QLCommon.CurrPlatform;
		
		// Start the service
        ServiceManager serviceManager = new ServiceManager(con);
        serviceManager.setNotificationIcon(notifiIcon);
        serviceManager.startService();	
        
        QLAdController.getQLAdManager(con);
	}
	
	//在service中重启时调用
	public void initService(Context context)
	{
		CurrPlatform = QLCommon.CurrPlatform;
		this.con = context;	
		isInit = true;
		     
        QLAdController.getQLAdManager(con);
	}
	
	//获得管理器实例
	public static QLAdManager getQLAdManager(Context context)
	{
		if(manager != null)
		{
			return manager;
		}
				
		manager = new QLAdManagerQingLu(context);		
		manager.init(testModel);
		return manager;
	}
		
	//获得插屏管理器实例
	public static QLSpotManager getQLSpotManager(Context context)
	{
		if(spotManager != null)
		{
			return spotManager;
		}
		
		spotManager = new QLSpotManagerQingLu(context);		
		return spotManager;
	}
	
	
	//获得广告条管理器实例
	public static QLAdView getQLAdView(Context context,QLSize size)
	{
				
		CurrPlatform = QLCommon.CurrPlatform;
		
		QLAdView view = null;
		
		
		return view;
	}
	
	//获得积分墙管理器实例
	public static QLOffersManager getQLOffersManager(Context context)
	{
		if(offersManager != null)
		{
			return offersManager;
		}
		
		return offersManager;
	}
	
	//得到上下文
	public Context getContext()
	{
		return con;
	}
	
	//切换广告
	public void changeAdPlatform(int platform)
	{			
		if(CurrPlatform != platform)
		{
			QLCommon.CurrPlatform = CurrPlatform;
		}				
	}
}
