<#-- @ftlvariable name="" type="com.tutorial.view.EstimateView" -->
<#include 'macros.ftl'>
<@header "Estimate Wall" />
<body>
    <h1>Estimate Wall</h1>

    <div class="wall-column">
        <form action="/stories/new" method="post">
            <label for="title">Title</label>
            <input type="text" id="title" name="title"/><br/>
            <label for="estimate">Estimate</label>
            <input type="text" id="estimate" name="estimate"/> <br/>
            <input type="submit" value="submit" />
        </form>
    </div>

</body>
<@footer />