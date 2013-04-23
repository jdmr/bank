<%@ page import="bank.Account" %>

<g:hiddenField name="manager.id" value="${accountInstance.manager.id}" />

<div class="fieldcontain ${hasErrors(bean: accountInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="account.name.label" default="Name" />
		
	</label>
	<g:textField name="name" value="${accountInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: accountInstance, field: 'name', 'error')} ">
	<label for="client.id">
		Client
	</label>
	<g:select name="client.id" value="${accountInstance?.client}" from="${clients}"
              optionKey="id" optionValue="username"
        />
</div>


