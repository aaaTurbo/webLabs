function receiveSubmit() {

    let xValue = document.getElementById("x_value").value;
    let yValue = document.getElementById("y_value").value;
    let rValue = document.getElementById("r_value").value;

    console.log(xValue);

    if (validate(xValue, yValue, rValue)) {
        $.ajax({
                type: 'GET',
                url: 'areaChecker',
                async: false,
                data: {time: new Date(), x: xValue.trim(), y: yValue.trim(), r: rValue.trim()},
                success: function (data) {
                    console.log("got it");
                    sessionStorage.setItem("dots", sessionStorage.getItem("dots")
                        + "<circle cx=\"" + (((xValue * 100) / rValue) + 150)
                        + "\" cy=\"" +  (- 1 *((yValue * 100) / rValue) + 150) + "\" r=\"2\" fill=\"black\"/>");
                    sessionStorage.setItem("x", xValue);
                    sessionStorage.setItem("y", yValue);
                    sessionStorage.setItem("r", rValue);
                    window.location.href = "areaChecker";
                },
                error: function (data) {
                    alert(data.responseText);
                },
            }
        );
    }
}