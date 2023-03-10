<%--
  Created by IntelliJ IDEA.
  User: sofs6
  Date: 09.03.23
  Time: 13:34
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
  <head>
     <meta name="layout" content="main">
<g:set var="entityName" value="${message(code: 'book.label', default: 'Book')}" />
<title><g:message code="default.list.label" args="[entityName]" /></title>
<g:javascript>

			$(document).ready(function () {
				$('#dt').DataTable({
					sScrollY: "75%",
					sScrollX: "100%",
					bProcessing: true,
					bServerSide: true,
					sAjaxSource: "/TekDays/tekEvent/dataTablesRenderer",
					bJQueryUI: false,
					bAutoWidth: false,
					sPaginationType: "full_numbers",
					aLengthMenu: [5, 10, 25, 50, 100, 200],
					iDisplayLength: 10,
					aoColumnDefs: [
						{
							// bSearchable: false,
							render: function (data, type, full, meta) {
								if (full) {
									return '<a href="${createLink(controller: 'TekEvent', action: 'show')}/' + full[0] + '"class="btn">' + data + '</a>';
								} else {
									return data;
								}
							},
							aTargets: [0]
						},
						{
							createdCell: function (td, cellData, rowData, row, col) {
								// console.log(td)
								// console.log(cellData)
								// console.log(rowData)
								// console.log(row)
								// console.log(col)
								$(td).attr('style', 'color: #071C76;');
							},
							// bSearchable: false,
							bSortable: false,
							visible: true,
							aTargets: [1, 2,3]
						}
					]
				});
			});

</g:javascript>
  </head>
<body>
<table class="table-bordered" id="dt">



    <thead>
    <tr>
        <th>name</th>
        <th>city</th>
        <th>organizer</th>
        <th>venue</th>
        <th>startDate</th>
        <th>endDate</th>
    </tr>
    </thead>
</table>
</body>
</html>
