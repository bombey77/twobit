<#import "parts/common.ftlh" as c>
<#import  "parts/login.ftlh" as l>

<@c.page>
    <div><a href="/login">Log In</a></div>
    <@l.logout />
    <form method="post">
        <input type="text" name="message" placeholder="Input Message"/>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <button type="submit">Send</button>
    </form>
    <form method="get">
        <input type="text" name="message" value="${filter?ifExists}" placeholder="Find By Message"/>
        <button type="submit">Find</button>
    </form>
    <div><b>Message List:</b></div>
    <#list messages as message>
        <div>
            ${message.id}
            ${message.message}
            ${message.userInfo}
        </div>
    <#else>
        <div><b>No messages</b></div>
    </#list>
</@c.page>
