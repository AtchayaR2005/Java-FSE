function ListOfPlayers() {

    const players = [

        { name: "Virat", score: 90 },
        { name: "Rohit", score: 80 },
        { name: "Gill", score: 65 },
        { name: "KL Rahul", score: 75 },
        { name: "Hardik", score: 55 },
        { name: "Jadeja", score: 85 },
        { name: "Ashwin", score: 40 },
        { name: "Bumrah", score: 35 },
        { name: "Shami", score: 60 },
        { name: "Siraj", score: 72 },
        { name: "Surya", score: 95 }

    ];

    const lowScore = players.filter(player => player.score < 70);

    return (

        <div>

            <h2>Player Scores</h2>

            <ul>

                {

                    players.map((player, index) => (

                        <li key={index}>

                            {player.name} - {player.score}

                        </li>

                    ))

                }

            </ul>

            <h2>Players with Score Below 70</h2>

            <ul>

                {

                    lowScore.map((player, index) => (

                        <li key={index}>

                            {player.name} - {player.score}

                        </li>

                    ))

                }

            </ul>

        </div>

    );

}

export default ListOfPlayers;