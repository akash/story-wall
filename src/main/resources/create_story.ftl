<#-- @ftlvariable name="" type="com.tutorial.view.CreateStoryView" -->
<#include 'macros.ftl'>
<@header "Create Story" />
<body>

    <h1>Create Story</h1>

    <form action="/stories/new" method="POST">
        <label for="story_name">Name:</label><input id="story_name" type="text" name="story_name"/>
        <label for="story_estimate">Estimate:</label><input id="story_estimate" type="text" name="story_estimate"/>
        <input type="submit" value="Submit" />
    </form>

</body>
<@footer />