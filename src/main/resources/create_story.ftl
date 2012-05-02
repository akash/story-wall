<#-- @ftlvariable name="" type="com.tutorial.view.CreateStoryView" -->
<html>
<head>
    <link href="http://localhost:8080/assets/default.css" rel="stylesheet" type="text/css"/>
</head>
<body>

    <h1>Create Story</h1>

    <form action="/stories/new" method="POST">
        <label for="story_name">Name:</label><input id="story_name" type="text" />
        <label for="story_estimate">Estimate:</label><input id="story_estimate" type="text" />
        <input type="submit" title="Submit" />
    </form>

</body>
</html>