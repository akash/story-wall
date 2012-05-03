<#-- @ftlvariable name="" type="com.tutorial.view.StoriesView" -->
<#include 'macros.ftl'>
<@header "Story Wall" />
<body>
    <style>
        #backlog, #inProgress, #done { list-style-type: none; margin: 0; padding: 0 0 2.5em; float: left; margin-right: 10px; }
        #backlog li, #inProgress li, #done li { margin: 0 5px 5px 5px; padding: 5px; font-size: 1.2em; width: 120px; }
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
                <li class="story" id="${story.id}">${story.name} - ${story.estimate}</li>
            </#list>
        </ul>
    </div>

    <div  class="wall-column">
        <h2 class="column-title">In Progress</h2>
        <ul id="inProgress" class="column-data">
            <#list inProgressStories as story>
                <li class="story" id="${story.id}">${story.name} - ${story.estimate}</li>
            </#list>
        </ul>
    </div>

    <div  class="wall-column">
        <h2 class="column-title">Done</h2>
        <ul id="done" class="column-data">
            <#list doneStories as story>
                <li class="story" id="${story.id}">${story.name} - ${story.estimate}</li>
            </#list>
        </ul>
    </div>

    <a href="/stories/new" style="clear:both;float:left">Add Story</a>

</body>
<@footer />