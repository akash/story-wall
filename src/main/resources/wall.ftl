<#-- @ftlvariable name="" type="com.tutorial.view.StoriesView" -->
<#include 'macros.ftl'>
<@header "Story Wall" />
<body>
    <h1>Story wall awesome</h1>

    <#if newStory??>
        <span>Congrats you've created a story - ${newStory.title}</span>
    </#if>
    <div class="wall-column">
        <h2 class="column-title">Backlog</h2>
        <ul id="backlog" class="column-data">

        </ul>
    </div>

    <div  class="wall-column">
        <h2 class="column-title">In Progress</h2>
        <ul id="inProgress" class="column-data">

        </ul>
    </div>

    <div  class="wall-column">
        <h2 class="column-title">Done</h2>
        <ul id="done" class="column-data">

        </ul>
    </div>

    <a href="/stories/new" style="clear:both;float:left">Add Story</a>

</body>
<@footer />