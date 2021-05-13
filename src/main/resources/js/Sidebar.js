// AJS.toInit(function () {
//     var sidebar = AJS.sidebar('.aui-sidebar');
//
// // Try to expand the sidebar.
//     if (sidebar.isCollapsed()) {
//         sidebar.expand();
//     }
//
// // Listen to collapse events.
//     sidebar.on('collapse-start', function () {
//         console.log('Sidebar is collapsing!');
//     });
//
//     sidebar.on('collapse-end', function () {
//         console.log('Sidebar is now collapsed!');
//     });
//
// // Event delegation for custom interactions.
//     sidebar.$el.on('click', '.clone', function (e) {
//         if (sidebar.isCollapsed()) {
//             e.preventDefault();
//             cloneDialog.show();
//         }
//     });
// })