$(function() {
    var gantt = $("#gantt").dxGantt({
        taskTitlePosition: "outside",
        scaleType: "months",
        tasks: {
            dataSource: tasks,
            keyExpr: "id"
        },
        dependencies: {
            dataSource: dependencies
        },
        resources: {
            dataSource: resources
        },
        resourceAssignments: {
            dataSource: resourceAssignments
        },
        editing: {
            enabled: true
        },
        columns: [{
            dataField: "title",
            caption: "Subject",
            width: 300
        }, {
            dataField: "start",
            caption: "Start Date"
        }, {
            dataField: "end",
            caption: "End Date"
        }],
        taskListWidth: 500,
        taskTooltipContentTemplate: getTaskTooltipContentTemplate
    }).dxGantt("instance");

    $("#scaleType").dxSelectBox({
        items: [
            "auto",
            "minutes",
            "hours",
            "days",
            "weeks",
            "months",
            "quarters",
            "years"
        ],
        value: "months",
        onValueChanged: function (e) {
            gantt.option("scaleType", e.value);
        }
    });

    $("#titlePosition").dxSelectBox({
        items: [
            "inside",
            "outside",
            "none"
        ],
        value: "outside",
        onValueChanged: function (e) {
            gantt.option("taskTitlePosition", e.value);
        }
    });

    $("#showResources").dxCheckBox({
        text: "Show Resources",
        value: true,
        onValueChanged: function (e) {
            gantt.option("showResources", e.value);
        }
    });

    $("#customizeTaskTooltip").dxCheckBox({
        text: "Customize Task Tooltip",
        value: true,
        onValueChanged: function (e) {
            e.value ? gantt.option("taskTooltipContentTemplate", getTaskTooltipContentTemplate)
                : gantt.option("taskTooltipContentTemplate", undefined);
        }
    });

    function getTaskTooltipContentTemplate(task, container) {
        var timeEstimate = Math.abs(task.start - task.end) / 36e5;
        var timeLeft = Math.floor((100 - task.progress) / 100 * timeEstimate);

        var $customTooltip = $(document.createElement("div"))
            .addClass("custom-task-edit-tooltip");

        $(document.createElement("div"))
            .addClass("custom-tooltip-title")
            .text(task.title)
            .appendTo($customTooltip);
        $(document.createElement("div"))
            .addClass("custom-tooltip-row")
            .text("Estimate: " + timeEstimate + " hours")
            .appendTo($customTooltip);
        $(document.createElement("div"))
            .addClass("custom-tooltip-row")
            .text("Left: " + timeLeft + " hours")
            .appendTo($customTooltip);

        return $customTooltip;
    }

});

// var tasks = [{
//     'id': 1,
//     'parentId': 0,
//     'title': 'Software Development',
//     'start': new Date('2019-02-21T05:00:00.000Z'),
//     'end': new Date('2019-07-04T12:00:00.000Z'),
//     'progress': 31
// }, {
//     'id': 2,
//     'parentId': 1,
//     'title': 'Scope',
//     'start': new Date('2019-02-21T05:00:00.000Z'),
//     'end': new Date('2019-02-26T09:00:00.000Z'),
//     'progress': 60
// }, {
//     'id': 3,
//     'parentId': 2,
//     'title': 'Determine project scope',
//     'start': new Date('2019-02-21T05:00:00.000Z'),
//     'end': new Date('2019-02-21T09:00:00.000Z'),
//     'progress': 100
// }, {
//     'id': 4,
//     'parentId': 2,
//     'title': 'Secure project sponsorship',
//     'start': new Date('2019-02-21T10:00:00.000Z'),
//     'end': new Date('2019-02-22T09:00:00.000Z'),
//     'progress': 100
// }, {
//     'id': 5,
//     'parentId': 2,
//     'title': 'Define preliminary resources',
//     'start': new Date('2019-02-22T10:00:00.000Z'),
//     'end': new Date('2019-02-25T09:00:00.000Z'),
//     'progress': 60
// }, {
//     'id': 6,
//     'parentId': 2,
//     'title': 'Secure core resources',
//     'start': new Date('2019-02-25T10:00:00.000Z'),
//     'end': new Date('2019-02-26T09:00:00.000Z'),
//     'progress': 0
// }, {
//     'id': 7,
//     'parentId': 2,
//     'title': 'Scope complete',
//     'start': new Date('2019-02-26T09:00:00.000Z'),
//     'end': new Date('2019-02-26T09:00:00.000Z'),
//     'progress': 0
// }, {
//     'id': 8,
//     'parentId': 1,
//     'title': 'Analysis/Software Requirements',
//     'start': new Date('2019-02-26T10:00:00.000Z'),
//     'end': new Date('2019-03-18T09:00:00.000Z'),
//     'progress': 80
// }, {
//     'id': 9,
//     'parentId': 8,
//     'title': 'Conduct needs analysis',
//     'start': new Date('2019-02-26T10:00:00.000Z'),
//     'end': new Date('2019-03-05T09:00:00.000Z'),
//     'progress': 100
// }, {
//     'id': 10,
//     'parentId': 8,
//     'title': 'Draft preliminary software specifications',
//     'start': new Date('2019-03-05T10:00:00.000Z'),
//     'end': new Date('2019-03-08T09:00:00.000Z'),
//     'progress': 100
// }]

