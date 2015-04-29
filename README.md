# PushMocking
It's a Cordova/Phonegap plugin that allows you to mock push notifications and see how it will look on any Android device.

Usage Example

```javascript
function  sendANotification(title, message, appName) {
        var success = function() { alert("Success"); };
        var error = function(message) { alert("Error! " + message); };
        
        PushMocking.showPush(success, error, title, message, appName);
};
```

### Icon

_The icon that the notification will show is the same one of the App_.