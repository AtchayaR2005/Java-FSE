import Cart from "./Cart";

function OnlineShopping() {

    const items = [

        { itemname: "Laptop", price: 55000 },

        { itemname: "Mouse", price: 600 },

        { itemname: "Keyboard", price: 1200 },

        { itemname: "Monitor", price: 9000 },

        { itemname: "Headphone", price: 1800 }

    ];

    return (

        <div>

            <h1>Online Shopping Cart</h1>

            <table border="1" cellPadding="10">

                <thead>

                    <tr>

                        <th>Item Name</th>

                        <th>Price</th>

                    </tr>

                </thead>

                <tbody>

                    {

                        items.map((item, index) => (

                            <Cart

                                key={index}

                                itemname={item.itemname}

                                price={item.price}

                            />

                        ))

                    }

                </tbody>

            </table>

        </div>

    );

}

export default OnlineShopping;