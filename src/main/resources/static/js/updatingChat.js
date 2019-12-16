const URL = "http://localhost:8080/session";
const PING_INTERVAL = 1000;

const updateChat = async () => {
    try {
        const xhr = new XMLHttpRequest();
        xhr.open("GET", URL, true);
        await xhr.send();
        const response = await xhr.response;
        console.info("Response : ", response);

    } catch (e) {
        console.error("Response error", e);
    }
};

setInterval(updateChat, PING_INTERVAL);

// const updateChat2 = async () => {
//     try {
//         const response = await fetch(URL);
//         if (response.ok) {
//             const data = response.json();
//             const chatBody = document.querySelector(".chat");
//             data.data.length > 0 ?
//                 data.data.forEach(item => (chatBody.append(`<div><b>${item.username}</b><span>${item.message}</span></div>`)))
//                 : null;
//         }
//     } catch (e) {
//         console.info("error", e);
//     }
// };