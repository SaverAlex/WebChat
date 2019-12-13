const URL = "http://localhost:8080/session";
const PING_INTERVAL = 1000;

const updateChat = async () => {
    try {
        const response = await fetch(URL);
        if (response.ok) {
            const data = response.json();
            const chatBody = document.querySelector(".chat");
            data.data.length > 0 ?
                data.data.forEach(item => (chatBody.append(`<div><b>${item.username}</b><span>${item.message}</span></div>`)))
                : null;
        }
    } catch (e) {
        console.info("error", e);
    }
};

//setInterval(updateChat, PING_INTERVAL);

setInterval(()=>{
    const xhr = new XMLHttpRequest();
     xhr.open("GET", URL, false);
     xhr.send();
     console.info("Ping!")},PING_INTERVAL);