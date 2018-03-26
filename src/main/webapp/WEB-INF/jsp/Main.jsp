<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@include file="common/tag.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@include file="common/head.jsp"%>
	<title>主页面</title>
</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">自动化捞取工具首页</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
            <li><a href="#">设置</a></li>
            <li><a href="#">个人资料</a></li>
            <li><a href="http://wiki.qiyi.domain/pages/viewpage.action?pageId=163179038">帮助</a></li>
          </ul>
          <form class="navbar-form navbar-right">
            <input type="text" class="form-control" placeholder="Search...">
          </form>
        </div>
      </div>
    </nav>

    <div class="container-fluid">
      <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
          <ul class="nav nav-sidebar">
            <li><a href="#">概览 <span class="sr-only">(current)</span></a></li>
            <li class="active"><a href="#" id="crash" onClick="show();">崩溃率</a></li>
            <li><a id="success" href="#" onClick="show1();">播放成功率</a></li>
            <li><a id="error" href="#" onClick="show2();">错误率</a></li>
          </ul>
          <ul class="nav nav-sidebar">
            <li><a href="">Nav item</a></li>
            <li><a href="">Nav item again</a></li>
            <li><a href="">One more nav</a></li>
            <li><a href="">Another nav item</a></li>
            <li><a href="">More navigation</a></li>
          </ul>
          <ul class="nav nav-sidebar">
            <li><a href="">Nav item again</a></li>
            <li><a href="">One more nav</a></li>
            <li><a href="">Another nav item</a></li>
          </ul>
        </div>
        
        <div class="row placeholders">
        <!-- 主要配置 -->
        <div id="content" style="display:none" class="col-xs-6 col-sm-9 placeholder">
          <h1 class="page-header">配置</h1>
          <!-- 收件人 -->
          <div class="row placeholders">
            <div class="col-xs-6 col-sm-3 placeholder">
              <label>发件人</label>
              <input id="to" type="text" class="form-control" placeholder="收件人">
            </div>
            <!-- 抄送人 -->
            <div class="col-xs-6 col-sm-3 placeholder">
              <label>抄送人</label>
              <input id="cc" type="text" class="form-control" placeholder="抄送人">
            </div>
            <!-- 邮件主题 -->
            <div class="col-xs-6 col-sm-3 placeholder">
              <label>邮件主题</label>
              <input id="subject" type="text" class="form-control" placeholder="邮件主题">
            </div>
          </div>
        </div>
        
        <!-- 必要配置 -->
        <!-- 日期 -->
        <div id="content1" style="display:none" class="col-xs-6 col-sm-9 placeholder">
          <h1 class="page-header">必要配置(不能为空)</h1>
          <div class="row placeholders">
            <div class="col-xs-6 col-sm-3 placeholder">
              <h4>日期</h4>
              <input id="date" type="text" class="form-control" placeholder="日期"> 
              <div class="btn-group">
              	<button type="button" class="btn btn-default dropdown-toggle" 
					data-toggle="dropdown">
						类型<span class="caret"></span>
				</button>
				<ul class="dropdown-menu" role="menu">
					<li>date</li>
					<li>null</li>
				</ul>
              </div>
            </div>
            <!-- 版本 -->
            <div class="col-xs-6 col-sm-3 placeholder">
              <h4>版本</h4>
              <input id="版本" type="text" class="form-control" placeholder="版本">             
              <div class="btn-group">
              	<button type="button" class="btn btn-default dropdown-toggle" 
					data-toggle="dropdown">
						类型<span class="caret"></span>
				</button>
				<ul class="dropdown-menu" role="menu">
					<li>date</li>
					<li>null</li>
				</ul>
              </div>
            </div>
            <!-- 渠道 -->
            <div class="col-xs-6 col-sm-3 placeholder">
              <h4>渠道</h4>
              <input id="subject" type="text" class="form-control" placeholder="渠道">
              <div class="btn-group">
              	<button type="button" class="btn btn-default dropdown-toggle" 
					data-toggle="dropdown">
						类型<span class="caret"></span>
				</button>
				<ul class="dropdown-menu" role="menu">
					<li>date</li>
					<li>null</li>
				</ul>
              </div>
            </div>
          </div>
        </div>
        <div id="content2"  style="display:none" class="col-xs-6 col-sm-9 placeholder">
        	<h1 class="page-header"></h1>
        	<button id="submit" type="button" class="btn btn-primary">提交</button>
        </div>
       </div>   
      </div>
    </div>
</body>
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<!-- jQuery cookie操作插件 -->
<script src="//cdn.bootcss.com/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>
<script type="text/javascript">
	var name1,name2,name3,command;
	
	function show(){
		command="-qc";
		document.getElementById("content").style.display="";
		document.getElementById("content1").style.display="";
		document.getElementById("content2").style.display="";
	}
	
	function show1(){
		command="-qfs";
		document.getElementById("content").style.display="";
		document.getElementById("content1").style.display="";
		document.getElementById("content2").style.display="";
	}
	
	function show2(){
		command="-qe"
		document.getElementById("content").style.display="";
		document.getElementById("content1").style.display="";
		document.getElementById("content2").style.display="";
	}
	
	
	$("#submit").click(function(){
		var arr=new Array();
		arr.push("1");
		arr.push("2");
		alert(command);
		$.ajax({
            url : "/mytool/visual/execution",
            type : "POST",
            dataType : "json",
            contentType : "application/json;charset=UTF-8",
            data : JSON.stringify({
                date : JSON.stringify(arr),
                version : $("#version").val(),
                subject:$("#subject").val(),
                to:$("#to").val(),
                cc:$("#cc").val(),
                command : command
            }),
            success : function(result) {
                alert(JSON.stringify(result));
         		
            },
            error:function(result){
                alert("Sorry,you are make a error!");
            }
        });	
	});
</script>
</html>