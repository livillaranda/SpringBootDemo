let button = document.getElementById("button");

button.addEventListener('click', async function getCandy() {

    try {
        const resp = await fetch(`http://localhost:8080/app/candies`);

        if (!resp.ok) {
            throw new Error(raw_resp.status)
        }

        console.log("Request completed.")

        const data = await resp.json();

        console.log(data);

        // RENDERING
        let sentence = document.getElementById("sentence");
        sentence.innerHTML = `${data[0].name} is my favorite candy.`;

        } catch (error) {
        console.log(error)
    }})