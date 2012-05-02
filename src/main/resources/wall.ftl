<#-- @ftlvariable name="" type="com.tutorial.view.StoriesView" -->
<#include 'macros.ftl'>
<@header "Create Story" />
<body>

    <h1>Story wall</h1>

    <#if newStory??>
        <span>Story ${newStory.name} successfully added</span>
    </#if>
    <div class="wall-column">
        <h2 class="column-title">Backlog</h2>
        <div class="column-data">
            <#list stories as story>
                <div class="story"><span>${story.name} - ${story.estimate}</span></div>
            </#list>
        </div>
    </div>

    <div class="wall-column">
        <h2 class="column-title">In Progress</h2>
        <div class="column-data">

        </div>
    </div>

    <div class="wall-column">
        <h2 class="column-title">Done</h2>
        <div class="column-data">

        </div>
    </div>

    <a href="/stories/new" style="clear:both;float:left">Add Story</a>

</body>
<@footer />