import axios from "axios";
import { useState } from "react";
import { useHistory } from "react-router";

const CheckBalance = () =>{
    const histroy = useHistory();
    const [email,setEmail] = useState("");
    const [password,setPassword] = useState("");

    const Authenticate = () =>{
        const body = {
            'email':email,
            'password':password
        }
        const url = "http://localhost:8080"
        axios.post(url+"/users/login",body).then(Response =>{
            const result = Response.data
            if(result.status == "success"){
                histroy.push("/showAmount")
            }else{
                window.alert("Invalid Credentials. Plz try again!!")
            }
        })
    }

    return (
        <div className="container">
            <div className="adminProfile">
            <table >
                <tr>
                    <td>Enter email</td>
                    <td>
                        <input type="email" required onChange={e=>{setEmail(e.target.value)}} />
                    </td>
                </tr>
                <tr>
                    <td>Enter Password : </td>
                    <td>
                        <input type="password" required onChange={e=>{setPassword(e.target.value)}}/>
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td><button className="button-small" onClick={Authenticate}>Verify</button></td>
                </tr>
            </table>
            
        </div></div>
    )
}
export default CheckBalance