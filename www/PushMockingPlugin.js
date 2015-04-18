var PushMocking = function() {
};

PushMocking.prototype.showPush = function(successCallback, errorCallback, title, message, appName) {
    if (errorCallback == null) { errorCallback = function() {}}

    if (typeof errorCallback != "function")  {
        console.log("PushMocking.showPush failure: failure parameter not a function");
        return
    }

    if (typeof successCallback != "function") {
        console.log("PushMocking.showPush failure: success callback parameter must be a function");
        return
    }

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
};

//-------------------------------------------------------------------

if(!window.plugins) {
    window.plugins = {};
}
if (!window.plugins.pushMocking) {
    window.plugins.pushMocking = new PushMocking();
}

if (typeof module != 'undefined' && module.exports) {
  module.exports = PushMocking;
}