const courseMap = {
    Highlands: {
        course:'Highlands',
        rating: 73.9,
        slope:139
    },
    Glen: {
        course: 'Glen',
        rating: 70.1,
        slope: 120
    },
    Waterview: {
        course: 'Waterview',
        rating: 73.3,
        slope: 130
    },
    Mesquite: {
        course: 'Mesquite',
        rating: 72.9,
        slope:135
    }
};
//dfw courses for beta test

// Handling Form Submission
function createPlayer() {
  // Get data from input fields
  const username = document.getElementById('username').value;
  const email = document.getElementById('PlayerEmail').value;
  //const handicapIndex = parseFloat(document.getElementById('Handicap Index').value); // Parse handicap to double
  //const courses = document.getElementById('Courses').value;

  const rounds = document.getElementById('Rounds').value;

  var roundList = [];
  rounds.split('), ').forEach(function(round){
     round = round.replace("(","");
     var courseName = round.split(", ")[1];
     var date = round.split(", ")[0];
     var score = parseInt(round.split(", ")[2]);
     var roundObj = {};
     roundObj.date = date;
     roundObj.score = score;
     roundObj.course = courseMap[courseName];
     roundList.push(roundObj);
  });
  // Prepare player data object
  const playerData = {
    username: username,
    email: email,
    rounds: roundList,
    //handiCapIndex: handicapIndex,
  };

  // Send data to backend using axios
  // should path be '/handicaptracker/createplayer'
  axios.post('https://wrl4cgy725.execute-api.us-west-2.amazonaws.com/prod/players', playerData)
    .then(response => {
      // Success handling
      console.log('Player created successfully!', response.data);
      //console.log('Full response data:', response.data);

      //alert('The player, ' + response.data.username + ' is ready!' );
      // Update UI with success message or redirect
    })
    .catch(error => {
      // Error handling
      console.error('Error creating player:', error);
      // Display error message to user
    });

}

    const createButton = document.getElementById('createPlayerButton');
    createButton.addEventListener('click', createPlayer);

function updatePlayer(){
      const username = document.getElementById('username').value;
      const email = document.getElementById('PlayerEmail').value;
      const handicapIndex = parseDouble(document.getElementById('Handicap Index').value); // Parse handicap to double
      const rounds = document.getElementById('Rounds').value;
      const courses = document.getElementById('Courses').value;
        // Prepare player data object
        const playerData = {
          username,
          email,
          rounds,
          handicapIndex,
        };

        // Send data to backend using axios
        axios.put('https://wrl4cgy725.execute-api.us-west-2.amazonaws.com/prod/players', playerData)
          .then(response => {
            // Success handling
            console.log('Player updated successfully!', response.data);
            // Update UI with success message or redirect
          })
          .catch(error => {
            // Error handling
            console.error('Error updating player:', error);
            // Display error message to user
          });

}

    const getHandicapButton = document.getElementById('GetHandicapButton');
    getHandicapButton.addEventListener('click', getHandicap);


// 1/11/24
function getHandicap(){
      const username = document.getElementById('usernameForPreviousRounds').value;

      //const handicapIndex = parseDouble(document.getElementById('Handicap Index').value); // Parse handicap to double


//        const playerData = {
//          username: username
//
//        };

          //        https://wrl4cgy725.execute-api.us-west-2.amazonaws.com/prod/handicaptracker/getHandicap
        axios.get('https://wrl4cgy725.execute-api.us-west-2.amazonaws.com/prod/getHandicap?username='+username)
          .then(response => {
            // Success handling
            console.log('handicap retrieved successfully!', response.data);
            alert('The handicap of ' + response.data.handicap.username + ' is ' + response.data.handicap.handicapIndex);
            // Update UI with success message or redirect
          })
          .catch(error => {
            // Error handling
            console.error('Error retrieving handicap:', error);
            // Display error message to user
          });

}

   // const getHandicapButton = document.getElementById('getHandicapButton');
