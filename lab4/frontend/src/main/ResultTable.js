import {useEffect} from "react";

function ResultTable({results}) {

    useEffect(() => {
        const table = document.getElementById("result-table");
        table.scrollTo(0, table.scrollHeight);
    }, [results]);

    let rendered = "";

    if (results.length > 0) {
        rendered = results.map((res, i) =>
            <tr key={i} className={i === results.length - 1 ? res.result ? 'last-row-hit' : 'last-row-miss' : ''}>
                <td>{res.x}</td>
                <td>{res.y}</td>
                <td>{res.r}</td>
                <td>{res.result ? "Есть пробитие!" : "Промах"}</td>
            </tr>
        );
    }

    return (
        <table id="result-table">
            <thead>
            <tr id="first-row" className="last-row-hit">
                <td>X</td>
                <td>Y</td>
                <td>R</td>
                <td>Результат</td>
            </tr>
            </thead>
            <tbody>
            {rendered}
            </tbody>
        </table>
    );
}

export default ResultTable;