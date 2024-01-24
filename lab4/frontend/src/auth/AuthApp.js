function LoginApp({fetcher}) {

    return (
        <div className="container">
            Войди или зарегистрируйся:
            <br/>
            <input className="input-select rounded box" name="name" placeholder="Enter login"
                   required type="text" onChange={fetcher.loginChangeHandle}/>
            <br/>
            <input className="input-select rounded box" name="password" placeholder="Enter password"
                   required type="password" onChange={fetcher.passwordChangeHandle}/>
            <br/>
            <button className="box rounded redirect"
                    onClick={fetcher.loginHandle}>Войти
            </button>
            <br/>
            <button className="box rounded redirect"
                    onClick={fetcher.registerHandle}>Зарегистрироваться
            </button>
        </div>
    );
}

export default LoginApp;