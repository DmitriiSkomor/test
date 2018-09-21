<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <title>Part Info</title>
</head>
<body>
<h1>About detail</h1>
<table>
    <tr>
        <td>Id</td>
        <td>${part.id}</td>
    </tr>
    <tr>
        <td>Name</td>
        <td>${part.name}</td>
    </tr>
    <tr>
        <td>Count</td>
        <td><!--></td>
    </tr>
    <tr>
        <#if part.required == 1>
        <td><b>REQUIRED</b></td>
        <#else >
        <td>NOT required</td>
        </#if>
        <td><!--></td>
    </tr>
</table>

<br>
<a href="/parts?page=${page}&requiredFilter=${requiredFilter}">Back</a>
</body>
</html>