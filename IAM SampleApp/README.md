## AT&T In-App Messaging(IAM)SDK for Android
**IAM** service allows a developer to send SMS or MMS message on behalf of an AT&T mobile subscriber.

The In-App Messaging SDK is an android library for natively consuming the RESTful resources for AT&T's In-App Messaging API.

##Quick Start
--------------
Sending a message can be as easy as:

	//Initialize the Manager
	iamManager = new IAMManager(...);
	
	//Send a Message
	iamManager.SendMessage(addresses, "This is a test message",null, true, null);

##Requirements
- Git
- Android SDK


Overview
--------------
There are two main components to the library :

- A  manager --HTTP client-- to handle all the In-App Messaging requests.
- A set of request wrappers for the HTTP requests to access the API's resources.

##Request Wrappers

The SDK provides the wrappers for the  actual REST resources that are accessed by the application.The main request parameters are exposed.
	
	APICreateMessageIndex
	APISendMessage
	APIGetMessageList
	APIGetMessage
	APIGetMessageContent
	APIGetDelta
	APIUpdateMessages
	APIUpdateMessage
	APIDeleteMessages
	APIDeleteMessage
	APIGetMessageIndexInfo
	APIGetNotificationConnectionDetails
	
##Request Management

The networking layer is abstracted away by providing the manager--IAMManager-- to handle the request made by the application.
The IAMManager creates the actual HTTP requests and allows the developer to define success and error callbacks using listeners

	iamManager = new IAMManager(......new sendMessageListener());
	
	private class sendMessageListener implements ATTIAMListener {
	@Override
		public void onSuccess(Object arg0) {
		//Your code  for success
		}
	@Override
		public void onError(Object arg0) {
		//Your code for error
		}


	
###Using the In-App messaging SDK in your app
-----------------------------------------------------
###Using the Binary
- Add the files under InAppMessaging
- Link the static library IAMSDK by configuring the build Path

###Using the Sources
- Open the Eclipse 
- Download the Android SDK
- Create a New Android Project in the workspace
- Link the IAMSDK library to the project
- Add the Activity UserConsentActivity in the AndroidManifest file

You can start building your APP with In-App Messaging support

##Usage
------
#### Initialize the app client
	
	final String domainName = "https://api.att.com";
		
	// Enter the value from 'App Key' field
	final String clientId = " appId";

	// Enter the value from 'Secret' field
	final String clientSecret = "appSecret";

#### Add the Activity UserConsentActivity in the AndroidManifest file

	<activity
            android:name="com.att.api.consentactivity.UserConsentActivity"
            android:label="@string/title_activity_user_consent" >
        </activity>


#### Create service for requesting an OAuth token
	OAuthService osrvc = new OAuthService(domainName, appId, appSecret);
Start the UserconsentActivity for result by passing the domainName, appId and appSecret as extras to get the oAuthCode on the onActivityResult callback.

	Intent i = new Intent(this,com.att.api.consentactivity.UserConsentActivity.class);
	i.putExtra("domainName", domainName);
	i.putExtra("appId", appId);
	i.putExtra("appSecret", appSecret);
	startActivityForResult(i, REQUEST_CODE);
	
Obtain the token by passing the oAuthCode in onActivityResult
						 
	osrvc.getOAuthToken(oAuthCode,new listener());				  
OnSuccess call back of the token listener, you can Send the Message 

	IAMManager iamManager = new IAMManager(domainName, token, new listener());
	iamManager.SendMessage(addresses, "This is a test message",null, false, null);

OnSuccess call back of the SendMessage Listener, you can add your code
	
	private class sendMessageListener implements ATTIAMListener {
	@Override
		public void onSuccess(Object arg0) {
		//Your code  for success
		}
	@Override
		public void onError(Object arg0) {
		//Your code for error
		}


	







