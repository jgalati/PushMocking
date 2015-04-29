var PushMocking = {
    
showPush : function(successCallback, errorCallback, title, message, appName) {

        cordova.exec(
            successCallback, 
            errorCallback, 
            "PushMockingPlugin", 
            "showPush", 
            [{
                "title": title,
                "message": message,
                "appName": appName
            }]
        );
    }
};

//-------------------------------------------------------------------


module.exports = PushMocking;