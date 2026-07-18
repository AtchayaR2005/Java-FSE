import CohortDetails from "./Components/CohortDetails";

function App() {

  return (

    <div>

      <h1>Academy Dashboard</h1>

      <CohortDetails
        name="React Batch"
        startedOn="01-Jul-2026"
        status="Ongoing"
        coach="John"
        trainer="David"
      />

      <CohortDetails
        name="Java FSE"
        startedOn="15-Jun-2026"
        status="Completed"
        coach="Alice"
        trainer="Robert"
      />

      <CohortDetails
        name="Python"
        startedOn="10-May-2026"
        status="Ongoing"
        coach="James"
        trainer="Michael"
      />

    </div>

  );

}

export default App;