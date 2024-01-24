import {Outlet} from "react-router-dom";

function Header() {
    return (<>
        <div className="container" id="header">
            <p>Лабораторная работа #4</p>
            <p>Семенов Антон Алексеевич P3214</p>
            <p>Вариант 2461</p>
        </div>
        <Outlet/>
    </>);
}

export default Header;