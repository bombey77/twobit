<#macro login path>
    <form action="${path}" method="post">
        <div><label> Email: <input type="text" name="username"></input> </label></div>
        <div><label> Password: <input type="password" name="password"/> </label></div>
        <input type="hidden" name="_csrf" value="${_csrf.token}"></input>
        <div><input type="submit" value="Sign In"/></div>
    </form>
</#macro>

<#macro logout>
    <form method="post" action="/logout">
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <button type="submit">Sign Out</button>
    </form>
</#macro>
