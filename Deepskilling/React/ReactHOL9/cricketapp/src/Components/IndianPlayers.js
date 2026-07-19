function IndianPlayers() {

    const team = [

        "Virat",
        "Rohit",
        "Gill",
        "KL Rahul",
        "Hardik",
        "Jadeja"

    ];

    const oddPlayers = team.filter((player, index) => index % 2 === 0);

    const evenPlayers = team.filter((player, index) => index % 2 !== 0);

    const t20Players = [

        "Virat",
        "Surya",
        "Hardik"

    ];

    const ranjiPlayers = [

        "Pujara",
        "Rahane",
        "Iyer"

    ];

    const mergedPlayers = [...t20Players, ...ranjiPlayers];

    return (

        <div>

            <h2>Odd Team Players</h2>

            <ul>

                {

                    oddPlayers.map((player, index) => (

                        <li key={index}>{player}</li>

                    ))

                }

            </ul>

            <h2>Even Team Players</h2>

            <ul>

                {

                    evenPlayers.map((player, index) => (

                        <li key={index}>{player}</li>

                    ))

                }

            </ul>

            <h2>Merged Players</h2>

            <ul>

                {

                    mergedPlayers.map((player, index) => (

                        <li key={index}>{player}</li>

                    ))

                }

            </ul>

        </div>

    );

}

export default IndianPlayers;