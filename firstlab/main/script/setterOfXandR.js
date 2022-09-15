let btns = [document.getElementById("x1"), document.getElementById("x2"),
    document.getElementById("x3"), document.getElementById("x4"),
    document.getElementById("x5"), document.getElementById("x6"),
    document.getElementById("x7"), document.getElementById("x8"), document.getElementById("x9")];

let chBoxes = [document.getElementById("r1"), document.getElementById("r02"),
    document.getElementById("r3"), document.getElementById("r4"),
    document.getElementById("r5")]

function setX(v, id){
    document.getElementById("x_value").value = v;
    if (document.getElementById(id).style.backgroundColor !== "aqua") {
        document.getElementById(id).style.backgroundColor = "aqua";
    } else {
        document.getElementById(id).style.backgroundColor = "white";
    }
    for (let i = 0; i < btns.length; i++) {
        if (btns[i].id !== id) {
            btns[i].style.backgroundColor = "white";
        }
    }
}

function setR(v, id){
    document.getElementById("r_value").value = v;
    document.getElementById("-r").innerHTML = v;
    document.getElementById("-r2").innerHTML = v + "/2";
    document.getElementById("r").innerHTML = v;
    document.getElementById("r2").innerHTML = v + "/2";
    document.getElementById("-R").innerHTML = v;
    document.getElementById("-R2").innerHTML = v  + "/2";
    document.getElementById("R").innerHTML = v;
    document.getElementById("R2").innerHTML = v + "/2";
    for (let i = 0; i < chBoxes.length; i++) {
        if (chBoxes[i].id !== id) {
            chBoxes[i].checked = false;
        }
    }
}

function errase() {
    document.getElementById("r_value").value = "";
    document.getElementById("x_value").value = "";
    document.getElementById("-r").innerHTML = "-R";
    document.getElementById("-r2").innerHTML = "-R/2";
    document.getElementById("r").innerHTML = "R";
    document.getElementById("r2").innerHTML = "R/2";
    document.getElementById("-R").innerHTML = "-R";
    document.getElementById("-R2").innerHTML = "-R/2";
    document.getElementById("R").innerHTML = "R";
    document.getElementById("R2").innerHTML = "R/2";

}