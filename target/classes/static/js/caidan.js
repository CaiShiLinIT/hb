//查询菜单类别
function doGetCaiDanByType(dom) {
    $.ajax({
        type: "GET",
        url: "/caidan/query/",
        data: {lei:$(dom).attr("lei")},
        dataType: "json",
        success: function(result) {
            if (result.status == 200) {
                console.log(result.data)
                //调用创建tbody函数
                createTBody(result.data)
            } else
                alert("查询失败")
        }
    })
}

//购物车商品减少或删除
function doUpdateDelCart(params) {
	console.log(params)
    var url = params.shuLiang==0?"/cart/delete/":"/cart/update/"
    $.ajax({
        type: "POST",
        url: url,
        data: params,
        dataType: "json"
    })
}
//购物车商品全部删除
function doUpdateDelAllCart(params) {
	console.log(params)
    var url = "/cart/deleteAll"
    $.ajax({
        type: "POST",
        url: url,
        data: params,
        async: false,
        dataType: "json",
        success: function (result) {
        	if(result.status == 200){
        		alert("清空成功!")
        	}
        }
    })
    location.reload()
}

//购物车商品增加或创建
function doUpdateAddCart(params) {
	console.log(params)
	var url = params.shuLiang==1?"/cart/add/":"/cart/update/"
    $.ajax({
        type: "POST",
        url: url,
        data: params,
        dataType: "json"
    })
}
//查询用户购物车
function doQueryCart(params) {
	var json;
    $.ajax({
        type: "POST",
        url: "/cart/queryByUID",
        data: params,
        dataType: "json",
        // data: {caiPinId:$(dom).attr("zhi")},
        success: function (result) {
            if (result.status == 200) {
            	json = result;
                var table = document.getElementsByClassName("big")
                for (var i = 0; i < table.length; i++) {
                    var zhi = $(table[i]).closest("table").find(".big").attr("id")
                    for (var j = 0; j < result.data.length; j++) {
                        if(zhi == result.data[j].caiPinId){
                            $(table[i]).closest("table").find(".input-num").val(result.data[j].shuLiang)
                        }
                    }
                }
            }
        }
    })
    return json;
}
//查询用户购物车
function doQueryAsyncCart(params) {
	var json;
    $.ajax({
        type: "POST",
        url: "/cart/queryByUID",
        data: params,
        async: false,
        dataType: "json",
        // data: {caiPinId:$(dom).attr("zhi")},
        success: function (result) {
            if (result.status == 200) {
            	json = result;
                var table = document.getElementsByClassName("big")
                for (var i = 0; i < table.length; i++) {
                    var zhi = $(table[i]).closest("table").find(".big").attr("id")
                    for (var j = 0; j < result.data.length; j++) {
                        if(zhi == result.data[j].caiPinId){
                            $(table[i]).closest("table").find(".input-num").val(result.data[j].shuLiang)
                        }
                    }
                }
            }
        }
    })
    return json;
}

//查询菜单特殊类别
function dotebie(dom) {
    $(".flag").css("background","#FFFFFF").css("border","none");
    $(dom).css("background","#DAA31C");
    $.ajax({
        type: "GET",
        url: "/caidan/tebie/",
        data: {par:$(dom).attr("par")},
        dataType: "json",
        success: function(result) {
            if (result.status == 200) {
                // console.log(result.data)
                //调用创建tbody函数
                createTBody(result.data)
            } else
                alert("查询失败")
        }
    })
}
//创建table并按需取值和改变css样式 加入到页面中
function createTBody(data) {
    $(".canDan_li").empty()
    for(var i=0; i<data.length; i++){
        var c_table = "<table>\n" +
            "\t\t\t\t\t\t\t\t\t\t<tr>\n" +
            "\t\t\t\t\t\t\t\t\t\t\t<td rowspan=\"4\"><img src=\"http://image.jt.com/2019/06/12/de1770674af9453d91f87ea5a5402dc7.jpg\" class=\"img1\" /></td>\n" +
            "\t\t\t\t\t\t\t\t\t\t\t<td>&emsp;&emsp;&emsp;&emsp;名称：</td>\n" +
            "\t\t\t\t\t\t\t\t\t\t\t<td class=\"mc\">"+data[i].caiMing+"</td>\n" +
            "\t\t\t\t\t\t\t\t\t\t\t<td zhi='"+data[i].caiDanID+"' class='caiPin_id"+data[i].caiDanID+" caiPin_id'></td>" +
            "\t\t\t\t\t\t\t\t\t\t\t<td></td>\n" +
            "\t\t\t\t\t\t\t\t\t\t</tr>\n" +
            "\t\t\t\t\t\t\t\t\t\t<tr>\n" +
            "\t\t\t\t\t\t\t\t\t\t\t<td>&emsp;&emsp;&emsp;&emsp;月销：</td>\n" +
            "\t\t\t\t\t\t\t\t\t\t\t<td class=\"kx\">"+data[i].yueXiaoLiang+"</td>\n" +
            "\t\t\t\t\t\t\t\t\t\t\t<td></td>\n" +
            "\t\t\t\t\t\t\t\t\t\t</tr>\n" +
            "\t\t\t\t\t\t\t\t\t\t<tr>\n" +
            "\t\t\t\t\t\t\t\t\t\t\t<td>&emsp;&emsp;&emsp;&emsp;价格：</td>\n" +
            "\t\t\t\t\t\t\t\t\t\t\t<td class=\"jg\">"+data[i].youHuiJiaGe+"</td>\n" +
            "\t\t\t\t\t\t\t\t\t\t\t<td class='shiji"+data[i].caiDanID+"'><s>"+data[i].yuanJiaGe+"</s></td>\n" +
            "\t\t\t\t\t\t\t\t\t\t</tr>\n" +
            "\t\t\t\t\t\t\t\t\t\t<tr>\n" +
            "\t\t\t\t\t\t\t\t\t\t\t<td>&emsp;&emsp;&emsp;&emsp;评分：</td>\n" +
            "\t\t\t\t\t\t\t\t\t\t\t<td class=\"pf\">"+data[i].pingFen+"</td>\n" +
            "\t\t\t\t\t\t\t\t\t\t\t<td></td>\n" +
            "\t\t\t\t\t\t\t\t\t\t\t<td class=\"shuliang\">\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t<ul class=\"btn-numbox\">\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t<ul class=\"count\">\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<li><span  class=\"num-jian\" style=\"color:black;\">-</span></li>\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<li><input type=\"text\" class=\"input-num\" id=\"input-num\" value=\"0\" /></li>\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<li><span  class=\"num-jia\" style=\"color:black;\">+</span></li>\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t</ul>\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t</ul>\n" +
            "\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
            "\t\t\t\t\t\t\t\t\t\t</tr>\n" +
            "\t\t\t\t\t\t\t\t\t</table>"
        $(".canDan_li").append(c_table)/*.append("<script>doQueryCart(document.getElementsByClassName(\"caiPin_id"+data[i].caiDanID+"\"))</script>")*/
        if(data[i].zheKou == 0){
            var id = ".shiji"+data[i].caiDanID
            $(id).text("")
        }
    }
    doQueryCart()

}