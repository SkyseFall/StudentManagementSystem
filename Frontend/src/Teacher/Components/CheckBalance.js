import axios from "axios";
import { useState } from "react";
import { useHistory } from "react-router";

const CheckBalance = (props) => {
    const userId = props.location.aboutProps.id.user
    const histroy = useHistory();

    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");


    const Authenticate = () => {


        const body = {
            'email': email,
            'password': password,
            'userId': userId
        }
        const url = "http://localhost:8080"
        axios.post(url + "/users/authenticateTeacher", body).then(Response => {
            const result = Response.data
            if (result.status == "success") {
                histroy.push({
                    pathname: '/balanceAmount',
                    search: '?query=abc',
                    state: userId
                })
            } else {
                window.alert(result.error)
            }
        })
    }
    return (
        <div className="container"><h4 align="center">Check balance</h4>
            <div className="adminProfile">
                <table >
                    <tbody>
                        <tr>
                            <td>Enter email</td>
                            <td>
                                <input type="email" required onChange={e => { setEmail(e.target.value) }} />
                            </td>
                        </tr>
                        <tr>
                            <td>Enter Password : </td>
                            <td>
                                <input type="password" required onChange={e => { setPassword(e.target.value) }} />
                            </td>
                        </tr>
                        <tr>
                            <td></td>
                            <td><button className="button-delete" onClick={Authenticate}>Verify</button></td>
                        </tr>
                    </tbody>
                </table>

            </div>
        </div>
    )
}
export default CheckBalance