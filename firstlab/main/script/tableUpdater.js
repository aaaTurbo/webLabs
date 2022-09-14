const table = document.getElementById("resultTableBody");
const storage = localStorage;
const site = "../secondPage/index.html"

if (storage.getItem("tableData") != null) {
    table.innerHTML += storage.getItem("tableData");
}

function addRow(data) {
    table.innerHTML += data;
    storage.setItem("tableData", table.innerHTML);
    window.open(site);
}

function clearTable() {
    table.innerHTML = '';
    storage.clear();
    window.reload();
}