function UserInput({fetcher}) {

    return (
        <table id="input-table">
            <tbody>
            <tr>
                <td colSpan="3" className="input-cell-l">Введи значения:</td>
            </tr>
            <tr>
                <td className="input-cell-l">X:</td>
                <td id="y-cell">
                    <input className="input-select rounded box" id="x-select" name="x-select" placeholder="(-5; 5)"
                           required type="text" onChange={fetcher.handleX}/>
                </td>
            </tr>
            <tr>
                <td className="input-cell-l">Y:</td>
                <td id="y-cell">
                    <input className="input-select rounded box" id="y-select" name="y-select" placeholder="(-5; 3)"
                           required type="text" onChange={fetcher.handleY}/>
                </td>
            </tr>
            <tr>
                <td className="input-cell-l">R:</td>
                <td id="y-cell">
                    <input className="input-select rounded box" id="r-select" name="r-select" placeholder="(-5; 5)"
                           required type="text" onChange={fetcher.handleR}/>
                </td>
            </tr>
            <tr>
                <td colSpan="3">
                    <button id="submit-button" className="rounded" onClick={fetcher.handleSubmit}>Вычислить</button>
                </td>
            </tr>
            <tr>
                <td colSpan="3">
                    <button id="clear-button" className="rounded" onClick={fetcher.handleClear}>Очистить</button>
                </td>
            </tr>
            </tbody>
        </table>
    );
}

export default UserInput;