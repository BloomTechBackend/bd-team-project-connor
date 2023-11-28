

// Handling Form Submission
document.querySelector('.ui.button.blue').addEventListener('click', function () {
    // Get values from input fields
    const username = document.getElementById('username').value;
    const avatar = document.getElementById('contactAvatar').value;
    const email = document.getElementById('PlayerEmail').value;
    const handicapIndex = document.getElementById('Handicap Index').value;

    // Perform actions with the values (e.g., send to server)
    // Example: Send data to server using axios
    axios.post('/api/create', { username, avatar, email, handicapIndex })
        .then(response => {
            console.log(response.data);
            // Update UI as needed
        })
        .catch(error => {
            console.error(error);
            // Handle errors
        });
});

// Fetching Previous Rounds
document.querySelector('.ui.button.blue').addEventListener('click', function () {
    // Get values from input fields
    const usernameForPreviousRounds = document.getElementById('usernameForPreviousRounds').value;
    const previousRounds = document.getElementById('Previous Round').value.split(',');

    // Perform actions with the values (e.g., send to server)
    // Example: Send data to server using axios
    axios.get(`/api/previousRounds?username=${usernameForPreviousRounds}&rounds=${previousRounds}`)
        .then(response => {
            console.log(response.data);
            // Update UI as needed
        })
        .catch(error => {
            console.error(error);
            // Handle errors
        });
});

// Dynamically Update Stats
// Assuming you have a div with id="stats" for displaying stats
const statsDiv = document.getElementById('stats');

// Example: Dynamically update stats based on user actions
function updateStats(statsData) {
    // Clear previous content
    statsDiv.innerHTML = '';

    // Create and append new elements based on statsData
    for (const stat of statsData) {
        const listItem = document.createElement('div');
        listItem.className = 'item';
        listItem.textContent = stat; // Adjust based on your data structure

        statsDiv.appendChild(listItem);
    }
}

// Usage example
//const sampleStatsData = [Putt, Fairways, Greens];
//updateStats(sampleStatsData);