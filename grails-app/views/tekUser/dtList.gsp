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
    $(document).ready(function() {
        $('#dt').DataTable({
            sScrollY: "75%",
            sScrollX: "100%",
            bProcessing: true,
            bServerSide: true,
            sAjaxSource: "/<webapp>/<controller>/dataTablesRenderer",
            bJQueryUI: false,
            bAutoWidth: false,
            sPaginationType: "full_numbers",
            aLengthMenu: [[10, 25, 50, 100, 200], [10, 25, 50, 100, 200]],
            iDisplayLength: 10,
            aoColumnDefs: [{
                createdCell: function ( td, cellData, rowData, row, col) {
                    $(td).attr('style','text-align: center;');
                },
                render: function ( data, type, full, meta ) {
                    if (data) {
                        return '<a href="edit/' + data + '" class="btn">Edit</a>';
                    } else {
                        return "";
                    }
                },
                aTargets: [<index of rendered field>]
                        }]
                        });
                        });
</g:javascript>
  </head>
<body>
<table class="display compact" id="dt">
    <thead>
    <tr>
        <th>field1</th>
        <th>...</th>
        <th>fieldn</th>
    </tr>
    </thead>
    <tbody></tbody>
    <tfoot>
    <tr>
        <th>field1</th>
        <th>...</th>
        <th>fieldn</th>
    </tr>
    </tfoot>
</table>
</body>
</html>
