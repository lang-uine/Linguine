window.addEventListener('DOMContentLoaded', event => {
    // Simple-DataTables
    // https://github.com/fiduswriter/Simple-DataTables/wiki

    const freeboard = document.getElementById('#freeboard');
    if (freeboard) {
        new simpleDatatables.DataTable(freeboard);
    }

    $('#freeboard').DataTable({
        searching: false,
        lengthChange: false,
        length: 10,
        info: false,
        order:[0,'desc'],
        ordering: false

    });
    const tradeboard = document.getElementById('#freeboard');
    if (tradeboard) {
        new simpleDatatables.DataTable(tradeboard);
    }

    $('#tradeboard').DataTable({
        searching: false,
        lengthChange: false,
        length: 10,
        info: false,
        order:[0,'desc'],
        ordering: false

    });
    const reviewboard = document.getElementById('#freeboard');
    if (reviewboard) {
        new simpleDatatables.DataTable(reviewboard);
    }

    $('#reviewboard').DataTable({
        searching: false,
        lengthChange: false,
        length: 10,
        info: false,
        order:[0,'desc'],
        ordering: false

    });


});
