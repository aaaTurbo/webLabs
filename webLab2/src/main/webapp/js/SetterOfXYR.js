let btns = [document.getElementById("r11"), document.getElementById("r115"),
    document.getElementById("r22"), document.getElementById("r225"),
    document.getElementById("r33")];

document.getElementById("x_value").value = sessionStorage.getItem("x");
document.getElementById("y_value").value = sessionStorage.getItem("y");
for (let i in btns) {
    if (btns[i].value === sessionStorage.getItem("r")) {
        btns[i].style.backgroundColor = "#CCCC66";
        setR(btns[i].value, btns[i].id);
        break;
    }
}

function setR(v, id) {
    document.getElementById("r_value").value = v;
    document.getElementById(id).style.backgroundColor = "#CCCC66";
    for (let i = 0; i < btns.length; i++) {
        if (btns[i].id !== id) {
            btns[i].style.backgroundColor = "#CC9933";
        }
    }
    document.getElementById("r_value").value = v;
    document.getElementById("-r").innerHTML = v;
    document.getElementById("-r2").innerHTML = v + "/2";
    document.getElementById("r").innerHTML = v;
    document.getElementById("r2").innerHTML = v + "/2";
    document.getElementById("-R").innerHTML = v;
    document.getElementById("-R2").innerHTML = v + "/2";
    document.getElementById("R").innerHTML = v;
    document.getElementById("R2").innerHTML = v + "/2";
    if (document.getElementById("r_value").value !== "") {
        document.getElementById("tooltiptext").style.visibility = 'hidden';
    } else {
        document.getElementById("tooltiptext").style.visibility = 'visible';
    }
}

document.getElementById('map').onclick = function (e) {
    let rect = document.getElementById('map').getBoundingClientRect();
    let x = e.clientX - rect.x;
    let y = e.clientY - rect.y;
    if (document.getElementById("r_value").value !== "") {
        document.getElementById("tooltiptext").style.visibility = 'hidden';
        document.getElementById("x_value").value = ((x - 150) / 100) * (parseFloat(document.getElementById("r_value").value));
        document.getElementById("y_value").value = -1 * ((y - 150) / 100) * (parseFloat(document.getElementById("r_value").value));
    } else {
        document.getElementById("tooltiptext").style.visibility = 'visible';
    }
}

function errase() {
    document.getElementById("r_value").value = "";
    document.getElementById("x_value").value = "";
    for (let i = 0; i < btns.length; i++) {
        btns[i].style.backgroundColor = "#CC9933";
    }
    document.getElementById("-r").innerHTML = "-R";
    document.getElementById("-r2").innerHTML = "-R/2";
    document.getElementById("r").innerHTML = "R";
    document.getElementById("r2").innerHTML = "R/2";
    document.getElementById("-R").innerHTML = "-R";
    document.getElementById("-R2").innerHTML = "-R/2";
    document.getElementById("R").innerHTML = "R";
    document.getElementById("R2").innerHTML = "R/2";
    document.getElementById("tooltiptext").style.visibility = 'visible';
}