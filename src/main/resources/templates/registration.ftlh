<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Spring Security Example</title>
</head>
<body>
<p>Registration page</p>
<div>${message?ifExists}</div>
<form action="/registration" method="post">
    <div><label> Email : <input type="text" name="email"/> </label></div>
    <div><label> Password: <input type="password" name="password"/> </label></div>
    <div><label> Confirm: <input type="password" name="confirmPassword"/> </label></div>
    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    <div><input type="submit" value="Sign Up"/></div>
</form>
</body>
</html>
