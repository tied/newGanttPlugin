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
//     url: AJS.contextPath() + '/rest/pps2/1.0/tablereport/get',
//     async:false
// }).done(function(data) {
//
//     var newData = getData(data.data, [], 0, [], -1)
//     var tasks = newData[1]
//     var resourceAssignments = newData[0]
//
//     $("#structure-gantt").dxGantt({
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
//     $(document.querySelectorAll('.dx-treelist-text-content').forEach(function (item) {
//         $(item).html($(item).text())
//     }))
// })
// };
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
//
// // console.log("test from js")
// new DevExpress.ui.dxGantt(document.getElementById("gantt"), {
//     "columns": [
//         "title"
//     ],
//     "taskListWidth": 140,
//     "tasks": {
//         "dataSource": [
//             {
//                 "id": 1,
//                 "title": "Market Analysis",
//                 "start": "2019-01-05",
//                 "end": "2019-01-13",
//                 "progress": 100
//             },
//             {
//                 "id": 2,
//                 "title": "Feature Planning",
//                 "start": "2019-01-13",
//                 "end": "2019-02-02",
//                 "progress": 100
//             },
//             {
//                 "id": 3,
//                 "title": "Implementation",
//                 "start": "2019-02-02",
//                 "end": "2019-03-21",
//                 "progress": 35
//             },
//             {
//                 "id": 4,
//                 "title": "Demos",
//                 "start": "2019-02-28",
//                 "end": "2019-03-21",
//                 "progress": 0
//             },
//             {
//                 "id": 5,
//                 "title": "Docs",
//                 "start": "2019-02-28",
//                 "end": "2019-03-21",
//                 "progress": 0
//             },
//             {
//                 "id": 6,
//                 "title": "Testing",
//                 "start": "2019-03-21",
//                 "end": "2019-04-05",
//                 "progress": 0
//             },
//             {
//                 "id": 7,
//                 "title": "Bug Fixing",
//                 "start": "2019-03-21",
//                 "end": "2019-04-15",
//                 "progress": 0
//             },
//             {
//                 "id": 8,
//                 "title": "Feature Release",
//                 "start": "2019-04-15",
//                 "end": "2019-04-15"
//             }
//         ]
//     }
// });

function aaa(){console.log(2)}
$(function() {
    $("#gantt").dxGantt({
        tasks: {
            dataSource: tasks
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
        validation: {
            autoUpdateParentTasks: true
        },
        toolbar: {
            items: [
                "undo",
                "redo",
                "separator",
                "collapseAll",
                "expandAll",
                "separator",
                "addTask",
                "deleteTask",
                "separator",
                "zoomIn",
                "zoomOut"
            ]
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
        scaleType: "weeks",
        taskListWidth: 500
    });
});
