var PushMocking = {
    
showPush : function(successCallback, errorCallback, title, message, appName) {

        cordova.exec(
            successCallback, 
            errorCallback, 
            "PushMockingPlugin", 
            "showPush", 
            [{
                "title": title,
                "messae": message,
                "appName": appName
            }]
        );
    }
};

//-------------------------------------------------------------------


module.exports = PushMocking;