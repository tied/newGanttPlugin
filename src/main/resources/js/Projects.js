function getAllProjects() {
    AJS.$.ajax({
        type: "GET",
        url: "/jira/rest/gantt/1.0/project/getAllProjects",
        dataType: "json",
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            console.log(errorThrown)
        },
        success: function (data) {
            fillTableForProjects(data)
        }
    })
}

function fillTableForProjects(projects) {
    var dataGrid = $("#gridContainer-projects").dxDataGrid({
        dataSource: projects,
        columnsAutoWidth: true,
        showBorders: true,
        // focusedRowEnabled: true,
        // focusedRowKey: 1,
        filterRow: {
            visible: true,
            applyFilter: "auto"
        },
        // searchPanel: {
        //     visible: false,
        //     width: 240,
        //     placeholder: "Поиск..."
        // },
        // headerFilter: {
        //     visible: true
        // },
        onRowPrepared: function (e) {
            if (e.rowType === "data" && e.rowIndex % 2 === 0) {
                e.rowElement.css("background-color", "#bfbfbf58");
            }
        },
        columns: [
            {
                caption: "ID проекта",
                dataField: "id",
                width: 80,
                allowHeaderFiltering: true,
                allowSearch: false
            }, {
                caption: "Название проекта",
                dataField: "name",
                allowHeaderFiltering: false,
                headerFilter: {
                    allowSearch: true
                }
            }, {
                caption: "Описание",
                dataField: "description",
                width: 200,
                headerFilter: {
                    allowSearch: false
                }
            },
            {
                type: "buttons",
                buttons: [{
                    text: "Подробнее",
                    onClick: function (e) {
                        var projectId = e.row.data.id
                        window.location.href = '/jira/projects/projectId/issues'; //id=' + bookId;
                    }
                }]
            }
        ]
    }).dxDataGrid('instance');


    // console.log(tasks)
    // console.log(books1)

    var applyFilterTypes = [{
        key: "auto",
        name: "Immediately"
    }, {
        key: "onClick",
        name: "On Button Click"
    }];

    var applyFilterModeEditor = $("#useFilterApplyButton").dxSelectBox({
        items: applyFilterTypes,
        value: applyFilterTypes[0].key,
        valueExpr: "key",
        displayExpr: "name",
        onValueChanged: function (data) {
            dataGrid.option("filterRow.applyFilter", data.value);
        }
    }).dxSelectBox("instance");

    // $("#filterRow").dxCheckBox({
    //     text: "Filter Row",
    //     value: true,
    //     onValueChanged: function (data) {
    //         dataGrid.clearFilter();
    //         dataGrid.option("filterRow.visible", data.value);
    //         applyFilterModeEditor.option("disabled", !data.value);
    //     }
    // });
    //
    // $("#headerFilter").dxCheckBox({
    //     text: "Header Filter",
    //     value: true,
    //     onValueChanged: function (data) {
    //         dataGrid.clearFilter();
    //         dataGrid.option("headerFilter.visible", data.value);
    //     }
    // });
}