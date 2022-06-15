window.addEventListener('DOMContentLoaded', event => {
    // Simple-DataTables
    // https://github.com/fiduswriter/Simple-DataTables/wiki

    const datatablesSimple = document.getElementById('#freeboard');
    if (datatablesSimple) {
        new simpleDatatables.DataTable(datatablesSimple);
    }

    $('#freeboard').DataTable({
        searching: false,
        lengthChange: false,
        length: 10,
        info: false,
        order:[0,'desc'],
        ordering: false

    });

});
