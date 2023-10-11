<!DOCTYPE html>
<html lang="en">
<script src="js/Validator.js" defer></script>
<script src="js/ReceiveSubmit.js" defer></script>
<script src="js/SetterOfXYR.js" defer></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<head>
    <style>
        div {
            align-content: center;
            text-align: center;
        }

        #cap {
            background: #FFFF99;
            font-size: 18px;
            text-align: center;
            width: 100%;
            margin-top: 0;
        }

        body {
            width: 100%;
            margin-top: 0;
            margin-left: 0;
            margin-right: 0;
            background: #FFFFFF;

        }

        line {
            stroke: black;
        }

        .figure {
            fill: #CC9933;
            opacity: 80%;
        }

        ul {
            list-style: none;
            display: block;
        }

        li {
            margin-top: 0;
            list-style-type: none;
            text-align: center;
            line-height: 60px;
            width: 100%;
            margin-left: 0;
            display: block;
        }

        button {
            background: #CC9933;
            -webkit-transition-duration: 0.2s;
            transition-duration: 0.2s;
            border-width: 0;
            box-shadow: none;
            border-radius: 30px;
        }

        input[type=text] {
            outline: #fcd17d solid 2px;
            box-shadow: none;
        }

        button:hover {
            background: #CCCC66;
        }

        #imap {
            position: center;
            display: block;
            margin-left: 0;
            margin-top: 0;
        }

        #imap #tooltiptext {
            visibility: hidden;
            width: 160px;
            background-color: #bd1919;
            color: #fff;
            text-align: center;
            border-radius: 3px;
            z-index: 1;
            left: 50%;
            margin-left: 250px;
            opacity: 0;
            transition: opacity 0.3s;
        }

        #imap #tooltiptext::after {
            content: "";
            position: fixed;
            margin-left: 2505px;
            border-width: 5px;
            border-style: solid;
            border-color: #555 transparent transparent transparent;
        }

        #imap:hover #tooltiptext {
            visibility: visible;
            opacity: 1;
        }

        #map {
            border: solid black 1px;
        }
    </style>
    <meta charset="UTF-8">
    <title>Menu</title>
    <link rel="icon" href="resources/favicon.ico" type="image/x-icon">
</head>
<body>
<h1 id="cap">Semenov Anton Alekseevich<br/>Group 3214<br/>Variant 2480</h1>
<ul>
    <li id="imap">
        <span id="tooltiptext">Set R!</span>
        <br/>
        <svg width="300" height="300" id="map">
            <line x1="0" x2="300" y1="150" y2="150"></line>
            <line x1="150" x2="150" y1="0" y2="300"></line>

            <polygon points="150,0 145,15 155,15"></polygon>
            <polygon points="300,150 285,145 285,155"></polygon>

            <polygon points="100,150 150,100 150,150" class="figure"></polygon>

            <polygon points="150,150 150,50 200,50 200,150" class="figure"></polygon>

            <path d="M150,250 A100,100 90 0,0 250,150 L 150,150 Z" class="figure"></path>

            <text x="285" y="135">X</text>
            <text x="160" y="15">Y</text>

            <line x1="50" x2="50" y1="145" y2="155"></line>
            <line x1="100" x2="100" y1="145" y2="155"></line>
            <line x1="200" x2="200" y1="145" y2="155"></line>
            <line x1="250" x2="250" y1="145" y2="155"></line>

            <line x1="145" x2="155" y1="50" y2="50"></line>
            <line x1="145" x2="155" y1="100" y2="100"></line>
            <line x1="145" x2="155" y1="200" y2="200"></line>
            <line x1="145" x2="155" y1="250" y2="250"></line>

            <text x="50" y="140" text-anchor="middle" id="-r">-R</text>
            <text x="98" y="140" text-anchor="middle" id="-r2">-R/2</text>
            <text x="200" y="140" text-anchor="middle" id="r2">R/2</text>
            <text x="250" y="140" text-anchor="middle" id="r">R</text>

            <text x="160" y="52.5" id="R">R</text>
            <text x="160" y="102.5" id="R2">R/2</text>
            <text x="160" y="202.5" id="-R2">-R/2</text>
            <text x="160" y="252.5" id="-R">-R</text>
        </svg>
    </li>
    <li>
        <form id="form" name="form" onsubmit="receiveSubmit(); return false">
            <label for="x_value">Change X:

                <input type="text" name="x_value" id="x_value" placeholder="Number from -5 upto 3" maxlength="10"
                       required>
            </label>
            <br>
            <label for="y_value">Change Y:

                <input type="text" name="y_value" id="y_value" placeholder="Number from -3 upto 3" maxlength="10"
                       required>
            </label>
            <br>
            <label for="r_value" id="buttonsR">Change R:

                <button type="button" class="btnGroupR" value="1" id="r11" onclick="setR(value, id)">&nbsp;1&nbsp;</button>
                <button type="button" class="btnGroupR" value="1.5" id="r115" onclick="setR(value, id)">1.5</button>
                <button type="button" class="btnGroupR" value="2" id="r22" onclick="setR(value, id)">&nbsp;2&nbsp;</button>
                <button type="button" class="btnGroupR" value="2.5" id="r225" onclick="setR(value, id)">2.5</button>
                <button type="button" class="btnGroupR" value="3" id="r33" onclick="setR(value, id)">&nbsp;3&nbsp;</button>

            </label>
            <input type="text" name="r_value" id="r_value" hidden="hidden">
        </form>
    </li>
</ul>
<div>
        <span id="validationInfo">
        </span>
    <br/>
    <button type="submit" form="form">Submit</button>
    <button form="form" type="reset" onclick="errase()">Reset</button>
</div>
<script>
    let map = document.getElementById("map");
    map.innerHTML = map.innerHTML + sessionStorage.getItem("dots");
</script>
</body>
</html>
