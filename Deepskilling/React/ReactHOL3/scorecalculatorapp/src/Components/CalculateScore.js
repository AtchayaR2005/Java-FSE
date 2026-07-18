import "../Stylesheets/mystyle.css";

function CalculateScore() {

    const name = "John";
    const school = "ABC School";
    const total = 500;
    const goal = 450;

    const average = total / 5;

    return (
        <div className="box">
            <h2>Student Score Card</h2>

            <p><b>Name :</b> {name}</p>

            <p><b>School :</b> {school}</p>

            <p><b>Total :</b> {total}</p>

            <p><b>Goal :</b> {goal}</p>

            <p><b>Average :</b> {average}</p>

        </div>
    );
}

export default CalculateScore;