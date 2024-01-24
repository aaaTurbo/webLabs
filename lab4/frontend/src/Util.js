export async function autoFetch(url, method, body) {
    let res = false;
    try {
        let raw = await fetch('http://localhost:24800/lab4/api/' + url, {
            method: method ? method : 'GET',
            headers: {'Content-Type': 'application/json;charset=utf-8'},
            credentials: 'include',
            body: body ? JSON.stringify(body) : undefined
        });
        res = raw;
    } catch (e) {
        res.error = e;
    }

    if (!res.ok) {
        alert('Error!');
    }
    return res;
}