var tasks [{

}]

var dependencies = [{
    'id': 1,
    'predecessorId': 3,
    'successorId': 4,
    'type': 0
}, {
    'id': 2,
    'predecessorId': 4,
    'successorId': 5,
    'type': 0
}, {
    'id': 3,
    'predecessorId': 5,
    'successorId': 6,
    'type': 0
}, {
    'id': 4,
    'predecessorId': 6,
    'successorId': 7,
    'type': 0
}, {
    'id': 5,
    'predecessorId': 7,
    'successorId': 9,
    'type': 0
}, {
    'id': 6,
    'predecessorId': 9,
    'successorId': 10,
    'type': 0
}, {
    'id': 7,
    'predecessorId': 10,
    'successorId': 11,
    'type': 0
}, {
    'id': 8,
    'predecessorId': 11,
    'successorId': 12,
    'type': 0
}, {
    'id': 9,
    'predecessorId': 12,
    'successorId': 13,
    'type': 0
}, {
    'id': 10,
    'predecessorId': 13,
    'successorId': 14,
    'type': 0
}]

var resources = [{
    'id': 1,
    'text': 'Открыто'
}, {
    'id': 2,
    'text': 'Закрыто'
}, {
    'id': 3,
    'text': 'В работе'
}, {
    'id': 4,
    'text': 'Блокировано'
}, {
    'id': 5,
    'text': 'На проверке'
}, {
    'id': 6,
    'text': 'Неактуально'
}, {
    'id': 7,
    'text': ''
}, {
    'id': 8,
    'text': ''
}]

var resourceAssignments = [{
    'id': 0,
    'taskId': 3,
    'resourceId': 1
}, {
    'id': 1,
    'taskId': 4,
    'resourceId': 1
}, {
    'id': 2,
    'taskId': 5,
    'resourceId': 2
}, {
    'id': 3,
    'taskId': 6,
    'resourceId': 2
}, {
    'id': 4,
    'taskId': 9,
    'resourceId': 3
}, {
    'id': 5,
    'taskId': 10,
    'resourceId': 3
}]


