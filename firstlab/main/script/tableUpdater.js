const table = document.getElementById("resultTableBody");
const storage = localStorage;
const site = "../secondPage/index.html";
const mainSite = "../firstPage/index.html";

if (storage.getItem("tableData") != null) {
    table.innerHTML += storage.getItem("tableData");
}

function addRow(data) {
    table.innerHTML += data;
    storage.setItem("tableData", table.innerHTML);
    window.location.replace(site);
}

function clearTable() {
    table.innerHTML = '';
    storage.clear();
}

function goBack() {
    window.location.replace(mainSite);
}