function App() {

  const office = {

    Name: "Tech Park",

    Rent: 55000,

    Address: "Chennai"

  };

  const officeList = [

    {
      Name: "Tech Park",
      Rent: 55000,
      Address: "Chennai"
    },

    {
      Name: "DLF IT Park",
      Rent: 75000,
      Address: "Bangalore"
    },

    {
      Name: "RMZ Tower",
      Rent: 65000,
      Address: "Hyderabad"
    }

  ];

  return (

    <div style={{padding:"20px"}}>

      <h1>Office Space Rental App</h1>

      <img
        src="/office.jpg"
        alt="Office"
        width="400"
      />

      <h2>Single Office</h2>

      <p><b>Name :</b> {office.Name}</p>

      <p
        style={{
          color: office.Rent < 60000 ? "red" : "green"
        }}
      >
        <b>Rent :</b> ₹ {office.Rent}
      </p>

      <p><b>Address :</b> {office.Address}</p>

      <hr/>

      <h2>Available Office Spaces</h2>

      {

        officeList.map((item,index)=>(

          <div key={index}>

            <h3>{item.Name}</h3>

            <p
              style={{
                color:item.Rent<60000?"red":"green"
              }}
            >
              Rent : ₹ {item.Rent}
            </p>

            <p>Address : {item.Address}</p>

            <hr/>

          </div>

        ))

      }

    </div>

  );

}

export default App;