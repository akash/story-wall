<#-- @ftlvariable name="" type="com.tutorial.view.StoriesView" -->
<#include 'macros.ftl'>
<@header "Story Wall" />
<body>
    <style>
        #sortable1, #sortable2, #sortable3 { list-style-type: none; margin: 0; padding: 0 0 2.5em; float: left; margin-right: 10px; }
        #sortable1 li, #sortable2 li, #sortable3 li { margin: 0 5px 5px 5px; padding: 5px; font-size: 1.2em; width: 120px; }
    </style>
	<script>
	$(function() {
		$( "#sortable1, #sortable2, #sortable3" ).sortable({
			connectWith: ".column-data"
		}).disableSelection();
	});
	</script>
    <h1>Story wall</h1>

    <#if newStory??>
        <span>Story ${newStory.name} successfully added</span>
    </#if>
    <div class="wall-column">
        <h2 class="column-title">Backlog</h2>
        <ul id="sortable1" class="column-data">
            <#list stories as story>
                <li class="story"><span>${story.name} - ${story.estimate}</span></li>
            </#list>
        </ul>
    </div>

    <div  class="wall-column">
        <h2 class="column-title">In Progress</h2>
        <ul id="sortable2" class="column-data">
        <#list stories as story>
            <li class="story"><span>${story.name} - ${story.estimate}</span></li>
        </#list>
        </ul>
    </div>

    <div  class="wall-column">
        <h2 class="column-title">Done</h2>
        <ul id="sortable3" class="column-data">
        <#list stories as story>
            <li class="story"><span>${story.name} - ${story.estimate}</span></li>
        </#list>
        </ul>
    </div>

    <a href="/stories/new" style="clear:both;float:left">Add Story</a>

</body>
<@footer />