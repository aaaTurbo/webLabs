import {useState} from "react";
import {Navigate, useLoaderData} from "react-router-dom";
import {autoFetch} from "../Util";
import MainAppModed from "./MainAppModed";

function MainAppFetcher(props) {
    let [redirect, redirectTo] = useState();

    let loaded = useLoaderData();
    if(!loaded) redirect = '/';

    const [x, setX] = useState();
    const [y, setY] = useState();
    const [r, setR] = useState();
    const [results, setResults] = useState(loaded);

    function handleX(ev) {
        setX(+ev.target.value);
    }

    function handleY(ev) {
        setY(+ev.target.value);
    }

    function handleR(ev) {
        setR(+ev.target.value);
    }

    function handleSubmit() {
        checkHit(x, y);
    }

    function handleGraphClick(ev) {
        checkHit(+ev.x, +ev.y);
    }

    function handleClear() {
        autoFetch('clear', "GET")
            .then(res => {
                if (res) setResults([]);
                else redirectTo('/');
            });
    }

    function handleLogout() {
        autoFetch('auth/logout', "GET")
            .then(res => {
                if (res) redirectTo('/');
            });
    }

    async function checkHit(x, y) {
        if (x === undefined || Number.isNaN(x)) return alert("X value is undefined");
        if (y === undefined || Number.isNaN(y)) return alert("Y value is undefined or incorrect");
        if (r === undefined || Number.isNaN(r)) return alert("R value is undefined");
        if(x <= -5 || x >= 5) return alert("X is not valid");
        if(y <= -5 || y >= 3) return alert("Y is not valid");
        if(r <= -5 || r >= 5) return alert("R is not valid");

        let res = await autoFetch('check',
            'POST', {x, y, r});

        if (res.status !== 401)  {
            let newRes = await res.json();
            setResults([...results, newRes]);
        } else redirectTo('/');
    }

    if (redirect) return (<Navigate to={`..${redirect}`} relative/>);
    return (<MainAppModed fetcher={{r, results, handleX, handleY, handleR, handleSubmit, handleClear, handleGraphClick, handleLogout}}/>);

}

export async function LoadResults() {
    return await autoFetch('results');
}

export default MainAppFetcher;