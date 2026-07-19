function Cart(props) {

    return (

        <tr>

            <td>{props.itemname}</td>

            <td>₹ {props.price}</td>

        </tr>

    );

}

export default Cart;