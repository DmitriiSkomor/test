<#--<#macro page>-->
<!DOCTYPE html >
<html lang="ru">

<head>

    <meta charset="utf-8">

    <title>Header</title>
    <meta name="description" content="">

    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <#--<mvc:resources mapping="/resources/**" location="/resources" />-->

    <link rel="stylesheet" type="text/css" href="css/main.min.css">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <#--<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">-->


</head>
<body>
<#--<#nested>-->
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
<div class="container">
<div class="create">
    <h1>Parts list</h1>
    <form action="search" method="get">

        <input title="Search" type="text" name="searchName" placeholder="Search...">
        <input type="submit" value="OK">
    </form>
    <table class="blueTable">
        <thead>
        <tr>
            <th><a href="/parts?page=${page}"> All </a></th>
            <th><a href="parts?requiredFilter=1&page=${page}">Required </a></th>
            <th><a href="parts?requiredFilter=0&page=${page}">Optional</a></th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <th>Name</th>
            <th>Required?</th>
            <th>Count</th>

        </tr>
			    <#list parts as part>
			    <tr>

                    <td>${part.name}</td>

			       <#if part.required == 1>
			        <td><b>Yes</b></td>
                   <#else >
			        <td><b>No</b></td>
                   </#if>
                    <td>${part.count}</td>

                    <td class="add"><a href="update/${part.id}?page=${page}&requiredFilter=${requiredFilter}">Edit</a></td>
                    <td class="add"><a href="delete/${part.id}?page=${page}&requiredFilter=${requiredFilter}">Remove</a></td>
                </tr>
                </#list>
        <tfoot>
        <tr>
            <td colspan="3">
                You can create: ${computers} computers</div>
</div>
</td>
</tr>
</tfoot>
</tbody>
</table>

<a class="back" href="addPart?page=${page}&requiredFilter=${requiredFilter}">Add</a>
<a class="back" href="/parts?page=${page-1}&requiredFilter=${requiredFilter}">Back</a>
<a class="back" href="/parts?page=${page+1}&requiredFilter=${requiredFilter}">Next</a>
</form>
</body>
</div>
</html>
<#--</#macro>-->