//    getHandicapButton.addEventListener('click', getHandicap);


function getPlayer() {
  // Get data from input fields
  const username = document.getElementById('username').value;
  const email = document.getElementById('email').value;
  const handicapIndex = parseDouble(document.getElementById('Handicap Index').value); // Parse handicap to double
  const rounds = document.getElementById('rounds').value;
  const courses = document.getElementById('courses').value;

  const playerData = {
    username,
    email,
    rounds,
    courses,
    handicapIndex,
  };

 axios.get('https://wrl4cgy725.execute-api.us-west-2.amazonaws.com/prod/getPlayers', playerData)
    .then(response => {
      // Success handling
      console.log('Player retrieved successfully!', response.data);
      // Update UI with success message or redirect
    })
    .catch(error => {
      // Error handling
      console.error('Error retrieving player:', error);
      // Display error message to user
    });

}
const addRoundButton = document.getElementById('AddRoundButton');
    addRoundButton.addEventListener('click', addRoundToRounds);

function addRoundToRounds() {
/*
const addRoundJson = {
    username: username,
    date: date,
    score: score,
    course: courseMap[courseName]
}
*/
  const username = document.getElementById('usernameForAdds').value;
  const date = document.getElementById('Date').value

  const courses = document.getElementById('Course').value;

  const rounds = document.getElementById('Round').value;

//    var roundList = [];
//    rounds.split('), ').forEach(function(round){
//       round = round.replace("(","");
//       var courseName = round.split(", ")[1];
//       var date = round.split(", ")[0];
//       var score = parseInt(round.split(", ")[2]);
//       var roundObj = {};
//       roundObj.date = date;
//       roundObj.score = score;
//       roundObj.course = courseMap[courseName];
//       roundList.push(roundObj);
//    });
    // Prepare player data object
    const playerData = {
      username: username,
      date: date,
      course: courseMap[courses],
      score: rounds
    };


    // should path be '/handicaptracker/addRoundsToRoundsActivity'
    axios.put('https://wrl4cgy725.execute-api.us-west-2.amazonaws.com/prod/rounds', playerData)
      .then(response => {
        // Success handling
        console.log('Round added successfully!', response.data);
         })
      .catch(error => {
        // Error handling
        console.error('Error adding round:', error);
        // Display error message to user
      });


}