/////////////////////////////////////////////////////////////////////////////////////////////////////////////
// function getAllTasks() {
//     AJS.$.ajax({
//         type: "GET",
//         url: "/jira/rest/gantt/1.0/task/getAllTasks",
//         dataType: "json",
//         error: function (XMLHttpRequest, textStatus, errorThrown) {
//             console.log(errorThrown)
//         },
//         success: function (data) {
//             fillTableForTasks(data)
//         }
//     })
// }
//
// var resources = [{
//     'id': 1,
//     'text': 'Открыто'
// }, {
//     'id': 2,
//     'text': 'Закрыто'
// }, {
//     'id': 3,
//     'text': 'В работе'
// }, {
//     'id': 4,
//     'text': 'Блокировано'
// }, {
//     'id': 5,
//     'text': 'На проверке'
// }, {
//     'id': 6,
//     'text': 'Неактуально'
// }, {
//     'id': 7,
//     'text': ''
// }]
//
// $(function fillTableForTasks(tasks) {
//     var newData = getData(data.data, [], 0, [], -1)
//     var tasks = newData[1]
//     var resourceAssignments = newData[0]
//     var gantt = $('#gantt').dxGantt({
//         columnsAutoWidth: true,
//         contextMenu: getContextMenu(),
//         onCustomCommand: onCustomCommandClick,
//         onContextMenuPreparing: onContextMenuPreparing,
//         allowSelection: true,
//         tasks: {
//             dataSource: tasks
//         },
//         resources: {
//             dataSource: resources
//         },
//         editing: {
//             enabled: true
//         },
//         validation: {
//             autoUpdateParentTasks: true,
//             validateDependencies: true
//         },
//         toolbar: {
//             items: [
//                 "undo",
//                 "redo",
//                 "separator",
//                 "collapseAll",
//                 "expandAll",
//                 "separator",
//                 "addTask",
//                 "deleteTask",
//                 "separator",
//                 "zoomIn",
//                 "zoomOut"
//             ]
//         },
//         columns: [{
//         //     dataField: "id",
//         //     caption: "ID"
//         // }, {
//         //     dataField: "status",
//         //     caption: "Status"
//         // }, {
//             dataField: "title",
//             caption: "Name",
//             width: 300
//         }, {
//             dataField: "start",
//             caption: "Start Date",
//             // width: 300
//         }, {
//             dataField: "end",
//             caption: "End Date",
//             // width: 300
//             // }, {
//             // dataField: "author",
//             // caption: "Author"
//             // } ],
//         }],
//         scaleType: "weeks",
//         taskListWidth: 500
//     }).dxGantt('instance');
//     $("#preventContextMenuShowing").dxCheckBox({
//         text: "Prevent Context Menu Showing",
//         value: false,
//     });
//
//     function onContextMenuPreparing(e) {
//         e.cancel = $("#preventContextMenuShowing").dxCheckBox('instance').option('value');
//     }
//
//     $("#customizeContextMenu").dxCheckBox({
//         text: 'Customize Context Menu',
//         value: true,
//         onValueChanged: function(e) {
//             var items = e.value ? getContextMenuItems() : undefined;
//             gantt.option("contextMenu.items", items);
//         }
//     });
//
//     function onCustomCommandClick(e) {
//         if(e.name == 'ToggleDisplayOfResources') {
//             var showResources = gantt.option("showResources");
//             gantt.option("showResources", !showResources);
//         }
//     }
//
//     function getContextMenu() {
//         return {
//             enabled: true,
//             items: getContextMenuItems()
//         }
//     }
//
//     function getContextMenuItems() {
//         return [
//             'addTask',
//             'taskDetails',
//             'deleteTask',
//             {
//                 name: 'ToggleDisplayOfResources',
//                 text: 'Toggle Display of Resources'
//             }
//         ]
//     }
// });
//
// function getData(data, resourceAssignments, counter, tasks, parentId) {
//     for (var item in data) {
//         var now = new Date()
//         var afterWeek = new Date()
//         var startDate = now;
//         var endDate = afterWeek;
//         if (data[item].startDate === "" && data[item].endDate !== "") {
//             endDate.setTime(new Date(data[item].endDate))
//             startDate.setTime(endDate.getTime() - 7)
//         }
//         if (data[item].startDate !== "" && data[item].endDate !== "") {
//             endDate.setTime(new Date(data[item].endDate))
//             startDate.setTime(new Date(data[item].startDate))
//         }
//         if (data[item].startDate !== "" && data[item].endDate === "") {
//             startDate.setTime(new Date(data[item].startDate))
//             endDate.setTime(startDate.getTime() + 7)
//         }
//         afterWeek.setDate(afterWeek.getDate() + 7)
//         if (tasks.length === 100)
//             return [resourceAssignments, tasks]
//         tasks.push({
//             'id': data[item].id,
//             'parentId': parentId,
//             'title': data[item].title,
//             'start': startDate,
//             'end': endDate,
//             'progress': data[item].progress ? "0" : data[item].progress
//         })
//         var resourceId = 7;
//         if (data[item].status === "Открыто")
//             resourceId = 1
//         else if (data[item].status === "Закрыто")
//             resourceId = 2
//         else if (data[item].status === "В работе")
//             resourceId = 3
//         else if (data[item].status === "Блокировано")
//             resourceId = 4
//         else if (data[item].status === "На проверке")
//             resourceId = 5
//         else if (data[item].status === "Неактуально")
//             resourceId = 6
//
//         resourceAssignments.push({
//             'id': data[item].id,
//             'taskId': data[item].id,
//             'resourceId': resourceId
//         })
//         var creatingData = getData(data[item].childs, resourceAssignments, counter, tasks, data[item].id);
//     }
//     return creatingData
// }



