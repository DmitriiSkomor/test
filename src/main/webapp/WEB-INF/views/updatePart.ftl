<html lang="en">
<head>

    <meta charset="utf-8">

    <title>Add part</title>
    <meta name="description" content="">

    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

 <link rel="stylesheet" type="text/css" href="/css/update.min.css">

</head>
<body>
<div class="create">
    <form name="part" action="${part.id}?page=${page}&requiredFilter=${requiredFilter}" method="post">
        <p>Name</p>
        <input title="Name" type="text" name="name" value="${part.name}">
        <p>Count</p>
        <input title="Count" type="text" name="count" value="${part.count}">
        <p>Required?</p>
        <ul>
            <li class="radio_div">
                <input type="radio" name="required" value="1"> Yes<br>
            </li>
            <li class="radio_div">
                <input type="radio" name="required" value="0" checked="checked"> No<br>
            </li>
        </ul>
        <input type="submit" value="OK">
    </form>
    <a href="/parts?page=${page}&requiredFilter=${requiredFilter}" class="back">Back</a>
</div>

</body>
</html>