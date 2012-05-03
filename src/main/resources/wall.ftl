<#-- @ftlvariable name="" type="com.tutorial.view.StoriesView" -->
<#include 'macros.ftl'>
<@header "Story Wall" />
<body>
    <style>

    </style>
	<script>
	$(function() {
		$( "#backlog, #inProgress, #done" ).sortable({
			connectWith: ".column-data",
            revert: true,
            receive: function(event, ui) {
                var uri = '/stories/' + ui.item.attr('id') + '/change-column';
                $.ajax({
                  type: 'POST',
                  url: uri,
                  data: { 'column': ui.item.parent().attr('id') },
                  success: function () { /* do something here */ },
                  error: function () { ui.sender.append(ui.item) }
                });
            }
		}).disableSelection();
	});
	</script>
    <h1>Story wall</h1>

    <#if newStory??>
        <span>Story ${newStory.name} successfully added</span>
    </#if>
    <div class="wall-column">
        <h2 class="column-title">Backlog</h2>
        <ul id="backlog" class="column-data">
            <#list backlogStories as story>
                <@story_li story />
            </#list>
        </ul>
    </div>

    <div  class="wall-column">
        <h2 class="column-title">In Progress</h2>
        <ul id="inProgress" class="column-data">
            <#list inProgressStories as story>
                <@story_li story />
            </#list>
        </ul>
    </div>

    <div  class="wall-column">
        <h2 class="column-title">Done</h2>
        <ul id="done" class="column-data">
            <#list doneStories as story>
                <@story_li story />
            </#list>
        </ul>
    </div>

    <a href="/stories/new" style="clear:both;float:left">Add Story</a>

</body>
<@footer />

<#macro story_li story >
<li class="story" id="${story.id}"><span class="name">${story.name}</span><span class="estimate">(${story.estimate})</span></li>
</#macro>