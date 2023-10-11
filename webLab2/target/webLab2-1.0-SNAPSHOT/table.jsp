<%@ page import="beans.StorageBean" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Results</title>
    <meta charset="UTF-8">
    <link rel="icon" href="resources/favicon.ico" type="image/x-icon"/>
    <style>
        #results {
            overflow-x: auto;
            text-align: center;
            align-content: center;
            width: 100%;
            border-style: solid;
            border-width: thin;
            border-color: black;
            border-top: none;
        }

        #tableCap {
            text-align: center;
            align-content: center;
            width: 100%;
            border-style: solid;
            border-width: thin;
            border-color: black;
        }

        th {
            width: 20%;
        }

        #cap {
            background: #FFFF99;
            font-size: 18px;
            text-align: center;
            width: 100%;
            margin-top: 0;
            margin-bottom: 0;
        }

        body {
            margin-top: 0;
            margin-left: 0;
            margin-right: 0;
            background: #FFFFFF;
        }

        line {
            stroke: black;
        }

        button {
            background: #CC9933;
            -webkit-transition-duration: 0.2s;
            transition-duration: 0.2s;
            border-width: 0;
            box-shadow: none;
            border-radius: 30px;
        }

        button:hover {
            background: #CCCC66;
        }
        .scroll-table-body {
            height: 700px;
            overflow-x: auto;
            margin-top: 0px;
            margin-bottom: 20px;
            border-bottom: 1px solid #eee;
        }
        .scroll-table table {
            width:100%;
            table-layout: fixed;
            border: none;
        }
        .scroll-table thead th {
            font-weight: bold;
            text-align: left;
            border: none;
            padding: 10px 15px;
            background: #d8d8d8;
            font-size: 14px;
            border-left: 1px solid #ddd;
            border-right: 1px solid #ddd;
        }

        .scroll-table tbody tr:nth-child(even){
            background: #f3f3f3;
        }

        ::-webkit-scrollbar {
            width: 6px;
        }
        ::-webkit-scrollbar-track {
            box-shadow: inset 0 0 6px rgba(0,0,0,0.3);
        }
        ::-webkit-scrollbar-thumb {
            box-shadow: inset 0 0 6px rgba(0,0,0,0.3);
        }
    </style>
</head>
<body>
<h1 id="cap">Results</h1>
<table id="tableCap">
    <tbody>
    <tr>
        <th>TIME</th>
        <th>HIT</th>
        <th>X</th>
        <th>Y</th>
        <th>R</th>
    </tr>
    </tbody>
</table>
<div class="scroll-table-body">
<table id="results" class="scroll-table">
    <%= StorageBean.getStorage() %>
</table>
</div>
<button onclick="goMain()">Return to menu</button>
</body>
<script>function goMain() {
    window.location.href = "../menu";
}</script>
</html>
