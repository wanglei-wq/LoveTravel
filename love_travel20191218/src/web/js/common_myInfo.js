$(function () {
    $("#myinfo").click(function(){
        var userStr = sessionStorage.getItem("user")
        var user = JSON.parse(userStr)
        if (user == null || user == "") {
            if (window.confirm("您还未登录，是否跳转到登录界面？")) {
                window.location.replace("loginAndRegister.html")
            }else{
                window.location.reload();
            }
        }
    })
    $("a[name='RBAC']").click(function () {
        var userStr = sessionStorage.getItem("user")
        var user = JSON.parse(userStr)
        if (user == null || user == "") {
            if (window.confirm("您还未登录，是否跳转到登录界面？")) {
                window.location.replace("loginAndRegister.html")
                return false;
            }else{
                window.location.reload();
                return false;
            }
        }
    })
})