//// Handling Form Submission
//function createPlayer() {
//  // Get data from input fields
//  const username = document.getElementById('username').value;
//  const email = document.getElementById('PlayerEmail').value;
//  const handicapIndex = parseFloat(document.getElementById('Handicap Index').value); // Parse handicap to double
//  const courses = document.getElementById('Courses').value;
//
//  const rounds = document.getElementById('Rounds').value;
//  // Prepare player data object
//  const playerData = {
//    username,
//    email,
//    rounds,
//    courses,
//    handicapIndex,
//  };
//
//  // Send data to backend using axios
//  // should path be '/handicaptracker/createplayer'
//  axios.post('https://wrl4cgy725.execute-api.us-west-2.amazonaws.com/prod/players', playerData)
//    .then(response => {
//      // Success handling
//      console.log('Player created successfully!', response.data);
//      // Update UI with success message or redirect
//    })
//    .catch(error => {
//      // Error handling
//      console.error('Error creating player:', error);
//      // Display error message to user
//    });
//
//}
//
//    const createButton = document.getElementById('createPlayerButton');
//    createButton.addEventListener('click', createPlayer);
//
//function updatePlayer(){
//      const username = document.getElementById('username').value;
//      const email = document.getElementById('PlayerEmail').value;
//      const handicapIndex = parseDouble(document.getElementById('Handicap Index').value); // Parse handicap to double
//      const rounds = document.getElementById('Rounds').value;
//      const courses = document.getElementById('Courses').value;
//        // Prepare player data object
//        const playerData = {
//          username,
//          email,
//          rounds,
//          handicapIndex,
//        };
//
//        // Send data to backend using axios
//        axios.put('https://wrl4cgy725.execute-api.us-west-2.amazonaws.com/prod/players', playerData)
//          .then(response => {
//            // Success handling
//            console.log('Player updated successfully!', response.data);
//            // Update UI with success message or redirect
//          })
//          .catch(error => {
//            // Error handling
//            console.error('Error updating player:', error);
//            // Display error message to user
//          });
//
//}
//
//   // const updateButton = document.getElementById('updatePlayerButton');
//    //updateButton.addEventListener('click', updatePlayer);
//
//
//
//function getHandicap(){
//      const username = document.getElementById('username').value;
//
//      const handicapIndex = parseDouble(document.getElementById('Handicap Index').value); // Parse handicap to double
//
//
//        const playerData = {
//          username,
//          handicapIndex,
//        };
//
//          //        https://wrl4cgy725.execute-api.us-west-2.amazonaws.com/prod/handicaptracker/getHandicap
//        axios.get('https://wrl4cgy725.execute-api.us-west-2.amazonaws.com/prod/getHandicap', playerData)
//          .then(response => {
//            // Success handling
//            console.log('handicap retrieved successfully!', response.data);
//            // Update UI with success message or redirect
//          })
//          .catch(error => {
//            // Error handling
//            console.error('Error retrieving handicap:', error);
//            // Display error message to user
//          });
//
//}
//
//   // const getHandicapButton = document.getElementById('getHandicapButton');
////    getHandicapButton.addEventListener('click', getHandicap);
//
//
//function getPlayer() {
//  // Get data from input fields
//  const username = document.getElementById('username').value;
//  const email = document.getElementById('email').value;
//  const handicapIndex = parseDouble(document.getElementById('Handicap Index').value); // Parse handicap to double
//  const rounds = document.getElementById('rounds').value;
//  const courses = document.getElementById('courses').value;
//
//  const playerData = {
//    username,
//    email,
//    rounds,
//    courses,
//    handicapIndex,
//  };
//
//
//
//  axios.get('https://wrl4cgy725.execute-api.us-west-2.amazonaws.com/prod/getPlayers', playerData)
//    .then(response => {
//      // Success handling
//      console.log('Player retrieved successfully!', response.data);
//      // Update UI with success message or redirect
//    })
//    .catch(error => {
//      // Error handling
//      console.error('Error retrieving player:', error);
//      // Display error message to user
//    });
//
//}

    //const getPlayerButton = document.getElementById('getPlayerButton');
  //  getPlayerButton.addEventListener('click', getPlayer);






















//// Fetching Previous Rounds
//document.querySelector('.ui.button.blue').addEventListener('click', function () {
//    // Get values from input fields
//    const usernameForPreviousRounds = document.getElementById('usernameForPreviousRounds').value;
//    const previousRounds = document.getElementById('Previous Round').value.split(',');
//
//    // Perform actions with the values (e.g., send to server)
//    // Example: Send data to server using axios
//    axios.get(`/api/previousRounds?username=${usernameForPreviousRounds}&rounds=${previousRounds}`)
//        .then(response => {
//            console.log(response.data);
//            // Update UI as needed
//        })
//        .catch(error => {
//            console.error(error);
//            // Handle errors
//        });
//});
//
//// Dynamically Update Stats
//// Assuming you have a div with id="stats" for displaying stats
//const statsDiv = document.getElementById('stats');
//
//// Example: Dynamically update stats based on user actions
//function updateStats(statsData) {
//    // Clear previous content
//    statsDiv.innerHTML = '';
//
//    // Create and append new elements based on statsData
//    for (const stat of statsData) {
//        const listItem = document.createElement('div');
//        listItem.className = 'item';
//        listItem.textContent = stat; // Adjust based on your data structure
//
//        statsDiv.appendChild(listItem);
//    }
//}

// Usage example
//const sampleStatsData = [Putt, Fairways, Greens];
//updateStats(sampleStatsData);