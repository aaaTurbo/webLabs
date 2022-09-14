function setX(v){
    document.getElementById("x_value").value = v;
}

function setR(v){
    document.getElementById("r_value").value = v;
    document.getElementById("-r").innerHTML = v;
    document.getElementById("-r2").innerHTML = v + "/2";
    document.getElementById("r").innerHTML = v;
    document.getElementById("r2").innerHTML = v + "/2";
    document.getElementById("-R").innerHTML = v;
    document.getElementById("-R2").innerHTML = v  + "/2";
    document.getElementById("R").innerHTML = v;
    document.getElementById("R2").innerHTML = v + "/2";
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