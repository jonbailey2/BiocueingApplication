export function createClient(clientData)  {
    return fetch('http://localhost:3000/api/createClient', {
        mode: 'cors',
        credentials: 'same-origin',
        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(clientData)
    })
    .then(response => {
        if(response.status === 201) {
            console.log("CREATED CLIENT")
        return response.json();
        } else {
            console.error('Response Error: ${response.status}');
        }
    }).catch(e => console.error('Error: ${JSON.stringify(e)}'));
}

export function createEmptyClient()  {
    return fetch('http://localhost:3000/api/createEmptyClient', {
        mode: 'cors',
        credentials: 'same-origin',
        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify()
    })
    .then(response => {
        if(response.status === 201) {
            console.log("CREATED CLIENT")
        return response.json();
        } else {
            console.error('Response Error: ${response.status}');
        }
    }).catch(e => console.error('Error: ${JSON.stringify(e)}'));
}
