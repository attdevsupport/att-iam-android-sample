package com.att.iamsampleapp;

public class Config {
	
	public static String token;
	public static String refreshToken;
	public static final int messageLimit 			= 	500;
	public static final int messageOffset 			= 	0;
	public static final int maxRecipients 			= 	10;
	public static final int	maxAttachments			= 	21;
	public static final String fqdn		 			= 	"https://api.att.com";
	
	public static final String clientID				= 	 APP_KEY;
	public static final String secretKey 			= 	 APP_SECRET;
	public static final String appScope	 			= 	 APP_SCOPE;
	public static final String redirectUri  		= 	 REDIRECT_URI;
	public static final String iamDownloadDirectory = "InAppMessagingDownloads";
}