////какой-то код
// You can create the Gantt widget using the following code.
// Read more at https://js.devexpress.com/Documentation/Guide/Widgets/Common/Advanced/3rd-Party_Frameworks_Integration_API/#Create_and_Configure_a_Widget.



///////код вики
// var resources = [{
//     'id': 1,
//     'text': 'Открыто'
// }, {
//     'id': 2,
//     'text': 'Закрыто'
// }, {
//     'id': 3,
//     'text': 'В работе'
// }, {
//     'id': 4,
//     'text': 'Блокировано'
// }, {
//     'id': 5,
//     'text': 'На проверке'
// }, {
//     'id': 6,
//     'text': 'Неактуально'
// }, {
//     'id': 7,
//     'text': ''
// }]
//
// jQuery.ajax({
//     dataType: "json",
//     type: 'get',
//     url: AJS.contextPath() + '/rest/gantt/1.0/task/getAllTasks',
//     async:false
// }).done(function(data){
//
//     var newData = getData(data.data, [], 0, [], -1)
//     var tasks = newData[1]
//     var resourceAssignments = newData[0]
//
//     var gantt = $("#gantt").dxGantt({
//         tasks: {
//             dataSource: tasks
//         },
//         resources: {
//             dataSource: resources
//         },
//         resourceAssignments: {
//             dataSource: resourceAssignments
//         },
//         validation: {
//             autoUpdateParentTasks: true
//         },
//         loadPanel: {
//             enabled: true
//         },
//         toolbar: {
//             items: [
//                 "undo",
//                 "redo",
//                 "separator",
//                 "collapseAll",
//                 "expandAll",
//                 "separator",
//                 "separator",
//                 "zoomIn",
//                 "zoomOut"
//             ]
//         },
//         columns: [{
//             dataField: "title",
//             caption: "Название",
//             width: 300
//         }, {
//             dataField: "start",
//             caption: "Дата начала"
//         }, {
//             dataField: "end",
//             caption: "Срок Исполнения"
//         }],
//         scaleType: "weeks",
//         taskListWidth: 600
//     });
//     $(document.querySelectorAll('.dx-treelist-text-content').forEach(function(item){$(item).html($(item).text())}))
// // })
// });
//
// function getData(data, resourceAssignments, counter, tasks, parentId) {
//     for (var item in data) {
//         var now = new Date()
//         var afterWeek = new Date()
//         var startDate = now;
//         var endDate = afterWeek;
//         if (data[item].startDate == "" && data[item].endDate != "") {
//             endDate.setTime(new Date(data[item].endDate))
//             startDate.setTime(endDate.getTime() - 7)
//         }
//         if (data[item].startDate != "" && data[item].endDate != "") {
//             endDate.setTime(new Date(data[item].endDate))
//             startDate.setTime(new Date(data[item].startDate))
//         }
//         if (data[item].startDate != "" && data[item].endDate == "") {
//             startDate.setTime(new Date(data[item].startDate))
//             endDate.setTime(startDate.getTime() + 7)
//         }
//         afterWeek.setDate(afterWeek.getDate() + 7)
//         if (tasks.length === 100)
//             return [resourceAssignments, tasks]
//         tasks.push({
//             'id': data[item].id,
//             'parentId': parentId,
//             'title': data[item].title,
//             'start': startDate,
//             'end': endDate,
//             'progress': data[item].progress ? "0" : data[item].progress
//         })
//         var resourceId = 7;
//         if (data[item].status === "Открыто")
//             resourceId = 1
//         else if (data[item].status === "Закрыто")
//             resourceId = 2
//         else if (data[item].status === "В работе")
//             resourceId = 3
//         else if (data[item].status === "Блокировано")
//             resourceId = 4
//         else if (data[item].status === "На проверке")
//             resourceId = 5
//         else if (data[item].status === "Неактуально")
//             resourceId = 6
//
//         resourceAssignments.push({
//             'id': data[item].id,
//             'taskId': data[item].id,
//             'resourceId': resourceId
//         })
//         var creatingData = getData(data[item].childs, resourceAssignments, counter, tasks, data[item].id);
//     }
//     return creatingData
// }