<#-- @ftlvariable name="" type="com.tutorial.view.StoriesView" -->
<#include 'macros.ftl'>
<@header "Story Wall" />
<body>
<script>
$(function() {
	$( "#backlog, #inProgress, #done" ).sortable({
		connectWith: ".column-data",
           revert: true,
           receive: function(event, ui) {
               var uri = '/stories/' + ui.item.attr('id') + '/change-column';
               // /stories/{id}/change-column  @PathParam("id") String id
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


<h1>Story wall awesome</h1>

<#if newStory??>
<span>Congrats you've created a story - ${newStory.title}</span>
</#if>
<div class="wall-column">
    <h2 class="column-title">Backlog</h2>
    <ul id="backlog" class="column-data">
    <#list backlogStories as story>
                <@story_li story />
            </#list>
    </ul>
</div>

<div class="wall-column">
    <h2 class="column-title">In Progress</h2>
    <ul id="inProgress" class="column-data">

    </ul>
</div>

<div class="wall-column">
    <h2 class="column-title">Done</h2>
    <ul id="done" class="column-data">

    </ul>
</div>

<a href="/stories/new" style="clear:both;float:left">Add Story</a>

</body>
<@footer />

<#macro story_li story>
<li>
    <span class="name">${story.title!"hello"}</span>
    <span class="estimate">(${story.estimate})</span>
</li>
</#macro>