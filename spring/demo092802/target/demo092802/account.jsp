<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>账户操作</title>
</head>
<body>
<!-- bean对象的参数绑定-->
<form method="post" action="account/saveAccount">
    名称：<input type="text" name="name"><br>
    金额：<input type="text" name="money"><br>
    <input type="submit" value="提交">
</form>
<hr/>
<!-- 基本类型的参数绑定 -->
<a href="account/findAccountById01?id=10">点我查询账户Id01</a>
<hr/>
<!-- 限定请求headers param -->
<a href="account/findAccountById02?id=10">点我查询账户Id02</a>
<hr/>
<!--复杂bean对象的参数绑定 -->
<form action="account/saveAccount02" method="post">
    用户名称：<input type="text" name="userName"><br/>
    用户年龄：<input type="text" name="age"><br/>
    账户1_名称：<input type="text" name="accountList[0].name"><br/>
    账户1_金额：<input type="text" name="accountList[0].money"><br/>
    账户2_名称：<input type="text" name="accountList[1].name"><br/>
    账户2_金额：<input type="text" name="accountList[1].money"><br/>
    <input type="submit" value="提交">
</form>
<hr/>
<!-- 传递日期类型参数，自定义参数转换器 -->
<a href="account/findAccountById03?userName=kenny&age=12&birthday=2020-09-30">点我查询账户Id03</a>
<hr/>
</body>
</html>

