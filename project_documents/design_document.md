[team name] Design Document

Connor's LBC Project 

1. Explain clearly what problem you are trying to solve. I want to have a golf handicap tracker. A golfer's handicap is a measure of the player's ability and allows for players of significantly different handicaps to compete on a level playing surface

2. accessing a database of course ratings
player's area they live in.
course recommendations
tracking player's statistics

U1. As a golfer, I want to create a new, empty profile with a given name and a list of statistics.

U2. As a golfer, I want to retrieve my handicap with a given ID.

U3. As a golfer, I want to update my handicap by adding my latest score.

U5. As a golfer, I want to add a stat to the my profile.

U6. As a golfer, I want to retrieve all stats in my profile.


4.1. In Scope
Creating, retrieving, and updating a golf handicap
Adding to and retrieving a saved profile's list of rounds
4.2. Out of Scope
When adding a score on the website, having a drop down or autocomplete with the different courses available.
The ability to search for existing courses either through the website or the API
Being able to add stats 
Sharing scores between users

5. Proposed Architecture Overview
   This initial iteration will provide the minimum lovable product (MLP) including creating, retrieving, and updating a handicap, as well as adding to and retrieving a saved profile's list of scores.

We will use API Gateway and Lambda to create five endpoints (GetHandicap, CreateHandicap, UpdateHandicap, AddCourse, and GetRounds) that will handle the creation, update, and retrieval of handicaps to satisfy our requirements.

We will store PlayerProfiles for golfers in a table in DynamoDB. handicaps themselves will also be stored in DynamoDB. For simpler handicap retrieval, we will store the list of rounds in a given profile directly in the player table.

AmazonMusicPlaylistService will also provide a web interface for users to manage their playlists. A main page providing a list view of all of their playlists will let them create new playlists and link off to pages per-playlist to update metadata and add songs.

6. API
   6.1. Public Models
   Define the data models your service will expose in its responses via your -Model package. These will be equivalent to the PlaylistModel and SongModel from the Unit 3 project.

6.2. First Endpoint
Describe the behavior of the first endpoint you will build into your service API. This should include what data it requires, what data it returns, and how it will handle any known failure cases. You should also include a sequence diagram showing how a user interaction goes from user to website to service to database, and back. This first endpoint can serve as a template for subsequent endpoints. (If there is a significant difference on a subsequent endpoint, review that with your team before building it!)

(You should have a separate section for each of the endpoints you are expecting to build...)

6.3 Second Endpoint
(repeat, but you can use shorthand here, indicating what is different, likely primarily the data in/out and error conditions. If the sequence diagram is nearly identical, you can say in a few words how it is the same/different from the first endpoint)

7. Tables
  7.1 users 
      player_id // partition key, string
  7.2 courses
       course id // partition key, int
       rating // double
       slope // double
  7.3 handicaps
     player_ id // partition key, string 
     date // 
     handicap // double
   