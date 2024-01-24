import LoginApp from "./AuthApp";
import {useState} from "react";
import {Navigate, useLoaderData} from 'react-router-dom';
import {autoFetch} from "../Util";

function LoginAppFetcher(props) {
    let [redirect, redirectTo] = useState();
    const loaded = useLoaderData();
    if(loaded.success) redirect = '/main';

    const [name, setName] = useState('');
    const [password, setPassword] = useState('');

    function loginChangeHandle(ev) {setName(ev.target.value)}
    function passwordChangeHandle(ev) {setPassword(ev.target.value)}

    function loginHandle() {
        if(!name || !password) return;
        autoFetch('auth/login', 'POST', {name, password})
            .then(res => {
                if(res) redirectTo('/main');
            });
    }

    function registerHandle() {
        if(!name || !password) return;
        autoFetch('auth/register', 'POST', {name, password})
            .then(res => {
                if(res.success) redirectTo('/main');
            });
    }

    if(redirect) return (<Navigate to={`.${redirect}`} relative/>);

    return (<LoginApp fetcher={{loginChangeHandle, passwordChangeHandle, loginHandle, registerHandle}}/>);
}

export default LoginAppFetcher;

export async function getLogin() {
    return await autoFetch('auth', 'GET', undefined, true);
}