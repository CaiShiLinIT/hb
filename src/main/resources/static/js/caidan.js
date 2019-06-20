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
//查询菜单特殊类别
function dotebie(dom) {
    $(".flag").css("background","#FFFFFF").css("border","none");
    $(dom).css("background","#DAA31C")
    $.ajax({
        type: "GET",
        url: "/caidan/tebie/",
        data: {par:$(dom).attr("par")},
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
//创建table并按需取值和改变css样式 加入到页面中
function createTBody(data) {
    $(".canDan_li").empty()
    for(var i=0; i<data.length; i++){
        var c_table = "<table>\n" +
            "\t\t\t\t\t\t\t\t\t\t<tr>\n" +
            "\t\t\t\t\t\t\t\t\t\t\t<td rowspan=\"4\"><img src=\"http://image.jt.com/2019/06/12/de1770674af9453d91f87ea5a5402dc7.jpg\" class=\"img1\" /></td>\n" +
            "\t\t\t\t\t\t\t\t\t\t\t<td>&emsp;&emsp;&emsp;&emsp;名称：</td>\n" +
            "\t\t\t\t\t\t\t\t\t\t\t<td class=\"mc\">"+data[i].caiMing+"</td>\n" +
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
            "\t\t\t\t\t\t\t\t\t\t\t<td class='youHui'></td>\n" +
            "\t\t\t\t\t\t\t\t\t\t</tr>\n" +
            "\t\t\t\t\t\t\t\t\t\t<tr>\n" +
            "\t\t\t\t\t\t\t\t\t\t\t<td>&emsp;&emsp;&emsp;&emsp;评分：</td>\n" +
            "\t\t\t\t\t\t\t\t\t\t\t<td class=\"pf\">"+data[i].pingFen+"</td>\n" +
            "\t\t\t\t\t\t\t\t\t\t\t<td></td>\n" +
            "\t\t\t\t\t\t\t\t\t\t\t<td class=\"shuliang\">\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t<ul class=\"btn-numbox\">\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t<ul class=\"count\">\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<li><span id=\"num-jian\" class=\"num-jian\" style=\"color:black;\">-</span></li>\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<li><input type=\"text\" class=\"input-num\" id=\"input-num\" value=\"0\" /></li>\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t\t<li><span id=\"num-jia\" class=\"num-jia\" style=\"color:black;\">+</span></li>\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t</ul>\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t</ul>\n" +
            "\t\t\t\t\t\t\t\t\t\t\t</td>\n" +
            "\t\t\t\t\t\t\t\t\t\t</tr>\n" +
            "\t\t\t\t\t\t\t\t\t</table>"
        $(".canDan_li").append(c_table)
        if(data[i].zheKou == 1){
            $(".youHui").text(data[i].yuanJiaGe).css("text-decoration","line-through")
        }
    }

}