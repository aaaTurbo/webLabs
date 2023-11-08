var radios = document.querySelectorAll('[type = "radio"]');

function setR() {
    let v = document.getElementById("form:horizontalAfter_input").value;
    v = v.replace(",", ".");
    if (v > 2.9 || v < 0.2) {
        v = 0.2;
        document.getElementById("form:horizontalAfter_input").value = v;
    }
    let vD = v/2;
    document.getElementById("-r").innerHTML = v;
    document.getElementById("-r2").innerHTML = String(vD);
    document.getElementById("r").innerHTML = v;
    document.getElementById("r2").innerHTML = String(vD);
    document.getElementById("-R").innerHTML = v;
    document.getElementById("-R2").innerHTML = String(vD);
    document.getElementById("R").innerHTML = v;
    document.getElementById("R2").innerHTML = String(v / 2);
    if (document.getElementById("form:horizontalAfter_input").value !== "") {
        document.getElementById("tooltiptext").style.visibility = 'hidden';
    } else {
        document.getElementById("tooltiptext").style.visibility = 'visible';
    }
}

function erase() {
    document.getElementById("form:horizontalAfter_input").value = "";
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

document.getElementById("map").onclick = function (e) {
    let rect = document.getElementById("map").getBoundingClientRect();
    let x = e.clientX - rect.x;
    let y = e.clientY - rect.y;
    if (document.getElementById("form:horizontalAfter_input").value !== "") {
        let v =document.getElementById("form:horizontalAfter_input").value;
        v = v.replace(",", ".");
        document.getElementById("tooltiptext").style.visibility = 'hidden';
        let xVal = Math.round(((x - 150) / 100) * v * 2) / 2;
        for (let i of radios) {
            if (i.value == xVal) {
                i.checked = true;
                break;
            }
        }
        document.getElementById("form:y_value").value = -1 * ((y - 150) / 100) * v;
    } else {
        document.getElementById("tooltiptext").style.visibility = 'visible';
    }
}