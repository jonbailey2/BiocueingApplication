async function createClientInfo(clientInfo) {
    const response = await fetch('/createClientInfo', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(clientInfo)
    });

    if (!response.ok) {
        throw new Error(`Error: ${response.status}`);
    }
    return response.json();
}

async function getClientInfo(client) {
    const queryParams = new URLSearchParams(client).toString();
    const response = await fetch(`/getClientInfo?${queryParams}`, {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json'
        }
    });
    if (!response.ok) {
        throw new Error(`Error: ${response.status}`);
    }
    return response.json();
}

async function updateClientInfo(clientInfo) {
    const response = await fetch('/updateClientInfo', {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(clientInfo)
    });

    if (!response.ok) {
        throw new Error(`Error: ${response.status}`);
    }
    return response.json();
}

