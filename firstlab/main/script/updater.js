function receiveSubmit() {

    let xValue = document.getElementById("x_value").value;
    let yValue = document.getElementById("y_value").value;
    let rValue = document.getElementById("r_value").value;

    if (validate(xValue, yValue, rValue)) {
        $.ajax({
            type: 'POST',
            url: "../firstPage/index.php",
            async: false,
            data: { 'x': xValue.trim(), 'y': yValue.trim(), 'r': rValue.trim() },
            success: function (data) {
                addRow(data);
                document.getElementById("form").reset();
                errase();
                },
            error: function (data) {
                alert(data);
            }
        });
    };
}