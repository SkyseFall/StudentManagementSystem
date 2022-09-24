import axios from "axios"
import { useHistory } from "react-router"
import "../../adminHome.css"
const DeactivatedUserRow = ({u}) =>{
    const history = useHistory()
    const Activate = () =>{
        const body = {
            "email" : u.email
        }
        const url = "http://localhost:8080"
        axios.post(url+"/users/activateUser",body).then(Response =>{
            const result = Response.data
            if(result.status == "success"){
                window.alert(result.message)
                history.push('/AdminHome')
            }else{
                window.alert(result.error)
                history.push('/AdminHome')
            }
        })
    }

    const Delete = () =>{
        const body = {
            "email" : u.email
        }
        const url = "http://localhost:8080"
        axios.delete(url+"/users/"+u.email).then(Response =>{
            const result = Response.data
            if(result.status == "success")
            window.alert(result.message)
            history.push('/AdminHome')
        })
    }

    return(
        <tr>
            <td>{u.firstName}</td>
            <td>{u.lastName}</td>
            <td>{u.typeJob}</td>
            <td>{u.email}</td>
            <td>{u.mobile}</td>
            <td>
                <button className ="button-small"onClick={Activate}>Activate</button>
            </td>
            <td>
                <button className="button-delete" onClick={Delete} >Delete</button>
            </td>
        </tr>
    )
}

export default DeactivatedUserRow